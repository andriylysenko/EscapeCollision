package com.asl.escapecollision.game.eventbus.events;

/**
 * Created by asl on 10/3/17.
 */

public class MovementEvent extends GameEvent {

    private final double deltaTime;

    public MovementEvent(double time, double deltaTime) {
        super(time);
        this.deltaTime = deltaTime;
    }

    public double getDeltaTime() {
        return deltaTime;
    }
}
