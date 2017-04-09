package com.mygdx.Level5;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Polygon;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.CollDet;
import com.mygdx.gameobjects.BlackEnemy;

import com.mygdx.gameobjects.BoundRectLevel5;
import com.mygdx.gameobjects.FrogEnemy;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 23-Jun-16.
 */
public class Level5update {


        public static  double x,y,lastx,lasty;

        public double vx,vy,lastvx=0;
        public Game thisGame;

        public double accelarationx,accelarationy,friction,bounce,gravity;
        public boolean isOnGround,onPaddle,blackFinished,frogFinished;
        public int jumpForce,speedLimit;
        public  boolean switchedOn;
        public FrogEnemy frogEnemy;

        public BlackEnemy blackEnemy;

        public Level5update(Game game){
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
            blackFinished=false;
frogFinished=false;

            switchedOn=false;

         BlackEnemy.dummyForBlack1.set(650,120,70,70);
           BlackEnemy.dummyForBlack2.set(1000,120,70,70);
         frogEnemy=new FrogEnemy(1400,140,1700,1400,true,false);

          blackEnemy=new BlackEnemy(800,120);
        }

        public void update(float delta,OrthographicCamera camera) {

blackEnemy.update(delta);
            if(!frogFinished)
            frogEnemy.update(delta);

            BoundRectLevel5.polygoncharacter=new Polygon(new float[]{0,0,BoundRectLevel5.rect[15].width,0,BoundRectLevel5.rect[15].width,BoundRectLevel5.rect[15].height,0,
                    BoundRectLevel5.rect[15].height});

            BoundRectLevel5.rect[7].y+=1;
          BoundRectLevel5.rect[8].y+=1;
        BoundRectLevel5.rect[9].y+=1;

            if(BoundRectLevel5.rect[7].y+BoundRectLevel5.rect[7].height<0){
                BoundRectLevel5.rect[7].y=0;
            }
            if(BoundRectLevel5.rect[7].y>510){
                BoundRectLevel5.rect[7].y=0- BoundRectLevel5.rect[7].y;
            }

       if(BoundRectLevel5.rect[8].y+BoundRectLevel5.rect[8].height<0){
                BoundRectLevel5.rect[8].y=-10;
            }
            if(BoundRectLevel5.rect[8].y>510){
                BoundRectLevel5.rect[8].y=0- BoundRectLevel5.rect[8].y;
            }
            if(BoundRectLevel5.rect[9].y+BoundRectLevel5.rect[9].height<0){
                BoundRectLevel5.rect[9].y=-20;
            }
            if(BoundRectLevel5.rect[9].y>510){
                BoundRectLevel5.rect[9].y=0- BoundRectLevel5.rect[9].y;
            }



         BoundRectLevel5.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());
            if(!blackFinished) {
                if (BlackEnemy.y < 120)
                    BlackEnemy.y = 120;
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
                    if (BoundRectLevel5.rect[i] != null) {
                        if(i!=15) {
                            int collisionSide = CollDet.collided(BoundRectLevel5.rect[15], BoundRectLevel5.rect[i], 5, 15);
                            if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                                isOnGround = true;
                                vy += gravity;


                            } else if (collisionSide == CollDet.TOP_SIDE && vy <= 0) {
                                isOnGround = true;

                               if(i==7){
                                   y= BoundRectLevel5.rect[7].y+BoundRectLevel5.rect[7].height;
                               }
                                if(i==8) {
                                    if(!Constants.characterFinished)
                                        AssetLoader.falling.play();
                                    vx=0;
                                    Constants.characterFinished=true;
                                    AssetLoader.backgroundmusic.stop();
                                }
                                if(i==9)
                                    y= BoundRectLevel5.rect[9].y+BoundRectLevel5.rect[9].height;
                                vy = 0;


                            } else if (collisionSide == CollDet.RIGHT_SIDE && vx >= 0) {


                                vx = 0;
                            } else if (collisionSide == CollDet.LEFT_SIDE && vx <= 0) {
                                if (i == 2) {
                                    BoundRectLevel5.rect[2].x = (float) (x - BoundRectLevel5.rect[2].width);
                                    switchedOn = true;
                                }
                                if (i == 2)
                                    vx = lastvx;

                                vx = 0;
                            }
                            if (collisionSide != CollDet.BOTTOM_SIDE && vy > 0) {
                                isOnGround = false;
                            }
                        }
                    }
                }
            }




            if(switchedOn){
                if(BoundRectLevel5.rect[5].y>70) {
                    BoundRectLevel5.rect[5].y--;
                }
            }


    ////////////character in danger////////////
              int colside= CollDet.collided(BoundRectLevel5.rect[15],blackEnemy.blackEnemyRect,5,15);


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
            int colside2= CollDet.collided(BoundRectLevel5.rect[15],frogEnemy.frogEnemyRect,5,15);


            switch(colside2){
                case CollDet.TOP_SIDE:
                    frogFinished=true;
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

            if(frogFinished){
                frogEnemy.frogEnemyRect.y-=20;
            }


///////////////////////////////////////////////////


            if(x>=3100){
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




            BoundRectLevel5.rect[6].setPosition(frogEnemy.frogEnemyRect.x, frogEnemy.frogEnemyRect.y);

            BoundRectLevel5.polygon1wing1.setOrigin(0, 10);
            BoundRectLevel5.polygon1wing1.setPosition(2775, 290);
            BoundRectLevel5.polygon1wing2.setOrigin(0, 10);
            BoundRectLevel5.polygon1wing2.setPosition(2775, 290);

            BoundRectLevel5.polygon1wing3.setOrigin(0, 10);
            BoundRectLevel5.polygon1wing3.setPosition(2775, 290);


            BoundRectLevel5.polygoncharacter.setPosition(BoundRectLevel5.rect[15].x, BoundRectLevel5.rect[15].y);

            if(Intersector.overlapConvexPolygons(BoundRectLevel5.polygoncharacter,BoundRectLevel5.polygon1wing1)||
                    Intersector.overlapConvexPolygons(BoundRectLevel5.polygoncharacter,BoundRectLevel5.polygon1wing2)||
                    Intersector.overlapConvexPolygons(BoundRectLevel5.polygoncharacter,BoundRectLevel5.polygon1wing3)){

                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }


            if(y < 0){
                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }



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
                BoundRectLevel5.rect[5].y=220;

                frogFinished=false;
                blackFinished=false;
                frogEnemy=new FrogEnemy(1400,140,1700,1400,true,false);
                BoundRectLevel5.rect[2].setPosition(550,130);
                blackEnemy.x=800;
                blackEnemy.y=120;


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







