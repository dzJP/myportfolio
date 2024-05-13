package portfolio.jakob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BackendApplication {

	@GetMapping("/message")
	public String message() {
		return "Spring boot application successfully deployed to Azure.";
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
