package com.asl.escapecollision.game.shapes;

import android.opengl.Matrix;

import com.asl.escapecollision.game.model.Model;
import com.asl.escapecollision.game.model.Sphere;

/**
 * Created by asl on 9/21/17.
 */

public class Ball3D {
    private Model model;

    private final float radius;
    private float[] color;

    private float x;
    private float y;
    private float z;
    private float vx;
    private float vy;
    private float vz;

    private final float mass;

    private int directionChanges = 0;

    private float[] modelMatrix = new float[16];

    public Ball3D(float radius, float[] color, float x, float y, float z, float vx, float vy, float vz, float mass) {
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
        this.z = z;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.mass = mass;

        model = new Sphere(radius, color, 32, 64/*64, 128*/);
    }

    public void move(double dt) {
        x += vx * dt;
        y += vy * dt;
        z += vz * dt;
    }

    public void changeDirection(float vx, float vy, float vz) {
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.directionChanges++;
    }

    public void draw(float[] mvMatrix, float[] projectionMatrix, float[] lightPosInEyeSpace) {
        Matrix.setIdentityM(modelMatrix, 0);
        Matrix.translateM(modelMatrix, 0, x, y, z);
        Matrix.multiplyMM(modelMatrix, 0, mvMatrix, 0, modelMatrix.clone(), 0);
        model.draw(modelMatrix, projectionMatrix, lightPosInEyeSpace);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getVx() {
        return vx;
    }

    public float getVy() {
        return vy;
    }

    public float getVz() {
        return vz;
    }

    public float getMass() {
        return mass;
    }

    public float getRadius() {
        return radius;
    }

    public int getDirectionChanges() {
        return directionChanges;
    }
}
