package at.fh.softwaresystem1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dso")
public class DSOController {
    @RequestMapping(value = "totalEnergy", method = RequestMethod.GET)
    String getTotalEnergy() {
        return "Current total power consumed: " + Math.random();
    }

    @RequestMapping(value = "switchFlexPowerAvailable", method = RequestMethod.GET)
    String switchFlexPowerAvailable(@RequestParam("enable") boolean flexPowerAvailable) {
        return "Flex Power is now " + (flexPowerAvailable ? "available" : "not available");
    }
}
