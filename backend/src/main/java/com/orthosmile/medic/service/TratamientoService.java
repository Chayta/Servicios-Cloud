package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Tratamiento;
import com.orthosmile.medic.repository.TratamientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TratamientoService {

    private final TratamientoRepository tratamientoRepository;

    public TratamientoService(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

    public List<Tratamiento> listarTodos() {
        return tratamientoRepository.findAll();
    }

    public Optional<Tratamiento> buscarPorId(Long id) {
        return tratamientoRepository.findById(id);
    }

    public Tratamiento guardar(Tratamiento tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    public Tratamiento actualizar(Long id, Tratamiento tratamiento) {

        Optional<Tratamiento> existente = tratamientoRepository.findById(id);

        if (existente.isPresent()) {

            Tratamiento actual = existente.get();

            actual.setNombre(tratamiento.getNombre());
            actual.setDescripcion(tratamiento.getDescripcion());
            actual.setCosto(tratamiento.getCosto());
            actual.setActivo(tratamiento.getActivo());

            return tratamientoRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        tratamientoRepository.deleteById(id);
    }
}