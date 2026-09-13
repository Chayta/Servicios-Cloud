package com.orthosmile.medic.service;

import com.orthosmile.medic.entity.Usuario;
import com.orthosmile.medic.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Long id, Usuario usuario) {

        Optional<Usuario> existente = usuarioRepository.findById(id);

        if (existente.isPresent()) {

            Usuario actual = existente.get();

            actual.setNombres(usuario.getNombres());
            actual.setApellidos(usuario.getApellidos());
            actual.setUsername(usuario.getUsername());
            actual.setPassword(usuario.getPassword());
            actual.setRol(usuario.getRol());
            actual.setActivo(usuario.getActivo());

            return usuarioRepository.save(actual);
        }

        return null;
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}