package com.asl.escapecollision.game.eventbus.listeners;

import com.asl.escapecollision.collision.CollisionUtils;
import com.asl.escapecollision.game.eventbus.EventListener;
import com.asl.escapecollision.game.eventbus.events.BallToBallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToHorizontalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToSideWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToVerticalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.GameEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.shapes.Ball3D;
import com.asl.escapecollision.game.shapes.Wall;

import java.util.List;
import java.util.Queue;

/**
 * Created by asl on 10/8/17.
 */

public class PredictionEventListener implements EventListener<PredictionEvent> {

    private final Queue<GameEvent> events;
    private final List<Wall> verticalWalls;
    private final List<Wall> horizontalWalls;
    private final List<Wall> sideWalls;
    private final List<Ball3D> balls;

    public PredictionEventListener(Queue<GameEvent> events, List<Wall> verticalWalls, List<Wall> horizontalWalls, List<Wall> sideWalls, List<Ball3D> balls) {
        this.events = events;
        this.verticalWalls = verticalWalls;
        this.horizontalWalls = horizontalWalls;
        this.sideWalls = sideWalls;
        this.balls = balls;
    }

    @Override
    public void onEvent(PredictionEvent event) {
        for (Wall wall : verticalWalls) {
            double time = CollisionUtils.timeToHitVerticalWall(event.getBall(), wall);
            if (time != Double.POSITIVE_INFINITY) {
                events.add(new BallToVerticalWallCollisionEvent(event.getTime() + time, event.getBall()));
            }
        }

        for (Wall wall : horizontalWalls) {
            double time = CollisionUtils.timeToHitHorizontalWall(event.getBall(), wall);
            if (time != Double.POSITIVE_INFINITY) {
                events.add(new BallToHorizontalWallCollisionEvent(event.getTime() + time, event.getBall()));
            }
        }

        for (Wall wall : sideWalls) {
            double time = CollisionUtils.timeToHitSideWall(event.getBall(), wall);
            if (time != Double.POSITIVE_INFINITY) {
                events.add(new BallToSideWallCollisionEvent(event.getTime() + time, event.getBall()));
            }
        }

        for (Ball3D ball : balls) {
            double time = CollisionUtils.timeToHit(event.getBall(), ball);
            if (time != Double.POSITIVE_INFINITY) {
                events.add(new BallToBallCollisionEvent(event.getTime() + time, event.getBall(), ball));
            }
        }
    }

}
