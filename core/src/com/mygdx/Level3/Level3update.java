package com.mygdx.Level3;

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
import com.mygdx.gameobjects.BoundRectLevel3;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 17-Jun-16.
 */
public class Level3update {


    public static  double x,y,lastx,lasty,rockvy,rockaccey;
    public double vx,vy,lastvx=0;
    public Game thisGame;
    private boolean leftStick=true,rightStick=false,leftStick2=true,rightStick2=false,rockonthestick1=false,charIsOnTheRock=false,rockonthestick2=false;
    public double accelarationx,accelarationy,friction,bounce,gravity;
    public boolean isOnGround;
    public int jumpForce,speedLimit;

    public boolean canRockMove=true;
    public BlackEnemy blackEnemy;

    public Level3update(Game game){
        thisGame=game;
        x=250;y=400;vx=vy=0;
        Constants.characterX=(int)x;
        lastx=250;
        lasty=400;


        accelarationx=accelarationy=0;
        speedLimit=5;
        friction=.96;
        bounce=.7;
        gravity=-18;
        isOnGround=false;
        jumpForce=10;
        rockaccey=12;
        rockvy=0;






        BlackEnemy.dummyForBlack1.set(1630,150,70,70);
        BlackEnemy.dummyForBlack2.set(2000,150,70,70);
        blackEnemy=new BlackEnemy(1750,150);
    }

    public void update(float delta,OrthographicCamera camera) {


        BoundRectLevel3.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());


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

            for (int i = 0; i < 6; i++) {
                int collisionSide = CollDet.collided(BoundRectLevel3.rect[15], BoundRectLevel3.rect[i],3,15);
                if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                    isOnGround = true;
                    vy += gravity;


                } else if (collisionSide ==CollDet.TOP_SIDE && vy <= 0) {
                    isOnGround = true;

                    if(i==3) {
                        charIsOnTheRock = true;
                    }
                    else
                        charIsOnTheRock=false;

                    if(((i==1)&&(!MovControl.right)&&(!MovControl.left)&&rightStick)||
                            ((i==2)&&(!MovControl.right)&&(!MovControl.left)&&rightStick2)||
                            (charIsOnTheRock&&rockonthestick1&&rightStick)||(charIsOnTheRock&&rockonthestick2&&rightStick2)){

                        x+=50*delta;
                    }

                    if(((i==1)&&(!MovControl.right)&&(!MovControl.left)&&leftStick)||
                            ((i==2)&&(!MovControl.right)&&(!MovControl.left)&&leftStick2)||
                            (charIsOnTheRock&&rockonthestick1&&leftStick)|| (charIsOnTheRock&&rockonthestick2&&leftStick2)){
                        x-=50*delta;
                    }

                    vy = 0;
                } else if (collisionSide == CollDet.RIGHT_SIDE && vx >= 0) {
                    if (i == 3) {
                        if (canRockMove) {
                            BoundRectLevel3.rect[3].x=(float)(x+BoundRectLevel3.rect[15].width);
                        }
                    }

                    if(i!=3) {
                        vx = 0;
                    }

                    if(!canRockMove)
                        vx=0;

                } else if (collisionSide == CollDet.LEFT_SIDE && vx <= 0) {

                    if (i == 3) {
                        if (canRockMove) {
                            BoundRectLevel3.rect[3].x=(float)(x-BoundRectLevel3.rect[3].width);
                        }
                    }

                    if(i!=3) {
                        vx = 0;
                    }
                    if(!canRockMove) {
                        vx = 0;
                    }

                }
                if (collisionSide !=CollDet.BOTTOM_SIDE && vy > 0) {
                    isOnGround = false;
                }

            }
        }

        ///////////////////////////////////fallrock collision detection///////////////////////////////


        if(!Intersector.overlaps(BoundRectLevel3.rect[3],BoundRectLevel3.rect[1])&&
                !Intersector.overlaps(BoundRectLevel3.rect[3],BoundRectLevel3.rect[4])) {
            BoundRectLevel3.rect[3].y-=4;
        }



        if(CollDet.collided(BoundRectLevel3.rect[3], BoundRectLevel3.rect[1],3,3)==CollDet.TOP_SIDE){
            if(canRockMove) {
                if (rightStick)
                    BoundRectLevel3.rect[3].x += 50 * delta;
                if (leftStick)
                    BoundRectLevel3.rect[3].x -= 50 * delta;
                rockonthestick1=true;
               // Gdx.app.log("rockontheistckone",""+rockonthestick1);


            }

        }
        else rockonthestick1=false;

        if(CollDet.collided(BoundRectLevel3.rect[3], BoundRectLevel3.rect[2],3,3)==CollDet.TOP_SIDE){
            if(canRockMove) {
                if (rightStick2)
                    BoundRectLevel3.rect[3].x += 50 * delta;
                if (leftStick2)
                    BoundRectLevel3.rect[3].x -= 50 * delta;
                rockonthestick2=true;


            }

        }
        else rockonthestick2=false;


        int collision=(CollDet.collided(BoundRectLevel3.rect[3], BoundRectLevel3.rect[5],3,3));
               collision= (CollDet.collided(BoundRectLevel3.rect[3], BoundRectLevel3.rect[0],3,3)) ;


        if ((BoundRectLevel3.rect[3].x>(BoundRectLevel3.rect[5].x-BoundRectLevel3.rect[3].getWidth()))) {
            canRockMove = false;
            Gdx.app.log("hithardhithard","");

        }
        else
            canRockMove=true;

       // Gdx.app.log("lnsdlktiht",""+(BoundRectLevel3.rect[0].x+BoundRectLevel3.rect[0].width));

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






        if(x>=2500){
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



        if(y < 0){
            if(!Constants.characterFinished)
                AssetLoader.falling.play();
            vx=0;
            Constants.characterFinished=true;
            AssetLoader.backgroundmusic.stop();

        }



           /* if(x>=2300){

                Constants.ReachedHome=true;
                AssetLoader.finishedx=camera.position.x-200;
                AssetLoader.nextx=AssetLoader.finishedx+280;
                AssetLoader.finretryx=AssetLoader.finishedx+70;
                AssetLoader.finlevelx=AssetLoader.finishedx+180;
                vx=0;

            }
*/


        if(Intersector.overlaps(BoundRectLevel3.rect[1],BoundRectLevel3.rect[2])){
            rightStick=false;
            leftStick=true;
            leftStick2=false;
            rightStick2=true;
        }



        if(!Constants.characterFinished) {

//////////first moving rectangle
            if (BoundRectLevel3.rect[1].x >=  1000 && leftStick) {
                BoundRectLevel3.rect[1].x-= 50 * delta;
            }

            if (BoundRectLevel3.rect[1].x <1000) {
                leftStick = false;
                rightStick = true;
            }


            if (rightStick) {
                BoundRectLevel3.rect[1].x += 50 * delta;

            }

            if (BoundRectLevel3.rect[1].x >=  1390 && rightStick) {
                rightStick = false;
                leftStick = true;
            }
//////////////////////second moving rectangle
            if (BoundRectLevel3.rect[2].x >= 1390 && leftStick2) {
                BoundRectLevel3.rect[2].x-= 50 * delta;
            }

            if (BoundRectLevel3.rect[2].x <1390) {
                leftStick2 = false;
                rightStick2 = true;
            }


            if (rightStick2) {
                BoundRectLevel3.rect[2].x +=50 * delta;

            }

            if (BoundRectLevel3.rect[2].x >=  1700 && rightStick2) {
                rightStick2 = false;
                leftStick2 = true;
            }

               /* BoundRectLevel3.rect[5].setPosition(AssetLoader.stickx, AssetLoader.sticky);
                BoundRectLevel3.rect[4].setPosition(AssetLoader.rockx, AssetLoader.rocky);
                BoundRectLevel3.rect[6].setPosition(AssetLoader.switchx, AssetLoader.switchy);*/
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


            x=lastx;
            y=lasty;
            BoundRectLevel3.rect[3].setPosition((float)300, (float)249);
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




