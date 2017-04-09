package com.mygdx.gameobjects;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 27-Jun-16.
 */
public class BoundRectLevel7 {


        public static Rectangle rect[];
        public static Polygon polygoncharacter,zigzag1wing1,zigzag1wing2,zigzag2wing1,zigzag2wing2,polygon1wing1,polygon1wing2,
                polygon1wing3,zigzag3wing1,zigzag3wing2,polygon2wing1,polygon2wing2,polygon2wing3,polygon3wing1,polygon3wing2,
    polygon3wing3;
        public  static Rectangle bulletrect[];
    public static Rectangle antRect[];
    public static Circle wheelcircle1,wheelcircle2;


        public BoundRectLevel7() {

        }
        public static void  loadRect() {
            rect = new Rectangle[22];
            bulletrect=new Rectangle[12];
            antRect=new Rectangle[6];
            /////////////starting rectangle
            rect[0]=new Rectangle(400,20,3000,100);
            /////////////zigzag switch 1 base
            rect[1]=new Rectangle(2000,120,70,70);
            ///////////zigzag switch 2 base
            rect[2]=new Rectangle(2600,120,70,70);
            ////// zigzag switch 3 base
            rect[3]=new Rectangle(3600,20,70,100);

            //////rectangle after zig zag3
            rect[4]=new Rectangle(3900,20,1200,100);
            /////////////guns base
            rect[5]=new Rectangle(4500,120,100,150);
            ///////////gun one
            rect[6]=new Rectangle(4470,170,30,50);
            //////////gun two
            rect[7]=new Rectangle(4600,170,30,50);
            /////////bullet one
            rect[8]=new Rectangle(4400,190,70,20);
            //////////bullet two
            rect[9]=new Rectangle(4600,190,70,20);
            ////////dummy for bullet one
            rect[10]=new Rectangle(4400,190,70,20);
            ////////flying ground
            rect[11]=new Rectangle(5400,20,500,100);
            //////////killing hawk saw rectangle
            rect[12]=new Rectangle(5400,450,500,50);
            /////shutter switch puller stick
            rect[13]=new Rectangle(6750,240,20,300);
            ////////shutter switch standing base
            rect[14]=new Rectangle(6710,240,100,20);
            //////door base above ground
            rect[16]=new Rectangle(6100,400,1600,150);
            ////////////door base at the ground
            rect[17]=new Rectangle(6100,20,1600,100);
            ///////////door up
            rect[18]=new Rectangle(7000,260,30,210);
            //////////door down
            rect[19]=new Rectangle(7000,50,30,210);
            ////ant home starting like a bended pipe
            rect[20]=new Rectangle(6200,120,120,70);


            //antRect
            antRect[0]=new Rectangle(6200,120,100,30);
            antRect[1]=new Rectangle(6200,120,100,30);
            antRect[2]=new Rectangle(6200,120,100,30);
            antRect[3]=new Rectangle(6200,120,100,30);
            antRect[4]=new Rectangle(6200,120,100,30);
            antRect[5]=new Rectangle(6200,120,100,30);

           ////ant home ending like a bended pipe
            rect[21]=new Rectangle(7000,120,120,70);


            //////character
            rect[15]=new Rectangle();


             wheelcircle1=new Circle(1000,120,45);
            wheelcircle2=new Circle(650,120,45);


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

            polygoncharacter=new Polygon();



        }
    }



