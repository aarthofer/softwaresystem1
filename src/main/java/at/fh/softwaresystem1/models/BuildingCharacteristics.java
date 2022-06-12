package at.fh.softwaresystem1.models;

import java.util.List;

public class BuildingCharacteristics {
    String contractId;
    List<ManagementUnit> ManagementUnits; // SmartMeter

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public List<ManagementUnit> getManagementUnits() {
        return ManagementUnits;
    }

    public void setManagementUnits(List<ManagementUnit> managementUnits) {
        ManagementUnits = managementUnits;
    }
}
