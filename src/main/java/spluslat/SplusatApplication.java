package spluslat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SplusatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SplusatApplication.class, args);
	}

}
