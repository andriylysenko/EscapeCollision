package com.asl.escapecollision.game.shapes;

import android.opengl.Matrix;

import com.asl.escapecollision.game.model.Cuboid;
import com.asl.escapecollision.game.model.Model;

/**
 * Created by asl on 9/26/17.
 */

public class Wall {
    private Model model;

    private float length;
    private float height;
    private float width;

    private float x;
    private float y;
    private float z;

    private float xAngle;
    private float yAngle;
    private float zAngle;

    private float[] modelMatrix = new float[16];

    public Wall(float length, float height, float width, float x, float y, float z, float xAngle, float yAngle, float zAngle) {
        this.length = length;
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
        this.z = z;
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;

        model = new Cuboid(length, height, width);
    }

    public Wall(float length, float height, float width, float x, float y, float z) {
        this(length, height, width, x, y, z, 0f, 0f, 0f);
    }

    public void draw(float[] mvMatrix, float[] projectionMatrix, float[] lightPosInEyeSpace) {
        Matrix.setIdentityM(modelMatrix, 0);
        Matrix.setRotateM(modelMatrix, 0, xAngle, 1.0f, 0.0f, 0.0f);
        Matrix.setRotateM(modelMatrix, 0, yAngle, 0.0f, 1.0f, 0.0f);
        Matrix.setRotateM(modelMatrix, 0, yAngle, 0.0f, 0.0f, 1.0f);

        Matrix.translateM(modelMatrix, 0, x, y, z);

        Matrix.multiplyMM(modelMatrix, 0, mvMatrix, 0, modelMatrix.clone(), 0);
        model.draw(modelMatrix, projectionMatrix, lightPosInEyeSpace);
    }

    public void move(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void rotate(float xAngle, float yAngle, float zAngle) {
        this.xAngle = xAngle;
        this.yAngle = yAngle;
        this.zAngle = zAngle;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
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

    public float getxAngle() {
        return xAngle;
    }

    public float getyAngle() {
        return yAngle;
    }

    public float getzAngle() {
        return zAngle;
    }
}
