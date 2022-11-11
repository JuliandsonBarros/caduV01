package br.com.cadastrounico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cadastrounico.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
	@Query("SELECT u from Usuario u where u.id_usuario = :id_usuario")
	Usuario buscaPeloCodigo(@Param("id_usuario") Integer Integer);
	
}
