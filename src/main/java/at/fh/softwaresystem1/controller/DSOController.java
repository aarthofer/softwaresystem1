package at.fh.softwaresystem1.controller;

import at.fh.softwaresystem1.core.DSOManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dso")
public class DSOController {

    @Resource
    DSOManagement controller;

    @RequestMapping(value = "totalEnergy", method = RequestMethod.GET)
    String getTotalEnergy() {
        return "Current total power consumed: " + controller.currentTotalEnergy();
    }

    @RequestMapping(value = "switchFlexPowerAvailable", method = RequestMethod.GET)
    String switchFlexPowerAvailable(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.triggerFlexPower(flexPowerAvailable);
        return "Flex Power is now " + (flexPowerAvailable ? "available" : "not available");
    }

    @RequestMapping(value = "switchWind", method = RequestMethod.GET)
    String switchWind(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.switchWind(flexPowerAvailable);
        return "Wind is " + (flexPowerAvailable ? "available" : "not available");
    }

    @RequestMapping(value = "switchSun", method = RequestMethod.GET)
    String switchSun(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.switchSun(flexPowerAvailable);
        return "Sun is " + (flexPowerAvailable ? "available" : "not available");
    }
}
