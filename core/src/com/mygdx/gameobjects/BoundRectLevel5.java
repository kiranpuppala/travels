package com.mygdx.gameobjects;


import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;


/**
 * Created by Personal on 23-Jun-16.
 */
public class BoundRectLevel5 {
    public static Rectangle rect[];
public static Polygon polygon1wing1,polygon1wing2,polygon1wing3,polygoncharacter;


    public BoundRectLevel5() {

    }
    public static void  loadRect() {
        rect = new Rectangle[17];
    /////////////starting rectangle
        rect[0]=new Rectangle(400,20,150,200);
        ///////////////second base rectangle
        rect[1]=new Rectangle(550,20,1200,100);
        ////////switch rectangle
        rect[2]=new Rectangle(550,130, AssetLoader.switch1.getWidth(),AssetLoader.switch1.getHeight());
        ///////gate down rectangle
        rect[3]=new Rectangle(1250,120,150,100);
        /////////gate up rectangle
        rect[4]=new Rectangle(1250,370,500,100);
        /////////gate
        rect[5]=new Rectangle(1310,220,30,150);
        ////////frog enemy
        rect[6]=new Rectangle(1400,280, AssetLoader.duck.getWidth(),AssetLoader.duck.getHeight());
        //////////paddle one smooth
        rect[7]=new Rectangle(1900,0,200,30);
        /////////paddle two throng
        rect[8]=new Rectangle(1900,200,200,60);
        ///////paddle three smooth
        rect[9]=new Rectangle(1900,400,200,30);
        //////////Fan ground after paddles
        rect[10]=new Rectangle(2200,20,1200,100);
        //////////Fan up ground afer paddles
        rect[11]=new Rectangle(2200,370,800,100);
        /////fan one base
        rect[12]=new Rectangle(2750,270,50,100);

        rect[15]=new Rectangle();

        polygon1wing1=new Polygon(new float[]{0,0,180,10,180,20,0,
                20});
        polygon1wing2=new Polygon(new float[]{0,0,180,10,180,20,0,
                20});
        polygon1wing3=new Polygon(new float[]{0,0,180,10,180,20,0,
                20});
        polygoncharacter=new Polygon();



    }
}
