package com.mygdx.Level3;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.Level2.Level2update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.BoundRectLevel3;



/**
 * Created by Personal on 17-Jun-16.
 */
public class Level3render {

        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;

        public Level3render(OrthographicCamera cam) {
            camera=cam;
            batch=new SpriteBatch();
            shapeRenderer=new ShapeRenderer();


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
            batch.draw(AssetLoader.background, -500, 0);
            batch.draw(AssetLoader.background, 300, 0);
            batch.draw(AssetLoader.background, 1100, 0);
            batch.draw(AssetLoader.background, 1900, 0);
            batch.draw(AssetLoader.background, 2700, 0);

            batch.enableBlending();
            ////////Rendering game objects
            if(!Constants.characterFinished) {


                batch.draw(AssetLoader.duck,BoundRectLevel3.rect[15].x,  BoundRectLevel3.rect[15].y);
            }

            /////////////////

            batch.draw(AssetLoader.grasshalf, BoundRectLevel3.rect[0].x, BoundRectLevel3.rect[0].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel3.rect[0].x+250, BoundRectLevel3.rect[0].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel3.rect[0].x+500, BoundRectLevel3.rect[0].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel3.rect[0].x+750, BoundRectLevel3.rect[0].y);

            batch.draw(AssetLoader.grasstop, BoundRectLevel3.rect[4].x, BoundRectLevel3.rect[4].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel3.rect[4].x+250, BoundRectLevel3.rect[4].y);


            ////Rendering world

            /////////////////////////////



            ////Rendering rectangles

            shapeRenderer.setColor(Color.BLACK);
            for (int i=0;i<6;i++) {
                shapeRenderer.rect(BoundRectLevel3.rect[i].x, BoundRectLevel3.rect[i].y, BoundRectLevel3.rect[i].getWidth(),
                        BoundRectLevel3.rect[i].getHeight());
            }
            shapeRenderer.setColor(Color.GREEN);
shapeRenderer.rect(BoundRectLevel3.rect[15].x,BoundRectLevel3.rect[15].y,BoundRectLevel3.rect[15].getWidth(),
        BoundRectLevel3.rect[15].getHeight());





            /////////////////////


            if(Constants.ReachedHome) {
                batch.draw(AssetLoader.finished, AssetLoader.finishedx, AssetLoader.finishedy);
                batch.draw(AssetLoader.next, AssetLoader.nextx, AssetLoader.nexty);
                batch.draw(AssetLoader.retry, AssetLoader.finretryx, AssetLoader.finretryy);
                batch.draw(AssetLoader.levels, AssetLoader.finlevelx, AssetLoader.finlevely);
            }




            if(Constants.characterFinished) {
                batch.draw(AssetLoader.levelfailed, AssetLoader.levelfailedx, AssetLoader.levelfailedy);
                batch.draw(AssetLoader.duck, (float) Level2update.x, (float) Level2update.y);
                batch.draw(AssetLoader.levels, AssetLoader.levelx, AssetLoader.levely);
                batch.draw(AssetLoader.retry, AssetLoader.retryx, AssetLoader.retryy);
            }
            batch.draw(AssetLoader.left, AssetLoader.leftx, AssetLoader.lefty);
            batch.draw(AssetLoader.right, AssetLoader.rightx, AssetLoader.righty);

            batch.draw(AssetLoader.jump, AssetLoader.jumpx, AssetLoader.jumpy);
            if(!Constants.pauseClicked) {
                batch.draw(AssetLoader.pause, AssetLoader.pausex, AssetLoader.pausey);
            }
            if(Constants.pauseClicked){
                batch.draw(AssetLoader.resume,AssetLoader.pausex,AssetLoader.pausey);
            }


            shapeRenderer.setColor(Color.GREEN);

            shapeRenderer.end();

            batch.end();

        }

    }




