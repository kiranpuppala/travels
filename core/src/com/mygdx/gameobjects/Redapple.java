package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 01-Aug-16.
 */
public class Redapple {

    public  Rectangle[] sqrredrect =new Rectangle[50];
    public static Boolean[] redcatched=new Boolean[1000];

    public Redapple(int num,int offset){
        for(int i=offset;i<offset+num;i++){
            //Gdx.app.log("redcatched value",""+i);
            redcatched[i]=false;
        }
    }


    public void setredrect(int applex,int appley,int rowsize,int colsize)  {
        int firstapplex=applex;
        int redcount=0;

        for(int i=0;i<colsize;i++) {
            for (int j = 0; j < rowsize; j++) {
                applex  += 50;
                sqrredrect[redcount]=new Rectangle(applex,appley, AssetLoader.rapple.getWidth(),AssetLoader.rapple.getHeight());
              //  Gdx.app.log("redapple x paosition", "" +sqrredrect[redcount].x);
              //  Gdx.app.log("redapple y paosition",""+sqrredrect[redcount].y);
                redcount++;
            }
            appley = appley-50;
            applex = firstapplex;
        }

    }




}
