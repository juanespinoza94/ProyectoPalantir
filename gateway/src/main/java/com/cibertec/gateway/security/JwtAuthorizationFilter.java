package com.cibertec.gateway.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.function.Predicate;

@Component
public class JwtAuthorizationFilter implements GlobalFilter, Ordered {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthorizationFilter.class);

    @Value("${jwt.secret}")
    private String secretKey;

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    private static final List<String> PUBLIC_PATHS = List.of(
            "/login",
            "/api/planes",
            "/api/precio-habitacion-plan/tipo/**"
    );


    @PostConstruct
    public void init() {
        logger.info("JwtAuthorizationFilter bean creado y listo");
    }

    private boolean matches(String path, String pattern) {
        return pathMatcher.match(pattern, path);
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();


        // Rutas públicas sin necesidad de token
        if (PUBLIC_PATHS.stream().anyMatch(p -> matches(path, p))) {
            return chain.filter(exchange);
        }

        List<String> authHeaders = request.getHeaders().getOrEmpty(HttpHeaders.AUTHORIZATION);

        if (authHeaders.isEmpty() || !authHeaders.get(0).startsWith("Bearer ")) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String jwtHeader = authHeaders.get(0);
        String jwt = jwtHeader.replace("Bearer", "").trim();

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody();

            String role = claims.get("role", String.class);

            if (!isAuthorized(request, role)) {
                logger.warn("[Gateway] No autorizado para ruta: {}", path);
                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
                return exchange.getResponse().setComplete();
            }

            ServerHttpRequest mutatedRequest = request.mutate()
                    .header("X-ROLE", role)
                    .build();

            return chain.filter(exchange.mutate().request(mutatedRequest).build());

        } catch (Exception e) {
            logger.error("[Gateway] Token inválido o error: {}", e.getMessage());
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
    }

    private boolean isAuthorized(ServerHttpRequest request, String role) {
        String path = request.getURI().getPath();
        HttpMethod method = request.getMethod();

        if (method == null) return false;

        Predicate<String> match = p -> matches(path, p);

        switch (role) {
            case "ROLE_ADMIN":
                return (
                        match.test("/api/tipoHabitacion/**") ||
                                (match.test("/api/cargo/**") && !method.equals(HttpMethod.DELETE)) ||
                                match.test("/api/proveedor/**") ||
                                match.test("/api/habitacion/**") ||
                                match.test("/api/bancoDisponibles/**") ||
                                (match.test("/api/huespedes/**") && method.equals(HttpMethod.GET)) ||
                                match.test("/api/empleado/**") ||
                                (match.test("/api/reserva/**") && method.equals(HttpMethod.GET)) ||
                                match.test("/api/itemConsumo/**") ||
                                (match.test("/api/detalleReserva/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/pago/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/pagoDetalle/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/pagoTarjeta/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/itemProveedor/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/solicitudConsumo/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/ordenCompra/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/detalleOrden/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/auditoria/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/horarioServicio/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/empleadoServicio/**") && method.equals(HttpMethod.GET))
                );

            case "ROLE_GERENTE":
                return (match.test("/api/reportes/**") && method.equals(HttpMethod.GET) ||
                        (match.test("/api/pagosVistas/**") && method.equals(HttpMethod.GET))

                );

            case "ROLE_PERSONAL_DE_SERVICIOS":
                return match.test("/api/consumoVistas/**") && method.equals(HttpMethod.GET);

            case "ROLE_RECEPCIONISTA":
                return (
                        (match.test("/api/vistasReservas/**") && method.equals(HttpMethod.GET)) ||
                        (match.test("/api/habitacion/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/huespedes/**") && (method.equals(HttpMethod.GET) || method.equals(HttpMethod.POST) || method.equals(HttpMethod.PUT))) ||
                                match.test("/api/reserva/**") ||
                                (match.test("/api/planes/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/precioHabitacion/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/itemConsumo/**") && !method.equals(HttpMethod.DELETE)) ||
                                (match.test("/api/detalleReserva/**") && method.equals(HttpMethod.GET)) ||
                                match.test("/api/solicitudConsumo/**") ||
                                (match.test("/api/pago/**") && (method.equals(HttpMethod.POST) || method.equals(HttpMethod.DELETE))) ||
                                (match.test("/api/pagoDetalle/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/horarioServicio/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/empleadoServicio/**") && method.equals(HttpMethod.GET))
                );

            case "ROLE_ENCARGADO_DE_ADQUISICIONES":
                return (
                        (match.test("/api/inventarioVistas/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/vistasCompras/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/itemProveedor/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/stock/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/vencimientoProducto/**") && method != HttpMethod.DELETE) ||
                                match.test("/api/ordenCompra/**") ||
                                match.test("/api/detalleOrden/**")
                );

            case "ROLE_HUESPED":
                return (
                        (match.test("/api/vistasReservas/**") && method.equals(HttpMethod.GET)) ||
                        (match.test("/api/habitacion/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/huespedes/**") && !method.equals(HttpMethod.GET)) ||
                                (match.test("/api/reserva/**") && method.equals(HttpMethod.POST)) ||
                                (match.test("/api/planes/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/precioHabitacion/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/pago/**") && method.equals(HttpMethod.POST)) ||
                                (match.test("/api/itemConsumo/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/detalleReserva/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/solicitudConsumo/**") && method.equals(HttpMethod.POST)) ||
                                (match.test("/api/pagoDetalle/**") && method.equals(HttpMethod.GET)) ||
                                (match.test("/api/pagoTarjeta/**") && method.equals(HttpMethod.POST))

                );
        }

        return false;
    }

    @Override
    public int getOrder() {
        return -1; // Alta prioridad
    }
}
