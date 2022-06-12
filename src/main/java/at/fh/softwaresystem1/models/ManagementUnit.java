package at.fh.softwaresystem1.models;

import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@SessionScope
public class ManagementUnit {
    long id;
    List<PowerConsumer> consumers;
    List<LimitValues> defaultValues;
    String NetworkIdentifier;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PowerConsumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<PowerConsumer> consumers) {
        this.consumers = consumers;
    }

    public List<LimitValues> getDefaultValues() {
        return defaultValues;
    }

    public void setDefaultValues(List<LimitValues> defaultValues) {
        this.defaultValues = defaultValues;
    }

    public String getNetworkIdentifier() {
        return NetworkIdentifier;
    }

    public void setNetworkIdentifier(String networkIdentifier) {
        NetworkIdentifier = networkIdentifier;
    }
}
