package com.orthosmile.medic.controller;

import com.orthosmile.medic.entity.Atencion;
import com.orthosmile.medic.service.AtencionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atenciones")
@CrossOrigin(origins = "*")
public class AtencionController {

    private final AtencionService atencionService;

    public AtencionController(AtencionService atencionService) {
        this.atencionService = atencionService;
    }

    @GetMapping
    public List<Atencion> listarTodos() {
        return atencionService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atencion> buscarPorId(@PathVariable Long id) {

        return atencionService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atencion> guardar(@RequestBody Atencion atencion) {
        return ResponseEntity.ok(atencionService.guardar(atencion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atencion> actualizar(
            @PathVariable Long id,
            @RequestBody Atencion atencion) {

        Atencion actualizado = atencionService.actualizar(id, atencion);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        atencionService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}