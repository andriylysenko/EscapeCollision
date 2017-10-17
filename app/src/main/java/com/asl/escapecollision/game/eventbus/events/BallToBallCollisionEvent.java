package com.asl.escapecollision.game.eventbus.events;

import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 9/22/17.
 */

public class BallToBallCollisionEvent extends GameEvent {

    private final Ball3D ball1;
    private final Ball3D ball2;

    private final int directionChangesBall1;
    private final int directionChangesBall2;


    public BallToBallCollisionEvent(double time, Ball3D ball1, Ball3D ball2) {
        super(time);
        this.ball1 = ball1;
        this.ball2 = ball2;

        this.directionChangesBall1 = ball1.getDirectionChanges();
        this.directionChangesBall2 = ball2.getDirectionChanges();
    }

    @Override
    public boolean isValid() {
        return super.isValid()
                && directionChangesBall1 == ball1.getDirectionChanges()
                && directionChangesBall2 == ball2.getDirectionChanges();
    }

    public Ball3D getBall1() {
        return ball1;
    }

    public Ball3D getBall2() {
        return ball2;
    }
}
