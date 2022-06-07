package at.fh.softwaresystem1.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "at.fh.softwaresystem1")
public class Softwaresystem1Application {

    public static void main(String[] args) {
        SpringApplication.run(Softwaresystem1Application.class, args);
    }


}
