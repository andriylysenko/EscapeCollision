package com.asl.escapecollision.game.eventbus.events;

import com.asl.escapecollision.game.shapes.Ball3D;

/**
 * Created by asl on 10/8/17.
 */

public class PredictionEvent extends GameEvent {

    private final Ball3D ball;

    public PredictionEvent(double time, Ball3D ball) {
        super(time);
        this.ball = ball;
    }

    public Ball3D getBall() {
        return ball;
    }
}
