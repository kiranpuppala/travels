package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.Level1.Level1render;
import com.mygdx.Level1.Level1update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel1;

/**
 * Created by Personal on 11-Jun-16.
 */
public class LevelRenderer {


    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;

    public LevelRenderer(OrthographicCamera cam) {
        camera = cam;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

    }

    public void render(float runTime) {

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();



        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.disableBlending();

        batch.draw(AssetLoader.levelimage, 0, 0);

        batch.enableBlending();

        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.rect(Constants.LevelRect1.getX(),
                Constants.LevelRect1.getY(), Constants.LevelRect1.getWidth(),
                Constants.LevelRect1.getHeight());
        shapeRenderer.rect(Constants.LevelRect2.getX(),
                Constants.LevelRect2.getY(),Constants.LevelRect2.getWidth(),
                Constants.LevelRect2.getHeight());

        shapeRenderer.rect(Constants.LevelRect3.getX(),
                Constants.LevelRect3.getY(),Constants.LevelRect3.getWidth(),
                Constants.LevelRect3.getHeight());

        shapeRenderer.rect(Constants.LevelRect4.getX(),
                Constants.LevelRect4.getY(),Constants.LevelRect4.getWidth(),
                Constants.LevelRect4.getHeight());

        shapeRenderer.rect(Constants.LevelRect5.getX(),
                Constants.LevelRect5.getY(),Constants.LevelRect5.getWidth(),
                Constants.LevelRect5.getHeight());
        shapeRenderer.rect(Constants.LevelRect6.getX(),
                Constants.LevelRect6.getY(),Constants.LevelRect6.getWidth(),
                Constants.LevelRect6.getHeight());

        shapeRenderer.rect(Constants.LevelRect7.getX(),
                Constants.LevelRect7.getY(),Constants.LevelRect7.getWidth(),
                Constants.LevelRect7.getHeight());
        shapeRenderer.rect(Constants.LevelRect8.getX(),
                Constants.LevelRect8.getY(),Constants.LevelRect8.getWidth(),
                Constants.LevelRect8.getHeight());


        shapeRenderer.setColor(Color.GREEN);

        shapeRenderer.end();

        batch.end();

    }
}