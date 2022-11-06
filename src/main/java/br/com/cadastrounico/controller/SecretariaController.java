package br.com.cadastrounico.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cadastrounico.dto.SecretariaDTO;
import br.com.cadastrounico.dto.SecretariaNewDTO;
import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.service.HistoricoService;
import br.com.cadastrounico.service.IPAddress;
import br.com.cadastrounico.service.SecretariaService;

@RestController
@RequestMapping(value = "/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService service;
    
    @Autowired
    private HistoricoService hitsService;
    
    @Autowired
	private IPAddress ipAdress;

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
    public ResponseEntity<Void> insert(@Valid @RequestBody SecretariaNewDTO secretariaDTO, HttpServletRequest request, Model model ){
        Secretaria secretariaSalva = service.fromDTO(secretariaDTO);
        secretariaSalva = service.insert(secretariaSalva);
        String clientIPAddress = ipAdress.getClientIPAddress(request);
        model.addAttribute("clienteIPAddress", clientIPAddress);
        hitsService.cadastraHistotico("Cadastro Secretaria", "Secretaria criada",clientIPAddress, LocalDateTime.now());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(secretariaSalva.getId()).toUri();
        return ResponseEntity.ok().build();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody SecretariaDTO secretariaDTO, @PathVariable Integer id, HttpServletRequest request, Model model) {
    	Secretaria secretariaSalva = service.fromDTO(secretariaDTO);// 
		secretariaSalva.setId(id);
		secretariaSalva = service.update(secretariaSalva);
		String clientIPAddress = ipAdress.getClientIPAddress(request);
		model.addAttribute("clienteIPAddress", clientIPAddress);
		hitsService.cadastraHistotico("Cadastro alterado", "Alteração secretaria",clientIPAddress, LocalDateTime.now());
		return ResponseEntity.noContent().build();
    }
}
