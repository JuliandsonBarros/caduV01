package br.com.cadastrounico.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastrounico.dto.HistoricoDTO;
import br.com.cadastrounico.model.Historico;
import br.com.cadastrounico.service.HistoricoService;

@RestController
@RequestMapping(value = "/historico")
public class HistoricoController {
	
	@Autowired
	private HistoricoService service;

	@RequestMapping(method = RequestMethod.GET) public ResponseEntity<List<HistoricoDTO>> findAll() {
		List<Historico> listaHistorico = service.findAll();
		List<HistoricoDTO> listDTO = listaHistorico.stream().map(obj -> new HistoricoDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
