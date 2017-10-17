package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.MovementEvent;
import com.asl.escapecollision.game.shapes.Ball3D;

import java.util.List;

/**
 * Created by asl on 10/3/17.
 */

public class MovementEventListener implements EventListener<MovementEvent> {

    private List<Ball3D> balls;

    public MovementEventListener(List<Ball3D> balls) {
        this.balls = balls;
    }

    @Override
    public void onEvent(MovementEvent event) {
        for (Ball3D ball : balls) {
            ball.move(event.getDeltaTime());
        }
    }
}
