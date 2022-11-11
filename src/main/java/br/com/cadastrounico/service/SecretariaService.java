package br.com.cadastrounico.service;

import br.com.cadastrounico.dto.SecretariaDTO;
import br.com.cadastrounico.dto.SecretariaNewDTO;
import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.repository.SecretariaRepository;
import br.com.cadastrounico.repository.UsuarioRepository;
import br.com.cadastrounico.service.exception.ObjectNotFoundExeption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository repo;

    @Autowired
    private UsuarioRepository usuarioRepo;
    
    @Autowired
    private UsuarioService usuarioSevice;

    public List<Secretaria> findAll(){
        return repo.findAll();
    }

    public Secretaria findId(Integer id){
        Optional<Secretaria> secretaria = repo.findById(id);
        if(secretaria.orElse(null) == null) {
        	throw new ObjectNotFoundExeption("Secretaria não encontrada.");
        }
        return secretaria.orElseThrow();
    }

	@Transactional
	public Secretaria insert(Secretaria obj) {
		obj.getId_secretaria();
		return repo.save(obj);
	}

    public Secretaria update(Secretaria secretaria){
        Secretaria novaSecretaria = findId((secretaria.getId_secretaria()));
        atualizaBanco(novaSecretaria, secretaria);
        return repo.save(novaSecretaria);
    }

    public Secretaria fromDTO(SecretariaDTO objDto){
        return new Secretaria(objDto.getId_secretaria(), objDto.getNom_secretaria(),objDto.getNom_endereco()
        		,objDto.getCod_telefone(),objDto.getSta_secretaria(),objDto.getDes_observacao(), objDto.getUsuario());
    }

    public Secretaria fromDTO(SecretariaNewDTO objDto){
         return new Secretaria(null, objDto.getNom_secretaria(), objDto.getNom_endereco(), objDto.getCod_telefone(),
                objDto.getSta_secretaria(), objDto.getDes_observacao(), usuarioSevice.fromDTO(objDto.getUsuario()));
    }

    private void atualizaBanco(Secretaria novaSecretaria, Secretaria secretaria) {
        novaSecretaria.setNom_secretaria(secretaria.getNom_secretaria());
        novaSecretaria.setNom_endereco(secretaria.getNom_endereco());
        novaSecretaria.setCod_telefone(secretaria.getCod_telefone());
        novaSecretaria.setSta_secretaria(secretaria.getSta_secretaria());
        novaSecretaria.setDes_observacao(secretaria.getDes_observacao());
    }
}
