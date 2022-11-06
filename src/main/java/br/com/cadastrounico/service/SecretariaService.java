package br.com.cadastrounico.service;

import br.com.cadastrounico.dto.SecretariaDTO;
import br.com.cadastrounico.dto.SecretariaNewDTO;
import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.model.Usuario;
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
    public Secretaria insert(Secretaria obj){
        obj.setId(null);
        repo.save(obj);
        return obj;
    }

    public Secretaria update(Secretaria secretaria){
        Secretaria novaSecretaria = findId((secretaria.getId()));
        atualizaBanco(novaSecretaria, secretaria);
        return repo.save(novaSecretaria);
    }

    public Secretaria fromDTO(SecretariaDTO objDto){
        return new Secretaria(objDto.getId(), objDto.getNome(), objDto.getEndereco(), objDto.getTelefone(),
                objDto.getStatusSec(), objDto.getObservacao(),null);
    }

    public Secretaria fromDTO(SecretariaNewDTO objDto){
        Secretaria sec = new Secretaria(null, objDto.getNome(), objDto.getEndereco(), objDto.getTelefone(),
                objDto.getStatusSec(), objDto.getObservacao(),null);
        return sec;
    }

    private void atualizaBanco(Secretaria novaSecretaria, Secretaria secretaria) {
        novaSecretaria.setNome(secretaria.getNome());
        novaSecretaria.setEndereco(secretaria.getEndereco());
        novaSecretaria.setTelefone(secretaria.getTelefone());
        novaSecretaria.setStatusSec(secretaria.getStatusSec());
        novaSecretaria.setObservacao(secretaria.getObservacao());
    }
}
