package com.mygdx.Level1;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Intersector;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.CollDet;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.Greeenapple;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.Redapple;
import com.mygdx.screens.LevelScreen;


import java.util.Timer;
import java.util.TimerTask;

public class Level1update {
    public static  double x,y,lastx,lasty;
    public static  double vx,vy,lastvx=0;
    public Game thisGame;

    public double accelarationx,accelarationy,friction,bounce,gravity;
    public boolean isOnGround;
    public int jumpForce,speedLimit,lastswitchx,lastrockx,laststickx;
    public Timer timerr;


    private boolean leftStick=true,rightstick=false;
    private boolean switchedOn=true;
    public boolean canRockMove=true,rockHitRight=false,rockHitLeft=false;
    public Redapple redapple=new Redapple(30,0);
   public  Redapple redapple2 =new Redapple(20,30);
   public Greeenapple greenapple=new Greeenapple(5,0);

    public Level1update(Game game){
        thisGame=game;
        x=390;y=210;vx=vy=0;
        Constants.characterX=(int)x;
        lastx=480;
        lasty=270;
        accelarationx=accelarationy=0;
        lastswitchx=1625;
        lastrockx=1800;
        laststickx=1550;
        speedLimit=5;
        friction=.96;
        bounce=.7;
        gravity=-18;
        isOnGround=false;
        jumpForce=10;
       redapple.setredrect(500,400,10,3);
        redapple2.setredrect(1500, 400, 10, 3);
        greenapple.setgreenrect(2300, 410, 5, 1);


       setTimer(40);

    }

    public void setTimer(int interval){
        Constants.time=interval;

        timerr=new Timer();
        timerr.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(Constants.time!=0&&!Constants.pauseClicked&&Constants.targetstudied)
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


        BoundRectLevel1.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());

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
            for (int i = 0; i < 7; i++) {
                int collisionSide = CollDet.collided(BoundRectLevel1.rect[15], BoundRectLevel1.rect[i],1,15);
                if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                    isOnGround = true;

                    //thing toc hedij
                    vy += gravity;
                } else if (collisionSide ==CollDet.TOP_SIDE && vy <= 0) {
                    // y = (BoundRectLevel1.rect[i].getY() + BoundRectLevel1.rect[i].getHeight())-1;
                    isOnGround = true;
                    vy = 0;

                }


                else if (collisionSide == CollDet.RIGHT_SIDE && vx >= 0) {
                    if (i == 4) {
                        if (canRockMove) {
                           BoundRectLevel1.rect[4].x=(float)(x+BoundRectLevel1.rect[15].width);
                        }

                    }

                    if(i!=4)
                        vx = 0;

                    if(!canRockMove)
                        vx=0;

                } else if (collisionSide == CollDet.LEFT_SIDE && vx <= 0) {

                    if (i == 4) {
                        if (canRockMove) {
                            BoundRectLevel1.rect[4].x=(float)(x-BoundRectLevel1.rect[4].width);
                        }
                    }


                    if (i == 6) {
                       BoundRectLevel1.rect[6].x=(float)(x-BoundRectLevel1.rect[6].width);
                        switchedOn=true;
                    }

                    if(i!=4) {
                        vx = 0;

                    }
                    if(!canRockMove)
                        vx=0;
                    if(i==6)
                        vx=lastvx;
                }
                if (collisionSide != CollDet.BOTTOM_SIDE && vy > 0) {
                    isOnGround = false;
                }


            }
        }
        if ((CollDet.collided(BoundRectLevel1.rect[4], BoundRectLevel1.rect[2],1,4) == CollDet.RIGHT_SIDE) ||
                (CollDet.collided(BoundRectLevel1.rect[4], BoundRectLevel1.rect[0],1,4) == CollDet.LEFT_SIDE)) {
            canRockMove = false;

        }
        else
            canRockMove=true;

        if (CollDet.collided(BoundRectLevel1.rect[4], BoundRectLevel1.rect[6],1,4) == CollDet.LEFT_SIDE) {
            BoundRectLevel1.rect[6].x += vx;
            switchedOn = true;
        }

        ///Gdx.app.log("vx",""+vx);


        int i=0;
        while (i<30) {
               if(Intersector.overlaps(BoundRectLevel1.rect[15],redapple.sqrredrect[i]))
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
            if(Intersector.overlaps(BoundRectLevel1.rect[15],redapple2.sqrredrect[i-30]))
            {
                Redapple.redcatched[i]=true;
                Constants.redscore++;
                redapple2.sqrredrect[i-30].x=-400;
            }
            i++;
        }

        i=0;
        while (i<5) {
            if(Intersector.overlaps(BoundRectLevel1.rect[15],greenapple.sqrgreenrect[i]))
            {
                Greeenapple.greencatched[i]=true;
                Constants.greenscore++;
                greenapple.sqrgreenrect[i].x=-400;
            }
            i++;
        }





        //////////////////////////////////////animation controlling




        /////////////////



        if(x>=3400&&Constants.redscore==50&&Constants.greenscore==5){

            Constants.ReachedHome=true;
            AssetLoader.finishedx=camera.position.x-200;
            AssetLoader.nextx=AssetLoader.finishedx+280;
            AssetLoader.finretryx=AssetLoader.finishedx+70;
            AssetLoader.finlevelx=AssetLoader.finishedx+180;
            vx=0;


        }



        ///////////////////////checking if target is read or not and moving character then.

if(Constants.targetstudied) {
    x += vx;

}
        y += vy;
        Constants.characterX=(int)x;

        if( (y<0)||(Constants.time==0&&x<3400) ||(x>=3400&&Constants.redscore<50&&Constants.greenscore<5) ){
            Gdx.app.log("xposition",""+x);
            Gdx.app.log("yosition",""+y);
            if(!Constants.characterFinished)
                AssetLoader.falling.play();
            Constants.characterFinished=true;

            vx=0;Constants.redscore=0;
            Constants.greenscore=0;


            AssetLoader.backgroundmusic.stop();

        }




        if(friction==1){
            Constants.stopAnimation=true;
        }

        else {
            Constants.stopAnimation = false;
        }




        if(!Constants.characterFinished) {

            if (switchedOn) {
                if (BoundRectLevel1.rect[5].x >= 2500 && leftStick) {
                    BoundRectLevel1.rect[5].x -= 50 * delta;
                }

                if (BoundRectLevel1.rect[5].x < 2500) {
                    leftStick = false;
                    rightstick = true;
                }


                if (rightstick) {
                    BoundRectLevel1.rect[5].x += 50 * delta;

                }

                if (BoundRectLevel1.rect[5].x >=2700 && rightstick) {
                    rightstick = false;
                    leftStick = true;
                }
            }



        }
        if(Constants.retryLevel){

            Constants.ReachedHome=false;

            Constants.characterFinished=false;
            BoundRectLevel1.rect[4].x=1800;
            camera.position.x=400;
            AssetLoader.jumpx=AssetLoader.lastjumpx;
            AssetLoader.leftx=AssetLoader.lastleftx;
            AssetLoader.rightx=AssetLoader.lastrightx;
            AssetLoader.pausex=AssetLoader.lastpausex;
            AssetLoader.levelfailedx=AssetLoader.lastlevelfailedx;
            AssetLoader.levelx=AssetLoader.lastlevelx;
            AssetLoader.retryx=AssetLoader.lastretryx;
            AssetLoader.rockx=lastrockx;
            AssetLoader.stickx=laststickx;
          BoundRectLevel1.rect[6].x=lastswitchx;
            for(int j=0;j<50;j++)
            Redapple.redcatched[j]=false;

             for(int j=0;j<5;j++)
                 Greeenapple.greencatched[j]=false;
            redapple.setredrect(500, 400, 10, 3);
            redapple2.setredrect(1500, 400, 10, 3);
            greenapple.setgreenrect(2300, 410, 5, 1);


           // Gdx.app.log("retry reached", "");


                timerr.cancel();
                timerr=null;
               // Gdx.app.log("timer reached", "");
              setTimer(40);


            switchedOn=false;

            x=lastx;
            y=lasty;
            AssetLoader.backgroundmusic.loop(.2f);
            Constants.retryLevel=false;

            AssetLoader.targetrightx=800;
            AssetLoader.targetleftx=-200;
            Constants.targetstudied=false;



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

