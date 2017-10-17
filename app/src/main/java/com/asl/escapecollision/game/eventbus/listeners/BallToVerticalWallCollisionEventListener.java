package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.BallToVerticalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/5/17.
 */

public class BallToVerticalWallCollisionEventListener implements EventListener<BallToVerticalWallCollisionEvent> {

    private final EventBus bus;

    public BallToVerticalWallCollisionEventListener(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(BallToVerticalWallCollisionEvent event) {
        Ball3D ball = event.getBall();
        ball.changeDirection(ball.getVx() * (-1), ball.getVy(), ball.getVz());

        bus.publish("main_events", new PredictionEvent(event.getTime(), ball));
    }
}
