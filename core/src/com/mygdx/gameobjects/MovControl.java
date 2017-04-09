package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.InputHandler;


public class MovControl {
    public static Vector3 position;
    OrthographicCamera cam;

    public static float touchX,touchY;
    public  static FitViewport fitViewport;
    public static int PAUSE_COUNT=1;


    public static boolean jump=false;
    public static boolean right=false,left=false;
    public MovControl(int x,int y,OrthographicCamera camera,boolean touchdown,FitViewport viewport){

        this.cam=camera;
        fitViewport=viewport;
        position=new Vector3(x,y,0);
        cam.unproject(position,viewport.getScreenX(),viewport.getScreenY(),viewport.getScreenWidth(),viewport.getScreenHeight());
        touchX=position.x;
        touchY=position.y;



        if(InputHandler.key){

            if(InputHandler.keyDown) {

                if (InputHandler.spacePressed) {
                    jump = true;
                }


                if (InputHandler.rightPressed){
                    right = true;

                }
                if (InputHandler.leftPressed){
                    left = true;
                }

                if(InputHandler.enterPressed) {
                    PAUSE_COUNT++;
                    if (PAUSE_COUNT % 2 == 0)
                        Constants.pauseClicked = true;
                    else
                        Constants.pauseClicked = false;
                }

            }

            if(!InputHandler.keyDown){
                if (!InputHandler.spacePressed)
                jump=false;
                if(!InputHandler.leftPressed)
                left=false;
                if(!InputHandler.rightPressed)
                right=false;

            }


        }

if(InputHandler.touch){
  if(touchdown) {


if(touchX>AssetLoader.jumpx&&touchX<AssetLoader.jumpx+AssetLoader.jump.getWidth()&&touchY>AssetLoader.jumpy&&touchY<AssetLoader.jumpy+AssetLoader.jump.getHeight()){
    jump=true;
}
      else jump=false;

      if(touchX>AssetLoader.leftx&&touchX<AssetLoader.leftx+AssetLoader.left.getWidth()&&touchY>AssetLoader.lefty&&touchY<AssetLoader.lefty+AssetLoader.left.getHeight()){
          left=true;  Gdx.app.log("left true","");
      }
      else left=false;

      if(touchX>AssetLoader.rightx&&touchX<AssetLoader.rightx+AssetLoader.right.getWidth()&&touchY>AssetLoader.righty&&touchY<AssetLoader.righty+AssetLoader.right.getHeight()){
          right=true;

          Gdx.app.log("right true","");
      }
      else right=false;

      if(touchX>AssetLoader.pausex&&touchX<AssetLoader.pausex+AssetLoader.pause.getWidth()
              &&touchY>AssetLoader.pausey&&touchY<AssetLoader.pausey+AssetLoader.pause.getHeight()){

          Gdx.app.log("pause times",""+PAUSE_COUNT);
          PAUSE_COUNT++;
          if(PAUSE_COUNT%2==0) {
              Constants.pauseClicked = true;
              AssetLoader.backgroundmusic.stop();
          }
          else {
              Constants.pauseClicked = false;
              AssetLoader.backgroundmusic.loop(.2f);
          }
          Gdx.app.log("pause times",""+PAUSE_COUNT);
      }



      if(touchX>Constants.LevelRect1.x&&touchX<Constants.LevelRect1.x+Constants.LevelRect1.getWidth()
              &&touchY>Constants.LevelRect1.y&&touchY<Constants.LevelRect1.y+Constants.LevelRect1.getHeight()){
          Constants.Level1Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect2.x&&touchX<Constants.LevelRect2.x+Constants.LevelRect2.getWidth()
              &&touchY>Constants.LevelRect2.y&&touchY<Constants.LevelRect2.y+Constants.LevelRect2.getHeight()){
          Constants.Level2Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect3.x&&touchX<Constants.LevelRect3.x+Constants.LevelRect3.getWidth()
              &&touchY>Constants.LevelRect3.y&&touchY<Constants.LevelRect3.y+Constants.LevelRect3.getHeight()){
          Constants.Level3Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect4.x&&touchX<Constants.LevelRect4.x+Constants.LevelRect4.getWidth()
              &&touchY>Constants.LevelRect4.y&&touchY<Constants.LevelRect4.y+Constants.LevelRect4.getHeight()){
          Constants.Level4Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect5.x&&touchX<Constants.LevelRect5.x+Constants.LevelRect5.getWidth()
              &&touchY>Constants.LevelRect5.y&&touchY<Constants.LevelRect5.y+Constants.LevelRect5.getHeight()){
          Constants.Level5Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect6.x&&touchX<Constants.LevelRect6.x+Constants.LevelRect6.getWidth()
              &&touchY>Constants.LevelRect6.y&&touchY<Constants.LevelRect6.y+Constants.LevelRect6.getHeight()){
          Constants.Level6Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }

      if(touchX>Constants.LevelRect7.x&&touchX<Constants.LevelRect7.x+Constants.LevelRect7.getWidth()
              &&touchY>Constants.LevelRect7.y&&touchY<Constants.LevelRect7.y+Constants.LevelRect7.getHeight()){
          Constants.Level7Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }
      if(touchX>Constants.LevelRect8.x&&touchX<Constants.LevelRect8.x+Constants.LevelRect8.getWidth()
              &&touchY>Constants.LevelRect8.y&&touchY<Constants.LevelRect8.y+Constants.LevelRect8.getHeight()){
          Constants.Level8Clicked=true;
          // Gdx.app.log("Level1Clicked","");
      }



      if((touchX>AssetLoader.retryx&&touchX<AssetLoader.retryx+AssetLoader.retry.getWidth()
              &&touchY>AssetLoader.retryy&&touchY<AssetLoader.retryy+AssetLoader.retry.getHeight())&&Constants.characterFinished){

          Constants.retryLevel=true;

      }

      if((touchX>AssetLoader.levelx&&touchX<AssetLoader.levelx+AssetLoader.levels.getWidth()
              &&touchY>AssetLoader.levely&&touchY<AssetLoader.levely+AssetLoader.levels.getHeight())&&Constants.characterFinished){

          Constants.goToLevelPage=true;

      }
      if((touchX>AssetLoader.finretryx&&touchX<AssetLoader.finretryx+AssetLoader.retry.getWidth()
              &&touchY>AssetLoader.finretryy&&touchY<AssetLoader.finretryy+AssetLoader.retry.getHeight())&&Constants.ReachedHome){
          Constants.retryLevel=true;
      }
      if((touchX>AssetLoader.finlevelx&&touchX<AssetLoader.finlevelx+AssetLoader.levels.getWidth()
              &&touchY>AssetLoader.finlevely&&touchY<AssetLoader.finlevely+AssetLoader.levels.getHeight())&&Constants.ReachedHome){

          Constants.goToLevelPage=true;

      }

      if((touchX>AssetLoader.gox&&touchX<AssetLoader.gox+AssetLoader.go.getWidth()
              &&touchY>AssetLoader.goy&&touchY<AssetLoader.goy+AssetLoader.go.getHeight())&&!Constants.targetstudied){
          Constants.targetstudied=true;

      }



}

    if(!touchdown){
        right=false;
        jump=false;
        left=false;

    }


    }

}}
