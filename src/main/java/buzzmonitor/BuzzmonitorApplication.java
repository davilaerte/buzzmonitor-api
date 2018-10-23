package buzzmonitor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import buzzmonitor.repository.PostRepository;

@SpringBootApplication
public class BuzzmonitorApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BuzzmonitorApplication.class, args);
	}
	
	//iniciliza Atividades Default.
	@Bean
	public CommandLineRunner initializeDb(PostRepository repository){
	   return (args) -> {
	        
		   //Post teste1 = repository.save(new Post("1049282814565396480","Vamos lah", new Author("amira", "@lander5d❣️class of ‘19 🎓🧡 THHHH")));
		   //Teste teste2 = repository.save(new Teste("1003", "Legal"));
		   //Teste teste3 = repository.save(new Teste("1004", "Dahora"));
		   //Teste teste4 = repository.save(new Teste("1005", "Massa"));
		   
		   //List<Post> testes = repository.findAll();
		   
		   //testes.forEach(x -> System.out.println(x));
		   
		   //System.out.println(teste1.getId());
		   //System.out.println(teste2.getTexto());
		   //System.out.println(teste3.getTexto());		   	
		};
	}
}