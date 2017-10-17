package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.BallToHorizontalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/9/17.
 */

public class BallToHorizontalWallCollisionEventListener implements EventListener<BallToHorizontalWallCollisionEvent> {

    private final EventBus bus;

    public BallToHorizontalWallCollisionEventListener(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(BallToHorizontalWallCollisionEvent event) {
        Ball3D ball = event.getBall();
        ball.changeDirection(ball.getVx(), ball.getVy() * (-1), ball.getVz());

        bus.publish("main_events", new PredictionEvent(event.getTime(), ball));
    }
}
