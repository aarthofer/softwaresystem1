package at.fh.softwaresystem1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dso")
public class DSOController {
    @RequestMapping(value = "products", method = RequestMethod.GET)
    String hello() {
        return "Hello world!";
    }
}
