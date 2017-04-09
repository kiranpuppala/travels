package com.mygdx.Level7;

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
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.BoundRectLevel8;
import com.mygdx.gameobjects.FrogEnemy;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.SpikeEnemy;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 27-Jun-16.
 */
public class Level7update {



    public static  double x,y,lastx,lasty;

    public double vx,vy,lastvx=0;
    public Game thisGame;
    public static boolean onTheZigZag1,onTheZigZag2,onTheZigZag3;

    public double accelarationx,accelarationy,friction,bounce,gravity;
    public boolean isOnGround,onPaddle,blackFinished,frogFinished,spikeFinished;
    public boolean antHitSwitch[];
    public static boolean leftStick=true,rightStick=false,leftStick2=true,rightStick2=false;
    public int jumpForce,speedLimit;
    public  boolean switchedOn;
    public FrogEnemy frogEnemy;
    private boolean topStick=true,bottomStick=false;
    public static boolean initRotation=false;
    public BlackEnemy blackEnemy;
    public SpikeEnemy spikeEnemy;
    public Level7update(Game game){
        thisGame=game;
        x=400;y=400;vx=vy=0;
        Constants.characterX=(int)x;
        lastx=400;
        lasty=400;
antHitSwitch=new boolean[6];
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
        frogEnemy=new FrogEnemy(1200,240,1300,1100,true,false);
        blackEnemy=new BlackEnemy(2500,120);
        blackEnemy.dummyForBlack1.set(2330,120,70,70);
        blackEnemy.dummyForBlack2.set(2950,120,70,70);

        spikeEnemy=new SpikeEnemy(1200,120);
    }

    public void update(float delta,OrthographicCamera camera) {

       //blackEnemy.update(delta);
        spikeEnemy.update(delta);
       // if(!frogFinished)
         //   frogEnemy.update(delta);

           BoundRectLevel7.polygoncharacter=new Polygon(new float[]{0,0,BoundRectLevel7.rect[15].width,
                 0,BoundRectLevel7.rect[15].width,BoundRectLevel7.rect[15].height,0,
                   BoundRectLevel7.rect[15].height});



       BoundRectLevel7.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());

//BoundRectLevel7.wheelcircle1.x++;

          /* if(!blackFinished) {
                if (BlackEnemy.y < 120)
                    BlackEnemy.y = 120;
            }
*/
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

                for (int i = 0; i <22; i++) {
                    if (BoundRectLevel7.rect[i] != null) {
                        if(i!=15&&i!=8&&i!=9&&i!=10) {
                            int collisionSide = CollDet.collided(BoundRectLevel7.rect[15], BoundRectLevel7.rect[i], 7, 15);
                            if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                                isOnGround = true;
                                vy += gravity;


                            } else if (collisionSide == CollDet.TOP_SIDE && vy <= 0) {
                                isOnGround = true;
                                if(i==1) onTheZigZag1=true;
                                if(i==2) onTheZigZag2=true;
                                if(i==3) onTheZigZag3=true;
                                if(i==11) y=BoundRectLevel7.rect[11].getY()+BoundRectLevel7.rect[11].getHeight();

                                if (i == 14) {
                                    if (!Intersector.overlaps(BoundRectLevel7.rect[14], BoundRectLevel7.rect[17])) {
                                        BoundRectLevel7.rect[14].y -= 3;
                                        BoundRectLevel7.rect[13].y -= 3;
                                    } else switchedOn = true;
                                }

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


    /*    rect[1]=new Rectangle(2000,120,70,70);
        ///////////zigzag switch 2 base
        rect[2]=new Rectangle(2600,120,70,70);
        ////// zigzag switch 3 base
        rect[3]=new Rectangle(3600,20,70,100);*/

            BoundRectLevel7.polygoncharacter.setPosition(BoundRectLevel7.rect[15].x, BoundRectLevel7.rect[15].y);

        BoundRectLevel7.zigzag1wing1.setOrigin(170, 10);
        BoundRectLevel7.zigzag1wing1.setPosition(1840, 120);
        BoundRectLevel7.zigzag1wing2.setOrigin(10, 10);
        BoundRectLevel7.zigzag1wing2.setPosition(2050, 120);

        BoundRectLevel7.zigzag2wing1.setOrigin(170, 10);
        BoundRectLevel7.zigzag2wing1.setPosition(2440, 120);
        BoundRectLevel7.zigzag2wing2.setOrigin(10, 10);
        BoundRectLevel7.zigzag2wing2.setPosition(2650, 120);

        BoundRectLevel7.zigzag3wing1.setOrigin(170, 10);
        BoundRectLevel7.zigzag3wing1.setPosition(3440, 50);
        BoundRectLevel7.zigzag3wing2.setOrigin(10, 10);
        BoundRectLevel7.zigzag3wing2.setPosition(3650, 50);











            ////////////character in danger////////////

            if(y < 0||Intersector.overlaps(BoundRectLevel7.rect[15],BoundRectLevel7.rect[12])||
                    Intersector.overlaps(BoundRectLevel7.wheelcircle1, BoundRectLevel7.rect[15])||
                  Intersector.overlaps(BoundRectLevel7.wheelcircle2,BoundRectLevel7.rect[15])||
                    Intersector.overlaps(BoundRectLevel7.rect[15],spikeEnemy.spikeEnemyRect)||
                    Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag1wing1, BoundRectLevel7.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag1wing2,BoundRectLevel7.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag2wing1, BoundRectLevel7.polygoncharacter)||
                    Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag2wing2, BoundRectLevel7.polygoncharacter)||
            Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag3wing1, BoundRectLevel7.polygoncharacter)||
            Intersector.overlapConvexPolygons(BoundRectLevel7.zigzag3wing2,BoundRectLevel7.polygoncharacter)||
                    Intersector.overlaps(BoundRectLevel7.rect[15], BoundRectLevel7.rect[9])||
                    Intersector.overlaps(BoundRectLevel7.rect[15],BoundRectLevel7.rect[10]))
            {


                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }


///////////////////////////////////////////////////

/////////////////////////killing frog or gettting killed by frog

            /////////////////////////////////////////////

//////////////////////////////killing blackenemy

///////////////////////////killing spike enemy
            //////////////////////////////

        ///////////////////////////////////moving wheels




        ///////////////first wheel
        if (BoundRectLevel7.wheelcircle1.x >=  650 && leftStick) {
            BoundRectLevel7.wheelcircle1.x-= 100 * delta;
        }

        if (BoundRectLevel7.wheelcircle1.x <650) {
            leftStick = false;
            rightStick = true;
        }


        if (rightStick) {
            BoundRectLevel7.wheelcircle1.x +=100 * delta;

        }

        if (BoundRectLevel7.wheelcircle1.x >=  1000 && rightStick) {
            rightStick = false;
            leftStick = true;
        }
///////////////////////////////second wheel
        if (BoundRectLevel7.wheelcircle2.x >=  650 && leftStick2) {
            BoundRectLevel7.wheelcircle2.x-= 100 * delta;
        }

        if (BoundRectLevel7.wheelcircle2.x <650) {
            leftStick2 = false;
            rightStick2 = true;
        }


        if (rightStick2) {
            BoundRectLevel7.wheelcircle2.x += 100 * delta;

        }

        if (BoundRectLevel7.wheelcircle2.x >=  1000 && rightStick2) {
            rightStick2 = false;
            leftStick2 = true;
        }
//////////////////////////////////////
        /////////////////////bullets movement
        BoundRectLevel7.rect[9].x+=7;

        if(BoundRectLevel7.rect[9].x+BoundRectLevel7.rect[9].width<4600){
            BoundRectLevel7.rect[9].x=4600;
        }
        if(BoundRectLevel7.rect[9].x>5030){
            BoundRectLevel7.rect[9].x=0- BoundRectLevel7.rect[9].x;
        }
        BoundRectLevel7.rect[9].y= (BoundRectLevel7.rect[7].y+BoundRectLevel7.rect[7].height/2)-(BoundRectLevel7.rect[9].height/2);

        BoundRectLevel7.rect[8].x+=7;

        if(BoundRectLevel7.rect[8].x+BoundRectLevel7.rect[8].width<3900){
            BoundRectLevel7.rect[8].x=3900;
        }
        if(BoundRectLevel7.rect[8].x>4430){
            BoundRectLevel7.rect[8].x=0- BoundRectLevel7.rect[8].x;
        }
        BoundRectLevel7.rect[8].y= (BoundRectLevel7.rect[6].y+BoundRectLevel7.rect[6].height/2)-(BoundRectLevel7.rect[8].height/2);

        BoundRectLevel7.rect[10].x=3900+(4430-BoundRectLevel7.rect[8].x);

        ///////////////////////



        /////////////////////////flying rectangle
        BoundRectLevel7.polygon1wing1.setOrigin(0, 10);
        BoundRectLevel7.polygon1wing1.setPosition(5450, BoundRectLevel7.rect[11].y + 40);
        BoundRectLevel7.polygon1wing2.setOrigin(0, 10);
        BoundRectLevel7.polygon1wing2.setPosition(5450, BoundRectLevel7.rect[11].y + 40);
        BoundRectLevel7.polygon1wing3.setOrigin(0, 10);
        BoundRectLevel7.polygon1wing3.setPosition(5450, BoundRectLevel7.rect[11].y + 40);


        BoundRectLevel7.polygon2wing1.setOrigin(0, 10);
        BoundRectLevel7.polygon2wing1.setPosition(5850, BoundRectLevel7.rect[11].y + 40);
        BoundRectLevel7.polygon2wing2.setOrigin(0, 10);
        BoundRectLevel7.polygon2wing2.setPosition(5850, BoundRectLevel7.rect[11].y + 40);
        BoundRectLevel7.polygon2wing3.setOrigin(0, 10);
        BoundRectLevel7.polygon2wing3.setPosition(5850, BoundRectLevel7.rect[11].y+40);

        ///////////////////////////////////////////


        /////////////////////////ants
        if(x>6400) {
            BoundRectLevel7.antRect[0].x++;
            for (int i = 0; i < 5; i++) {
                if (BoundRectLevel7.antRect[i].x > 6400)

                    BoundRectLevel7.antRect[i + 1].x++;
            }

            for (int i = 0; i < 6; i++) {
                if (BoundRectLevel7.antRect[i].x > 7980)
                    BoundRectLevel7.antRect[i].x = 6300;
            }
            for (int i = 0; i < 6; i++) {
                if (BoundRectLevel7.antRect[i].x > 7000)
                    BoundRectLevel7.antRect[i].y = 60;
                else BoundRectLevel7.antRect[i].y = 120;
            }
        }

        for(int i=0;i<6;i++) {
            if (Intersector.overlaps(BoundRectLevel7.rect[14], BoundRectLevel7.antRect[i])){
                antHitSwitch[i]=true;
            }

        }
        for(int i=0;i<6;i++) {
        if(antHitSwitch[i]) {
       BoundRectLevel7.antRect[i].y = 60;
       }
        }





/////////////////////////////////////////////////////////


        /////////////////////////////door


        if(switchedOn){
            if(BoundRectLevel7.rect[19].y>-80&&BoundRectLevel7.rect[18].y<550) {
                BoundRectLevel7.rect[19].y--;
                BoundRectLevel7.rect[18].y++;
            }
        }







        ///////////////////////



        ///////////////////flying rectangle

        if ( topStick) {
            BoundRectLevel7.rect[11].y -= 50 * delta;
        }

        if (BoundRectLevel7.rect[11].y< 20) {
            topStick = false;
            bottomStick = true;
        }


        if (bottomStick) {
            BoundRectLevel7.rect[11].y += 50 * delta;

        }

        if (BoundRectLevel7.rect[11].y >320 && bottomStick) {
            bottomStick = false;
            topStick = true;
        }


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


                onTheZigZag1=onTheZigZag2=onTheZigZag3=false;
                initRotation=true;
                frogFinished=false;
                blackFinished=false;
                spikeFinished=false;

                //frogEnemy=new FrogEnemy(1200,240,1300,1100,true,false);
              //  blackEnemy=new BlackEnemy(2500,120);

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










