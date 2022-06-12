package at.fh.softwaresystem1.core;

import at.fh.softwaresystem1.models.BuildingCharacteristics;
import at.fh.softwaresystem1.models.ManagementUnit;
import at.fh.softwaresystem1.models.PowerConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class DSOManagement {

    @Resource
    DummyDataService dataService;

    List<BuildingCharacteristics> customers;

    @PostConstruct
    public void loadData() {
        customers = dataService.getBuildingCharacteristics();
    }

    boolean windAvailable = false;
    boolean sunAvailable = false;

    public double currentTotalEnergy() {
        double totalEnergy = 0.0;
        for (BuildingCharacteristics bc :
                customers) {
            double flex = 0.0, constant = 0.0;
            for (ManagementUnit mc :
                    bc.getManagementUnits()) { // load per smart meter (flex load)
                for (PowerConsumer pc :
                        mc.getConsumers()) {
                    if (pc.isCurrentlyConsuming()) {
                        flex += getRandomNumber(0.5, 1.5);
                    }
                }
            }
            // load per customer (constant load)
            constant = getRandomNumber(2.0, 5.0);
            dataService.storeDataForBilling(bc, flex, constant);
            totalEnergy += (flex + constant);
        }
        return totalEnergy;
    }

    public void triggerFlexPower(boolean flexPowerAvailable) {

    }

    public double getRandomNumber(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }

    public void switchWind(boolean windAvailable) {
        this.windAvailable = windAvailable;
    }

    public void switchSun(boolean sunAvailable) {
        this.sunAvailable = sunAvailable;
    }
}
