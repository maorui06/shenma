package org.example.xdiamond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


/**
 * Hello world!
 *
 */
@ImportResource(value={"classpath:/spring/spring-config.xml"})
@SpringBootApplication
public class App extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) { 
	   container.setPort(8082); 
	}

}