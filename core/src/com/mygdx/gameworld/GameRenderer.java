package com.mygdx.gameworld;


import com.badlogic.gdx.graphics.OrthographicCamera;

import com.mygdx.Level1.Level1render;
import com.mygdx.Level2.Level2render;
import com.mygdx.Level3.Level3render;
import com.mygdx.Level4.Level4render;
import com.mygdx.Level5.Level5render;
import com.mygdx.Level6.Level6render;
import com.mygdx.Level7.Level7render;
import com.mygdx.Level7.Level7update;
import com.mygdx.Level8.Level8render;


public class GameRenderer {
    private Level1render level1render;
    private Level2render level2render;
    private Level3render level3render;
    private Level4render level4render;
    private Level5render level5render;
    private Level6render level6render;
    private Level7render level7render;
    private Level8render level8render;
    private OrthographicCamera camera;
    private int levelNum;

    public GameRenderer(OrthographicCamera cam,int whichLevel) {
        camera=cam;
        levelNum=whichLevel;
        if(levelNum==1)
            level1render=new Level1render(camera);
        if(levelNum==2)
            level2render=new Level2render(camera);
        if(levelNum==3)
            level3render=new Level3render(camera);
        if(levelNum==4)
            level4render=new Level4render(camera);
        if(levelNum==5)
            level5render=new Level5render(camera);
        if(levelNum==6)
            level6render=new Level6render(camera);
        if(levelNum==7)
            level7render=new Level7render(camera);
        if(levelNum==8)
            level8render=new Level8render(camera);

    }
    public void render(float delta)
    {
        if(levelNum==1)
            level1render.render(delta);
        if(levelNum==2)
            level2render.render(delta);
        if(levelNum==3)
            level3render.render(delta);
        if(levelNum==4)
           level4render.render(delta);
        if(levelNum==5)
           level5render.render(delta);
        if(levelNum==6)
            level6render.render(delta);
        if(levelNum==7)
            level7render.render(delta);
        if(levelNum==8)
            level8render.render(delta);
    }
}
