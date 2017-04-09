package com.mygdx.Level5;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.Level2.Level2update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel4;
import com.mygdx.gameobjects.BoundRectLevel5;

/**
 * Created by Personal on 23-Jun-16.
 */
public class Level5render {




        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;
private int i;
        public Level5render(OrthographicCamera cam) {
            camera=cam;
            batch=new SpriteBatch();
            shapeRenderer=new ShapeRenderer();
i=1;



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

                batch.draw(AssetLoader.duck, BoundRectLevel5.rect[15].x,  BoundRectLevel5.rect[15].y);
                batch.draw(AssetLoader.blackenemy, (float) BlackEnemy.x, (float) BlackEnemy.y);
            }

            /////////////////





            ////Rendering world

            /////////////////////////////



            ////Rendering rectangles




            shapeRenderer.setColor(Color.BLACK);
           for (int i=0;i<17;i++) {
              if(BoundRectLevel5.rect[i]!=null)
                shapeRenderer.rect(BoundRectLevel5.rect[i].x, BoundRectLevel5.rect[i].y, BoundRectLevel5.rect[i].getWidth(),
                        BoundRectLevel5.rect[i].getHeight());
            }
            shapeRenderer.setColor(Color.BLACK);
            shapeRenderer.rect(BoundRectLevel5.rect[15].x, BoundRectLevel5.rect[15].y, BoundRectLevel5.rect[15].getWidth(),
                    BoundRectLevel5.rect[15].getHeight());
            shapeRenderer.rect(BlackEnemy.dummyForBlack1.x, BlackEnemy.dummyForBlack1.getY(),
                    BlackEnemy.dummyForBlack1.getWidth(), BlackEnemy.dummyForBlack1.getHeight());
            shapeRenderer.rect(BlackEnemy.dummyForBlack2.x, BlackEnemy.dummyForBlack2.getY(),
                    BlackEnemy.dummyForBlack2.getWidth(), BlackEnemy.dummyForBlack2.getHeight());

            shapeRenderer.rect(BlackEnemy.blackEnemyRect.x, BlackEnemy.blackEnemyRect.y,
                    BlackEnemy.blackEnemyRect.getWidth(), BlackEnemy.blackEnemyRect.getHeight());
            i++;

            BoundRectLevel5.polygon1wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel5.polygon1wing1.getTransformedVertices());
            BoundRectLevel5.polygon1wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel5.polygon1wing2.getTransformedVertices());
            BoundRectLevel5.polygon1wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel5.polygon1wing3.getTransformedVertices());

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
