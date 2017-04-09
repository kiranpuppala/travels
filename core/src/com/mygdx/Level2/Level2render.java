package com.mygdx.Level2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2D;
import com.mygdx.Level1.Level1update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.Greeenapple;
import com.mygdx.gameobjects.MovControl;
import com.mygdx.gameobjects.Redapple;

/**
 * Created by Personal on 15-Jun-16.
 */
public class Level2render {

        private ShapeRenderer shapeRenderer;
        private OrthographicCamera camera;
        private SpriteBatch batch;
    private float runTime;
    private boolean updateAnimationStateTime;
    public enum Direction{LEFT,RIGHT};
    TextureRegion region;

    private Redapple redapple,redapple2;
    private Greeenapple greenapple,greeenapple2;

    private int startPoint = 0;int sco=0, digit1th, digit10th,digit100th,tempRedScore,gdigit1th,gdigit10th,gdigit100th,tempGreenScore,
            cdigit1th,cdigit10th,cdigit100th,tempclock;
    private BitmapFont font;


        public Level2render(OrthographicCamera cam) {
            camera=cam;
            batch=new SpriteBatch();
            shapeRenderer=new ShapeRenderer();

            redapple=new Redapple(30,0);
            redapple2 =new Redapple(20,30);
            greenapple=new Greeenapple(5,0);
            font=new BitmapFont();


            redapple.setredrect(700,300,10,3);
            redapple2.setredrect(1500,200,10,3);
            greenapple.setgreenrect(2300, 300, 5, 1);
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
            batch.draw(AssetLoader.background, camera.position.x-400, 0);
            batch.enableBlending();
        ////////Rendering game objects
            if(!Constants.characterFinished) {

                batch.draw(AssetLoader.blackenemy, (float) BlackEnemy.x, (float) BlackEnemy.y);
            }
            /////////////////


          //  batch.draw(AssetLoader.switch1, BoundRectLevel2.rect[3].x, BoundRectLevel2.rect[3].y,AssetLoader.switch1.getWidth(),
                //    AssetLoader.switch1.getHeight(),0,0,AssetLoader.switch1.getWidth(),AssetLoader.switch1.getHeight(),true,false);

            batch.draw(AssetLoader.switch1,BoundRectLevel2.rect[3].x+10, BoundRectLevel2.rect[3].y-5,AssetLoader.switch1.getWidth()/2,AssetLoader.switch1.getHeight()/2,
                    AssetLoader.switch1.getWidth(),AssetLoader.switch1.getHeight(),1,1,270,0,0,
                    AssetLoader.switch1.getWidth(),AssetLoader.switch1.getHeight(),false,false);
            ////Rendering world
    /*
            int start1=200;
            batch.draw(AssetLoader.grassleft, start1, 100);
            batch.draw(AssetLoader.grasbotleft,start1,0);
            batch.draw(AssetLoader.grasscenter,start1+85,100);
            batch.draw(AssetLoader.grasscenter,start1+85+65,100);
            batch.draw(AssetLoader.grasscenter,start1+85+65+65,100);
            batch.draw(AssetLoader.grasscenter, start1 + 85 + 65 + 65 + 65, 100);
            batch.draw(AssetLoader.grasscenter, start1 + 85 + 65 + 65 + 65+65, 100);
            batch.draw(AssetLoader.grasbotcenter,start1+85,0);
            batch.draw(AssetLoader.grasbotcenter,start1+85+65,0);
            batch.draw(AssetLoader.grasbotcenter,start1+85+65+65,0);
            batch.draw(AssetLoader.grasbotcenter,start1+85+65+65+65,0);
            batch.draw(AssetLoader.grasbotcenter,start1+85+65+65+65+65,0);
            batch.draw(AssetLoader.grassright,start1+85+65+65+65+65+65,100);
            batch.draw(AssetLoader.grasbotright,start1+85+65+65+65+65+65,0);


            int start2=220;

            batch.draw(AssetLoader.sideleft,start2,300);
            batch.draw(AssetLoader.sidebotleft,start2,225);
            batch.draw(AssetLoader.topsmall,start2+85,300);
            batch.draw(AssetLoader.botsmall,start2+85,225);
            batch.draw(AssetLoader.sideright,start2+150,300);
            batch.draw(AssetLoader.sidebotright,start2+150,225);
*/
            /////////////////////////////




            int j=0;
            while (j<30) {
                if(Redapple.redcatched[j]==false) {
                    batch.draw(AssetLoader.rapple, redapple.sqrredrect[j].x, redapple.sqrredrect[j].y);
                    //shapeRenderer.rect(redapple.sqrredrect[i].x, redapple.sqrredrect[i].y, redapple.sqrredrect[i].width, redapple.sqrredrect[i].height);
                }

                j++;
            }
            while (j>=30&&j<50) {

                if(Redapple.redcatched[j]==false) {
                    batch.draw(AssetLoader.rapple, redapple2.sqrredrect[j-30].x, redapple2.sqrredrect[j-30].y);

                }

                j++;

            }



            j=0;
            while (j<5) {
                if(Greeenapple.greencatched[j]==false) {
                    batch.draw(AssetLoader.gapple, greenapple.sqrgreenrect[j].x,greenapple.sqrgreenrect[j].y);
                    //shapeRenderer.rect(redapple.sqrredrect[i].x, redapple.sqrredrect[i].y, redapple.sqrredrect[i].width, redapple.sqrredrect[i].height);
                }

                j++;
            }



            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x + 250, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x + 500, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x + 750, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x + 1000, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop, BoundRectLevel2.rect[1].x + 1250, BoundRectLevel2.rect[1].y);
            batch.draw(AssetLoader.grasstop,BoundRectLevel2.rect[6].x,BoundRectLevel2.rect[6].y);
            batch.draw(AssetLoader.grasstop,BoundRectLevel2.rect[7].x,BoundRectLevel2.rect[7].y);
            batch.draw(AssetLoader.grasstop,BoundRectLevel2.rect[7].x+250,BoundRectLevel2.rect[7].y);
            batch.draw(AssetLoader.grasstop,BoundRectLevel2.rect[9].x,BoundRectLevel2.rect[9].y);
            batch.draw(AssetLoader.grasstop,BoundRectLevel2.rect[9].x+250,BoundRectLevel2.rect[9].y);

            batch.draw(AssetLoader.grasshalf, BoundRectLevel2.rect[2].x, BoundRectLevel2.rect[2].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel2.rect[2].x + 250, BoundRectLevel2.rect[2].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel2.rect[2].x + 500, BoundRectLevel2.rect[2].y);
            batch.draw(AssetLoader.grasshalf, BoundRectLevel2.rect[2].x + 750, BoundRectLevel2.rect[2].y);




            ////Rendering rectangles

            shapeRenderer.setColor(Color.BLACK);
            for (int i=0;i<10;i++) {
                if (BoundRectLevel2.rect[i] != null) {
                    shapeRenderer.rect(BoundRectLevel2.rect[i].x, BoundRectLevel2.rect[i].y, BoundRectLevel2.rect[i].getWidth(),
                            BoundRectLevel2.rect[i].getHeight());
                }
            }
            shapeRenderer.rect(BlackEnemy.dummyForBlack1.x, BlackEnemy.dummyForBlack1.getY(),
                    BlackEnemy.dummyForBlack1.getWidth(), BlackEnemy.dummyForBlack1.getHeight());
            shapeRenderer.rect(BlackEnemy.dummyForBlack2.x, BlackEnemy.dummyForBlack2.getY(),
                    BlackEnemy.dummyForBlack2.getWidth(), BlackEnemy.dummyForBlack2.getHeight());
            shapeRenderer.rect(BlackEnemy.blackEnemyRect.x,BlackEnemy.blackEnemyRect.y,
                    BlackEnemy.blackEnemyRect.getWidth(),BlackEnemy.blackEnemyRect.getHeight());


            Direction direction = Direction.RIGHT;

            AssetLoader.duckAnimation.setPlayMode(Animation.PlayMode.LOOP);

            updateAnimationStateTime = false;


            if(Level2update.vx!=0){
                //  updateAnimationStateTime=true;
            }

            if(Level2update.vx<10){
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
                batch.draw(AssetLoader.fontarray[cdigit1th], AssetLoader.timex + 30, AssetLoader.timey);

            }






            batch.draw(AssetLoader.charSprite, BoundRectLevel2.rect[15].x, BoundRectLevel2.rect[15].y);

            batch.draw(AssetLoader.scoregreen,AssetLoader.scoregreeniconx,AssetLoader.scoregreenicony);

            batch.draw(AssetLoader.scorered,AssetLoader.scorerediconx,AssetLoader.scoreredicony);

            batch.draw(AssetLoader.clock, AssetLoader.clockx, AssetLoader.clocky);


            /////////////////////


            if(Constants.ReachedHome) {
                batch.draw(AssetLoader.finished, AssetLoader.finishedx, AssetLoader.finishedy);
                batch.draw(AssetLoader.next, AssetLoader.nextx, AssetLoader.nexty);
                batch.draw(AssetLoader.retry, AssetLoader.finretryx, AssetLoader.finretryy);
                batch.draw(AssetLoader.levels, AssetLoader.finlevelx, AssetLoader.finlevely);
            }




            if(Constants.characterFinished) {
                batch.draw(AssetLoader.levelfailed, AssetLoader.levelfailedx, AssetLoader.levelfailedy);
                //batch.draw(AssetLoader.duck, (float) Level2update.x, (float) Level2update.y);
                batch.draw(AssetLoader.levels, AssetLoader.levelx, AssetLoader.levely);
                batch.draw(AssetLoader.retry, AssetLoader.retryx, AssetLoader.retryy);
            }
            batch.draw(AssetLoader.left, AssetLoader.leftx, AssetLoader.lefty);
            batch.draw(AssetLoader.right, AssetLoader.rightx, AssetLoader.righty);

            batch.draw(AssetLoader.jump, AssetLoader.jumpx, AssetLoader.jumpy);
            if(!Constants.pauseClicked) {
                batch.draw(AssetLoader.pause, AssetLoader.pausex, AssetLoader.pausey);
            }
            if(Constants.pauseClicked){
                batch.draw(AssetLoader.resume,AssetLoader.pausex,AssetLoader.pausey);
            }


            shapeRenderer.setColor(Color.GREEN);

            shapeRenderer.end();

            batch.end();

        }

    }




