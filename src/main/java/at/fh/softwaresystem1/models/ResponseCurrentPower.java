package at.fh.softwaresystem1.models;

public class ResponseCurrentPower {
    private long timeofday;
    private double totalFlexQuarterHourConsumtion;
    private double totalConstantQuarterHourConsumption;
    private long managementUnitId;

    public long getTimeofday() {
        return timeofday;
    }

    public void setTimeofday(long timeofday) {
        this.timeofday = timeofday;
    }

    public double getTotalFlexQuarterHourConsumtion() {
        return totalFlexQuarterHourConsumtion;
    }

    public void setTotalFlexQuarterHourConsumtion(double totalFlexQuarterHourConsumtion) {
        this.totalFlexQuarterHourConsumtion = totalFlexQuarterHourConsumtion;
    }

    public double getTotalConstantQuarterHourConsumption() {
        return totalConstantQuarterHourConsumption;
    }

    public void setTotalConstantQuarterHourConsumption(double totalConstantQuarterHourConsumption) {
        this.totalConstantQuarterHourConsumption = totalConstantQuarterHourConsumption;
    }

    public long getManagementUnitId() {
        return managementUnitId;
    }

    public void setManagementUnitId(long managementUnitId) {
        this.managementUnitId = managementUnitId;
    }
}
