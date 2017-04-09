package com.mygdx.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

import org.w3c.dom.css.Rect;

/**
 * Created by Personal on 22-May-16.
 */
public class BoundRectLevel1 {


   public static Rectangle rect[];
    public BoundRectLevel1() {
    }
    public static void  loadRect() {
        rect = new Rectangle[16];
        rect[0] = new Rectangle(375, 0,1250, 250);
        rect[1] = new Rectangle(1625, -100, 1500,250);
        rect[2] = new Rectangle(2625, -100, 250, 500);
        rect[3]=new Rectangle(3250,-100,1000,250);
        rect[5] = new Rectangle(2625, 350, AssetLoader.stick.getWidth(), AssetLoader.stick.getHeight());
        ///////////////rock
        rect[4] = new Rectangle(1800, 150,
                AssetLoader.rock.getWidth(), AssetLoader.rock.getHeight());
        rect[6] = new Rectangle(1625,175,
               (AssetLoader.switch1.getWidth()), (AssetLoader.switch1.getHeight()));
        /////////////////////////////////character rectangle////////////////////////
         rect[15]=new Rectangle();



    }

}
