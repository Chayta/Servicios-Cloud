package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Paciente;
import com.orthosmile.medic.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    // Listar todos los pacientes
    public List<Paciente> listarTodos() {
        return pacienteRepository.findAll();
    }

    // Buscar paciente por ID
    public Optional<Paciente> buscarPorId(Long id) {
        return pacienteRepository.findById(id);
    }

    // Registrar paciente
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // Actualizar paciente
    public Paciente actualizar(Long id, Paciente paciente) {

        Optional<Paciente> pacienteExistente = pacienteRepository.findById(id);

        if (pacienteExistente.isPresent()) {

            Paciente pacienteActual = pacienteExistente.get();

            pacienteActual.setDni(paciente.getDni());
            pacienteActual.setNombres(paciente.getNombres());
            pacienteActual.setApellidos(paciente.getApellidos());
            pacienteActual.setTelefono(paciente.getTelefono());
            pacienteActual.setCorreo(paciente.getCorreo());
            pacienteActual.setDireccion(paciente.getDireccion());

            return pacienteRepository.save(pacienteActual);
        }

        return null;
    }

    // Eliminar paciente
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}