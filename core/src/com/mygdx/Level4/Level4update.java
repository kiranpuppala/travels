package com.mygdx.Level4;

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
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.BoundRectLevel3;
import com.mygdx.gameobjects.BoundRectLevel4;
import com.mygdx.gameobjects.FrogEnemy;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 21-Jun-16.
 */


    public class Level4update {


        public static  double x,y,lastx,lasty,rockvy,rockaccey;
        public static float lastswitchy,lastswitchsticky,lastdoordowny,lastdoorupy;
        public double vx,vy,lastvx=0;
        public Game thisGame;

        private boolean leftFrog=true,rightFrog=false,topStick=true,bottomStick=false,topStick2=true,
    bottomStick2=false,topStick3=true,bottomStick3=false,frogdied=false;

        public double accelarationx,accelarationy,friction,bounce,gravity;
        public boolean isOnGround;
        public int jumpForce,speedLimit;
         public  boolean switchedOn;
   public FrogEnemy frogEnemy;

        public BlackEnemy blackEnemy;

        public Level4update(Game game){
            thisGame=game;
            x=500;y=120;vx=vy=0;
            Constants.characterX=(int)x;
            lastx=500;
            lasty=120;
            lastswitchsticky=200;
            lastswitchy=200;
            lastdoordowny=130;
            lastdoorupy=230;
            accelarationx=accelarationy=0;
            speedLimit=5;
            friction=.96;
            bounce=.7;
            gravity=-18;
            isOnGround=false;
            jumpForce=10;
            rockaccey=12;
            rockvy=0;

switchedOn=false;

            BlackEnemy.dummyForBlack1.set(1630,150,70,70);
            BlackEnemy.dummyForBlack2.set(2000,150,70,70);
            frogEnemy=new FrogEnemy(1600,144,2000,1550,true,false);

            blackEnemy=new BlackEnemy(1750,150);
        }

        public void update(float delta,OrthographicCamera camera) {
            frogEnemy.update(delta);


            BoundRectLevel4.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());
            BoundRectLevel4.polygoncharacter=new Polygon(new float[]{0,0,BoundRectLevel4.rect[15].width,0,BoundRectLevel4.rect[15].width,BoundRectLevel4.rect[15].height,0,
                    BoundRectLevel4.rect[15].height});

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

////////////////////////////////////////falling rock coordinates///////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


            if(!Constants.characterFinished) {

                for (int i = 0; i <17; i++) {
                    if(i!=13&&i!=14&&i!=15) {
                        int collisionSide = CollDet.collided(BoundRectLevel4.rect[15], BoundRectLevel4.rect[i], 4, 15);
                        if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {

                            if(i==12){
                                if(!Constants.characterFinished)
                                    AssetLoader.falling.play();
                                vx=0;
                                Constants.characterFinished=true;
                                AssetLoader.backgroundmusic.stop();
                            }
                            isOnGround = true;
                            vy += gravity;

                        } else if (collisionSide == CollDet.TOP_SIDE && vy <= 0) {
                            isOnGround = true;
                            if (i == 6) {
                                if (!Intersector.overlaps(BoundRectLevel4.rect[6], BoundRectLevel4.rect[0])) {
                                    BoundRectLevel4.rect[5].y -= 3;
                                    BoundRectLevel4.rect[6].y -= 3;
                                } else switchedOn = true;
                            }

                            if(i==12){
                                frogdied=true;
                            }
                            vy = 0;
                        } else if (collisionSide == CollDet.RIGHT_SIDE && vx >= 0) {
                            if(i==12){
                                if(!Constants.characterFinished)
                                    AssetLoader.falling.play();
                                vx=0;
                                Constants.characterFinished=true;
                                AssetLoader.backgroundmusic.stop();
                            }

                            vx = 0;
                        } else if (collisionSide == CollDet.LEFT_SIDE && vx <= 0) {
                            if(i==12){
                                if(!Constants.characterFinished)
                                    AssetLoader.falling.play();
                                vx=0;
                                Constants.characterFinished=true;
                                AssetLoader.backgroundmusic.stop();
                            }
                            vx = 0;
                        }
                        if (collisionSide != CollDet.BOTTOM_SIDE && vy > 0) {
                            isOnGround = false;
                        }
                    }
                }
            }


            if(switchedOn){
                if(BoundRectLevel4.rect[9].y>50&&BoundRectLevel4.rect[10].y<450) {
                    BoundRectLevel4.rect[9].y--;
                    BoundRectLevel4.rect[10].y++;
                }
            }



            BoundRectLevel4.polygonup.setOrigin(0, 10);
            BoundRectLevel4.polygonup.setPosition(625, 325);


            BoundRectLevel4.polygondown.setOrigin(0, 10);
            BoundRectLevel4.polygondown.setPosition(925, 145);

            BoundRectLevel4.polygoncharacter.setPosition(BoundRectLevel4.rect[15].x,BoundRectLevel4.rect[15].y);

            if(Intersector.overlapConvexPolygons(BoundRectLevel4.polygoncharacter,BoundRectLevel4.polygonup)||
                    Intersector.overlapConvexPolygons(BoundRectLevel4.polygoncharacter,BoundRectLevel4.polygondown)){
                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }



            if(x>=3700){
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
if(!frogdied) {
    BoundRectLevel4.rect[12].setPosition(frogEnemy.frogEnemyRect.x, frogEnemy.frogEnemyRect.y);
    Gdx.app.log("frogenemy", "" + frogEnemy.frogEnemyRect.x);
}
            else BoundRectLevel4.rect[12].y-=10;




            if ( topStick) {
                BoundRectLevel4.rect[13].y -= 50 * delta;
            }

            if (BoundRectLevel4.rect[13].y<20) {
                topStick = false;
                bottomStick = true;
            }


            if (bottomStick) {
                BoundRectLevel4.rect[13].y += 50 * delta;

            }

            if (BoundRectLevel4.rect[13].y >120 && bottomStick) {
                bottomStick = false;
                topStick = true;
            }


            if ( topStick2) {
                BoundRectLevel4.rect[14].y -= 50 * delta;
            }

            if (BoundRectLevel4.rect[14].y< 30) {
                topStick2 = false;
                bottomStick2 = true;
            }


            if (bottomStick2) {
                BoundRectLevel4.rect[14].y += 50 * delta;

            }

            if (BoundRectLevel4.rect[14].y >120 && bottomStick2) {
                bottomStick2 = false;
                topStick2 = true;
            }



         if(Intersector.overlaps(BoundRectLevel4.rect[15],BoundRectLevel4.rect[13])||
                    Intersector.overlaps(BoundRectLevel4.rect[15],BoundRectLevel4.rect[14])){
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
                BoundRectLevel4.rect[6].y=lastswitchy;
                BoundRectLevel4.rect[5].y=lastswitchsticky;
                BoundRectLevel4.rect[10].y=lastdoorupy;
                BoundRectLevel4.rect[9].y=lastdoordowny;

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





