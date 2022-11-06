package br.com.cadastrounico.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastrounico.dto.HistoricoDTO;
import br.com.cadastrounico.model.Historico;
import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.repository.HistoricoRepository;
import br.com.cadastrounico.repository.UsuarioRepository;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository repoHist;

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioRepository repo;

	public List<Historico> findAll() {
		return repoHist.findAll();
	}

	public void cadastraHistotico(String nomeAcao, String desccricao, String ip, LocalDateTime dthHistorico) {
		Usuario usuario = service.findId(1);
		Historico historico = new Historico();
		historico.setDescricaoAcao(desccricao);
		historico.setTipoAcao(nomeAcao);
		historico.setIp(ip);
		historico.setUsuario(usuario);
		historico.setDthHistorico(dthHistorico);
		repoHist.save(historico);
	}

	public Historico fromDTO(HistoricoDTO objDto) {
		return new Historico(objDto.getId(), objDto.getDthHistorico(), objDto.getTipoAcao(), objDto.getDescricaoAcao(),
				objDto.getIp(), objDto.getUsuario());
	}
}
