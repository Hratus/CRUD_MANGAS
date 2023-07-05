package com.example.phmangas.Controler;

import com.example.phmangas.Services.UsuarioService;
import com.example.phmangas.dto.UsuarioRecordDTO;
import com.example.phmangas.dto.mangaRecordDto;
import com.example.phmangas.entitys.ProductModel;
import com.example.phmangas.entitys.Usuario;
import com.example.phmangas.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController   {
    @Autowired
    UsuarioService usuarioService;

@GetMapping
    public List<Usuario> buscarUsuario(){
    return usuarioService.buscarUsuario();
}
public Usuario cadastrarUsuario(@RequestBody Usuario manga){
return usuarioService.cadastrasUsuario(manga);
}
@PutMapping("/{id}")
public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario manga){
return usuarioService.atualizarUsuario(id, manga);

}
@DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Long id){
usuarioService.excluirUsuario(id);

}




}

