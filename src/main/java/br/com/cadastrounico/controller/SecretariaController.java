package br.com.cadastrounico.controller;

import br.com.cadastrounico.dto.SecretariaDTO;
import br.com.cadastrounico.dto.SecretariaNewDTO;
import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<SecretariaDTO>> findAll(){
        List<Secretaria> listaSecretaria = service.findAll();
        List<SecretariaDTO> listDTO =  listaSecretaria.stream()
                .map(obj -> new SecretariaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscarId(@PathVariable Integer id){
        Secretaria secretaria = service.findId(id);
        return ResponseEntity.ok().body(secretaria);
    }

    @RequestMapping(method =RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody SecretariaNewDTO secretariaDTO){
        Secretaria secretariaSalva = service.fromDTO(secretariaDTO);
        secretariaSalva = service.insert(secretariaSalva);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(secretariaSalva.getId()).toUri();
        return ResponseEntity.ok().build();
    }
}
