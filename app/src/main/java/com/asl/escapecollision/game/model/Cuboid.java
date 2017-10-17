package com.asl.escapecollision.game.model;

/**
 * Created by asl on 9/16/17.
 */

public class Cuboid extends ModelWithSpotLight implements Model {

    private float vertices[];
    private float colors[];
    private float normals[];

    public Cuboid(float length, float height, float width) {
        vertices = new float[] {
                // Front face
                -length/2.0f, height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, width/2.0f,
                length/2.0f, -height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, width/2.0f,

                // Right face
                length/2.0f, height/2.0f, width/2.0f,
                length/2.0f, -height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, -width/2.0f,
                length/2.0f, -height/2.0f, width/2.0f,
                length/2.0f, -height/2.0f, -width/2.0f,
                length/2.0f, height/2.0f, -width/2.0f,

                // Back face
                length/2.0f, height/2.0f, -width/2.0f,
                length/2.0f, -height/2.0f, -width/2.0f,
                -length/2.0f, height/2.0f, -width/2.0f,
                length/2.0f, -height/2.0f, -width/2.0f,
                -length/2.0f, -height/2.0f, -width/2.0f,
                -length/2.0f, height/2.0f, -width/2.0f,

                // Left face
                -length/2.0f, height/2.0f, -width/2.0f,
                -length/2.0f, -height/2.0f, -width/2.0f,
                -length/2.0f, height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, -width/2.0f,
                -length/2.0f, -height/2.0f, width/2.0f,
                -length/2.0f, height/2.0f, width/2.0f,

                // Top face
                -length/2.0f, height/2.0f, -width/2.0f,
                -length/2.0f, height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, -width/2.0f,
                -length/2.0f, height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, width/2.0f,
                length/2.0f, height/2.0f, -width/2.0f,

                // Bottom face
                length/2.0f, -height/2.0f, -width/2.0f,
                length/2.0f, -height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, -width/2.0f,
                length/2.0f, -height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, width/2.0f,
                -length/2.0f, -height/2.0f, -width/2.0f,
        };

        colors = new float[] {
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,

                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,

                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,

                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,

                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,

                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
                0.0f, 0.0f, 1.0f, 1.0f,
        };

        normals = new float[] {
                // Front face
                -0.0f, 0.0f, 1.0f,
                -0.0f, 0.0f, 1.0f,
                -0.0f, 0.0f, 1.0f,
                -0.0f, 0.0f, 1.0f,
                -0.0f, 0.0f, 1.0f,
                -0.0f, 0.0f, 1.0f,

                // Right face
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,

                // Back face
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,
                0.0f, 0.0f, -1.0f,

                // Left face
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,
                -1.0f, 0.0f, 0.0f,

                // Top face
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,

                // Bottom face
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f,
                0.0f, -1.0f, 0.0f
        };
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
