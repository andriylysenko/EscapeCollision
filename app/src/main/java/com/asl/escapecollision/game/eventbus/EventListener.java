package com.asl.escapecollision.game.eventbus;

import com.asl.escapecollision.game.eventbus.events.GameEvent;

/**
 * Created by asl on 10/1/17.
 */

public interface EventListener<E> {

    void onEvent(E event);

}
