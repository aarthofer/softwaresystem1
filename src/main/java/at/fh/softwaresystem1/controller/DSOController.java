package at.fh.softwaresystem1.controller;

import at.fh.softwaresystem1.core.DSOManagement;
import at.fh.softwaresystem1.core.FlexLoadTriggerListener;
import at.fh.softwaresystem1.models.FlexLoadState;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/dso")
public class DSOController implements FlexLoadTriggerListener {

    @Resource
    DSOManagement controller;

    List<SseEmitter> clients = new LinkedList<>();

    @PostConstruct
    public void postConstruct() {
        controller.setTriggerListener(this);
    }

    @RequestMapping(value = "totalEnergy", method = RequestMethod.GET)
    Double getTotalEnergy() {
        Double energy = controller.currentTotalEnergy();
        System.out.println(String.format("#####: Current total energy %f", energy));
        return energy;
    }

    @RequestMapping(value = "switchFlexPowerAvailable", method = RequestMethod.GET)
    String switchFlexPowerAvailable(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.triggerFlexPower(flexPowerAvailable);
        return "Flex Power is now " + (flexPowerAvailable ? "available" : "not available");
    }

    @RequestMapping(value = "switchWind", method = RequestMethod.GET)
    String switchWind(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.switchWind(flexPowerAvailable);
        return "Wind is " + (flexPowerAvailable ? "available" : "not available");
    }

    @RequestMapping(value = "switchSun", method = RequestMethod.GET)
    String switchSun(@RequestParam("enable") boolean flexPowerAvailable) {
        controller.switchSun(flexPowerAvailable);
        return "Sun is " + (flexPowerAvailable ? "available" : "not available");
    }

    @RequestMapping(value = "/triggerFlexPower", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter triggerFlexPower() {
        SseEmitter emitter = new SseEmitter();
        emitter.onCompletion(() -> clients.remove(emitter));
        emitter.onError(throwable -> clients.remove(emitter));
        clients.add(emitter);
        return emitter;
    }

    @Override
    public void sendTrigger(FlexLoadState state) {
        for (SseEmitter emitter :
                clients) {
            try {
                SseEmitter.SseEventBuilder event = SseEmitter.event()
                        .data(state.getValue())
                        .name("onmessage ");
                emitter.send(event);
            } catch (Exception ex) {
                emitter.completeWithError(ex);
                System.out.println(ex);
            }
        }
    }
}
