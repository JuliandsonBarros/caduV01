package br.com.cadastrounico;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cadastrounico.model.Secretaria;
import br.com.cadastrounico.model.Usuario;
import br.com.cadastrounico.repository.SecretariaRepository;
import br.com.cadastrounico.repository.UsuarioRepository;

@SpringBootApplication
public class ProjetoCadastroUnicoApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private SecretariaRepository secretariaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoCadastroUnicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		LocalDate sdf = LocalDate.now();
		LocalDate sdf1 = LocalDate.now();
		LocalDate sdf2 = LocalDate.now();
		LocalDate sdf3 = LocalDate.now();
		LocalDate sdf4 = LocalDate.now();

		Usuario u1 = new Usuario(null, "Juliandson Barros Soares", sdf,
				"Juliandsonbs@gmail.com","M", "01384935100", "2589028", "123456","A");
		Usuario u2 = new Usuario(null,"Eduarda Leão Barros", sdf1,
				"EduardaLeão@gmail.com","F ","05184935100", "689258", "321654","I");
		Usuario u3 = new Usuario(null, "Bruan", sdf2,
				"bruna@gmail.com"," F","02284935100", "352028", "852369","A");
		Usuario u5 = new Usuario(null, "Ana melia", sdf3,
				"ana@gmail.com", "F","05184935100", "689258", "321654","I");
		Usuario u6 = new Usuario(null,"Isabele Barros", sdf4,
				"isa@gmail.com","F", "02284935100", "352028", "852369","A");
		

		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u5,u6));

		Secretaria s1 = new Secretaria(null,"Saúde", "Avenida Pedro II lote 54",
				"6132356598","A","Secretária de saúde municipal",u6);
		Secretaria s2 = new Secretaria(null,"Esporte", "Avenida Pedro II lote 54",
				"6132356599","A","Secretária de Esportes do municipio",u2);
		Secretaria s3 = new Secretaria(null,"Cultura", "Avenida Pedro II lote 54",
				"6132356590","I","Secretária inativa por falta de recursos",u3);

		secretariaRepository.saveAll(Arrays.asList(s1,s2,s3));



	}
}
