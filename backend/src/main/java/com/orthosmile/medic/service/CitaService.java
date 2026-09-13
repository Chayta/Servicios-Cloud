package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Cita;
import com.orthosmile.medic.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public List<Cita> listarTodos() {
        return citaRepository.findAll();
    }

    public Optional<Cita> buscarPorId(Long id) {
        return citaRepository.findById(id);
    }

    public Cita guardar(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizar(Long id, Cita cita) {

        Optional<Cita> existente = citaRepository.findById(id);

        if (existente.isPresent()) {

            Cita actual = existente.get();

            actual.setPaciente(cita.getPaciente());
            actual.setOdontologo(cita.getOdontologo());
            actual.setFecha(cita.getFecha());
            actual.setHora(cita.getHora());
            actual.setMotivo(cita.getMotivo());
            actual.setEstado(cita.getEstado());

            return citaRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        citaRepository.deleteById(id);
    }
}