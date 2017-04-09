package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.CollDet;

/**
 * Created by Personal on 25-Jun-16.
 */
public class SpikeEnemy {

        public static  double x,y,lastx;
        public double vx,vy;
        public static Rectangle dummyForSpike2=new Rectangle();

        public static Rectangle dummyForSpike1=new Rectangle();


        public double accelarationx,accelarationy,friction,bounce,gravity;
        public boolean isOnGround;
        public int jumpForce,speedLimit;
        public static  Rectangle spikeEnemyRect;
        public  boolean moveLeft,moveRight;
        public static int lastdummy1x=0,lastdummy2x=0;

        public SpikeEnemy(int x,int y){
            this.x=x;this.y=y;vx=vy=0;
            lastx=1900;
            accelarationx=accelarationy=0;
            speedLimit=5;
            friction=.96;
            bounce=.7;
            gravity=-18;
            isOnGround=true;
            jumpForce=10;
            moveLeft=false;
            moveRight=true;

           spikeEnemyRect=new Rectangle();
            lastdummy2x=950;
            lastdummy1x=850;

        }

        public void update(float delta) {
            spikeEnemyRect.set((float) x, (float) y, AssetLoader.blackenemy.getWidth(), AssetLoader.blackenemy.getHeight());

            if(CollDet.collided(spikeEnemyRect, SpikeEnemy.dummyForSpike1, 0, 0)==CollDet.LEFT_SIDE){
                vx=0;
                moveRight=true;
                moveLeft=false;
            }

            if(CollDet.collided(spikeEnemyRect, SpikeEnemy.dummyForSpike2,0,0)==CollDet.RIGHT_SIDE){
                vx=0;
                moveRight=false;
                moveLeft=true;
            }


            if(moveRight){
                accelarationx=18;
                friction=1;
            }
            if(moveLeft){
                accelarationx=-18;
                friction=1;
            }

            vx+=(accelarationx*delta);
            vy+=accelarationy;

            if(isOnGround){
                vx*=friction;
            }

            vy+=gravity;

            if(vx>speedLimit){
                vx=speedLimit;
            }
            if(vx<-speedLimit){
                vx=-speedLimit;
            }


        /*for(int i=0;i<7;i++) {
            int collisionSide = CollDet.collided(blackEnemyRect, BoundRectLevel1.rect[i]);
            if (collisionSide == CollDet.BOTTOM_SIDE && vy >= 0) {
                //  vy += gravity;
                isOnGround = true;

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
*/



            x+=vx;
            y+=vy;





        }



    }


