package at.fh.softwaresystem1.core;

import at.fh.softwaresystem1.models.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
public class DSOManagement {

    @Resource
    DummyDataService dataService;
    boolean windAvailable = false;
    boolean sunAvailable = false;
    List<BuildingCharacteristics> customers;
    private FlexLoadTriggerListener triggerListener;

    @PostConstruct
    public void loadData() {
        customers = dataService.getBuildingCharacteristics();
    }

    public void setTriggerListener(FlexLoadTriggerListener triggerListener) {
        this.triggerListener = triggerListener;
    }

    public double currentTotalEnergy() {
        double totalFlexEnergy = 0.0;
        double totalConstantEnergy = 0.0;
        for (BuildingCharacteristics bc :
                customers) {
            double flex = 0.0, constant = 0.0;
            for (ManagementUnit mc :
                    bc.getManagementUnits()) { // load per smart meter (flex load)
                for (PowerConsumer pc :
                        mc.getConsumers()) {
                    if (pc.isCurrentlyConsuming()) {
                        flex += getRandomNumber(2, 4);
                        System.out.println(String.format("#####: Device %s (%s) - %s currently consumes %f", pc.getName(), pc.getDeviceAddress(),
                                pc.getType(), flex));
                    }
                }
            }
            // load per customer (constant load)
            constant = getRandomNumber(4.0, 10.0);
            dataService.storeDataForBilling(bc, flex, constant);
            totalFlexEnergy += flex;
            totalConstantEnergy += constant;
        }
        System.out.println(String.format("#####: Current total constant energy %f", totalConstantEnergy));
        checkFlexLoadAvailable(totalConstantEnergy);
        return totalConstantEnergy + totalFlexEnergy;
    }

    public void triggerFlexPower(boolean flexPowerAvailable) {
        System.out.println("#####: Flex load is " +
                (flexPowerAvailable ? "available" : "not available"));
        sendFlexLoadTriggerToDevices(flexPowerAvailable);
        triggerListener.sendTrigger(new FlexLoadState(flexPowerAvailable ? State.ON : State.OFF));
    }

    private void sendFlexLoadTriggerToDevices(boolean flexPowerAvailable) {
        for (ManagementUnit mu :
                dataService.getManagementUnits()) {
            for (PowerConsumer pc :
                    mu.getConsumers()) {
                if (pc.isInteruptableEnabled()) {
                    pc.setCurrentlyConsuming(flexPowerAvailable);
                }
            }
        }
    }

    public double getRandomNumber(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }

    public void switchWind(boolean windAvailable) {
        this.windAvailable = windAvailable;
        System.out.println("#####: Wind is" +
                (windAvailable ? " " : " not ") + "blowing");
    }

    public void switchSun(boolean sunAvailable) {
        this.sunAvailable = sunAvailable;
        System.out.println("#####: Sun is" +
                (sunAvailable ? " " : " not ") + "shining");
    }

    private void checkFlexLoadAvailable(double currentConstantEnergyConsumption) {
        if ((windAvailable && sunAvailable)
                || (currentConstantEnergyConsumption < 15.0 && (windAvailable || sunAvailable))) {
            triggerFlexPower(true);
        } else {
            triggerFlexPower(false);
        }
    }

}
