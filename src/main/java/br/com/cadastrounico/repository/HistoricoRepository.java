package br.com.cadastrounico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cadastrounico.model.Historico;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

}
