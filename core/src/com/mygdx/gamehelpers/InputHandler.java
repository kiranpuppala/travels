package com.mygdx.gamehelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.gameobjects.MovControl;




public class InputHandler implements InputProcessor {
MovControl control;
    OrthographicCamera cam;
    FitViewport fitViewport;
    boolean touchdown=false,animStop=false;
    public  static boolean spacePressed=false,leftPressed=false,rightPressed=false,keyDown=false,key=false,touch=false,enterPressed=false;
    private  int touchx=0,touchy=0;

    public InputHandler(OrthographicCamera camera,FitViewport viewport){
        cam=new OrthographicCamera();
        this.cam=camera;
       this. fitViewport=viewport;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touch=true;
        touchdown=true;
      // key=false;

          control=new MovControl(screenX,screenY,cam, touchdown,fitViewport);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
      keyDown=true;
         key=true;
        touch=false;
         animStop=false;
       if(keycode== Input.Keys.SPACE){
           spacePressed=true;
        }

       if(keycode== Input.Keys.LEFT)
             leftPressed=true;
         if(keycode== Input.Keys.RIGHT)
            rightPressed=true;
        if(keycode==Input.Keys.ENTER)
            enterPressed=true;
          control=new MovControl(touchx,touchy,cam, touchdown,fitViewport);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
    keyDown=false;
     if(keycode==Input.Keys.SPACE)
        spacePressed=false;
        if(keycode==Input.Keys.LEFT)
      leftPressed=false;
        if(keycode==Input.Keys.RIGHT)
      rightPressed=false;
        if(keycode==Input.Keys.ENTER)
            enterPressed=false;
        control=new MovControl(touchx,touchy,cam, touchdown,fitViewport);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touchdown=false;
        animStop=true;
        control=new MovControl(screenX,screenY,cam, touchdown,fitViewport);
       //touch=false;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}