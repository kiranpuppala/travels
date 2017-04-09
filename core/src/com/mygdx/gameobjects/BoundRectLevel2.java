package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 16-Jun-16.
 */
public class BoundRectLevel2 {


    public static Rectangle rect[];

    public BoundRectLevel2() {

    }
    public static void  loadRect() {
        rect = new Rectangle[16];


        rect[1] = new Rectangle(200, -100,1500,250);
        rect[2] = new Rectangle(680,350, 1000, 125);
        /////switch
        rect[3] = new Rectangle(690, 320, (AssetLoader.switch1.getHeight()), (AssetLoader.switch1.getWidth()));

        ////stick one
        rect[4] = new Rectangle(1300,150, 30, 150);

/////////////////stick two
        rect[5] = new Rectangle(1600,220, 30, 150);

        /////up coming stick base
        rect[6]=new Rectangle(2000,-100,250,250);

/////////////black enemy present
        rect[7]=new Rectangle(2500,-100,500,250);

        //up coming stick
        rect[8]=new Rectangle(2100,-60,10,150);

        ///home rect
        rect[9]=new Rectangle(3300,-100,500,250);

         rect[15]=new Rectangle();


    }

}


