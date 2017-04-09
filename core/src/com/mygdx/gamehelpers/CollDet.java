package com.mygdx.gamehelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.BoundRectLevel3;
import com.mygdx.gameobjects.BoundRectLevel4;
import com.mygdx.gameobjects.BoundRectLevel5;
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.BoundRectLevel8;


public class CollDet {

  public static final int LEFT_SIDE = 1, TOP_SIDE = 2, RIGHT_SIDE = 3, BOTTOM_SIDE = 4;

  public static int collided(Rectangle r1, Rectangle r2,int levelNum,int rectNum) {

    int center1x = (int) (r1.x + (r1.width / 2));
    int center1y = (int) (r1.y + (r1.height / 2));
    int center2x = (int) (r2.x + (r2.width / 2));
    int center2y = (int) (r2.y + (r2.height / 2));
    int halfwidth1 = (int) (r1.width / 2);
    int halfheight1 = (int) (r1.height / 2);
    int halfwidth2 = (int) (r2.width / 2);
    int halfheight2 = (int) (r2.height / 2);
    int vx = center1x - center2x;
    int vy = center1y - center2y;

    int combinedHW = halfwidth1 + halfwidth2;
    int combinedHH = halfheight1 + halfheight2;
    if (Math.abs(vx) < combinedHW) {
      if (Math.abs(vy) < combinedHH) {
        int overlapx = combinedHW - Math.abs(vx);
        int overlapy = combinedHH - Math.abs(vy);

        if (overlapx >= overlapy) {
          if (vy > 0) {
            if(levelNum==1) {
              BoundRectLevel1.rect[rectNum].y = BoundRectLevel1.rect[rectNum].y + overlapy;
            }
            if(levelNum==2) {
                BoundRectLevel2.rect[rectNum].y = BoundRectLevel2.rect[rectNum].y + overlapy;
            }
            if(levelNum==3) {
              BoundRectLevel3.rect[rectNum].y = BoundRectLevel3.rect[rectNum].y + overlapy;
            }
            if(levelNum==4) {
              BoundRectLevel4.rect[rectNum].y = BoundRectLevel4.rect[rectNum].y + overlapy;
            }
            if(levelNum==5) {
            BoundRectLevel5.rect[rectNum].y = BoundRectLevel5.rect[rectNum].y + overlapy;
            }
              if(levelNum==6) {
                  BoundRectLevel6.rect[rectNum].y = BoundRectLevel6.rect[rectNum].y + overlapy;
              }
              if(levelNum==7) {
                  BoundRectLevel7.rect[rectNum].y = BoundRectLevel7.rect[rectNum].y + overlapy;
              }
              if(levelNum==8) {
                  BoundRectLevel8.rect[rectNum].y = BoundRectLevel8.rect[rectNum].y + overlapy;
              }
            //  Gdx.app.log("topside collided","");

            return TOP_SIDE;
          } else {

           if(levelNum==1) {
                BoundRectLevel1.rect[rectNum].y = BoundRectLevel1.rect[rectNum].y - overlapy;
            }
            if(levelNum==2) {
                BoundRectLevel2.rect[rectNum].y = BoundRectLevel2.rect[rectNum].y - overlapy;
            }

            if(levelNum==3) {
                BoundRectLevel3.rect[rectNum].y = BoundRectLevel3.rect[rectNum].y - overlapy;
            }
            if(levelNum==4) {
              BoundRectLevel4.rect[rectNum].y = BoundRectLevel4.rect[rectNum].y - overlapy;
            }
            if(levelNum==5) {
              BoundRectLevel5.rect[rectNum].y = BoundRectLevel5.rect[rectNum].y - overlapy;
            }
              if(levelNum==6) {
                  BoundRectLevel6.rect[rectNum].y = BoundRectLevel6.rect[rectNum].y - overlapy;
              }
              if(levelNum==7) {
                  BoundRectLevel7.rect[rectNum].y = BoundRectLevel7.rect[rectNum].y - overlapy;
              }
              if(levelNum==8) {
                  BoundRectLevel8.rect[rectNum].y = BoundRectLevel8.rect[rectNum].y - overlapy;
              }
            // Gdx.app.log("bottomsidecollided","");
            return BOTTOM_SIDE;
          }
        } else {
          if (vx > 0) {

            if(levelNum==1) {
                BoundRectLevel1.rect[rectNum].x = BoundRectLevel1.rect[rectNum].x+overlapx;
            }
            if(levelNum==2) {
                BoundRectLevel2.rect[rectNum].x = BoundRectLevel2.rect[rectNum].x+overlapx;
            }
            if(levelNum==3) {
                BoundRectLevel3.rect[rectNum].x = BoundRectLevel3.rect[rectNum].x+overlapx;
            }

            if(levelNum==4) {
              BoundRectLevel4.rect[rectNum].x = BoundRectLevel4.rect[rectNum].x+overlapx;
            }
            if(levelNum==5) {
                BoundRectLevel5.rect[rectNum].x = BoundRectLevel5.rect[rectNum].x + overlapx;
            }
              if(levelNum==6) {
                  BoundRectLevel6.rect[rectNum].x = BoundRectLevel6.rect[rectNum].x + overlapx;
              }
              if(levelNum==7) {
                  BoundRectLevel7.rect[rectNum].x = BoundRectLevel7.rect[rectNum].x + overlapx;
              }
              if(levelNum==8) {
                  BoundRectLevel8.rect[rectNum].x = BoundRectLevel8.rect[rectNum].x + overlapx;
              }
            //Gdx.app.log("leftside collided","");
            return LEFT_SIDE;
          } else {

            if(levelNum==1) {
                BoundRectLevel1.rect[rectNum].x = BoundRectLevel1.rect[rectNum].x-overlapx;
            }

            if(levelNum==2) {
                BoundRectLevel2.rect[rectNum].x = BoundRectLevel2.rect[rectNum].x-overlapx;
            }
            if(levelNum==3) {
                BoundRectLevel3.rect[rectNum].x = BoundRectLevel3.rect[rectNum].x-overlapx;
            }
            if(levelNum==4) {
              BoundRectLevel4.rect[rectNum].x = BoundRectLevel4.rect[rectNum].x-overlapx;
            }
            if(levelNum==5) {
              BoundRectLevel5.rect[rectNum].x = BoundRectLevel5.rect[rectNum].x-overlapx;
            }
              if(levelNum==6) {
                  BoundRectLevel6.rect[rectNum].x = BoundRectLevel6.rect[rectNum].x-overlapx;
              }
              if(levelNum==7) {
                  BoundRectLevel7.rect[rectNum].x = BoundRectLevel7.rect[rectNum].x-overlapx;
              }
              if(levelNum==8) {
                  BoundRectLevel8.rect[rectNum].x = BoundRectLevel8.rect[rectNum].x-overlapx;
              }
            //Gdx.app.log("right side collided","");
            return RIGHT_SIDE;
          }
        }

      }
    }

    return 0;
  }
}