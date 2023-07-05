package com.example.phmangas.Services;

import com.example.phmangas.entitys.Usuario;
import com.example.phmangas.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> buscarUsuario(){
        return usuarioRepository.findAll();
    }
    public Usuario cadastrasUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    public Usuario atualizarUsuario(Long id, Usuario usuario){
        usuario.setId(id);
        return usuarioRepository.save(usuario);

    }
    public void excluirUsuario(Long id){
        usuarioRepository.deleteById(id);

    }
}
