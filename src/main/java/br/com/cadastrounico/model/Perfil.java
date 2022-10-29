package br.com.cadastrounico.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cadu_003_perfil")
public class Perfil {
    private static final long serialVersionUID = 1;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_perfil")
    private Integer id;
    
    @Column(name="nom_perfil")
    private String perfil;
    
    @Column(name="sta_perfil")
    private String statusPerfil;
    
	public Perfil(Integer id, String perfil, String statusPerfil) {
		super();
		this.id = id;
		this.perfil = perfil;
		this.statusPerfil = statusPerfil;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getStatusPerfil() {
		return statusPerfil;
	}
	public void setStatusPerfil(String statusPerfil) {
		this.statusPerfil = statusPerfil;
	}

	@Override
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
		Perfil other = (Perfil) obj;
		return Objects.equals(id, other.id);
	}
}
