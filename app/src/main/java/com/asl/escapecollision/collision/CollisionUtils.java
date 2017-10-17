package com.asl.escapecollision.collision;

import com.asl.escapecollision.game.shapes.Ball3D;
import com.asl.escapecollision.game.shapes.Wall;

/**
 * Created by asl on 10/8/17.
 */

public class CollisionUtils {

    public static double timeToHit(Ball3D ball1, Ball3D ball2) {
        if (ball1 == ball2) {
            return Float.POSITIVE_INFINITY;
        }
        double dx  = ball2.getX() - ball1.getX();
        double dy  = ball2.getY() - ball1.getY();
        double dz  = ball2.getZ() - ball1.getZ();
        double dvx = ball2.getVx() - ball1.getVx();
        double dvy = ball2.getVy() - ball1.getVy();
        double dvz = ball2.getVz() - ball1.getVz();

        double discriminant = Math.pow(2 * (dx*dvx + dy*dvy + dz*dvz), 2) - 4 * (dvx*dvx + dvy*dvy + dvz*dvz) * (dx*dx + dy*dy + dz*dz - Math.pow(ball1.getRadius() + ball2.getRadius(), 2));
        if (discriminant < 0) {
            return Double.POSITIVE_INFINITY;
        }
        double t1 = (-2 * (dx*dvx + dy*dvy + dz*dvz) - Math.sqrt(discriminant)) / (2 * (dvx*dvx + dvy*dvy + dvz*dvz));
//        float t2 = (-2 * (dx*dvx + dy*dvy + dz*dvz) + Math.sqrt(discriminant)) / (2 * (dvx*dvx + dvy*dvy + dvz*dvz));

        if (t1 < 0) {
            return Double.POSITIVE_INFINITY;
        }
        return t1;
    }

    public static double timeToHitVerticalWall(Ball3D ball, Wall wall) {
        double time = Double.POSITIVE_INFINITY;
        if (ball.getVx() > 0) {
            time = ((wall.getX() - wall.getLength() / 2) - (ball.getX() + ball.getRadius())) / ball.getVx();
        } else if (ball.getVx() < 0) {
            time = ((wall.getX() + wall.getLength() / 2) + (ball.getRadius() - ball.getX())) / ball.getVx();
        }
        return time >= 0 ? time : Double.POSITIVE_INFINITY;
    }

    public static double timeToHitHorizontalWall(Ball3D ball, Wall wall) {
        double time = Double.POSITIVE_INFINITY;
        if (ball.getVy() > 0) {
            time = ((wall.getY() - wall.getHeight() / 2) - (ball.getY() + ball.getRadius())) / ball.getVy();
        } else if (ball.getVy() < 0) {
            time = ((wall.getY() - wall.getHeight() / 2) + (ball.getRadius() - ball.getY())) / ball.getVy();
        }
        return time >= 0 ? time : Double.POSITIVE_INFINITY;
    }

    public static double timeToHitSideWall(Ball3D ball, Wall wall) {
        double time = Double.POSITIVE_INFINITY;
        if (ball.getVz() > 0) {
            time = ((wall.getZ() - wall.getWidth() / 2) - (ball.getZ() + ball.getRadius())) / ball.getVz();
        } else if (ball.getVz() < 0) {
            time = ((wall.getZ() + wall.getWidth() / 2) + (ball.getRadius() - ball.getZ())) / ball.getVz();
        }
        return time >= 0 ? time : Double.POSITIVE_INFINITY;
    }

    public static float[] velocitiesAfterBounce(Ball3D ball1, Ball3D ball2) {
        float dx  = ball2.getX() - ball1.getX();
        float dy  = ball2.getY() - ball1.getY();
        float dz  = ball2.getZ() - ball1.getZ();

        float dvx = ball2.getVx() - ball1.getVx();
        float dvy = ball2.getVy() - ball1.getVy();
        float dvz = ball2.getVz() - ball1.getVz();
        float dvdr = dx*dvx + dy*dvy + dz*dvz;
        float dist = ball1.getRadius() + ball2.getRadius();

        float vx1 = ball1.getVx() - (2 * ball2.getMass() / (ball1.getMass() + ball2.getMass())) * (dvdr * (-dx) / (dist * dist));
        float vy1 = ball1.getVy() - (2 * ball2.getMass() / (ball1.getMass() + ball2.getMass())) * (dvdr * (-dy) / (dist * dist));
        float vz1 = ball1.getVz() - (2 * ball2.getMass() / (ball1.getMass() + ball2.getMass())) * (dvdr * (-dz) / (dist * dist));

        float vx2 = ball2.getVx() - (2 * ball1.getMass()/ (ball1.getMass() + ball2.getMass())) * (dvdr * (dx) / (dist * dist));
        float vy2 = ball2.getVy() - (2 * ball1.getMass()/ (ball1.getMass() + ball2.getMass())) * (dvdr * (dy) / (dist * dist));
        float vz2 = ball2.getVz() - (2 * ball1.getMass()/ (ball1.getMass() + ball2.getMass())) * (dvdr * (dz) / (dist * dist));

        return new float[] {vx1, vy1, vz1, vx2, vy2, vz2};
    }
}
