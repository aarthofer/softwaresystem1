package at.fh.softwaresystem1.controller;

import at.fh.softwaresystem1.core.ManagementConsole;
import at.fh.softwaresystem1.models.BuildingCharacteristics;
import at.fh.softwaresystem1.models.ManagementUnit;
import at.fh.softwaresystem1.models.PowerConsumer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/powermanagement")
public class PowerManagementController {

    @Resource
    ManagementConsole managementConsole;

    @RequestMapping(value = "loadAllData", method = RequestMethod.GET)
    List<BuildingCharacteristics> loadAllData() {
        return managementConsole.loadAllData();
    }

    @RequestMapping(value = "loadCurrentData", method = RequestMethod.GET)
    ManagementUnit loadCurrentData(Long muId) {
        return managementConsole.loadCurrentData(muId);
    }

    @RequestMapping(value = "updatePowerConsumer", method = RequestMethod.POST)
    PowerConsumer updatePowerConsumer(@RequestBody PowerConsumer consumer) {
        return managementConsole.updatePowerConsumer(consumer);
    }
}
