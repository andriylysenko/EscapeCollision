package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.collision.CollisionUtils;
import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.BallToBallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/9/17.
 */

public class BallToBallCollisionEventListener implements EventListener<BallToBallCollisionEvent> {

    private final EventBus bus;

    public BallToBallCollisionEventListener(EventBus bus) {
        this.bus = bus;
    }

    @Override
    public void onEvent(BallToBallCollisionEvent event) {
        Ball3D ball1 = event.getBall1();
        Ball3D ball2 = event.getBall2();

        float velocities[] = CollisionUtils.velocitiesAfterBounce(ball1, ball2);

        ball1.changeDirection(velocities[0], velocities[1], velocities[2]);
        ball2.changeDirection(velocities[3], velocities[4], velocities[5]);

        bus.publish("main_events", new PredictionEvent(event.getTime(), ball1));
        bus.publish("main_events", new PredictionEvent(event.getTime(), ball2));
    }
}
