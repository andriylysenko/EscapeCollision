package com.asl.escapecollision.game.model;

import android.opengl.GLES20;
import android.opengl.Matrix;

import com.asl.escapecollision.opengl.renderer.GameRenderer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/**
 * Created by asl on 9/10/17.
 */

public class Sphere extends ModelWithSpotLight implements Model {

    private float radius;
    private float vertices[];
    private float colors[];
    private float normals[];
    private float p1[] = new float[3];
    private float p2[] = new float[3];
    private float p3[] = new float[3];
    private float p1p2p3Normal[] = new float[3];

    private int longitudes = 10;
    private int latitudes = 20;

    public Sphere(float radius, float[] color, int longitudes, int latitudes) {
        this.radius = radius;
        this.longitudes = longitudes;
        this.latitudes = latitudes;

        vertices = new float[((longitudes) * (latitudes) * 6 - 6) * 3];
        colors = new float[((longitudes) * (latitudes) * 6 - 6) * 4];
        normals = new float[((longitudes) * (latitudes) * 6 - 6) * 3];

        int vertexPosition = 0;
        int colorPosition = 0;
        int normalPosition = 0;
        for (int i = 0; i < this.longitudes; i++) {
            float phi1 = (float) ((Math.PI) * (float) i / (float) this.longitudes);
            float phi2 = (float) ((Math.PI) * (float) (i + 1) / (float) this.longitudes);

            for (int j = 0; j < this.latitudes; j++) {
                float theta1 = (float) ((2 * Math.PI) * (float) j / (float) this.latitudes);
                float theta2 = (float) ((2 * Math.PI) * (float) (j + 1) / (float) this.latitudes);

                if (i == 0) {
                    p1[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta1));
                    p1[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta1));
                    p1[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p1[0];
                    vertices[vertexPosition++] = p1[1];
                    vertices[vertexPosition++] = p1[2];

                    p2[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta1));
                    p2[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta1));
                    p2[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p2[0];
                    vertices[vertexPosition++] = p2[1];
                    vertices[vertexPosition++] = p2[2];

                    p3[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta2));
                    p3[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta2));
                    p3[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p3[0];
                    vertices[vertexPosition++] = p3[1];
                    vertices[vertexPosition++] = p3[2];

                    for (int k = 0; k < 4 * 3; k++) {
                        colors[colorPosition++] = color[k%4]/* + colorPosition/100000f*/;
                    }

                    normal3d(p1p2p3Normal, p1, p2, p3);

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];
                } else if ((i + 1) == longitudes) {
                    p1[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta1));
                    p1[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta1));
                    p1[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p1[0];
                    vertices[vertexPosition++] = p1[1];
                    vertices[vertexPosition++] = p1[2];

                    p2[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta1));
                    p2[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta1));
                    p2[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p2[0];
                    vertices[vertexPosition++] = p2[1];
                    vertices[vertexPosition++] = p2[2];

                    p3[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta2));
                    p3[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta2));
                    p3[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p3[0];
                    vertices[vertexPosition++] = p3[1];
                    vertices[vertexPosition++] = p3[2];

                    for (int k = 0; k < 4 * 3; k++) {
                        colors[colorPosition++] = color[k%4]/* + colorPosition/100000f*/;
                    }

                    normal3d(p1p2p3Normal, p1, p2, p3);

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];
                } else {
                    p1[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta1));
                    p1[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta1));
                    p1[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p1[0];
                    vertices[vertexPosition++] = p1[1];
                    vertices[vertexPosition++] = p1[2];

                    p2[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta1));
                    p2[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta1));
                    p2[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p2[0];
                    vertices[vertexPosition++] = p2[1];
                    vertices[vertexPosition++] = p2[2];

                    p3[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta2));
                    p3[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta2));
                    p3[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p3[0];
                    vertices[vertexPosition++] = p3[1];
                    vertices[vertexPosition++] = p3[2];

                    for (int k = 0; k < 4 * 3; k++) {
                        colors[colorPosition++] = color[k%4]/* + colorPosition/100000f*/;
                    }

                    normal3d(p1p2p3Normal, p1, p2, p3);

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    p1[0] = (float) (this.radius * Math.sin(phi1) * Math.cos(theta2));
                    p1[1] = (float) (this.radius * Math.sin(phi1) * Math.sin(theta2));
                    p1[2] = (float) (this.radius * Math.cos(phi1));

                    vertices[vertexPosition++] = p1[0];
                    vertices[vertexPosition++] = p1[1];
                    vertices[vertexPosition++] = p1[2];

                    p2[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta1));
                    p2[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta1));
                    p2[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p2[0];
                    vertices[vertexPosition++] = p2[1];
                    vertices[vertexPosition++] = p2[2];

                    p3[0] = (float) (this.radius * Math.sin(phi2) * Math.cos(theta2));
                    p3[1] = (float) (this.radius * Math.sin(phi2) * Math.sin(theta2));
                    p3[2] = (float) (this.radius * Math.cos(phi2));

                    vertices[vertexPosition++] = p3[0];
                    vertices[vertexPosition++] = p3[1];
                    vertices[vertexPosition++] = p3[2];

                    for (int k = 0; k < 4 * 3; k++) {
                        colors[colorPosition++] = color[k%4]/* + colorPosition/100000f*/;
                    }

                    normal3d(p1p2p3Normal, p1, p2, p3);

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];

                    normals[normalPosition++] = p1p2p3Normal[0];
                    normals[normalPosition++] = p1p2p3Normal[1];
                    normals[normalPosition++] = p1p2p3Normal[2];
                }
            }
        }
    }

    private void normal3d(float[] result, float[] p1, float[] p2, float[] p3) {
        result[0] = (p2[1] - p1[1]) * (p3[2] - p1[2]) - (p2[2] - p1[2]) * (p3[1] - p1[1]);
        result[1] = -1 * (p2[0] - p1[0]) * (p3[2] - p1[2]) + (p2[2] - p1[2]) * (p3[0] - p1[0]);
        result[2] = (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p2[1] - p1[1]) * (p3[0] - p1[0]);

        float k = 1f / Math.max(Math.abs(result[2]), Math.max(Math.abs(result[1]), Math.abs(result[0])));
        result[0] = result[0] * k;
        result[1] = result[1] * k;
        result[2] = result[2] * k;
        if (k < 0 || Math.abs(result[0]) > 1 || Math.abs(result[1]) > 1 || Math.abs(result[2]) > 1) {
            System.out.println("te");
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
