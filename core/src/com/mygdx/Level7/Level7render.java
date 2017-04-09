package com.mygdx.Level7;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.Level2.Level2update;
import com.mygdx.Level6.Level6update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.SpikeEnemy;

/**
 * Created by Personal on 27-Jun-16.
 */
public class Level7render {



        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private int firstRotation,secondRotation,thirdRotation;
        private int i;


        public Level7render(OrthographicCamera cam) {
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
            batch.draw(AssetLoader.background, 5100, 0);
            batch.draw(AssetLoader.background, 5900, 0);
            batch.draw(AssetLoader.background, 5700, 0);
            batch.draw(AssetLoader.background, 6500, 0);
            batch.draw(AssetLoader.background, 7300, 0);
            batch.draw(AssetLoader.background, 8100, 0);
            batch.enableBlending();
            ////////Rendering game objects
            if(!Constants.characterFinished) {


                batch.draw(AssetLoader.duck, BoundRectLevel7.rect[15].x,  BoundRectLevel7.rect[15].y);
                //    batch.draw(AssetLoader.blackenemy, (float) BlackEnemy.x, (float) BlackEnemy.y);
            }

            /////////////////





            ////Rendering world
            i++;
            if(Level7update.leftStick)
            batch.draw(AssetLoader.wheel,BoundRectLevel7.wheelcircle1.x-50, 70,AssetLoader.wheel.getWidth()/2,AssetLoader.wheel.getHeight()/2,
                    AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),1,1,+i,0,0,
                    AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),false,false);
            if(Level7update.rightStick)
                batch.draw(AssetLoader.wheel,BoundRectLevel7.wheelcircle1.x-50, 70,AssetLoader.wheel.getWidth()/2,AssetLoader.wheel.getHeight()/2,
                        AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),1,1,-i,0,0,
                        AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),false,false);

            if(Level7update.leftStick2)
            batch.draw(AssetLoader.wheel,BoundRectLevel7.wheelcircle2.x-50,  70,AssetLoader.wheel.getWidth()/2,AssetLoader.wheel.getHeight()/2,
                    AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),1,1,+i,0,0,
                    AssetLoader.wheel.getWidth(),AssetLoader.wheel.getHeight(),false,false);
            if(Level7update.rightStick2)
                batch.draw(AssetLoader.wheel, BoundRectLevel7.wheelcircle2.x - 50, 70, AssetLoader.wheel.getWidth() / 2, AssetLoader.wheel.getHeight() / 2,
                        AssetLoader.wheel.getWidth(), AssetLoader.wheel.getHeight(), 1, 1, -i, 0, 0,
                        AssetLoader.wheel.getWidth(), AssetLoader.wheel.getHeight(), false, false);




            ////Rendering rectangles

            shapeRenderer.setColor(Color.BLACK);
            for (int i=0;i<22;i++) {
                if(BoundRectLevel7.rect[i]!=null) {
                    if(i!=8)
                    shapeRenderer.rect(BoundRectLevel7.rect[i].x, BoundRectLevel7.rect[i].y, BoundRectLevel7.rect[i].getWidth(),
                                BoundRectLevel7.rect[i].getHeight());}

            }
            shapeRenderer.setColor(Color.BLACK);

            for (int i=0;i<6;i++) {
                if (BoundRectLevel7.antRect[i] != null) {
                    shapeRenderer.rect(BoundRectLevel7.antRect[i].x, BoundRectLevel7.antRect[i].y, BoundRectLevel7.antRect[i].getWidth(),
                            BoundRectLevel7.antRect[i].getHeight());
                }
            }


            shapeRenderer.circle(BoundRectLevel7.wheelcircle1.x, BoundRectLevel7.wheelcircle1.y, BoundRectLevel7.wheelcircle1.radius);
            shapeRenderer.circle(BoundRectLevel7.wheelcircle2.x, BoundRectLevel7.wheelcircle2.y, BoundRectLevel7.wheelcircle2.radius);



            shapeRenderer.rect(SpikeEnemy.dummyForSpike1.x, SpikeEnemy.dummyForSpike1.getY(),
                    SpikeEnemy.dummyForSpike1.getWidth(), SpikeEnemy.dummyForSpike1.getHeight());
            shapeRenderer.rect(SpikeEnemy.dummyForSpike2.x, SpikeEnemy.dummyForSpike2.getY(),
                    SpikeEnemy.dummyForSpike2.getWidth(), SpikeEnemy.dummyForSpike2.getHeight());

            shapeRenderer.rect(SpikeEnemy.spikeEnemyRect.x, SpikeEnemy.spikeEnemyRect.y,
                    SpikeEnemy.spikeEnemyRect.getWidth(), SpikeEnemy.spikeEnemyRect.getHeight());





            if(Level7update.onTheZigZag1) {

                firstRotation+=3.6;

                if(firstRotation<=90) {
                    BoundRectLevel7.zigzag1wing1.setRotation((float) (-firstRotation));

                    BoundRectLevel7.zigzag1wing2.setRotation((float) (+firstRotation));

                }

            }
            if(Level7update.onTheZigZag2) {

                secondRotation+=3.6;

                if(secondRotation<=90) {
                    BoundRectLevel7.zigzag2wing1.setRotation((float) (-secondRotation));

                    BoundRectLevel7.zigzag2wing2.setRotation((float) (+secondRotation));

                }

            }


            if(Level7update.onTheZigZag3) {

               thirdRotation+=3.6;

                if(thirdRotation<=90) {
                    BoundRectLevel7.zigzag3wing1.setRotation((float) (-thirdRotation));

                    BoundRectLevel7.zigzag3wing2.setRotation((float) (+thirdRotation));

                }

            }





            shapeRenderer.polygon(BoundRectLevel7.zigzag1wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel7.zigzag1wing2.getTransformedVertices());

           shapeRenderer.polygon(BoundRectLevel7.zigzag2wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel7.zigzag2wing2.getTransformedVertices());

            shapeRenderer.polygon(BoundRectLevel7.zigzag3wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel7.zigzag3wing2.getTransformedVertices());


            i+=3;

            BoundRectLevel7.polygon1wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel7.polygon1wing1.getTransformedVertices());
            BoundRectLevel7.polygon1wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel7.polygon1wing2.getTransformedVertices());
            BoundRectLevel7.polygon1wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel7.polygon1wing3.getTransformedVertices());

            BoundRectLevel7.polygon2wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel7.polygon2wing1.getTransformedVertices());
            BoundRectLevel7.polygon2wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel7.polygon2wing2.getTransformedVertices());
            BoundRectLevel7.polygon2wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel7.polygon2wing3.getTransformedVertices());

            /////////////////////

            if(Level7update.initRotation){
                BoundRectLevel7.zigzag1wing1.setRotation((float) (0));
                BoundRectLevel7.zigzag1wing2.setRotation((float) (0));
                BoundRectLevel7.zigzag2wing1.setRotation((float) (0));
                BoundRectLevel7.zigzag2wing2.setRotation((float) (0));
                BoundRectLevel7.zigzag3wing1.setRotation((float) (0));
                BoundRectLevel7.zigzag3wing2.setRotation((float) (0));
                Level7update.initRotation=false;

                firstRotation=secondRotation=thirdRotation=0;

            }
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



