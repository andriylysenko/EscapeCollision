package com.asl.escapecollision.game.model;

/**
 * Created by asl on 9/6/17.
 */

public class Circle extends ModelWithSpotLight implements Model {

    private float radius;

    private float vertices[];
    private float colors[] ;
    private float normals[];

    public Circle(float radius, float[] color) {
        this.radius = radius;

        int peaces = 180;
        vertices = new float[peaces * 3 * 3];
        colors =  new float[peaces * 4 * 3];
        normals =  new float[peaces * 3 * 3];

        int vertexPosition = 0;
        int colorPosition = 0;
        int normalPosition = 0;

        for (int i = 0; i < peaces; i++) {
            vertices[vertexPosition++] = 0;
            vertices[vertexPosition++] = 0;
            vertices[vertexPosition++] = 0f;

            vertices[vertexPosition++] = (float) (this.radius * Math.cos((2 * Math.PI) * (float) i / peaces));
            vertices[vertexPosition++] = (float) (this.radius * Math.sin((2 * Math.PI) * (float) i / peaces));
            vertices[vertexPosition++] = 0f;

            vertices[vertexPosition++] = (float) (this.radius * Math.cos((2 * Math.PI) * (float) (i + 1) / peaces));
            vertices[vertexPosition++] = (float) (this.radius * Math.sin((2 * Math.PI) * (float) (i + 1) / peaces));
            vertices[vertexPosition++] = 0f;

            for (int k = 0; k < 4 * 3; k++) {
                colors[colorPosition++] = color[k%4]/* + colorPosition/100000f*/;
            }

            for (int k = 0; k < 3; k++) {
                normals[normalPosition++] = 0f;
                normals[normalPosition++] = 0f;
                normals[normalPosition++] = 1f;
            }
        }
    }

    @Override
    protected float[] getVertices() {
        return vertices;
    }

    @Override
    protected float[] getColors() {
        return colors;
    }

    @Override
    protected float[] getNormals() {
        return normals;
    }
}
