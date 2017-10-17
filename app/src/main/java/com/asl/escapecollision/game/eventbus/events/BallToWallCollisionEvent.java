package com.asl.escapecollision.game.eventbus.events;

import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/4/17.
 */

public class BallToWallCollisionEvent extends GameEvent {

    private final Ball3D ball;

    private final int directionChanges;


    public BallToWallCollisionEvent(double time, Ball3D ball) {
        super(time);
        this.ball = ball;

        directionChanges = ball.getDirectionChanges();
    }

    @Override
    public boolean isValid() {
        return super.isValid() && directionChanges == ball.getDirectionChanges();
    }

    public Ball3D getBall() {
        return ball;
    }
}
