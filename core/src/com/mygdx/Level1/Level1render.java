package com.mygdx.Level1;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.Greeenapple;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.Redapple;

/**
 * Created by Personal on 11-Jun-16.
 */
public class Level1render {
    private ShapeRenderer shapeRenderer;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private boolean updateAnimationStateTime;
    public enum Direction{LEFT,RIGHT};
    private Redapple redapple,redapple2;
    private Greeenapple greenapple,greeenapple2;

    private int startPoint = 0;int sco=0, digit1th, digit10th,digit100th,tempRedScore,gdigit1th,gdigit10th,gdigit100th,tempGreenScore,
    cdigit1th,cdigit10th,cdigit100th,tempclock;

  private BitmapFont font;
    TextureRegion region;
    private float runTime;
    private int startPoint2 = 0;

    public Level1render(OrthographicCamera cam) {
        camera = cam;
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        redapple=new Redapple(30,0);
       redapple2 =new Redapple(20,30);
        greenapple=new Greeenapple(5,0);
        font=new BitmapFont();


      redapple.setredrect(500,400,10,3);
        redapple2.setredrect(1500,400,10,3);
        greenapple.setgreenrect(2300, 410, 5, 1);
    }

    public void render(float delta) {

        camera.update();
        batch.setProjectionMatrix(camera.combined);

        shapeRenderer.setProjectionMatrix(camera.combined);
        shapeRenderer.setAutoShapeType(true);
        shapeRenderer.begin();


        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.disableBlending();

        batch.draw(AssetLoader.background, camera.position.x - 400, 0);

        batch.enableBlending();

        batch.draw(AssetLoader.home, BoundRectLevel1.rect[3].x +750, AssetLoader.homey);
        batch.draw(AssetLoader.switch1, BoundRectLevel1.rect[6].x, BoundRectLevel1.rect[6].y);
        batch.draw(AssetLoader.stick, BoundRectLevel1.rect[5].x, BoundRectLevel1.rect[5].y);
        batch.draw(AssetLoader.rock, BoundRectLevel1.rect[4].x, BoundRectLevel1.rect[4].y);




       int i=0;
      while (i<30) {
                   if(Redapple.redcatched[i]==false) {
                       batch.draw(AssetLoader.rapple, redapple.sqrredrect[i].x, redapple.sqrredrect[i].y);
                       //shapeRenderer.rect(redapple.sqrredrect[i].x, redapple.sqrredrect[i].y, redapple.sqrredrect[i].width, redapple.sqrredrect[i].height);
                   }

           i++;
   }
       while (i>=30&&i<50) {

           if(Redapple.redcatched[i]==false) {
                batch.draw(AssetLoader.rapple, redapple2.sqrredrect[i-30].x, redapple2.sqrredrect[i-30].y);

            }

            i++;

        }



       i=0;
        while (i<5) {
            if(Greeenapple.greencatched[i]==false) {
                batch.draw(AssetLoader.gapple, greenapple.sqrgreenrect[i].x,greenapple.sqrgreenrect[i].y);
                //shapeRenderer.rect(redapple.sqrredrect[i].x, redapple.sqrredrect[i].y, redapple.sqrredrect[i].width, redapple.sqrredrect[i].height);
            }

            i++;
        }





        //////////first block


        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[0].x, BoundRectLevel1.rect[0].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[0].x + 250, BoundRectLevel1.rect[0].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[0].x + 500, BoundRectLevel1.rect[0].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[0].x + 750, BoundRectLevel1.rect[0].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[0].x + 1000, BoundRectLevel1.rect[0].y);





/////////////////////////////////////////////

///////////////under block

        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[1].x, BoundRectLevel1.rect[1].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[1].x + 250, BoundRectLevel1.rect[1].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[1].x + 500, BoundRectLevel1.rect[1].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[1].x + 750, BoundRectLevel1.rect[1].y);


        //////////////


        ////////////////////////////////////Stick present block


        batch.draw(AssetLoader.sand, BoundRectLevel1.rect[2].x, BoundRectLevel1.rect[2].y);

        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[2].x, BoundRectLevel1.rect[2].y + 250);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[3].x, BoundRectLevel1.rect[3].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[3].x + 250, BoundRectLevel1.rect[3].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[3].x + 500, BoundRectLevel1.rect[3].y);
        batch.draw(AssetLoader.grasstop, BoundRectLevel1.rect[3].x + 750, BoundRectLevel1.rect[3].y);











        ////////////////////////////////////////////////////


    /*    shapeRenderer.setColor(Color.BLACK);


        // shapeRenderer.rect((float) Duck.x,(float) Duck.y, Duck.duckRect.getWidth(), Duck.duckRect.getHeight());
        // Gdx.app.log("duck rect width",""+Duck.duckRect.getWidth());

        shapeRenderer.rect(BoundRectLevel1.rect[5].getX(), BoundRectLevel1.rect[5].getY(), BoundRectLevel1.rect[5].getWidth(), BoundRectLevel1.rect[5].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[0].getX(), BoundRectLevel1.rect[0].getY(), BoundRectLevel1.rect[0].getWidth(), BoundRectLevel1.rect[0].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[1].getX(), BoundRectLevel1.rect[1].getY(), BoundRectLevel1.rect[1].getWidth(), BoundRectLevel1.rect[1].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[2].getX(), BoundRectLevel1.rect[2].getY(), BoundRectLevel1.rect[2].getWidth(), BoundRectLevel1.rect[2].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[3].getX(), BoundRectLevel1.rect[3].getY(), BoundRectLevel1.rect[3].getWidth(), BoundRectLevel1.rect[3].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[4].getX(), BoundRectLevel1.rect[4].getY(), BoundRectLevel1.rect[4].getWidth(), BoundRectLevel1.rect[4].getHeight());
        shapeRenderer.rect(BoundRectLevel1.rect[6].getX(), BoundRectLevel1.rect[6].getY(), BoundRectLevel1.rect[6].getWidth(), BoundRectLevel1.rect[6].getHeight());

        shapeRenderer.setColor(Color.GREEN);
     // shapeRenderer.rect(BoundRectLevel1.rect[15].getX(),BoundRectLevel1.rect[15].getY(),
        // BoundRectLevel1.rect[15].getWidth(),BoundRectLevel1.rect[15].getHeight());

*/

    /*    batch.draw(AssetLoader.wood, AssetLoader.objects[0].xpos + 600, AssetLoader.objects[0].ypos + 180);
        batch.draw(AssetLoader.rock, AssetLoader.rockx, AssetLoader.rocky);
        batch.enableBlending();
*/
        Direction direction = Direction.RIGHT;

        AssetLoader.duckAnimation.setPlayMode(Animation.PlayMode.LOOP);

        updateAnimationStateTime = false;



       int a=70;

          if(Constants.redscore<10) {
              batch.draw(AssetLoader.fontarray[Constants.redscore], AssetLoader.redscorex,AssetLoader.redscorey);
          }

        if(Constants.redscore>=10&&Constants.redscore<100) {
            digit1th = Constants.redscore % 10;
            digit10th = Constants.redscore / 10;
            batch.draw(AssetLoader.fontarray[digit10th], AssetLoader.redscorex, AssetLoader.redscorey);
            batch.draw(AssetLoader.fontarray[digit1th], AssetLoader.redscorex +30, AssetLoader.redscorey);

        }


    if(Constants.redscore>=100&&Constants.redscore<1000){
            digit1th = Constants.redscore % 10;
            tempRedScore = Constants.redscore / 10;
             digit10th = tempRedScore % 10;
              digit100th=Constants.redscore/100;

            batch.draw(AssetLoader.fontarray[digit100th], AssetLoader.redscorex, AssetLoader.redscorey);
            batch.draw(AssetLoader.fontarray[digit10th], AssetLoader.redscorex+50, AssetLoader.redscorey);
            batch.draw(AssetLoader.fontarray[digit1th], AssetLoader.redscorex + 100, AssetLoader.redscorey);
        }


        batch.draw(AssetLoader.scorered,AssetLoader.scorerediconx,AssetLoader.scoreredicony);

        if(Constants.greenscore<10) {
            batch.draw(AssetLoader.fontarray[Constants.greenscore], AssetLoader.greenscorex,AssetLoader.greenscorey);
        }

        if(Constants.greenscore>=10&&Constants.greenscore<100) {
            gdigit1th = Constants.greenscore % 10;
           gdigit10th = Constants.greenscore / 10;
            batch.draw(AssetLoader.fontarray[gdigit10th], AssetLoader.greenscorex, AssetLoader.greenscorey);
            batch.draw(AssetLoader.fontarray[gdigit1th], AssetLoader.greenscorex+30, AssetLoader.greenscorey);

        }


        if(Constants.greenscore>=100&&Constants.greenscore<1000){
            gdigit1th = Constants.greenscore % 10;
            tempGreenScore = Constants.greenscore / 10;
            gdigit10th = tempGreenScore % 10;
            gdigit100th=Constants.greenscore/100;

            batch.draw(AssetLoader.fontarray[gdigit100th], AssetLoader.greenscorex, AssetLoader.greenscorey);
            batch.draw(AssetLoader.fontarray[gdigit10th], AssetLoader.greenscorex+50, AssetLoader.greenscorey);
            batch.draw(AssetLoader.fontarray[gdigit1th], AssetLoader.redscorex + 100, AssetLoader.redscorey);
        }


        if(Constants.time<10) {
            batch.draw(AssetLoader.fontarray[Constants.time], AssetLoader.timex,AssetLoader.timey);
        }

        if(Constants.time>=10&&Constants.time<100) {
            cdigit1th = Constants.time % 10;
            cdigit10th = Constants.time/ 10;
            batch.draw(AssetLoader.fontarray[cdigit10th], AssetLoader.timex, AssetLoader.timey);
            batch.draw(AssetLoader.fontarray[cdigit1th], AssetLoader.timex+30, AssetLoader.timey);

        }






        batch.draw(AssetLoader.scoregreen,AssetLoader.scoregreeniconx,AssetLoader.scoregreenicony);



        if(Level1update.vx!=0){
          //  updateAnimationStateTime=true;
        }

        if(Level1update.vx<10){
            updateAnimationStateTime=false;
           /// Gdx.app.log("zerozerozero","");
        }

// move specified units to left if left key is pressed
        if (MovControl.left) {
            updateAnimationStateTime = true;
            direction=Direction.LEFT;
        }
// move specified units to right if right key is pressed
        else if (MovControl.right) {
            updateAnimationStateTime = true;
            direction=Direction.RIGHT;
        }
//If Bob is moving, only then update his state time
            if (updateAnimationStateTime) {
                runTime += delta;
                region = AssetLoader.duckAnimation.getKeyFrame(runTime,
                        true);
            }
       else
            region=AssetLoader.currentFrame;

       AssetLoader.charSprite.setRegion(region);



        if(direction==Direction.LEFT){
           AssetLoader.charSprite.setFlip(true, false);
        }
        else{
            AssetLoader.charSprite.setFlip(false, false);
        }
         batch.draw(AssetLoader.charSprite, BoundRectLevel1.rect[15].x, BoundRectLevel1.rect[15].y);

        batch.draw(AssetLoader.clock,AssetLoader.clockx,AssetLoader.clocky);









/*


           region=AssetLoader.duckAnimation.getKeyFrame(runTime,true);
        boolean flip=MovControl.left;


            if(!Constants.characterFinished)
                batch.draw(region,  flip? BoundRectLevel1.rect[15].x+region.getRegionWidth():BoundRectLevel1.rect[15].x,
                        BoundRectLevel1.rect[15].y,flip?-region.getRegionWidth():region.getRegionWidth(),region.getRegionHeight());
*/

            if (Constants.ReachedHome) {
                batch.draw(AssetLoader.finished, AssetLoader.finishedx, AssetLoader.finishedy);
                batch.draw(AssetLoader.next, AssetLoader.nextx, AssetLoader.nexty);
                batch.draw(AssetLoader.retry, AssetLoader.finretryx, AssetLoader.finretryy);
                batch.draw(AssetLoader.levels, AssetLoader.finlevelx, AssetLoader.finlevely);
            }

         if(!Constants.targetstudied){

             batch.draw(AssetLoader.targetleft,AssetLoader.targetleftx,AssetLoader.targetlefty);
             batch.draw(AssetLoader.targetright,AssetLoader.targetrightx,AssetLoader.targetlefty);

             font.draw(batch,"TARGET::\nReach 400 m and catch " +
                     "all red and green\napples in 40 seconds",AssetLoader.targetleftx+50,350);

             batch.draw(AssetLoader.go,AssetLoader.gox,AssetLoader.goy);

         }


            if (Constants.characterFinished) {
                batch.draw(AssetLoader.levelfailed, AssetLoader.levelfailedx, AssetLoader.levelfailedy);
                batch.draw(AssetLoader.duck, (float) Level1update.x, (float) Level1update.y);
                batch.draw(AssetLoader.levels, AssetLoader.levelx, AssetLoader.levely);
                batch.draw(AssetLoader.retry, AssetLoader.retryx, AssetLoader.retryy);
            }
            batch.draw(AssetLoader.left, AssetLoader.leftx, AssetLoader.lefty);
            batch.draw(AssetLoader.right, AssetLoader.rightx, AssetLoader.righty);

            batch.draw(AssetLoader.jump, AssetLoader.jumpx, AssetLoader.jumpy);
            if (!Constants.pauseClicked) {
                batch.draw(AssetLoader.pause, AssetLoader.pausex, AssetLoader.pausey);
            }
            if (Constants.pauseClicked) {
                batch.draw(AssetLoader.resume, AssetLoader.pausex, AssetLoader.pausey);
            }


            shapeRenderer.setColor(Color.GREEN);

            shapeRenderer.end();

            batch.end();

        }

    }


