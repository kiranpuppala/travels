package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;


public class BoundRectLevel4 {

    public static Rectangle rect[];
    public static Polygon polygonup,polygondown,polygoncharacter;

    public BoundRectLevel4() {

    }
    public static void  loadRect() {
        rect = new Rectangle[17];
        ///////////DOWN RECTANGLE
        rect[0] = new Rectangle(400,20,1100, 100);
        ////////////////DOWN RECTANGLE
        rect[1] = new Rectangle(400,350,1100,100);
        //////////// FIRE UP BASE RECTANGLE
        rect[2]=new Rectangle(900,120,50,50);
        ///////////////// FIRE DOWN BASE RECTANGLE
        rect[3]=new Rectangle(600,300,50,50);
        //////////SHUTTER SWITCH BASE
        rect[4]=new Rectangle(1215,300,40,50);
        ///////////////SHUTTER SWITCH PULLLER STICK
        rect[5]=new Rectangle(1225,200,20,250);
        ////////////SHUTTER SWITCH
        rect[6]=new Rectangle(1185,200,100,20);
        ///////////DOOR UP BASE
        rect[7]=new Rectangle(1450,300,50,50);
        /////////////DOOR DOWN BASE
        rect[8]=new Rectangle(1450,120,50,50);
        ////////////DOOR DOWN
        rect[9]=new Rectangle(1460,130,30,100);
        /////////////DOOR UP
        rect[10]=new Rectangle(1460,230,30,100);
        /////////AFTER DOOR  RECTANGLE
        rect[11]=new Rectangle(1550,20,500,100);
        ///////FROG RECTANGLE
        rect[12]=new Rectangle(1650,270, AssetLoader.duck.getWidth(),AssetLoader.duck.getHeight());
        //////////AFTER DOOR FIRST THRONG RECTANGLE
        rect[13]=new Rectangle(1650,30,20,80);
        //////////AFTER DOOR SECOND THRONG RECTANGLE
        rect[14]=new Rectangle(1950,-10,20,80);
        //////////DESTINATOIN RECTANGLE
       rect[16]=new Rectangle(2300,20,200,100);

//////////////////////////////////
        rect[15]=new Rectangle();
        polygonup=new Polygon(new float[]{0,0,150,0,150,20,0,
                20});
        polygondown=new Polygon(new float[]{0,0,150,0,150,20,0,
                20});
        polygoncharacter=new Polygon();



    }
}
