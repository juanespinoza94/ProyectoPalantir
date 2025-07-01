package com.cibertec.serviceImpl;

import com.cibertec.model.Empleado;
import com.cibertec.model.Huesped;
import com.cibertec.model.Usuario;
import com.cibertec.repository.HuespedRepository;
import com.cibertec.repository.UsuarioRepository;
import com.cibertec.service.HuespedService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HuespedServiceImpl implements HuespedService {

    @Autowired
    private HuespedRepository huespedRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }

    private boolean esTextoDireccionValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ0-9 ,.\\-]+$");
    }


    @Override
    public ResponseEntity<List<Huesped>> listarHuespedes() {
        List<Huesped> huespedes = huespedRepository.findAll();
        return huespedes.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(huespedes);
    }

    @Override
    public ResponseEntity<Huesped> getHuespedPorNumeroDocumento(String numeroDocumento) {
        return huespedRepository.findByNumeroDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

    @Override
    public ResponseEntity<List<Huesped>> listarHuespedesporEstado(String estado) {
        List<Huesped> huespedesPorEstado = huespedRepository.findByEstadoIgnoreCase(estado);
        if (huespedesPorEstado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(huespedesPorEstado);
    }

    @Override
    public ResponseEntity<Huesped> agregarHuesped(Huesped huesped) {
        Usuario usuario = huesped.getUsuario();

        if (usuario == null || usuario.getUsername() == null || usuario.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!esTextoValido(huesped.getApellido())) {
            throw new IllegalArgumentException("El apellido solo debe contener letras.");
        }
        if (!esTextoValido(huesped.getNombre())) {
            throw new IllegalArgumentException("El nombre solo debe contener letras.");
        }
        if (!esTextoDireccionValido(huesped.getDireccion())) {
            throw new IllegalArgumentException("La direccion puede contener letras, numeros y algunos signos.");
        }

        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRol("ROLE_HUESPED");
        huesped.setUsuario(usuario);

        huesped.setEstado("Activo");

        return ResponseEntity.ok(huespedRepository.save(huesped));
    }

    @Override
    public ResponseEntity<Huesped> actualizarHuesped(Huesped huesped, Long id) {
        return huespedRepository.findById(id)
                .map(existente -> {
                    if (!esTextoValido(huesped.getApellido())) {
                        throw new IllegalArgumentException("El apellido solo debe contener letras.");
                    }
                    if (!esTextoValido(huesped.getNombre())) {
                        throw new IllegalArgumentException("El nombre solo debe contener letras.");
                    }
                    if (!esTextoDireccionValido(huesped.getDireccion())) {
                        throw new IllegalArgumentException("La direccion puede contener letras, numeros y algunos signos.");
                    }

                    BeanUtils.copyProperties(huesped, existente, "id", "usuario");

                    if (huesped.getUsuario() != null) {
                        Usuario nuevoUsuario = huesped.getUsuario();
                        Usuario actualUsuario = existente.getUsuario();

                        if (!nuevoUsuario.getUsername().equals(actualUsuario.getUsername())) {
                            if (usuarioRepository.existsByUsername(nuevoUsuario.getUsername())) {
                                return ResponseEntity.status(HttpStatus.CONFLICT).body(existente);
                            }
                            actualUsuario.setUsername(nuevoUsuario.getUsername());
                        }



                        if (nuevoUsuario.getPassword() != null && !nuevoUsuario.getPassword().isBlank()) {
                            if (!passwordEncoder.matches(nuevoUsuario.getPassword(), actualUsuario.getPassword())) {
                                actualUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
                            }
                        }
                    }

                    return ResponseEntity.ok(huespedRepository.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<?> eliminarHuesped(Long id) {
        return huespedRepository.findById(id)
                .map(huesped -> {
                    if (!"Inactivo".equalsIgnoreCase(huesped.getEstado())) {
                        huesped.setEstado("Inactivo");
                        huespedRepository.save(huesped);
                    }
                    return ResponseEntity.ok().build(); // o ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
