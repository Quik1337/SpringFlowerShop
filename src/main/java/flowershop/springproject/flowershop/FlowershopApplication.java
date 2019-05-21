package flowershop.springproject.flowershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlowershopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cmx  = SpringApplication.run(FlowershopApplication.class, args);
	}

}
