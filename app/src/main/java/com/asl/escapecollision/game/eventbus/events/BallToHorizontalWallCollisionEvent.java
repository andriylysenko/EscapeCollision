package com.asl.escapecollision.game.eventbus.events;

import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/4/17.
 */

public class BallToHorizontalWallCollisionEvent extends BallToWallCollisionEvent {

    public BallToHorizontalWallCollisionEvent(double time, Ball3D ball) {
        super(time, ball);
    }

}
