package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 01-Aug-16.
 */
public class Greeenapple {


        public  Rectangle[] sqrgreenrect =new Rectangle[50];
        public static Boolean[] greencatched=new Boolean[1000];

public Greeenapple(int num,int offset){
    for(int i=offset;i<offset+num;i++){
        Gdx.app.log("redcatched value",""+i);
        greencatched[i]=false;
    }
}





        public void setgreenrect(int applex,int appley,int rowsize,int colsize)  {
            int firstapplex=applex;
            int redcount=0;

            for(int i=0;i<colsize;i++) {
                for (int j = 0; j < rowsize; j++) {
                    applex  += 70;
                    sqrgreenrect[redcount]=new Rectangle(applex,appley, AssetLoader.gapple.getWidth(),AssetLoader.gapple.getHeight());
                    Gdx.app.log("redapple x paosition", "" +sqrgreenrect[redcount].x);
                    Gdx.app.log("redapple y paosition",""+sqrgreenrect[redcount].y);
                    redcount++;
                }
                appley = appley-50;
                applex = firstapplex;
            }

        }


    }





