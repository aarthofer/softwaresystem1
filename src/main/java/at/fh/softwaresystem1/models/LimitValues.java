package at.fh.softwaresystem1.models;

import javax.persistence.*;

@Entity
@Table
public class LimitValues {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Object value;
    @Column
    private DeviceType deviceType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DeviceType getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
}
