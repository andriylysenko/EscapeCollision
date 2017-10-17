package com.asl.escapecollision.game;

import com.asl.escapecollision.game.eventbus.EventBus;
import com.asl.escapecollision.game.eventbus.events.BallToBallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToHorizontalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToSideWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.BallToVerticalWallCollisionEvent;
import com.asl.escapecollision.game.eventbus.events.GameEvent;
import com.asl.escapecollision.game.eventbus.events.MovementEvent;
import com.asl.escapecollision.game.eventbus.events.PredictionEvent;
import com.asl.escapecollision.game.eventbus.events.TickerEvent;
import com.asl.escapecollision.game.eventbus.listeners.BallToBallCollisionEventListener;
import com.asl.escapecollision.game.eventbus.listeners.BallToHorizontalWallCollisionEventListener;
import com.asl.escapecollision.game.eventbus.listeners.BallToSideWallCollisionEventListener;
import com.asl.escapecollision.game.eventbus.listeners.BallToVerticalWallCollisionEventListener;
import com.asl.escapecollision.game.eventbus.listeners.MovementEventListener;
import com.asl.escapecollision.game.eventbus.listeners.PredictionEventListener;
import com.asl.escapecollision.game.eventbus.listeners.TickerEventListener;
import com.asl.escapecollision.game.shapes.Ball3D;
import com.asl.escapecollision.game.shapes.Wall;
import com.asl.predicate.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by asl on 9/4/17.
 */

public class CollisionGame {

    private EventBus bus;
    private Queue<GameEvent> events;
    private List<Ball3D> balls;

    private List<Wall> verticalWalls;
    private List<Wall> horizontalWalls;
    private List<Wall> sideWalls;


//    private Wall leftWall;
//    private Wall topWall;
//    private Wall rightWall;
//    private Wall bottomWall;
//    private Wall backWall;
//    private Wall frontWall;

    private Double gameTime;

    public CollisionGame() {
        bus = new EventBus();
        events = new PriorityQueue<>();
        balls = new ArrayList<>();
        verticalWalls = new ArrayList<>();
        horizontalWalls = new ArrayList<>();
        sideWalls = new ArrayList<>();
        gameTime = 0d;
    }

    public void init() {
//        float color[] = {0.63671875f, 0.76953125f, 0.22265625f, 1f};
        float color[] = {1f, 1f, 1f, 1f};

        verticalWalls.add(new Wall(0.1f, 8.1f, 8.1f, -4.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        verticalWalls.add(new Wall(0.1f, 8.1f, 8.1f, 4.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        horizontalWalls.add(new Wall(8.1f, 0.1f, 8.1f, 0.0f, 4.1f, 0.0f, 0.0f, 0.0f, 0.0f));
        horizontalWalls.add(new Wall(8.1f, 0.1f, 8.1f, 0.0f, -4.1f, 0.0f, 0.0f, 0.0f, 0.0f));
        sideWalls.add(new Wall(8.1f, 8.1f, 0.1f, 0.0f, 0.0f, -4.1f, 0.0f, 0.0f, 0.0f));
        sideWalls.add(new Wall(8.1f, 8.1f, 0.1f, 0.0f, 0.0f, 4.1f, 0.0f, 0.0f, 0.0f));

//        for ()

        balls.add(new Ball3D(1f, color, 0.1f, 0.1f, 0.1f, -0.04f, 0.05f, -0.07f, 0.90f));
        balls.add(new Ball3D(0.9f, color, -0.3f, 0.1f, 0.1f, -0.05f, -0.001f, 0.005f, 0.10f));
        balls.add(new Ball3D(0.6f, color, -0.3f, 0.1f, 0.1f, 0.008f, -0.03f, -0.009f, 0.10f));
        balls.add(new Ball3D(0.8f, color, 0.1f, 0.1f, 0.1f, -0.004f, 0.045f, -0.027f, 0.10f));
        balls.add(new Ball3D(0.7f, color, -0.3f, 0.1f, 0.1f, -0.065f, -0.001f, 0.005f, 0.10f));
        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.0108f, 0.03f, -0.009f, 0.10f));
        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, -0.034f, 0.015f, -0.07f, 0.10f));
        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, 0.045f, -0.0051f, 0.005f, 0.10f));
        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.0068f, -0.033f, -0.009f, 0.10f));
        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, 0.0024f, -0.075f, -0.027f, 0.10f));
        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, -0.0465f, -0.001f, 0.005f, 0.10f));
        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.0608f, 0.03f, -0.009f, 0.10f));

//        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, -0.014f, 0.05f, 0.07f, 0.10f));
//        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, -0.035f, -0.001f, 0.05f, 0.10f));
//        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.0048f, -0.03f, 0.09f, 0.10f));
//        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, -0.002f, 0.045f, -0.07f, 0.10f));
//        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, -0.05f, -0.001f, -0.002f, 0.10f));
//        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.018f, 0.03f, -0.009f, 0.10f));
//        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, -0.04f, 0.015f, 0.097f, 0.10f));
//        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, 0.145f, -0.0051f, 0.015f, 0.10f));
//        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.068f, -0.033f, 0.09f, 0.10f));
//        balls.add(new Ball3D(0.3f, color, 0.1f, 0.1f, 0.1f, 0.004f, -0.075f, 0.037f, 0.10f));
//        balls.add(new Ball3D(0.2f, color, -0.3f, 0.1f, 0.1f, -0.045f, -0.001f, 0.015f, 0.10f));
//        balls.add(new Ball3D(0.4f, color, -0.3f, 0.1f, 0.1f, 0.06f, 0.03f, 0.019f, 0.10f));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof TickerEvent;
            }
        }, new TickerEventListener(events));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof MovementEvent;
            }
        }, new MovementEventListener(balls));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof PredictionEvent;
            }
        }, new PredictionEventListener(events, verticalWalls, horizontalWalls, sideWalls, balls));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof BallToVerticalWallCollisionEvent;
            }
        }, new BallToVerticalWallCollisionEventListener(bus));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof BallToHorizontalWallCollisionEvent;
            }
        }, new BallToHorizontalWallCollisionEventListener(bus));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof BallToSideWallCollisionEvent;
            }
        }, new BallToSideWallCollisionEventListener(bus));

        bus.subscribe("main_events", new Predicate<GameEvent>() {
            @Override
            public boolean test(GameEvent obj) {
                return obj instanceof BallToBallCollisionEvent;
            }
        }, new BallToBallCollisionEventListener(bus));

        for (Ball3D ball : balls) {
            bus.publish("main_events", new PredictionEvent(0, ball));
        }

        bus.publish("main_events", new TickerEvent(0));

        new Thread(new CollisionGameThread()).start();
    }

    public void draw(float[] mvMatrix, float[] projectionMatrix, float[] lightPosInEyeSpace) {
//        float[] scratch = new float[16];
//        Matrix.setIdentityM(scratch, 0);
//        Matrix.translateM(scratch, 0, -1f, -0.5f, 0f);
//        Matrix.multiplyMM(scratch, 0, mvMatrix, 0, scratch.clone(), 0);
//        sphere2.draw(scratch, projectionMatrix, lightPosInEyeSpace);
//
//        Matrix.setIdentityM(scratch, 0);
//        Matrix.translateM(scratch, 0, 1f, 0.5f, 1f);
//        Matrix.multiplyMM(scratch, 0, mvMatrix, 0, scratch.clone(), 0);
//        cube.draw(scratch, projectionMatrix, lightPosInEyeSpace);

        for (Ball3D ball : balls) {
            ball.draw(mvMatrix, projectionMatrix, lightPosInEyeSpace);
        }

        for (Wall wall : verticalWalls) {
            wall.draw(mvMatrix, projectionMatrix, lightPosInEyeSpace);
        }
        for (Wall wall : horizontalWalls) {
            wall.draw(mvMatrix, projectionMatrix, lightPosInEyeSpace);
        }
        for (Wall wall : sideWalls) {
            wall.draw(mvMatrix, projectionMatrix, lightPosInEyeSpace);
        }
    }

    private class CollisionGameThread implements Runnable {

        @Override
        public void run() {
            while (!events.isEmpty()) {
                GameEvent event = events.remove();
                if (!event.isValid()) {
                    continue;
                }

                bus.publish("main_events", new MovementEvent(event.getTime(), event.getTime() - gameTime));
                bus.publish("main_events", event);

                gameTime = event.getTime();
            }
        }
    }
}
