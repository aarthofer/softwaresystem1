package at.fh.softwaresystem1.core;

import at.fh.softwaresystem1.models.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DummyDataService {

    private List<BuildingCharacteristics> buildingCharacteristics = loadBuildingCharacteristics();

    private List<ManagementUnit> managementUnits;

    private List<LimitValues> limitValues;

    public List<BuildingCharacteristics> getBuildingCharacteristics() {
        return buildingCharacteristics;
    }

    public List<ManagementUnit> getManagementUnits() {
        return buildingCharacteristics.stream()
                .map(BuildingCharacteristics::getManagementUnits)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<LimitValues> getLimitValues() {
        return loadDefaultValues();
    }

    private List<BuildingCharacteristics> loadBuildingCharacteristics() {
        BuildingCharacteristics b1 = new BuildingCharacteristics();
        b1.setContractId("contractC1");
        b1.setManagementUnits(loadManagementUnitsC1());

        BuildingCharacteristics b2 = new BuildingCharacteristics();
        b2.setContractId("contractC2");
        b2.setManagementUnits(loadManagementUnitsC2());

        return Arrays.asList(b1, b2);
    }

    private List<ManagementUnit> loadManagementUnitsC1() {
        ManagementUnit m1 = new ManagementUnit();
        m1.setId(1);
        m1.setNetworkIdentifier("1");
        m1.setDefaultValues(loadDefaultValues());
        m1.setConsumers(loadConsumersMU1());
        return Arrays.asList(m1);
    }

    private List<ManagementUnit> loadManagementUnitsC2() {
        ManagementUnit m1 = new ManagementUnit();
        m1.setId(2);
        m1.setNetworkIdentifier("2");
        m1.setDefaultValues(loadDefaultValues());
        m1.setConsumers(loadConsumersMU2());
        return Arrays.asList(m1);
    }

    private List<PowerConsumer> loadConsumersMU1() {
        PowerConsumer p1 = new PowerConsumer(
                1, "Heat pump"
                , true
                , null
                , false
                , "1::1"
                , DeviceType.HEAT_PUMP);
        return Arrays.asList(p1);
    }

    private List<PowerConsumer> loadConsumersMU2() {
        PowerConsumer p1 = new PowerConsumer(
                2, "EV"
                , true
                , null
                , false
                , "2::1"
                , DeviceType.EV);
        PowerConsumer p2 = new PowerConsumer(
                3, "Smart cooler"
                , true
                , null
                , false
                , "2::2"
                , DeviceType.OTHER);
        return Arrays.asList(p1, p2);
    }

    private List<LimitValues> loadDefaultValues() {
        LimitValues v1 = new LimitValues(1L, "HeatPumpMinRuntime", 30, DeviceType.HEAT_PUMP);
        LimitValues v2 = new LimitValues(2L, "HeatPumpMinTemp", 15, DeviceType.HEAT_PUMP);
        LimitValues v3 = new LimitValues(3L, "HeatPumpMaxTemp", 90, DeviceType.HEAT_PUMP);
        LimitValues v4 = new LimitValues(4L, "EVMinLoadPercentage", 15, DeviceType.EV);
        return Arrays.asList(v1, v2, v3, v4);
    }

    public void storeDataForBilling(BuildingCharacteristics bc, double flex, double constant) {
        // store data ...
    }
}
