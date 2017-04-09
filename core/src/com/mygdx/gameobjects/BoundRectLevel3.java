package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;


public class BoundRectLevel3 {
    public static Rectangle rect[];

    public BoundRectLevel3() {

    }
    public static void  loadRect() {
        rect = new Rectangle[16];
        ///////////starting rectangle
        rect[0] = new Rectangle(150,180,1000, 125);

        ////////////moving rectangles
        rect[1] = new Rectangle(600, 70, 200,30);
        rect[2] = new Rectangle(1220,70,200,30);


        /////rock
        rect[3] = new Rectangle(300, 249, (AssetLoader.rock.getWidth()), (AssetLoader.rock.getHeight()));


        ////pre destination rectangle
        rect[4] = new Rectangle(1900,-100, 200, 250);


        /////////destination rectangle
        rect[5] = new Rectangle(2100,-100, 150, 300);
        rect[15]=new Rectangle();



    }
}
