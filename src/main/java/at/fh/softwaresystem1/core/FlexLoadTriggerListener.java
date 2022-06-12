package at.fh.softwaresystem1.core;

import at.fh.softwaresystem1.models.FlexLoadState;

import java.util.EventListener;

public interface FlexLoadTriggerListener extends EventListener {
    void sendTrigger(FlexLoadState state);
}
