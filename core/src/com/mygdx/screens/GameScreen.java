package com.mygdx.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.Level1.Level1update;
import com.mygdx.gamehelpers.AssetLoader;
import com.mygdx.gamehelpers.InputHandler;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.BoundRectLevel1;
import com.mygdx.gameobjects.BoundRectLevel2;
import com.mygdx.gameobjects.BoundRectLevel3;
import com.mygdx.gameobjects.BoundRectLevel4;
import com.mygdx.gameobjects.BoundRectLevel5;
import com.mygdx.gameobjects.BoundRectLevel6;
import com.mygdx.gameobjects.BoundRectLevel7;
import com.mygdx.gameobjects.BoundRectLevel8;
import com.mygdx.gameworld.GameRenderer;
import com.mygdx.gameworld.GameUpdator;



public class GameScreen implements Screen {
    private GameUpdator gameUpdator;
    private GameRenderer renderer;
    private int levelNum;
    private float runTime=0;FitViewport viewport;

    OrthographicCamera camera;Texture background;SpriteBatch batch;
    public GameScreen(Game game,int whichLevel) {
        levelNum=whichLevel;
        camera = new OrthographicCamera();
        camera.position.set(400, 240, 0);
        gameUpdator=new GameUpdator(game,whichLevel);
        viewport = new FitViewport(800, 480, camera);
        renderer=new GameRenderer(camera,whichLevel);
        Gdx.input.setInputProcessor(new InputHandler(camera,viewport));
        AssetLoader.load(900, 40, viewport);
        if(whichLevel==1)
        BoundRectLevel1.loadRect();
        if(whichLevel==2)
        BoundRectLevel2.loadRect();
        if(whichLevel==3)
            BoundRectLevel3.loadRect();
        if(whichLevel==4)
            BoundRectLevel4.loadRect();
        if(whichLevel==5)
            BoundRectLevel5.loadRect();
        if(whichLevel==6)
            BoundRectLevel6.loadRect();
        if(whichLevel==7)
            BoundRectLevel7.loadRect();
        if(whichLevel==8)
            BoundRectLevel8.loadRect();

    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }

        @Override
        public void render(float delta) {

           gameUpdator.update(delta,camera);
            renderer.render(delta);


        }


    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resize called");
        viewport.update(width, height);
        camera.update();

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");
        Level1update.setPause();

    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }

    @Override
    public void dispose() {
        Gdx.app.log("GameScreen", "dispose called");
    }
}
