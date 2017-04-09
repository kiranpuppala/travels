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
import com.mygdx.gameworld.LevelRenderer;
import com.mygdx.gameworld.LevelUpdator;


public class LevelScreen implements Screen {
        private LevelUpdator levelUpdator;
    private Game  thisgame;
        private LevelRenderer levelRenderer;
        private float runTime=0;FitViewport viewport;
        OrthographicCamera camera;Texture background;SpriteBatch batch;
        public LevelScreen(Game game) {
            thisgame=game;
            camera = new OrthographicCamera();
            camera.position.set(400, 240, 0);
            levelUpdator=new LevelUpdator();
            viewport = new FitViewport(800, 480, camera);
            levelRenderer=new LevelRenderer(camera);
            Gdx.input.setInputProcessor(new InputHandler(camera,viewport));
            AssetLoader.load(900, 40, viewport);



        }
        @Override
        public void show() {
            Gdx.app.log("GameScreen", "show called");
        }

        @Override
        public void render(float delta) {

            runTime += delta;
           levelUpdator.update(delta,camera,thisgame);
           levelRenderer.render(runTime);


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

