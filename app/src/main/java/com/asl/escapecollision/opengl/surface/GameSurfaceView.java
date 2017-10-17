package com.asl.escapecollision.opengl.surface;


import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

import com.asl.escapecollision.game.CollisionGame;
import com.asl.escapecollision.opengl.renderer.GameRenderer;
import com.asl.escapecollision.opengl.renderer.SampleRenderer;

/**
 * Created by asl on 9/2/17.
 */

public class GameSurfaceView extends GLSurfaceView {
    private final GameRenderer glRenderer;

    private final CollisionGame game;

    public GameSurfaceView(Context context) {
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        game = new CollisionGame();

        glRenderer = new GameRenderer();
        glRenderer.setGame(game);

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(glRenderer);
//        setRenderer(new SampleRenderer());
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
//        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        requestRender();
        return super.onTouchEvent(event);
    }
}
