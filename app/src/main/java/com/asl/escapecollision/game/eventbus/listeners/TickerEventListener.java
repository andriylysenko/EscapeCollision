package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.GameEvent;
import com.asl.escapecollision.game.eventbus.events.TickerEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

import java.util.List;
import java.util.Queue;

/**
 * Created by asl on 10/2/17.
 */

public class TickerEventListener implements EventListener<TickerEvent> {

    private Queue<GameEvent> events;

    public TickerEventListener(Queue<GameEvent> events) {
        this.events = events;
    }

    @Override
    public void onEvent(TickerEvent event) {
        GameEvent tickerEvent = new TickerEvent(event.getTime() + 1.0);
        events.add(tickerEvent);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }
}
