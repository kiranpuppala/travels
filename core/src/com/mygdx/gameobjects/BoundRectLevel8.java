package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 28-Jun-16.
 */
public class BoundRectLevel8 {



        public static Rectangle rect[];
        public static Polygon polygoncharacter,zigzag1wing1,zigzag1wing2,zigzag2wing1,zigzag2wing2,polygon1wing1,polygon1wing2,
                polygon1wing3,zigzag3wing1,zigzag3wing2,polygon2wing1,polygon2wing2,polygon2wing3,polygon3wing1,polygon3wing2,
                polygon3wing3,zigzag4wing1,zigzag4wing2,zigzag5wing1,zigzag5wing2,polygonup,polygondown;
        public  static Rectangle bulletrect[];
        public static Circle wheelcircle1,wheelcircle2,wheelcircle3,wheelcircle4,wheelcircle5,wheelcircle6;


        public BoundRectLevel8() {

        }
        public static void  loadRect() {
            rect = new Rectangle[17];
            bulletrect=new Rectangle[12];
            /////////////starting rectangle
            rect[0]=new Rectangle(400,20,3500,100);
            /////////////zigzag switch 1 base
            rect[1]=new Rectangle(1000,120,70,70);
            ///////////zigzag switch 2 base
            rect[2]=new Rectangle(1230,120,70,70);
            //////////zigzag switch 3 base
            rect[3]=new Rectangle(1460,120,70,70);
            ////////////zigzag switch 4 base
            rect[4]=new Rectangle(1690,120,70,70);
            ////////////zigzag switch5base
            rect[5]=new Rectangle(1920,120,70,70);
            //////////////throng one
            rect[6]=new Rectangle(2500,120,30,150);
            //////////////throng two
            rect[7]=new Rectangle(2750,120,30,150);

            ///////////////single wheel rectag
            rect[8]=new Rectangle(4200,20,400,100);


            //////////flying rect with wheel
            rect[9]=new Rectangle(4800,20,400,100);

                ///////////////////////////////////////up rectangle
            rect[10]=new Rectangle(5400,400,1600,150);


            /////////////////down rectagnle
            rect[11]=new Rectangle(5400,20,1600,100);

            //////////// FIRE DOWN BASE RECTANGLE
            rect[12]=new Rectangle(5800,120,50,50);
            ///////////////// FIRE UP BASE RECTANGLE
            rect[13]=new Rectangle(6100,350,50,50);
            ////////frog enemy
            rect[14]=new Rectangle(6100,280, AssetLoader.duck.getWidth(),AssetLoader.duck.getHeight());
            //////character
            rect[15]=new Rectangle();
            wheelcircle1=new Circle(3450,120,45);
            wheelcircle2=new Circle(3100,120,45);

            wheelcircle3=new Circle(3800,120,45);
            wheelcircle4=new Circle(3450,120,45);


            wheelcircle5=new Circle(4200,120,45);

wheelcircle6=new Circle(5200,120,45);

            zigzag1wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag1wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag2wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag2wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});

            zigzag3wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});
            zigzag3wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});

            zigzag4wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});

            zigzag4wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});


            zigzag5wing1=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});

            zigzag5wing2=new Polygon(new float[]{0,0,180,0,180,20,0,
                    20});




            polygon1wing1=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon1wing2=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon1wing3=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon2wing1=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon2wing2=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon2wing3=new Polygon(new float[]{0,10,60,0,60,50,0,
                    20});
            polygon3wing1=new Polygon(new float[]{0,0,60,0,60,20,0,
                    20});
            polygon3wing2=new Polygon(new float[]{0,0,60,0,60,20,0,
                    20});
            polygon3wing3=new Polygon(new float[]{0,0,60,0,60,20,0,
                    20});

            polygonup=new Polygon(new float[]{0,0,220,0,220,20,0,
                    20});
            polygondown=new Polygon(new float[]{0,0,220,0,220,20,0,
                    20});
            polygoncharacter=new Polygon();



        }
    }





