package flowershop.springproject.flowershop;

import flowershop.springproject.flowershop.restcontrollers.TestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FlowershopApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cmx  = SpringApplication.run(FlowershopApplication.class, args);

        TestController testController = (TestController) cmx.getBean("testController");
        testController.setUpDB();
	}

}
