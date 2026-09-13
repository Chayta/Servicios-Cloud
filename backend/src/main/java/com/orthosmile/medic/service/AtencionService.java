package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Atencion;
import com.orthosmile.medic.repository.AtencionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtencionService {

    private final AtencionRepository atencionRepository;

    public AtencionService(AtencionRepository atencionRepository) {
        this.atencionRepository = atencionRepository;
    }

    public List<Atencion> listarTodos() {
        return atencionRepository.findAll();
    }

    public Optional<Atencion> buscarPorId(Long id) {
        return atencionRepository.findById(id);
    }

    public Atencion guardar(Atencion atencion) {
        return atencionRepository.save(atencion);
    }

    public Atencion actualizar(Long id, Atencion atencion) {

        Optional<Atencion> existente = atencionRepository.findById(id);

        if (existente.isPresent()) {

            Atencion actual = existente.get();

            actual.setCita(atencion.getCita());
            actual.setFecha(atencion.getFecha());
            actual.setHora(atencion.getHora());
            actual.setMotivo(atencion.getMotivo());
            actual.setDiagnostico(atencion.getDiagnostico());
            actual.setObservaciones(atencion.getObservaciones());
            actual.setEstado(atencion.getEstado());

            return atencionRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        atencionRepository.deleteById(id);
    }
}