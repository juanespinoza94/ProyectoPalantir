package com.cibertec.controller;

import java.util.List;

import com.cibertec.model.DetalleReservaDTO;
import com.cibertec.repository.DetalleReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.model.DetalleReserva;
import com.cibertec.service.DetalleReservaService;

@RestController
@RequestMapping("api/detalleReserva")
public class DetalleReservaController {

	@Autowired
	private DetalleReservaService detalleReservaService;

    @Autowired
    private DetalleReservaRepository detalleReservaRepository;
	
	@GetMapping
    public ResponseEntity<List<DetalleReserva>> listarDetalleReservas() {
        return detalleReservaService.listarDetalleReserva();
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<DetalleReservaDTO> obtenerDetalle(@PathVariable Long id) {
        return detalleReservaRepository.findById(id)
                .map(detalle -> {
                    DetalleReservaDTO dto = new DetalleReservaDTO();
                    dto.setId(detalle.getId());
                    dto.setReservaId(detalle.getIdReserva());
                    return ResponseEntity.ok(dto);
                }).orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<DetalleReserva> createDetalleReserva(@RequestBody DetalleReserva detalleReserva) {
        return detalleReservaService.agregarDetalleReserva(detalleReserva);
    }


    @PutMapping("/{id}") 
	public ResponseEntity <DetalleReserva> actualizarDetalleReserva (@RequestBody DetalleReserva detalleReserva, @PathVariable Long id) {
		return detalleReservaService.editarDetalleReserva(detalleReserva, id);
	}
}
