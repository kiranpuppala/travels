package com.mygdx.Level6;

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
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.SpikeEnemy;


public class Level6render {

        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;
    private int firstRotation,secondRotation;
    private int i;


        public Level6render(OrthographicCamera cam) {
            camera=cam;
            batch=new SpriteBatch();
            shapeRenderer=new ShapeRenderer();
            firstRotation=0;
            secondRotation=0;
i=0;
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
            batch.draw(AssetLoader.background, 3500, 0);
            batch.draw(AssetLoader.background, 4300, 0);
            batch.enableBlending();
            ////////Rendering game objects
            if(!Constants.characterFinished) {


               batch.draw(AssetLoader.duck, BoundRectLevel6.rect[15].x,  BoundRectLevel6.rect[15].y);
            //    batch.draw(AssetLoader.blackenemy, (float) BlackEnemy.x, (float) BlackEnemy.y);
            }

            /////////////////





            ////Rendering world

            /////////////////////////////



            ////Rendering rectangles


            shapeRenderer.setColor(Color.BLACK);
            for (int i=0;i<17;i++) {
                if(BoundRectLevel6.rect[i]!=null) {
                    if(i!=9&&i!=10&&i!=11){
                    shapeRenderer.rect(BoundRectLevel6.rect[i].x, BoundRectLevel6.rect[i].y, BoundRectLevel6.rect[i].getWidth(),
                            BoundRectLevel6.rect[i].getHeight());}
                }
            }
            shapeRenderer.setColor(Color.BLACK);

            shapeRenderer.rect(BlackEnemy.dummyForBlack1.x, BlackEnemy.dummyForBlack1.getY(),
                    BlackEnemy.dummyForBlack1.getWidth(), BlackEnemy.dummyForBlack1.getHeight());
            shapeRenderer.rect(BlackEnemy.dummyForBlack2.x, BlackEnemy.dummyForBlack2.getY(),
                    BlackEnemy.dummyForBlack2.getWidth(), BlackEnemy.dummyForBlack2.getHeight());

            shapeRenderer.rect(BlackEnemy.blackEnemyRect.x, BlackEnemy.blackEnemyRect.y,
                    BlackEnemy.blackEnemyRect.getWidth(), BlackEnemy.blackEnemyRect.getHeight());



          shapeRenderer.rect(SpikeEnemy.dummyForSpike1.x, SpikeEnemy.dummyForSpike1.getY(),
                    SpikeEnemy.dummyForSpike1.getWidth(), SpikeEnemy.dummyForSpike1.getHeight());
            shapeRenderer.rect(SpikeEnemy.dummyForSpike2.x, SpikeEnemy.dummyForSpike2.getY(),
                    SpikeEnemy.dummyForSpike2.getWidth(), SpikeEnemy.dummyForSpike2.getHeight());

            shapeRenderer.rect(SpikeEnemy.spikeEnemyRect.x, SpikeEnemy.spikeEnemyRect.y,
                    SpikeEnemy.spikeEnemyRect.getWidth(), SpikeEnemy.spikeEnemyRect.getHeight());





            if(Level6update.onTheZigZag1) {
                Gdx.app.log("onthesigsag1","");
               firstRotation+=3;

                if(firstRotation<=90) {
                    BoundRectLevel6.zigzag1wing1.setRotation((float) (-firstRotation));

                    BoundRectLevel6.zigzag1wing2.setRotation((float) (+firstRotation));

                }

            }
            if(Level6update.onTheZigZag2) {
                Gdx.app.log("onthesigsag2","");
                secondRotation+=3;

                if(secondRotation<=90) {
                    BoundRectLevel6.zigzag2wing1.setRotation((float) (-secondRotation));

                    BoundRectLevel6.zigzag2wing2.setRotation((float) (+secondRotation));

                }

            }
if(Level6update.initRotation){
    BoundRectLevel6.zigzag1wing1.setRotation((float) (0));
    BoundRectLevel6.zigzag1wing2.setRotation((float) (0));
    BoundRectLevel6.zigzag2wing1.setRotation((float) (0));
    BoundRectLevel6.zigzag2wing2.setRotation((float) (0));
    Level6update.initRotation=false;
    Gdx.app.log("init rotaiton","");
    firstRotation=secondRotation=0;

}

            shapeRenderer.polygon(BoundRectLevel6.zigzag1wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel6.zigzag1wing2.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel6.zigzag2wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel6.zigzag2wing2.getTransformedVertices());

            i++;

            BoundRectLevel6.polygon1wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel6.polygon1wing1.getTransformedVertices());
            BoundRectLevel6.polygon1wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel6.polygon1wing2.getTransformedVertices());
            BoundRectLevel6.polygon1wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel6.polygon1wing3.getTransformedVertices());

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


