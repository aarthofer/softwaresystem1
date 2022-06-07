package at.fh.softwaresystem1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/powermanagement")
public class PowerManagementController {
    @RequestMapping(value = "currentData", method = RequestMethod.GET)
    String getCurrentData() {
        return "Hello world!";
    }
}
