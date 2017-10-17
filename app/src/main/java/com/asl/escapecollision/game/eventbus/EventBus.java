package com.asl.escapecollision.game.eventbus;

import com.asl.escapecollision.game.eventbus.events.GameEvent;
import com.asl.predicate.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asl on 10/1/17.
 */

public class EventBus {
    private Map<String, Collection<Subscription>> subscriptions;

    public EventBus() {
        subscriptions = new HashMap<>();
    }

    public void subscribe(String topic, Predicate<? extends GameEvent> selector, EventListener<? extends GameEvent> listener) {
        if (!subscriptions.containsKey(topic)) {
            subscriptions.put(topic, new ArrayList<Subscription>());
        }

        subscriptions.get(topic).add(new Subscription(selector, listener));
    }

    public void publish(String topic, GameEvent event) {
        if (!subscriptions.containsKey(topic)) {
            return;
        }

        for (Subscription subscription : subscriptions.get(topic)) {
            if (subscription.getSelector().test(event)) {
                subscription.getListener().onEvent(event);
            }
        }
    }
    private static class Subscription<T> {
        private Predicate<T> selector;
        private EventListener<T> listener;

        public Subscription(Predicate<T> selector, EventListener<T> listener) {
            this.selector = selector;
            this.listener = listener;
        }

        public Predicate<T> getSelector() {
            return selector;
        }

        public EventListener<T> getListener() {
            return listener;
        }
    }
}
