package com.mygdx.gameworld;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.gameConstants.Constants;

import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.screens.GameScreen;
import com.mygdx.screens.LevelScreen;

/**
 * Created by Personal on 11-Jun-16.
 */
public   class LevelUpdator {

    public void update(float delta,OrthographicCamera camera,Game game){

        if (Constants.Level1Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,1));
            Constants.Level1Clicked=false;
        }
        if (Constants.Level2Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,2));
            Constants.Level2Clicked=false;
        }
        if(Constants.Level3Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,3));
            Constants.Level3Clicked=false;
        }
        if(Constants.Level4Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,4));
            Constants.Level4Clicked=false;
        }
        if(Constants.Level5Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,5));
            Constants.Level5Clicked=false;
        }
        if(Constants.Level6Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,6));
            Constants.Level6Clicked=false;
        }
        if(Constants.Level7Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,7));
            Constants.Level7Clicked=false;
        }
        if(Constants.Level8Clicked){
            AssetLoader.backgroundmusic.stop();
            game.setScreen(new GameScreen(game,8));
            Constants.Level8Clicked=false;
        }
    }


}

