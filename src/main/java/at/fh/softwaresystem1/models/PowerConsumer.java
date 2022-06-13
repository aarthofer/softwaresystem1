package at.fh.softwaresystem1.models;

import java.util.Map;

public class PowerConsumer {
    DeviceType type;
    private long id;
    private String name;
    private boolean interuptableEnabled;
    private Map<String, Object> attributes;
    private boolean currentlyConsuming;
    private String deviceAddress;

    public PowerConsumer(long id, String name, boolean interuptableEnabled, Map<String, Object> attributes, boolean currentlyConsuming, String deviceAddress, DeviceType type) {
        this.id = id;
        this.name = name;
        this.interuptableEnabled = interuptableEnabled;
        this.attributes = attributes;
        this.currentlyConsuming = currentlyConsuming;
        this.deviceAddress = deviceAddress;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInteruptableEnabled() {
        return interuptableEnabled;
    }

    public void setInteruptableEnabled(boolean interuptableEnabled) {
        this.interuptableEnabled = interuptableEnabled;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public boolean isCurrentlyConsuming() {
        return currentlyConsuming;
    }

    public void setCurrentlyConsuming(boolean currentlyConsuming) {
        this.currentlyConsuming = currentlyConsuming;
    }

    public String getDeviceAddress() {
        return deviceAddress;
    }

    public void setDeviceAddress(String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }
}
