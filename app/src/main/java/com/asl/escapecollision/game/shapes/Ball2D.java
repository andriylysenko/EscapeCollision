package com.asl.escapecollision.game.shapes;

import android.graphics.Color;
import android.opengl.Matrix;

import com.asl.escapecollision.game.model.Circle;
import com.asl.escapecollision.game.model.Model;

/**
 * Created by asl on 9/6/17.
 */

public class Ball2D {
    private Model model;

    private final float radius;
    private float[] color;

    private float x;
    private float y;
    private float vx;
    private float vy;

    private final float mass;

    public Ball2D(float radius, float[] color, float x, float y, float vx, float vy, float mass) {
        this.radius = radius;
        this.color = color;
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.mass = mass;

        model = new Circle(this.radius, this.color);
    }

    public void draw(float[] mvMatrix, float[] projectionMatrix, float[] lightPosInEyeSpace) {
        float[] rotationMatrix  = new float[16];
        float[] translationMatrix = new float[16];
        float[] scratch = new float[16];

        Matrix.setIdentityM(rotationMatrix, 0);
        Matrix.setIdentityM(translationMatrix, 0);
        Matrix.setIdentityM(scratch, 0);

        Matrix.translateM(translationMatrix, 0, x, y, 0);
        Matrix.setRotateM(rotationMatrix, 0, 0.1f, 0, 0, 1.0f);

        Matrix.multiplyMM(scratch, 0, translationMatrix, 0, rotationMatrix, 0);
        Matrix.multiplyMM(scratch, 0, mvMatrix, 0, scratch.clone(), 0);

        model.draw(scratch, projectionMatrix, lightPosInEyeSpace);
    }
}
