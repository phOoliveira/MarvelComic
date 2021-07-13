package marvelcomimcs.MC;

import marvelcomimcs.MC.Usuario.Usuario;
import marvelcomimcs.MC.Usuario.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class McApplication {


	public static void main(String[] args) {
		SpringApplication.run(McApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UsuarioRepository usuarioRepository){
		return args -> {
			Usuario phelipe = new Usuario(
					"Phelipe Pires Oliveira",
					"phelipepires13@gmail.com",
					"11114651699",
					LocalDate.of(1991, Month.NOVEMBER, 5)
			);

			Usuario marluce = new Usuario(
					"Marluce Correa Pires Oliveira",
					"mcpOliveira@gmail.com",
					"36495050100",
					LocalDate.of(1965, Month.FEBRUARY, 16)
			);
			usuarioRepository.saveAll(
					List.of(phelipe, marluce)
			);

		};
	}


}
