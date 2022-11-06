package br.com.cadastrounico.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import br.com.cadastrounico.model.Historico;
import br.com.cadastrounico.model.Usuario;

public class HistoricoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
	
	private Integer id;
    private LocalDateTime dthHistorico;
    private String tipoAcao;
	private String descricaoAcao;
    private String ip;
    private Usuario usuario;
	
    public HistoricoDTO() {
	}
    
    public HistoricoDTO(Historico historico) {
    	id = historico.getId();
    	dthHistorico = historico.getDthHistorico();
    	tipoAcao = historico.getTipoAcao();
    	descricaoAcao = historico.getDescricaoAcao();
    	ip = historico.getIp();
    	usuario = historico.getUsuario();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDthHistorico() {
		return dthHistorico;
	}

	public void setDthHistorico(LocalDateTime dthHistorico) {
		this.dthHistorico = dthHistorico;
	}

	public String getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(String tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public String getDescricaoAcao() {
		return descricaoAcao;
	}

	public void setDescricaoAcao(String descricaoAcao) {
		this.descricaoAcao = descricaoAcao;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
