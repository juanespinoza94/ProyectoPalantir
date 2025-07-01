package com.cibertec.util;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class JwtUtils {

    public Long extraerIdDesdeToken(String token) {
        try {
            token = token.replace("Bearer ", "");
            String[] partes = token.split("\\.");
            String payload = new String(Base64.getDecoder().decode(partes[1]));
            ObjectMapper mapper = new ObjectMapper();
            JsonNode body = mapper.readTree(payload);
            return body.get("id").asLong();
        } catch (Exception e) {
            throw new RuntimeException("Error al leer el token JWT", e);
        }
    }
}
