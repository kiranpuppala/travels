package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 24-Jun-16.
 */
public class BoundRectLevel6 {

        public static Rectangle rect[];
        public static Polygon polygoncharacter,zigzag1wing1,zigzag1wing2,zigzag2wing1,zigzag2wing2,polygon1wing1,polygon1wing2,
    polygon1wing3;
        public  static Rectangle bulletrect[];


        public BoundRectLevel6() {

        }
        public static void  loadRect() {
            rect = new Rectangle[17];
            bulletrect=new Rectangle[12];
            /////////////starting rectangle
            rect[0]=new Rectangle(400,20,1200,100);

            //////switch1 base
            rect[1]=new Rectangle(680,120,70,70);
            ////////switch2 base
            rect[2]=new Rectangle(910,120,70,70);
            //////////frog enemy
            rect[3]=new Rectangle(1200,280, AssetLoader.duck.getWidth(),AssetLoader.duck.getHeight());
            /////////second starting rectangle
            rect[4]=new Rectangle(1700,20,1250,100);
            ///////gun base rectangle
            rect[5]=new Rectangle(1700,120,100,150);
            ////////centre of second rectangle
            rect[6]=new Rectangle(2300,120,100,150);
            ///////gun
            rect[7]=new Rectangle(1800,170,30,50);
            /////////bullet
            rect[8]=new Rectangle(1830,190,70,20);
            //////////paddle one smooth
            rect[9]=new Rectangle(3000,0,250,30);
            /////////paddle two throng
            rect[10]=new Rectangle(3000,200,250,30);
            ///////paddle three smooth
            rect[11]=new Rectangle(3000,400,250,30);
            /////////dummyrect for paddle one smooth
            rect[12]=new Rectangle(3000,0,250,30);
            /////////dummyrect for paddle two throng
            rect[13]=new Rectangle(3000,200,250,60);
            /////////dummyrect for paddle three smooth
            rect[14]=new Rectangle(3000,400,250,30);

            //////character
            rect[15]=new Rectangle();
            /////////final rectangle with fan
            rect[16]=new Rectangle(3400,20,1500,100);
          zigzag1wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                  20});
          zigzag1wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag2wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag2wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});

            polygon1wing1=new Polygon(new float[]{0,0,180,10,180,20,0,
                    20});
            polygon1wing2=new Polygon(new float[]{0,0,180,10,180,20,0,
                    20});
            polygon1wing3=new Polygon(new float[]{0,0,180,10,180,20,0,
                    20});

            polygoncharacter=new Polygon();



        }
    }


