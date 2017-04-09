package com.mygdx.gameworld;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.Level1.Level1update;
import com.mygdx.Level2.Level2update;
import com.mygdx.Level3.Level3update;
import com.mygdx.Level4.Level4update;
import com.mygdx.Level5.Level5update;
import com.mygdx.Level6.Level6update;
import com.mygdx.Level7.Level7update;
import com.mygdx.Level8.Level8update;
import com.mygdx.gameConstants.Constants;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gameobjects.BlackEnemy;





public class GameUpdator {
   private Level1update level1update;
    private Level2update level2update;
    private Level3update level3update;
    private Level4update level4update;
    private Level5update level5update;
    private Level6update level6update;
    private Level7update level7update;
    private Level8update level8update;

    private BlackEnemy blackEnemy;
    private OrthographicCamera cam;
    private Game thisGame;
    private int levelNum;



    public GameUpdator(Game game,int whichLevel){
        levelNum=whichLevel;
      //level1update=new Level1update(game);
        if(levelNum==1) {
            level1update = new Level1update(game);

        }
        if(levelNum==2){
            level2update = new Level2update(game);
        }
        if(levelNum==3){
            level3update = new Level3update(game);
        }
        if(levelNum==4){
            level4update=new Level4update(game);
        }
        if(levelNum==5){
            level5update=new Level5update(game);
        }
        if(levelNum==6){
            level6update=new Level6update(game);
        }
        if(levelNum==7){
            level7update=new Level7update(game);
        }
        if(levelNum==8){
            level8update=new Level8update(game);
        }
        thisGame =game;
    }


    public void update(float delta,OrthographicCamera camera){



        if(!Constants.pauseClicked) {

            if(levelNum==1)
                level1update.update(delta,camera);
            if(levelNum==2)
                level2update.update(delta,camera);
            if(levelNum==3)
                level3update.update(delta,camera);
            if(levelNum==4)
               level4update.update(delta,camera);
            if(levelNum==5)
                level5update.update(delta,camera);
            if(levelNum==6)
                level6update.update(delta,camera);
            if(levelNum==7)
                level7update.update(delta,camera);
            if(levelNum==8)
                level8update.update(delta,camera);
          if(!Constants.characterFinished) {
            //camera.position.x+=3;

    camera.position.set((float) Constants.characterX, 240, 0);
             // camera.position.set((float) 3750, 240, 0);
              AssetLoader.scorerediconx=camera.position.x-390;
              AssetLoader.scoregreeniconx=camera.position.x-270;
              AssetLoader.redscorex=camera.position.x-345;
              AssetLoader.greenscorex=camera.position.x-225;
              AssetLoader.clockx=camera.position.x-160;
              AssetLoader.timex=camera.position.x-115;




              if(AssetLoader.targetleftx<camera.position.x-200)
                  AssetLoader.targetleftx+=10;
              else
              AssetLoader.targetleftx=camera.position.x-200;

              if(AssetLoader.targetrightx>camera.position.x)
              AssetLoader.targetrightx-=10;
              else
              AssetLoader.targetrightx=camera.position.x;

              AssetLoader.gox=AssetLoader.targetrightx+100;






        AssetLoader.leftx = camera.position.x - 390;
        AssetLoader.rightx = camera.position.x - 250;
        AssetLoader.jumpx = camera.position.x + 280;
        AssetLoader.pausex = camera.position.x + 340;
        AssetLoader.levelfailedx = camera.position.x - AssetLoader.levelfailed.getWidth() / 2;
        AssetLoader.levelfailedy = camera.position.y - AssetLoader.levelfailed.getHeight() / 2;
        AssetLoader.levelx=(AssetLoader.levelfailedx+50);
        AssetLoader.retryx=AssetLoader.levelfailedx+280;


}
        }

    }
}
