package com.mygdx.Level8;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.CollDet;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.BoundRectLevel8;
import com.mygdx.gameobjects.FrogEnemy;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.SpikeEnemy;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 28-Jun-16.
 */
public class Level8update {




        public static  double x,y,lastx,lasty;

        public double vx,vy,lastvx=0;
        public Game thisGame;
        public static boolean onTheZigZag1,onTheZigZag2,onTheZigZag3,onTheZigZag4,onTheZigZag5;

        public double accelarationx,accelarationy,friction,bounce,gravity;
        public boolean isOnGround,onPaddle,blackFinished,frogFinished,spikeFinished;
        public static boolean leftStick=true,rightStick=false,leftStick2=true,rightStick2=false
                ,leftStick3=true,rightStick3=false,leftStick4=true,rightStick4=false,leftStick5=true,rightStick5=false
                ,leftStick6=true,rightStick6=false;
        public int jumpForce,speedLimit;
        public  boolean switchedOn;
        public FrogEnemy frogEnemy;
        private boolean topStick=true,bottomStick=false,topStick2=true,bottomStick2=false,topStick3=true,bottomStick3=false;
        public static boolean initRotation=false;
        public BlackEnemy blackEnemy;
        public SpikeEnemy spikeEnemy;
        public Level8update(Game game){
            thisGame=game;
            x=400;y=400;vx=vy=0;
            Constants.characterX=(int)x;
            lastx=400;
            lasty=400;

            accelarationx=accelarationy=0;
            speedLimit=5;
            friction=.96;
            bounce=.7;
            gravity=-18;
            isOnGround=false;
            jumpForce=10;
            onPaddle=false;
            spikeFinished=false;
            frogFinished=false;

            switchedOn=false;
            onTheZigZag1=false;
            onTheZigZag2=false;
            onTheZigZag3=false;


            SpikeEnemy.dummyForSpike1.set(1100,120,70,70);
            SpikeEnemy.dummyForSpike2.set(1600,120,70,70);
            frogEnemy=new FrogEnemy(6100,240,7000,6100,true,false);
            blackEnemy=new BlackEnemy(6200,120);
            blackEnemy.dummyForBlack1.set(6100,120,70,70);
            blackEnemy.dummyForBlack2.set(7000,120,70,70);

            spikeEnemy=new SpikeEnemy(1200,120);
        }

        public void update(float delta,OrthographicCamera camera) {

            blackEnemy.update(delta);
           // spikeEnemy.update(delta);
            if(!frogFinished)
               frogEnemy.update(delta);

            BoundRectLevel8.polygoncharacter=new Polygon(new float[]{0,0,BoundRectLevel8.rect[15].width,
                    0,BoundRectLevel8.rect[15].width,BoundRectLevel8.rect[15].height,0,
                    BoundRectLevel8.rect[15].height});



            BoundRectLevel8.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());



          if(!blackFinished) {
                if (BlackEnemy.y < 120)
                    BlackEnemy.y = 120;
            }

            if(!spikeFinished) {
                if (SpikeEnemy.y < 120)
                    SpikeEnemy.y = 120;
            }




            if(MovControl.left&&!MovControl.right){
                accelarationx=-12;
                friction=1;
            }
            if(MovControl.right&&!MovControl.left){
                accelarationx=12;
                friction=1;
            }
            if(MovControl.jump&&isOnGround){
                vy+=jumpForce;
                isOnGround=false;
                friction=1;
                AssetLoader.jumping.play();
            }
            if(!MovControl.left && !MovControl.right)
            {////things to check
                accelarationx = 0;
                friction = 0.96;
                gravity =- 18;
            }

            vx+=(accelarationx*delta);
            vy+=accelarationy;

            if(isOnGround){
                vx*=friction;
            }

            vy+=(gravity*delta);

            if(vx>speedLimit){
                vx=speedLimit;
            }
            if(vx<-speedLimit){
                vx=-speedLimit;
            }
            lastvx=vx;





            if(!Constants.characterFinished) {

                for (int i = 0; i <17; i++) {
                    if (BoundRectLevel8.rect[i] != null) {
                        if(i!=15&&i!=6&&i!=7) {
                            int collisionSide = CollDet.collided(BoundRectLevel8.rect[15], BoundRectLevel8.rect[i], 8, 15);
                            if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                                isOnGround = true;
                                vy += gravity;


                            } else if (collisionSide == CollDet.TOP_SIDE && vy <= 0) {
                                isOnGround = true;
                                if(i==1){
                                    onTheZigZag1=true;
                                }
                                if(i==2){
                                 onTheZigZag2=true;
                                }

                                if(i==3){
                                    onTheZigZag3=true;
                                }
                                if(i==4){
                                    onTheZigZag4=true;
                                }
                                if(i==5){
                                    onTheZigZag5=true;
                                }
                                if(i==9){
                                    y= BoundRectLevel8.rect[9].y+BoundRectLevel8.rect[9].height;

                                }
                                if(i==14)
                                    frogFinished=true;
                                vy = 0;


                            } else if (collisionSide == CollDet.RIGHT_SIDE && vx >= 0) {

                                vx = 0;
                            } else if (collisionSide == CollDet.LEFT_SIDE && vx <= 0) {

                                vx = 0;
                            }
                            if (collisionSide != CollDet.BOTTOM_SIDE && vy > 0) {
                                isOnGround = false;
                            }
                        }
                    }
                }
            }







            BoundRectLevel8.zigzag1wing1.setOrigin(170, 10);
            BoundRectLevel8.zigzag1wing1.setPosition(840, 120);
            BoundRectLevel8.zigzag1wing2.setOrigin(10, 10);
            BoundRectLevel8.zigzag1wing2.setPosition(1050, 120);


            BoundRectLevel8.zigzag2wing1.setOrigin(170, 10);
            BoundRectLevel8.zigzag2wing1.setPosition(1070, 120);
            BoundRectLevel8.zigzag2wing2.setOrigin(10, 10);
            BoundRectLevel8.zigzag2wing2.setPosition(1280, 120);

            BoundRectLevel8.zigzag3wing1.setOrigin(170, 10);
            BoundRectLevel8.zigzag3wing1.setPosition(1300, 120);
            BoundRectLevel8.zigzag3wing2.setOrigin(10, 10);
            BoundRectLevel8.zigzag3wing2.setPosition(1510, 120);

            BoundRectLevel8.zigzag4wing1.setOrigin(170, 10);
            BoundRectLevel8.zigzag4wing1.setPosition(1530, 120);
            BoundRectLevel8.zigzag4wing2.setOrigin(10, 10);
            BoundRectLevel8.zigzag4wing2.setPosition(1740, 120);

            BoundRectLevel8.zigzag5wing1.setOrigin(170, 10);
            BoundRectLevel8.zigzag5wing1.setPosition(1760, 120);
            BoundRectLevel8.zigzag5wing2.setOrigin(10, 10);
            BoundRectLevel8.zigzag5wing2.setPosition(1970, 120);



            if ( topStick) {
                BoundRectLevel8.rect[6].y -= 50 * delta;
            }

            if (BoundRectLevel8.rect[6].y< 20) {
                topStick = false;
                bottomStick = true;
            }


            if (bottomStick) {
                BoundRectLevel8.rect[6].y += 50 * delta;

            }

            if (BoundRectLevel8.rect[6].y >120 && bottomStick) {
                bottomStick = false;
                topStick = true;
            }



            if ( topStick2) {
                BoundRectLevel8.rect[7].y -= 50 * delta;
            }

            if (BoundRectLevel8.rect[7].y< 20) {
                topStick2 = false;
                bottomStick2 = true;
            }


            if (bottomStick2) {
                BoundRectLevel8.rect[7].y += 50 * delta;

            }

            if (BoundRectLevel8.rect[7].y >120 && bottomStick) {
                bottomStick2 = false;
                topStick2 = true;
            }



            ///////////////first wheel
            if (BoundRectLevel8.wheelcircle1.x >=  3100 && leftStick) {
                BoundRectLevel8.wheelcircle1.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle1.x <3100) {
                leftStick = false;
                rightStick = true;
            }


            if (rightStick) {
                BoundRectLevel8.wheelcircle1.x +=100 * delta;

            }

            if (BoundRectLevel8.wheelcircle1.x >=  3450 && rightStick) {
                rightStick = false;
                leftStick = true;
            }
///////////////////////////////second wheel
            if (BoundRectLevel8.wheelcircle2.x >=  3100 && leftStick2) {
                BoundRectLevel8.wheelcircle2.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle2.x <3100) {
                leftStick2 = false;
                rightStick2 = true;
            }


            if (rightStick2) {
                BoundRectLevel8.wheelcircle2.x += 100 * delta;

            }

            if (BoundRectLevel8.wheelcircle2.x >=  3450 && rightStick3) {
                rightStick2 = false;
                leftStick2 = true;
            }


///////////////////////////////third wheel
            if (BoundRectLevel8.wheelcircle3.x >=  3450 && leftStick3) {
                BoundRectLevel8.wheelcircle3.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle3.x <3450) {
                leftStick3= false;
                rightStick3 = true;
            }


            if (rightStick3) {
                BoundRectLevel8.wheelcircle3.x += 100 * delta;

            }

            if (BoundRectLevel8.wheelcircle3.x >=  3800 && rightStick3) {
                rightStick3= false;
                leftStick3 = true;
            }

///////////////////////////////forth wheel
            if (BoundRectLevel8.wheelcircle4.x >=  3450 && leftStick4) {
                BoundRectLevel8.wheelcircle4.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle4.x <3450) {
                leftStick4= false;
                rightStick4 = true;
            }


            if (rightStick4) {
                BoundRectLevel8.wheelcircle4.x += 100 * delta;

            }

            if (BoundRectLevel8.wheelcircle4.x >=  3800 && rightStick4) {
                rightStick4= false;
                leftStick4 = true;
            }






            ////////////////////single wheel rectangle wheel num five


            if (BoundRectLevel8.wheelcircle5.x >=  4200 && leftStick5) {
                BoundRectLevel8.wheelcircle5.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle5.x <4200) {
                leftStick5= false;
                rightStick5= true;
            }


            if (rightStick5) {
                BoundRectLevel8.wheelcircle5.x += 100 * delta;

            }

            if (BoundRectLevel8.wheelcircle5.x >=  4600 && rightStick5) {
                rightStick5= false;
                leftStick5 = true;
            }


            ////////////////////flying wheel rectangle wheel num six


            if (BoundRectLevel8.wheelcircle6.x >=  4800 && leftStick6) {
                BoundRectLevel8.wheelcircle6.x-= 100 * delta;
            }

            if (BoundRectLevel8.wheelcircle6.x <4800) {
                leftStick6= false;
                rightStick6= true;
            }


            if (rightStick6) {
                BoundRectLevel8.wheelcircle6.x += 100 * delta;

            }

            if (BoundRectLevel8.wheelcircle6.x >=  5200 && rightStick6) {
                rightStick6= false;
                leftStick6 = true;
            }


////////////////////////////////////flying rectangle


            if ( topStick3) {
                BoundRectLevel8.rect[9].y -= 50 * delta;
            }

            if (BoundRectLevel8.rect[9].y< 20) {
                topStick3 = false;
                bottomStick3 = true;
            }


            if (bottomStick3) {
                BoundRectLevel8.rect[9].y += 50 * delta;

            }

            if (BoundRectLevel8.rect[9].y >320 && bottomStick3) {
                bottomStick3 = false;
                topStick3 = true;
            }

            BoundRectLevel8.polygon1wing1.setOrigin(0, 10);
            BoundRectLevel8.polygon1wing1.setPosition(4850, BoundRectLevel8.rect[9].y + 40);
            BoundRectLevel8.polygon1wing2.setOrigin(0, 10);
            BoundRectLevel8.polygon1wing2.setPosition(4850, BoundRectLevel8.rect[9].y + 40);
            BoundRectLevel8.polygon1wing3.setOrigin(0, 10);
            BoundRectLevel8.polygon1wing3.setPosition(4850, BoundRectLevel8.rect[9].y + 40);


            BoundRectLevel8.polygon2wing1.setOrigin(0, 10);
            BoundRectLevel8.polygon2wing1.setPosition(5150, BoundRectLevel8.rect[9].y + 40);
            BoundRectLevel8.polygon2wing2.setOrigin(0, 10);
            BoundRectLevel8.polygon2wing2.setPosition(5150, BoundRectLevel8.rect[9].y + 40);
            BoundRectLevel8.polygon2wing3.setOrigin(0, 10);
            BoundRectLevel8.polygon2wing3.setPosition(5150, BoundRectLevel8.rect[9].y + 40);




            BoundRectLevel8.wheelcircle6.y=BoundRectLevel8.rect[9].y+BoundRectLevel8.rect[9].height;










///////////////////////////////////////////


////////////////////////////revolving fire rectagnel







            BoundRectLevel8.polygonup.setOrigin(0, 10);
            BoundRectLevel8.polygonup.setPosition(6125, 375);


            BoundRectLevel8.polygondown.setOrigin(0, 10);
            BoundRectLevel8.polygondown.setPosition(5825, 145);

            BoundRectLevel8.polygoncharacter.setPosition(BoundRectLevel8.rect[15].x,BoundRectLevel8.rect[15].y);


////////////////////////////////


            BoundRectLevel8.rect[14].setPosition(frogEnemy.frogEnemyRect.x, frogEnemy.frogEnemyRect.y);




            ////////////character in danger////////////

            if(y < 0||Intersector.overlaps(BoundRectLevel8.rect[15],BoundRectLevel8.rect[12])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle1, BoundRectLevel8.rect[15])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle2,BoundRectLevel8.rect[15])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle3, BoundRectLevel8.rect[15])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle4,BoundRectLevel8.rect[15])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle5, BoundRectLevel8.rect[15])||
                    Intersector.overlaps(BoundRectLevel8.wheelcircle6,BoundRectLevel8.rect[15])||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag1wing1, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag1wing2, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag2wing1, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag2wing2, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag3wing1, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag3wing2,BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag4wing1, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag4wing2,BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag5wing1, BoundRectLevel8.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.zigzag5wing2,BoundRectLevel8.polygoncharacter)||
                    Intersector.overlaps(BoundRectLevel8.rect[15], BoundRectLevel8.rect[6])||
                    Intersector.overlaps(BoundRectLevel8.rect[15], BoundRectLevel8.rect[7])||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.polygoncharacter, BoundRectLevel8.polygonup)||
                    Intersector.overlapConvexPolygons(BoundRectLevel8.polygoncharacter, BoundRectLevel8.polygondown))
            {


                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }


            ////////////////killing blackenemy

            int colside= CollDet.collided(BoundRectLevel8.rect[15],blackEnemy.blackEnemyRect,8,15);


            switch(colside){
                case CollDet.TOP_SIDE:
                    blackFinished=true;
                    break;
                case CollDet.BOTTOM_SIDE:
                    if(!Constants.characterFinished)
                        AssetLoader.falling.play();
                    vx=0;
                    Constants.characterFinished=true;
                    AssetLoader.backgroundmusic.stop();
                    break;
                case CollDet.LEFT_SIDE:
                    if(!Constants.characterFinished)
                        AssetLoader.falling.play();
                    vx=0;
                    Constants.characterFinished=true;
                    AssetLoader.backgroundmusic.stop();
                    break;
                case CollDet.RIGHT_SIDE:
                    if(!Constants.characterFinished)
                        AssetLoader.falling.play();
                    vx=0;
                    Constants.characterFinished=true;
                    AssetLoader.backgroundmusic.stop();
                    break;
            }



            if(blackFinished){
                blackEnemy.blackEnemyRect.y-=20;
            }



            if(!frogFinished) {
                BoundRectLevel8.rect[14].setPosition(frogEnemy.frogEnemyRect.x, frogEnemy.frogEnemyRect.y);

            }








////////////////////////////////////


            //////////////////////////

            if(x>=7500){
                Constants.ReachedHome=true;
                AssetLoader.finishedx=camera.position.x-200;
                AssetLoader.nextx=AssetLoader.finishedx+280;
                AssetLoader.finretryx=AssetLoader.finishedx+70;
                AssetLoader.finlevelx=AssetLoader.finishedx+180;
                vx=0;
            }



            x += vx;
            y += vy;



            Constants.characterX=(int)x;


            if(Constants.retryLevel){

                Constants.ReachedHome=false;
                Constants.characterFinished=false;
                camera.position.x=400;
                AssetLoader.jumpx=AssetLoader.lastjumpx;
                AssetLoader.leftx=AssetLoader.lastleftx;
                AssetLoader.rightx=AssetLoader.lastrightx;
                AssetLoader.pausex=AssetLoader.lastpausex;
                AssetLoader.levelfailedx=AssetLoader.lastlevelfailedx;
                AssetLoader.levelx=AssetLoader.lastlevelx;
                AssetLoader.retryx=AssetLoader.lastretryx;



                initRotation=true;
                frogFinished=false;
                blackFinished=false;
                spikeFinished=false;

                onTheZigZag1=onTheZigZag2=onTheZigZag3=onTheZigZag4=onTheZigZag5=false;
                frogEnemy=new FrogEnemy(6100,240,7000,6100,true,false);
                blackEnemy=new BlackEnemy(6200,120);

                switchedOn=false;

                x=lastx;
                y=lasty;

                AssetLoader.backgroundmusic.loop(.2f);
                Constants.retryLevel=false;

            }
            if(Constants.goToLevelPage){
                Constants.characterFinished=false;
                thisGame.setScreen(new LevelScreen(thisGame));
                Constants.goToLevelPage=false;
            }

        }


        public static void setPause(){
            Constants.pauseClicked=true;
        }


    }











