package com.mygdx.Level8;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.Level2.Level2update;
import com.mygdx.Level7.Level7update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.BoundRectLevel8;
import com.mygdx.gameobjects.SpikeEnemy;

/**
 * Created by Personal on 28-Jun-16.
 */
public class Level8render {




        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;
        private int firstRotation,secondRotation,thirdRotation,fourthRotation,fifthRotation;
        private int i,j;


        public Level8render(OrthographicCamera cam) {
            camera=cam;
            batch=new SpriteBatch();
            shapeRenderer=new ShapeRenderer();
            firstRotation=0;
            secondRotation=0;
            i=0;j=0;
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
            batch.draw(AssetLoader.background, 6700, 0);
            batch.draw(AssetLoader.background, 7500, 0);
            batch.enableBlending();
            ////////Rendering game objects
            if(!Constants.characterFinished) {


                batch.draw(AssetLoader.duck, BoundRectLevel8.rect[15].x,  BoundRectLevel8.rect[15].y);
                //    batch.draw(AssetLoader.blackenemy, (float) BlackEnemy.x, (float) BlackEnemy.y);
            }

            /////////////////





            ////Rendering world





            ////Rendering rectangles

            shapeRenderer.setColor(Color.BLACK);
            for (int i=0;i<17;i++) {
                if(BoundRectLevel8.rect[i]!=null) {

                        shapeRenderer.rect(BoundRectLevel8.rect[i].x, BoundRectLevel8.rect[i].y, BoundRectLevel8.rect[i].getWidth(),
                                BoundRectLevel8.rect[i].getHeight());}

            }
            shapeRenderer.setColor(Color.BLACK);



            if(Level8update.onTheZigZag1) {

                firstRotation+=3.6;

                if(firstRotation<=90) {
                    BoundRectLevel8.zigzag1wing1.setRotation((float) (-firstRotation));

                    BoundRectLevel8.zigzag1wing2.setRotation((float) (+firstRotation));

                }

            }
            if(Level8update.onTheZigZag2) {

                secondRotation+=3.6;

                if(secondRotation<=90) {
                    BoundRectLevel8.zigzag2wing1.setRotation((float) (-secondRotation));

                    BoundRectLevel8.zigzag2wing2.setRotation((float) (+secondRotation));

                }

            }


            if(Level8update.onTheZigZag3) {

              thirdRotation+=3.6;

                if(thirdRotation<=90) {
                    BoundRectLevel8.zigzag3wing1.setRotation((float) (-thirdRotation));

                    BoundRectLevel8.zigzag3wing2.setRotation((float) (+thirdRotation));

                }

            }


            if(Level8update.onTheZigZag4) {

                fourthRotation+=3.6;

                if(fourthRotation<=90) {
                    BoundRectLevel8.zigzag4wing1.setRotation((float) (-fourthRotation));

                    BoundRectLevel8.zigzag4wing2.setRotation((float) (+fourthRotation));

                }

            }


            if(Level8update.onTheZigZag5) {

                fifthRotation+=3.6;

                if(fifthRotation<=90) {
                    BoundRectLevel8.zigzag5wing1.setRotation((float) (-fifthRotation));

                    BoundRectLevel8.zigzag5wing2.setRotation((float) (+fifthRotation));

                }

            }





            shapeRenderer.polygon(BoundRectLevel8.zigzag1wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel8.zigzag1wing2.getTransformedVertices());

            shapeRenderer.polygon(BoundRectLevel8.zigzag2wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel8.zigzag2wing2.getTransformedVertices());

            shapeRenderer.polygon(BoundRectLevel8.zigzag3wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel8.zigzag3wing2.getTransformedVertices());

            shapeRenderer.polygon(BoundRectLevel8.zigzag4wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel8.zigzag4wing2.getTransformedVertices());

            shapeRenderer.polygon(BoundRectLevel8.zigzag5wing1.getTransformedVertices());
            shapeRenderer.polygon(BoundRectLevel8.zigzag5wing2.getTransformedVertices());

            shapeRenderer.circle(BoundRectLevel8.wheelcircle1.x, BoundRectLevel8.wheelcircle1.y, BoundRectLevel8.wheelcircle1.radius);
            shapeRenderer.circle(BoundRectLevel8.wheelcircle2.x, BoundRectLevel8.wheelcircle2.y, BoundRectLevel8.wheelcircle2.radius);
            shapeRenderer.circle(BoundRectLevel8.wheelcircle3.x, BoundRectLevel8.wheelcircle3.y, BoundRectLevel8.wheelcircle3.radius);
            shapeRenderer.circle(BoundRectLevel8.wheelcircle4.x, BoundRectLevel8.wheelcircle4.y, BoundRectLevel8.wheelcircle4.radius);
            shapeRenderer.circle(BoundRectLevel8.wheelcircle5.x, BoundRectLevel8.wheelcircle5.y, BoundRectLevel8.wheelcircle5.radius);
            shapeRenderer.circle(BoundRectLevel8.wheelcircle6.x, BoundRectLevel8.wheelcircle6.y, BoundRectLevel8.wheelcircle6.radius);

            i+=3;

            BoundRectLevel8.polygon1wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel8.polygon1wing1.getTransformedVertices());
            BoundRectLevel8.polygon1wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel8.polygon1wing2.getTransformedVertices());
            BoundRectLevel8.polygon1wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel8.polygon1wing3.getTransformedVertices());

            BoundRectLevel8.polygon2wing1.setRotation((float) (i + 0));
            shapeRenderer.polygon(BoundRectLevel8.polygon2wing1.getTransformedVertices());
            BoundRectLevel8.polygon2wing2.setRotation((float) (i + 120));
            shapeRenderer.polygon(BoundRectLevel8.polygon2wing2.getTransformedVertices());
            BoundRectLevel8.polygon2wing3.setRotation((float) (i + 240));
            shapeRenderer.polygon(BoundRectLevel8.polygon2wing3.getTransformedVertices());

            if(Level8update.initRotation){
                BoundRectLevel8.zigzag1wing1.setRotation((float) (0));
                BoundRectLevel8.zigzag1wing2.setRotation((float) (0));
                BoundRectLevel8.zigzag2wing1.setRotation((float) (0));
                BoundRectLevel8.zigzag2wing2.setRotation((float) (0));
                BoundRectLevel8.zigzag3wing1.setRotation((float) (0));
                BoundRectLevel8.zigzag3wing2.setRotation((float) (0));
                BoundRectLevel8.zigzag4wing1.setRotation((float) (0));
                BoundRectLevel8.zigzag4wing2.setRotation((float) (0));
                BoundRectLevel8.zigzag5wing1.setRotation((float) (0));
                BoundRectLevel8.zigzag5wing2.setRotation((float) (0));
                Level8update.initRotation=false;

                firstRotation=secondRotation=thirdRotation=fourthRotation=fifthRotation=0;

            }



            j++;
            shapeRenderer.setColor(Color.BLACK);
            BoundRectLevel8.polygonup.setRotation((float) (-j));
            shapeRenderer.polygon(BoundRectLevel8.polygonup.getTransformedVertices());

            shapeRenderer.setColor(Color.BLACK);


            BoundRectLevel8.polygondown.setRotation((float) (j + 180));
            shapeRenderer.polygon(BoundRectLevel8.polygondown.getTransformedVertices());



            shapeRenderer.rect(BlackEnemy.dummyForBlack1.x, BlackEnemy.dummyForBlack1.getY(),
                    BlackEnemy.dummyForBlack1.getWidth(), BlackEnemy.dummyForBlack1.getHeight());
            shapeRenderer.rect(BlackEnemy.dummyForBlack2.x, BlackEnemy.dummyForBlack2.getY(),
                    BlackEnemy.dummyForBlack2.getWidth(), BlackEnemy.dummyForBlack2.getHeight());

            shapeRenderer.rect(BlackEnemy.blackEnemyRect.x, BlackEnemy.blackEnemyRect.y,
                    BlackEnemy.blackEnemyRect.getWidth(), BlackEnemy.blackEnemyRect.getHeight());

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




