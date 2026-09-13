package com.orthosmile.medic.controller;

import com.orthosmile.medic.entity.Tratamiento;
import com.orthosmile.medic.service.TratamientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tratamientos")
@CrossOrigin(origins = "*")
public class TratamientoController {

    private final TratamientoService tratamientoService;

    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    @GetMapping
    public List<Tratamiento> listarTodos() {
        return tratamientoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tratamiento> buscarPorId(@PathVariable Long id) {

        return tratamientoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tratamiento> guardar(
            @RequestBody Tratamiento tratamiento) {

        return ResponseEntity.ok(tratamientoService.guardar(tratamiento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tratamiento> actualizar(
            @PathVariable Long id,
            @RequestBody Tratamiento tratamiento) {

        Tratamiento actualizado =
                tratamientoService.actualizar(id, tratamiento);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        tratamientoService.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}