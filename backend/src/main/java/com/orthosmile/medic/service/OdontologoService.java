package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Odontologo;
import com.orthosmile.medic.repository.OdontologoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private final OdontologoRepository odontologoRepository;

    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public List<Odontologo> listarTodos() {
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> buscarPorId(Long id) {
        return odontologoRepository.findById(id);
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoRepository.save(odontologo);
    }

    public Odontologo actualizar(Long id, Odontologo odontologo) {

        Optional<Odontologo> existente = odontologoRepository.findById(id);

        if (existente.isPresent()) {

            Odontologo actual = existente.get();

            actual.setDni(odontologo.getDni());
            actual.setNombres(odontologo.getNombres());
            actual.setApellidos(odontologo.getApellidos());
            actual.setEspecialidad(odontologo.getEspecialidad());
            actual.setTelefono(odontologo.getTelefono());
            actual.setCorreo(odontologo.getCorreo());
            actual.setActivo(odontologo.getActivo());

            return odontologoRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        odontologoRepository.deleteById(id);
    }
}