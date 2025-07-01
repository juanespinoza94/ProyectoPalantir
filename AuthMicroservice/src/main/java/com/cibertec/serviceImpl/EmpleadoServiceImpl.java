package com.cibertec.serviceImpl;

import com.cibertec.model.Cargo;
import com.cibertec.model.Empleado;
import com.cibertec.model.Usuario;
import org.springframework.beans.BeanUtils;
import com.cibertec.repository.CargoRepository;
import com.cibertec.repository.EmpleadoRepository;
import com.cibertec.repository.UsuarioRepository;
import com.cibertec.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;
    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    private boolean esTextoValido(String texto) {
        return texto != null && texto.matches("^[a-zA-ZÁÉÍÓÚáéíóúñÑ ]+$");
    }

    @Override
    public ResponseEntity<List<Empleado>> listarEmpleados() {
        List<Empleado> listaEmpleados = empleadoRepository.findAll();
        return listaEmpleados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(listaEmpleados);
    }

    @Override
    public ResponseEntity<Empleado> getEmpleadoPorNumeroDocumento(String numeroDocumento) {
        return empleadoRepository.findByNumeroDocumento(numeroDocumento)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }


    @Override
    public ResponseEntity<List<Empleado>> listarEmpleadosporEstado(String estado) {
        List<Empleado> empleadosPorEstado = empleadoRepository.findByEstadoIgnoreCase(estado);
        if (empleadosPorEstado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleadosPorEstado);
    }

    @Override
    public ResponseEntity<List<Empleado>> listarEmpleadosporCargo(Long id) {
        List<Empleado> empleados = empleadoRepository.findByCargoId(id);
        if (empleados.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(empleados);
    }

    @Override
    public ResponseEntity<Empleado> agregarEmpleado(Empleado empleado) {
        Usuario usuario = empleado.getUsuario();

        if (usuario == null || usuario.getUsername() == null || usuario.getPassword() == null) {
            return ResponseEntity.badRequest().build();
        }

        if (!esTextoValido(empleado.getApellido())) {
            throw new IllegalArgumentException("El apellido solo debe contener letras.");
        }
        if (!esTextoValido(empleado.getNombre())) {
            throw new IllegalArgumentException("El nombre solo debe contener letras.");
        }

        // Verificar que el username no esté ya en la base de datos
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }

        // Encriptar contraseña
        String passwordEncriptada = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(passwordEncriptada);

        // Asignar rol basado en el cargo
        if (empleado.getCargo() != null && empleado.getCargo().getId() != null) {
            Optional<Cargo> cargoOptional = cargoRepository.findById(empleado.getCargo().getId());

            if (cargoOptional.isPresent()) {
                String descripcion = cargoOptional.get().getDescripcion().toUpperCase().replace(" ", "_");
                usuario.setRol("ROLE_" + descripcion);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } else {
            return ResponseEntity.badRequest().body(null);
        }

        empleado.setEstado("Activo");
        // Creacion del Usuario por cascade = CascadeType.ALL
        return ResponseEntity.ok(empleadoRepository.save(empleado));
    }

    @Override
    public ResponseEntity<Empleado> actualizarEmpleado(Empleado empleado, Long id) {
        return empleadoRepository.findById(id)
                .map(existente -> {

                    if (!esTextoValido(empleado.getApellido())) {
                        throw new IllegalArgumentException("El apellido solo debe contener letras.");
                    }
                    if (!esTextoValido(empleado.getNombre())) {
                        throw new IllegalArgumentException("El nombre solo debe contener letras.");
                    }
                    // Mantener el mismo ID
                    BeanUtils.copyProperties(empleado, existente, "id", "usuario");

                    // Verificar si el username fue actualizado
                    if (empleado.getUsuario() != null) {
                        Usuario nuevoUsuario = empleado.getUsuario();
                        Usuario actualUsuario = existente.getUsuario();

                        // Si el username cambió, verificar que no esté en uso
                        if (!nuevoUsuario.getUsername().equals(actualUsuario.getUsername())) {
                            if (usuarioRepository.existsByUsername(nuevoUsuario.getUsername())) {
                                return ResponseEntity.status(HttpStatus.CONFLICT)
                                        .body(existente); // Devolvemos el empleado existente sin cambios
                            }
                            // Actualizar el username
                            actualUsuario.setUsername(nuevoUsuario.getUsername());
                        }

                        // Si la contraseña es diferente, encriptarla y actualizar
                        if (nuevoUsuario.getPassword() != null && !nuevoUsuario.getPassword().isBlank()) {
                            if (!passwordEncoder.matches(nuevoUsuario.getPassword(), actualUsuario.getPassword())) {
                                actualUsuario.setPassword(passwordEncoder.encode(nuevoUsuario.getPassword()));
                            }
                        }
                    }

                    // Verificar si el cargo fue cambiado y actualizar rol
                    if (empleado.getCargo() != null && empleado.getCargo().getId() != null) {
                        Optional<Cargo> cargoOptional = cargoRepository.findById(empleado.getCargo().getId());
                        if (cargoOptional.isPresent()) {
                            Cargo nuevoCargo = cargoOptional.get();
                            existente.getUsuario().setRol("ROLE_" + nuevoCargo.getDescripcion().toUpperCase().replace(" ", "_"));
                            existente.setCargo(nuevoCargo);
                        } else {
                            return ResponseEntity.badRequest().body(existente);
                        }
                    }
                    return ResponseEntity.ok(empleadoRepository.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());    }


    @Override
    public ResponseEntity<?> eliminarEmpleado(Long id) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    if (!"Inactivo".equalsIgnoreCase(empleado.getEstado())) {
                        empleado.setEstado("Inactivo");
                        empleadoRepository.save(empleado);
                    }
                    return ResponseEntity.ok().build(); // o ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
