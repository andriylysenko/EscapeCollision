package com.asl.escapecollision.game.eventbus.events;

import android.support.annotation.NonNull;

/**
 * Created by asl on 9/22/17.
 */

public class GameEvent implements Comparable<GameEvent> {
    private final double time;

    public GameEvent(double time) {
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    @Override
    public int compareTo(@NonNull GameEvent gameEvent) {
        return Double.compare(this.getTime(), gameEvent.getTime());
    }

    public boolean isValid() {
        return true;
    }
}
