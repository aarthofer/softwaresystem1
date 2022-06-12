package at.fh.softwaresystem1.core;

import at.fh.softwaresystem1.models.ManagementUnit;
import at.fh.softwaresystem1.models.PowerConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ManagementConsole {
    @Resource
    DummyDataService dataService;

    public ManagementUnit loadCurrentData(Long muId) {
        return dataService.getManagementUnits().stream().filter(x -> x.getId() == muId).findFirst().orElse(null);
    }

    public PowerConsumer updatePowerConsumer(PowerConsumer consumer) {
        if (consumer == null || consumer.getId() < 0) {
            return null;
        }

        for (ManagementUnit mu :
                dataService.getManagementUnits()) {
            for (PowerConsumer pu :
                    mu.getConsumers()) {
                if (pu.getId() == consumer.getId()) {
                    pu.setInteruptableEnabled(consumer.isInteruptableEnabled());
                    pu.setCurrentlyConsuming(consumer.isCurrentlyConsuming());
                    return pu;
                }
            }
        }
        return null;
    }
}
