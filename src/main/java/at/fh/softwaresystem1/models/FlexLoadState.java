package at.fh.softwaresystem1.models;

public class FlexLoadState {
    State state;

    public FlexLoadState(State state) {
        this.state = state;
    }

    public String getValue() {
        return state.name();
    }
}
