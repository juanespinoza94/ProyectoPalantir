package com.cibertec.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");

        return http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/tipoHabitacion").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/precio-habitacion-plan/tipo/**").permitAll()

                        // ==============================
                        // ADMIN
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/tipoHabitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/tipoHabitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/tipoHabitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/tipoHabitacion/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/cargo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/cargo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/cargo/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/proveedor/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/proveedor/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/proveedor/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/proveedor/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/habitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/habitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/habitacion/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/habitacion/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/bancoDisponibles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/bancoDisponibles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/bancoDisponibles/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/bancoDisponibles/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/huespedes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/empleados/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/empleados/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/empleados/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/empleados/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/reserva/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/itemConsumo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/api/itemConsumo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/itemConsumo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/itemConsumo/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/detalleReserva/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/pago/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/pagoDetalle/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/pagoTarjeta/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/itemProveedor/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/solicitudConsumo/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/ordenCompra/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/detalleOrden/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/auditoria/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/horarioServicio/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/empleadoServicio/**").hasRole("ADMIN")

                        // ==============================
                        // GERENTE
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/reportes/**").hasRole("GERENTE")
                        .requestMatchers(HttpMethod.GET, "/api/pagosVistas/**").hasRole("GERENTE")

                        // ==============================
                        // PERSONAL DE SERVICIOS
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/consumoVistas/**").hasRole("PERSONAL_DE_SERVICIOS")

                        // ==============================
                        // RECEPCIONISTA
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/vistasReservas/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.GET, "/api/habitacion/**").hasRole("RECEPCIONISTA")

                        .requestMatchers(HttpMethod.GET, "/api/huespedes/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.POST, "/api/huespedes/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.PUT, "/api/huespedes/**").hasRole("RECEPCIONISTA")

                        .requestMatchers("/api/reserva/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.GET, "/api/planes/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.GET, "/api/precioHabitacion/**").hasRole("RECEPCIONISTA")

                        .requestMatchers(HttpMethod.GET, "/api/itemConsumo/**").hasRole("RECEPCIONISTA")

                        .requestMatchers(HttpMethod.GET, "/api/detalleReserva/**").hasRole("RECEPCIONISTA")
                        .requestMatchers("/api/solicitudConsumo/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.POST, "/api/pago/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.DELETE, "/api/pago/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.GET, "/api/pagoDetalle/**").hasRole("RECEPCIONISTA")


                        .requestMatchers(HttpMethod.GET, "/api/horarioServicio/**").hasRole("RECEPCIONISTA")
                        .requestMatchers(HttpMethod.GET, "/api/empleadoServicio/**").hasRole("RECEPCIONISTA")

                        // ==============================
                        // ENCARGADO DE ADQUISICIONES
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/inventarioVistas/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.GET, "/api/vistasCompras/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.GET, "/api/itemProveedor/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.GET, "/api/stock/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.GET, "/api/vencimientoProducto/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.POST, "/api/vencimientoProducto/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers(HttpMethod.PUT, "/api/vencimientoProducto/**").hasRole("ENCARGADO_DE_ADQUISICIONES")

                        .requestMatchers("/api/ordenCompra/**").hasRole("ENCARGADO_DE_ADQUISICIONES")
                        .requestMatchers("/api/detalleOrden/**").hasRole("ENCARGADO_DE_ADQUISICIONES")

                        // ==============================
                        // HUESPED
                        // ==============================
                        .requestMatchers(HttpMethod.GET, "/api/vistasReservas/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/habitacion/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.POST, "/api/huespedes/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.PUT, "/api/huespedes/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.DELETE, "/api/huespedes/**").hasRole("HUESPED")

                        .requestMatchers(HttpMethod.POST, "/api/reserva/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/planes/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/precioHabitacion/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.POST, "/api/pago/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/itemConsumo/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/detalleReserva/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.POST, "/api/solicitudConsumo/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.GET, "/api/pagoDetalle/**").hasRole("HUESPED")
                        .requestMatchers(HttpMethod.POST, "/api/pagoTarjeta/**").hasRole("HUESPED")


                        // ==============================
                        // Requiere autenticación por defecto
                        // ==============================
                        .anyRequest().authenticated()
                )


                .addFilter(jwtAuthenticationFilter)
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	/*
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager memoryManager = new InMemoryUserDetailsManager();
		memoryManager.createUser(
				User
				.withUsername("javier")
				.password(passwordEncoder().encode("password"))
				.roles()
				.build());
		return memoryManager;
	}
	*/

    @Bean
    AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
        return authBuilder.build();
    }


}