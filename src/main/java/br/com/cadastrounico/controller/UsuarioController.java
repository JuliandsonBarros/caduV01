package br.com.cadastrounico.controller;

import java.net.URI;
import java.time.LocalDateTime;
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

import br.com.cadastrounico.dto.UsuarioDTO;
import br.com.cadastrounico.dto.UsuarioDeleteDTO;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.service.HistoricoService;
import br.com.cadastrounico.service.IPAddress;
import br.com.cadastrounico.service.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Autowired
	private HistoricoService histService;

	@Autowired
	private IPAddress ipAdress;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> listUsuario = service.findAll();
		List<UsuarioDTO> listDTO = listUsuario.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarId(@PathVariable Integer id) {
		Usuario usuario = service.findId(id);
		return ResponseEntity.ok().body(usuario);
	}

	@RequestMapping(method =RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO usuarioDTO, HttpServletRequest request, Model model ){
        Usuario usuarioSalvo = service.fromDTO(usuarioDTO);
        usuarioSalvo = service.insert(usuarioSalvo);
        String clientIPAddress = ipAdress.getClientIPAddress(request);
        model.addAttribute("clienteIPAddress", clientIPAddress);
        histService.cadastraHistotico("Cadastro Usúario", "C",clientIPAddress, LocalDateTime.now());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id,
			HttpServletRequest request, Model model) {
		Usuario usuarioSalvo = service.fromDTO(usuarioDTO);//
		usuarioSalvo.setId(id);
		usuarioSalvo = service.update(usuarioSalvo);
		String clientIPAddress = ipAdress.getClientIPAddress(request);
		model.addAttribute("clienteIPAddress", clientIPAddress);
		histService.cadastraHistotico("Alteração", "A", clientIPAddress, LocalDateTime.now());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody UsuarioDeleteDTO usuarioDeleteDTO, @PathVariable Integer id,
			HttpServletRequest request, Model model) {
		Usuario usuarioSalvo = service.fromDTO(usuarioDeleteDTO);//
		usuarioSalvo.setId(id);
		usuarioSalvo = service.delete(usuarioSalvo);
		String clientIPAddress = ipAdress.getClientIPAddress(request);
		model.addAttribute("clienteIPAddress", clientIPAddress);
		histService.cadastraHistotico("Exlusão", "E", clientIPAddress, LocalDateTime.now());
		return ResponseEntity.noContent().build();
	}
}
    
   
