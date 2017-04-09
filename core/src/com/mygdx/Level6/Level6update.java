package com.mygdx.Level6;

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
import com.mygdx.gameobjects.BoundRectLevel5;
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.FrogEnemy;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.SpikeEnemy;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 24-Jun-16.
 */
public class Level6update {


        public static  double x,y,lastx,lasty;

        public double vx,vy,lastvx=0;
        public Game thisGame;
    public static boolean onTheZigZag1,onTheZigZag2;

        public double accelarationx,accelarationy,friction,bounce,gravity;
        public boolean isOnGround,onPaddle,blackFinished,frogFinished,spikeFinished;
        public int jumpForce,speedLimit;
        public  boolean switchedOn;
        public FrogEnemy frogEnemy;
    private boolean topStick=true,bottomStick=false;
    public static boolean initRotation=false;
        public BlackEnemy blackEnemy;
public SpikeEnemy spikeEnemy;
    public Level6update(Game game){
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


        SpikeEnemy.dummyForSpike1.set(3330,120,70,70);
      SpikeEnemy.dummyForSpike2.set(4200,120,70,70);
         frogEnemy=new FrogEnemy(1200,240,1300,1100,true,false);
       blackEnemy=new BlackEnemy(2500,120);
        blackEnemy.dummyForBlack1.set(2330,120,70,70);
        blackEnemy.dummyForBlack2.set(2950,120,70,70);

        spikeEnemy=new SpikeEnemy(3400,120);
        }

        public void update(float delta,OrthographicCamera camera) {

            blackEnemy.update(delta);
           spikeEnemy.update(delta);
           if(!frogFinished)
               frogEnemy.update(delta);

          BoundRectLevel6.polygoncharacter=new Polygon(new float[]{0,0,BoundRectLevel6.rect[15].width,
                   0,BoundRectLevel6.rect[15].width,BoundRectLevel6.rect[15].height,0,
                   BoundRectLevel6.rect[15].height});







            BoundRectLevel6.rect[15].set((float) x, (float) y, AssetLoader.duck.getWidth(), AssetLoader.duck.getHeight());



           if(!blackFinished) {
                if (BlackEnemy.y < 120)
                    BlackEnemy.y = 120;
            }

            if(!spikeFinished) {
                if (SpikeEnemy.y < 120)
                    SpikeEnemy.y = 120;
            }


            BoundRectLevel6.rect[9].y+=1;
            BoundRectLevel6.rect[10].y+=1;
            BoundRectLevel6.rect[11].y+=1;

            if(BoundRectLevel6.rect[9].y+BoundRectLevel6.rect[9].height<0){
                BoundRectLevel6.rect[9].y=0;
            }
            if(BoundRectLevel6.rect[9].y>510){
                BoundRectLevel6.rect[9].y=0- BoundRectLevel6.rect[9].y;
            }

            if(BoundRectLevel6.rect[10].y+BoundRectLevel6.rect[10].height<0){
                BoundRectLevel6.rect[10].y=-10;
            }
            if(BoundRectLevel6.rect[10].y>510){
                BoundRectLevel6.rect[10].y=0- BoundRectLevel6.rect[10].y;
            }
            if(BoundRectLevel6.rect[11].y+BoundRectLevel6.rect[11].height<0){
                BoundRectLevel6.rect[11].y=-20;
            }
            if(BoundRectLevel6.rect[11].y>510){
                BoundRectLevel6.rect[11].y=0- BoundRectLevel6.rect[11].y;
            }

            BoundRectLevel6.rect[12].y=510-BoundRectLevel6.rect[9].y;
            BoundRectLevel6.rect[13].y=510-BoundRectLevel6.rect[10].y;
            BoundRectLevel6.rect[14].y=510-BoundRectLevel6.rect[11].y;









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
                    if (BoundRectLevel6.rect[i] != null) {
                        if(i!=15&&i!=9&&i!=10&&i!=11) {
                            int collisionSide = CollDet.collided(BoundRectLevel6.rect[15], BoundRectLevel6.rect[i], 6, 15);
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
                                if(i==12){
                                    y= BoundRectLevel6.rect[12].y+BoundRectLevel6.rect[12].height;
                                    Gdx.app.log("on twelvce","");
                                }
                                if(i==13){
                                    if(!Constants.characterFinished)
                                        AssetLoader.falling.play();
                                    vx=0;
                                    Constants.characterFinished=true;
                                    AssetLoader.backgroundmusic.stop();
                                    Gdx.app.log("on5thirt","");
                                }
                                if(i==14){
                                    y= BoundRectLevel6.rect[14].y+BoundRectLevel6.rect[14].height;
                                    Gdx.app.log("on fowter","");
                                }
                                if(i==7){
                                    y= BoundRectLevel6.rect[7].y+BoundRectLevel6.rect[7].height;
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


            BoundRectLevel6.zigzag1wing1.setOrigin(170, 10);
            BoundRectLevel6.zigzag1wing1.setPosition(520, 120);
            BoundRectLevel6.zigzag1wing2.setOrigin(10, 10);
            BoundRectLevel6.zigzag1wing2.setPosition(730, 120);


            BoundRectLevel6.zigzag2wing1.setOrigin(170, 10);
            BoundRectLevel6.zigzag2wing1.setPosition(750, 120);
            BoundRectLevel6.zigzag2wing2.setOrigin(10, 10);
            BoundRectLevel6.zigzag2wing2.setPosition(960, 120);


            BoundRectLevel6.polygon1wing1.setOrigin(0, 10);
            BoundRectLevel6.polygon1wing1.setPosition(2775, 290);
            BoundRectLevel6.polygon1wing2.setOrigin(0, 10);
            BoundRectLevel6.polygon1wing2.setPosition(2775, 290);

            BoundRectLevel6.polygon1wing3.setOrigin(0, 10);
            BoundRectLevel6.polygon1wing3.setPosition(2775, 290);


            BoundRectLevel6.polygoncharacter.setPosition(BoundRectLevel6.rect[15].x, BoundRectLevel6.rect[15].y);

            if(Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.polygon1wing1)||
                    Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.polygon1wing2)||
                    Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.polygon1wing3)){

                if(!Constants.characterFinished)
                    AssetLoader.falling.play();
                vx=0;
                Constants.characterFinished=true;
                AssetLoader.backgroundmusic.stop();
            }

            /////////////////////gun movement


            if ( topStick) {
                BoundRectLevel6.rect[7].y -= 50 * delta;
            }

            if (BoundRectLevel6.rect[7].y< 120) {
                topStick = false;
                bottomStick = true;
            }


            if (bottomStick) {
                BoundRectLevel6.rect[7].y += 50 * delta;

            }

            if (BoundRectLevel6.rect[7].y >220 && bottomStick) {
                bottomStick = false;
                topStick = true;
            }





////////////////////////////////////////////////////

///////////////////////////////bullet movement
            BoundRectLevel6.rect[8].x+=7;


            if(BoundRectLevel6.rect[8].x+BoundRectLevel6.rect[8].width<1800){
                BoundRectLevel6.rect[8].x=1800;
            }
            if(BoundRectLevel6.rect[8].x>2230){
                BoundRectLevel6.rect[8].x=0- BoundRectLevel6.rect[8].x;
            }
            BoundRectLevel6.rect[8].y= (BoundRectLevel6.rect[7].y+BoundRectLevel6.rect[7].height/2)-(BoundRectLevel6.rect[8].height/2);

/////////////////////////////////////////////




            ////////////character in danger////////////
            BoundRectLevel6.polygoncharacter.setPosition(BoundRectLevel6.rect[15].x, BoundRectLevel6.rect[15].y);
            if(Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.zigzag1wing1)||
                    Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.zigzag1wing2)||
                    Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.zigzag2wing1)||
                Intersector.overlapConvexPolygons(BoundRectLevel6.polygoncharacter,BoundRectLevel6.zigzag2wing2)||
                    Intersector.overlaps(BoundRectLevel6.rect[15],BoundRectLevel6.rect[8])){


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


///////////////////////////////////////////////////

/////////////////////////killing frog or gettting killed by frog

            int colside= CollDet.collided(BoundRectLevel6.rect[15],frogEnemy.frogEnemyRect,6,15);


            switch(colside){
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
            if(frogFinished){
                frogEnemy.frogEnemyRect.y-=20;
            }


            BoundRectLevel6.rect[3].setPosition(frogEnemy.frogEnemyRect.x, frogEnemy.frogEnemyRect.y);


            /////////////////////////////////////////////

//////////////////////////////killing blackenemy
        int colside2= CollDet.collided(BoundRectLevel6.rect[15],blackEnemy.blackEnemyRect,6,15);


            switch(colside2){
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

///////////////////////////killing spike enemy


            int colside3= CollDet.collided(BoundRectLevel6.rect[15],spikeEnemy.spikeEnemyRect,6,15);


            switch(colside3){
                case CollDet.TOP_SIDE:
                    if(!Constants.characterFinished)
                        AssetLoader.falling.play();
                    vx=0;
                    Constants.characterFinished=true;
                    AssetLoader.backgroundmusic.stop();
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



            if(spikeFinished){
               spikeEnemy.spikeEnemyRect.y-=20;
            }



            //////////////////////////////

            if(x>=4500){
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


                onTheZigZag1=onTheZigZag2=false;
                initRotation=true;
                frogFinished=false;
                blackFinished=false;
                spikeFinished=false;

                frogEnemy=new FrogEnemy(1200,240,1300,1100,true,false);
                blackEnemy=new BlackEnemy(2500,120);
             //   frogEnemy.x=1200;
              //  frogEnemy.y=240;
              //  blackEnemy.x=2500;
              //  blackEnemy.y=120;
                //////////paddle one smooth
                BoundRectLevel6.rect[9].set(3000, 0, 250, 30);
                /////////paddle two throng
                BoundRectLevel6.rect[10].set(3000,200,250,30);
                ///////paddle three smooth
                BoundRectLevel6.rect[11].set(3000,400,250,30);
                /////////dummyrect for paddle one smooth
                BoundRectLevel6.rect[12].set(3000,0,250,30);
                /////////dummyrect for paddle two throng
                BoundRectLevel6.rect[13].set(3000,200,250,60);
                /////////dummyrect for paddle three smooth
                BoundRectLevel6.rect[14].set(3000,400,250,30);
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









