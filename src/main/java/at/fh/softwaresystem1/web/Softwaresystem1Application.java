package at.fh.softwaresystem1.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "at.fh.softwaresystem1")
public class Softwaresystem1Application {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Softwaresystem1Application.class);
        app.setLazyInitialization(true);
        app.run(args);
    }


}
