package com.mygdx.Level2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.CollDet;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.Greeenapple;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.Redapple;
import com.mygdx.screens.LevelScreen;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Personal on 15-Jun-16.
 */
public class Level2update {

    public static  double x,y,lastx,lasty;
    public static  double vx,vy,lastvx=0;
    public Game thisGame;
    public int lastswitchx=0,laststick1y,laststick2y,laststick3y;
    public double accelarationx,accelarationy,friction,bounce,gravity;
    public boolean isOnGround;
    public int jumpForce,speedLimit;

    private boolean topStick=true,bottomStick=false,topStick2=true,bottomStick2=false,
            topStick3=true,bottomStick3=false;
    private boolean switchedOn=false;
    public boolean canRockMove=true,rockHitRight=false,rockHitLeft=false;
    public BlackEnemy blackEnemy;
    public boolean blackFinished=false;
    public Redapple redapple=new Redapple(30,0);
    public  Redapple redapple2 =new Redapple(20,30);
    public Greeenapple greenapple=new Greeenapple(5,0);
    public Timer timerr;

    public Level2update(Game game){
        thisGame=game;
        x=250;y=400;vx=vy=0;
        Constants.characterX=(int)x;


        lastx=480;
        lasty=270;
        lastswitchx=680;
        laststick1y=150;
        laststick2y=220;
        laststick3y=-60;

        accelarationx=accelarationy=0;
        speedLimit=5;
        friction=.96;
        bounce=.7;
        gravity=-18;
        isOnGround=false;
        jumpForce=10;

        BlackEnemy.dummyForBlack1.set(2430,150,70,70);
        BlackEnemy.dummyForBlack2.set(3000,150,70,70);
        blackEnemy=new BlackEnemy(1820,150);

        redapple.setredrect(700, 300, 10, 3);
        redapple2.setredrect(1500, 200, 10, 3);
        greenapple.setgreenrect(2300, 300, 5, 1);
        setTimer(40);

    }

    public void setTimer(int interval){
        Constants.time=interval;


        timerr=new Timer();
        timerr.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(Constants.time!=0&&!Constants.pauseClicked)
                    Constants.time--;

                if(Constants.time==0)
                    if(timerr!=null) {
                        timerr.cancel();
                        // timerr = null;
                    }

            }
        },1000,1000);

    }







    public void update(float delta,OrthographicCamera camera) {
    blackEnemy.update(delta);

        if(!blackFinished) {
            if (BlackEnemy.y < 150)
                BlackEnemy.y = 150;
        }
        BoundRectLevel2.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());
        //BlackEnemy.blackEnemyRect.set()

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

            for (int i = 0; i < 10; i++) {
                if (BoundRectLevel2.rect[i] != null) {
                    int collisionSide = CollDet.collided(BoundRectLevel2.rect[15], BoundRectLevel2.rect[i], 2, 15);
                    if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                        isOnGround = true;
                        vy += gravity;
                        if (i == 3) {
                            BoundRectLevel2.rect[3].y = (float) (y + BoundRectLevel2.rect[15].height);
                            switchedOn = true;
                        }

                    } else if (collisionSide == CollDet.TOP_SIDE && vy <= 0) {
                        isOnGround = true;

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


        if(!Constants.characterFinished) {

            int collisionSide2 = CollDet.collided(BoundRectLevel2.rect[15], BlackEnemy.blackEnemyRect,2,15);
            if (collisionSide2 == CollDet.BOTTOM_SIDE ) {

            } else if (collisionSide2 ==CollDet.TOP_SIDE ) {
                blackFinished=true;

            } else if (collisionSide2 == CollDet.RIGHT_SIDE ) {
                Constants.characterFinished=true;

            } else if (collisionSide2 == CollDet.LEFT_SIDE ) {
                Constants.characterFinished=true;

            }


        }








        x += vx;
        y += vy;
        Constants.characterX=(int)x;



        if(!Constants.characterFinished) {

            int collisionSide2 = CollDet.collided(BoundRectLevel2.rect[15], BlackEnemy.blackEnemyRect,2,15);
            if (collisionSide2 == CollDet.BOTTOM_SIDE ) {

            } else if (collisionSide2 ==CollDet.TOP_SIDE ) {
                blackFinished=true;

            } else if (collisionSide2 == CollDet.RIGHT_SIDE ) {

                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();

            }  else if (collisionSide2 == CollDet.LEFT_SIDE ) {
                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }
        }



        if((Intersector.overlaps(BoundRectLevel2.rect[15],BoundRectLevel2.rect[4]))||
                ( Intersector.overlaps(BoundRectLevel2.rect[15],BoundRectLevel2.rect[5]))||
                (  Intersector.overlaps(BoundRectLevel2.rect[15],BoundRectLevel2.rect[8]))||y < 0){
            if(!Constants.characterFinished)
                AssetLoader.falling.play();
            vx=0;
            Constants.characterFinished=true;
            AssetLoader.backgroundmusic.stop();

        }

        int i=0;
        while (i<30) {
            if(Intersector.overlaps(BoundRectLevel2.rect[15],redapple.sqrredrect[i]))
            {
                // nooftime+=i;
                Redapple. redcatched[i]=true;
                Constants.redscore++;
                // Gdx.app.log("redscore",""+Constants.redscore);
                redapple.sqrredrect[i].x=-400;
            }
            i++;
        }



        while (i>=30&&i<50) {
            if(Intersector.overlaps(BoundRectLevel2.rect[15],redapple2.sqrredrect[i-30]))
            {
                Redapple.redcatched[i]=true;
                Constants.redscore++;
                redapple2.sqrredrect[i-30].x=-400;
            }
            i++;
        }

        i=0;
        while (i<5) {
            if(Intersector.overlaps(BoundRectLevel2.rect[15],greenapple.sqrgreenrect[i]))
            {
                Greeenapple.greencatched[i]=true;
                Constants.greenscore++;
                greenapple.sqrgreenrect[i].x=-400;
            }
            i++;
        }


        if(x>=3400){

            Constants.ReachedHome=true;
            AssetLoader.finishedx=camera.position.x-200;
            AssetLoader.nextx=AssetLoader.finishedx+280;
            AssetLoader.finretryx=AssetLoader.finishedx+70;
            AssetLoader.finlevelx=AssetLoader.finishedx+180;
            vx=0;

        }





        if(!Constants.characterFinished) {

            if (switchedOn) {
                if ( topStick) {
                    BoundRectLevel2.rect[4].y -= 50 * delta;
                }

                if (BoundRectLevel2.rect[4].y< 150) {
                    topStick = false;
                    bottomStick = true;
                }


                if (bottomStick) {
                    BoundRectLevel2.rect[4].y += 50 * delta;

                }

                if (BoundRectLevel2.rect[4].y >300 && bottomStick) {
                    bottomStick = false;
                    topStick = true;
                }
//////////////////////////////////////////////second stick

                if ( topStick2) {
                    BoundRectLevel2.rect[5].y -= 50 * delta;
                }

                if (BoundRectLevel2.rect[5].y< 150) {
                    topStick2 = false;
                    bottomStick2= true;
                }


                if (bottomStick2) {
                    BoundRectLevel2.rect[5].y += 50 * delta;

                }

                if (BoundRectLevel2.rect[5].y >300 && bottomStick2) {
                    bottomStick2 = false;
                    topStick2 = true;
                }
                //////////////////////////////////////third stick
                if ( topStick3) {
                    BoundRectLevel2.rect[8].y -= 20 * delta;
                }

                if (BoundRectLevel2.rect[8].y<-50) {
                    topStick3 = false;
                    bottomStick3= true;
                }


                if (bottomStick3) {
                    BoundRectLevel2.rect[8].y += 20 * delta;

                }

                if (BoundRectLevel2.rect[8].y >60 && bottomStick3) {
                    bottomStick3 = false;
                    topStick3 = true;
                }

            }


            //       BoundRectLevel1.rect[5].setPosition(AssetLoader.stickx, AssetLoader.sticky);
            //     BoundRectLevel1.rect[4].setPosition(AssetLoader.rockx, AssetLoader.rocky);
            //     BoundRectLevel1.rect[6].setPosition(AssetLoader.switchx, AssetLoader.switchy);

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
            BoundRectLevel2.rect[3].x=lastswitchx;
            BoundRectLevel2.rect[3].y=320;
            BoundRectLevel2.rect[4].y=laststick1y;
            BoundRectLevel2.rect[5].y=laststick2y;
            BoundRectLevel2.rect[8].y=laststick3y;

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


