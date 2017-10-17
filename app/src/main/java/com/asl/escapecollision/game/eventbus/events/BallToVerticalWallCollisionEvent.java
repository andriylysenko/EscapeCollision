package com.asl.escapecollision.game.eventbus.events;

import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/4/17.
 */

public class BallToVerticalWallCollisionEvent extends BallToWallCollisionEvent {

    public BallToVerticalWallCollisionEvent(double time, Ball3D ball) {
        super(time, ball);
    }

}
