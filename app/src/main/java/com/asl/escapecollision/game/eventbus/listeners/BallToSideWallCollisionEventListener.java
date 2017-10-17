package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.BallToSideWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/9/17.
 */

public class BallToSideWallCollisionEventListener implements EventListener<BallToSideWallCollisionEvent> {

    private final EventBus bus;

    public BallToSideWallCollisionEventListener(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(BallToSideWallCollisionEvent event) {
        Ball3D ball = event.getBall();
        ball.changeDirection(ball.getVx(), ball.getVy(), ball.getVz() * (-1));

        bus.publish("main_events", new PredictionEvent(event.getTime(), ball));
    }
}
