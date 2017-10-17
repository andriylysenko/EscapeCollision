package com.asl.escapecollision.game.model;

/**
 * Created by asl on 9/6/17.
 */

public interface Model {
    void draw(float[] mvMatrix, float[] projectionMatrix, float[] lightPosInEyeSpace);
}
