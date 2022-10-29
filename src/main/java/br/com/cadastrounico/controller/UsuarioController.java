package br.com.cadastrounico.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cadastrounico.dto.UsuarioDTO;
import br.com.cadastrounico.dto.UsuarioNewDTO;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> findAll(){
        List<Usuario> listUsuario = service.findAll();
        List<UsuarioDTO> listDTO = listUsuario.stream()
                .map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        Usuario usuario= service.findId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(method =RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UsuarioNewDTO usuarioNewDTO){
        Usuario usuarioSalvo = service.fromDTO(usuarioNewDTO);
        usuarioSalvo = service.insert(usuarioSalvo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
