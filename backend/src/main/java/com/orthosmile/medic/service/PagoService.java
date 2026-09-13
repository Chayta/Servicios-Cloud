package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Pago;
import com.orthosmile.medic.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    private final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    public List<Pago> listarTodos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> buscarPorId(Long id) {
        return pagoRepository.findById(id);
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizar(Long id, Pago pago) {

        Optional<Pago> existente = pagoRepository.findById(id);

        if (existente.isPresent()) {

            Pago actual = existente.get();

            actual.setPaciente(pago.getPaciente());
            actual.setAtencion(pago.getAtencion());
            actual.setMonto(pago.getMonto());
            actual.setFecha(pago.getFecha());
            actual.setMetodoPago(pago.getMetodoPago());
            actual.setEstado(pago.getEstado());
            actual.setObservaciones(pago.getObservaciones());

            return pagoRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }
}