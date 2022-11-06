package br.com.cadastrounico.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cadu_006_historico")
public class Historico  implements Serializable {
    private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historico")
    private Integer id;
    
    @Column(name="dth_historico")
    private LocalDateTime dthHistorico;
    
    @Column(name="tp_acao")
    private String tipoAcao;
    
    @Column(name="des_acao")
	private String descricaoAcao;
    
    @Column(name="cod_ip_maquina")
    private String ip;
    
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
   
    public Historico() {
	}
    
	public Historico(Integer id, LocalDateTime dthHistorico, String tipoAcao, String descricaoAcao, String ip,Usuario usuario) {
		super();
		this.id = id;
		this.dthHistorico = dthHistorico;
		this.tipoAcao = tipoAcao;
		this.descricaoAcao = descricaoAcao;
		this.ip = ip;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}
	
	
	public void setId(Integer id) {
		this.id = id;
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
	
	public LocalDateTime getDthHistorico() {
		return dthHistorico;
	}
	
	
	public void setDthHistorico(LocalDateTime dthHistorico) {
		this.dthHistorico = dthHistorico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Historico other = (Historico) obj;
		return Objects.equals(id, other.id);
	}
}
