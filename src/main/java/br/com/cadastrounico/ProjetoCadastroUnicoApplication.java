package br.com.cadastrounico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoCadastroUnicoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoCadastroUnicoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
