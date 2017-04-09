package com.mygdx.gamehelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class AssetLoader {

    public  static  Texture background,rapple,gapple;
    public static Texture jump,wood,stick,left,right,rock,home,grasstop,switch1,pause,
            resume,blackenemy,levelfailed,retry,levels,levelimage,next,finished,wheel,sand,fonts,scorered,scoregreen,clock,target,go;
    public  static  int xpos,ypos,inixpos;
    public static Texture block[];

    public static Sprite charSprite;
    public static float runTime;

    public static   Texture ducks;
    public static Texture duck;
    public static TextureRegion duck1,duck2,duck3,duck4,duck5,duck6,duck7,duck8,duck9,duck10,fontarray[],targetleft,targetright,grasshalf;
public static TextureRegion currentFrame;
    public static Animation duckAnimation;
    public static FitViewport fitViewport;    public static com.badlogic.gdx.audio.Sound jumping;
    public static Sound falling,backgroundmusic;
    public static float timex,timey;

   public  static float jumpx=0,jumpy=0,leftx=0,lefty=0,lastleftx=0,lastrightx=0,lastjumpx=0,lastpausex=0,
           rightx=0,righty=0,stickx=0,rockx=0,rocky=0,homex=0,homey=0,
    pausex=0,pausey=0,blackenemyx=0,blackenemyy=0,levelfailedx=0,levelfailedy=0,retryx=0,retryy=0,levelx=0,levely=0,
    lastlevelfailedx=0,lastlevelx=0,lastretryx=0,nextx=0,nexty=0,
           finishedx=0,finishedy=0,finlevelx=0,finlevely=0,finretryx=0,finretryy=0,scorerediconx=0,scoreredicony=0,redscorex=0,redscorey=0,scoregreeniconx=0,scoregreenicony=0,
           greenscorex=0,greenscorey=0,clockx=0,clocky=0,targetleftx=0,targetlefty=0,targetrightx=0,targetrighty=0,gox=0,goy=0;




    public static void load(int origx,int origy,FitViewport viewport) {

        fitViewport=viewport;
          lastjumpx=720;
        lastleftx=10;
        lastrightx=100;
        lastpausex=740;
        lastlevelfailedx=210;
        lastlevelx=260;
        lastretryx=510;
        scoreredicony=420;
        scoregreenicony=420;
        greenscorey=420;
        redscorey=420;
timex=720;
        timey=420;
        clocky=420;
        targetlefty=120;
        targetrighty=120;


        jumpx=700;
        jumpy=10;
        leftx=10;
        lefty=10;
        rightx=200;
        righty=10;

        rocky=70;
        homex=2560;
        homey=50;

        pausex=740;
        pausey=420;
        blackenemyx=800;
        blackenemyy=80;
          levelfailedx=210;
        levelfailedy=150;
       levelx=260;
        levely=190;
       retryx=510;
        retryy=190;
        goy=150;

        targetleftx=-200;
        targetrightx=800;

        finishedx=2250;
        finishedy=150;
        nextx=finishedx+280;
        nexty=170;
        finretryx=finishedx+70;
        finretryy=170;
        finlevelx=finishedx+180;
        finlevely=170;

        jumping = Gdx.audio.newSound(Gdx.files.internal("data/jumped.mp3"));
        falling=Gdx.audio.newSound(Gdx.files.internal("data/fallen.mp3"));
        backgroundmusic=Gdx.audio.newSound(Gdx.files.internal("data/backgroundmu.mp3"));

        background = new Texture(Gdx.files.internal("data/background.png"));
         left=new Texture(Gdx.files.internal("data/left.png"));
        right=new Texture(Gdx.files.internal("data/right.png"));
        rock=new Texture(Gdx.files.internal("data/rock.png"));
        switch1=new Texture(Gdx.files.internal("data/switch.png"));
        pause=new Texture(Gdx.files.internal("data/pause.png"));
        resume=new Texture(Gdx.files.internal("data/resume.png"));
        blackenemy=new Texture(Gdx.files.internal("data/blackenemy.png"));
        levelfailed=new Texture(Gdx.files.internal("data/levelfailed.png"));
        levels=new Texture("data/levels.png");
        retry=new Texture("data/retry.png");
        levelimage=new Texture("data/levelimage.png");
        next=new Texture("data/next.png");
        finished=new Texture("data/finished.png");
        wheel=new Texture("data/wheel.png");
        scorered=new Texture("data/scorered.png");
        scoregreen=new Texture("data/scoregreen.png");
       rapple=new Texture("data/rapple.png");
        gapple=new Texture("data/gapple.png");
        go=new Texture(Gdx.files.internal("data/go.png"));

         charSprite=new Sprite();
        charSprite.setSize(80,75);

        jump=new Texture(Gdx.files.internal("data/jump.png"));
        wood=new Texture(Gdx.files.internal("data/wood.png"));
        home=new Texture(Gdx.files.internal("data/home.png"));
        grasstop=new Texture(Gdx.files.internal("data/grass.png"));

        background.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        duck =new Texture(Gdx.files.internal("data/duck.png"));
        ducks=new Texture(Gdx.files.internal("data/characteranimation.png"));
        stick=new Texture(Gdx.files.internal("data/stick.png"));
        sand=new Texture(Gdx.files.internal("data/sand.png"));

        fonts=new Texture(Gdx.files.internal("data/fonts.png"));
        clock=new Texture(Gdx.files.internal("data/clock.png"));
        target=new Texture(Gdx.files.internal("data/target.png"));








        duck1=new TextureRegion(ducks,0,0,80,75);
        duck2=new TextureRegion(ducks,80,0,80,75);
        duck3=new TextureRegion(ducks,160,0,80,75);
        duck4=new TextureRegion(ducks,240,0,80,75);
        duck5=new TextureRegion(ducks,320,0,80,75);
        duck6=new TextureRegion(ducks,400,0,80,75);
        duck7=new TextureRegion(ducks,480,0,80,75);
        duck8=new TextureRegion(ducks,560,0,80,75);
        duck9=new TextureRegion(ducks,640,0,80,75);
        duck10=new TextureRegion(ducks,720,0,80,75);
        grasshalf=new TextureRegion(grasstop,0,0,250,125);


        targetleft=new TextureRegion(target,0,0,200,240);
        targetright=new TextureRegion(target,200,0,200,240);

        fontarray=new TextureRegion[10];


/*
        fontarray[0]=new TextureRegion(fonts,0,-1,40,51);
        fontarray[1]=new TextureRegion(fonts,40,-1,40,51);
        fontarray[2]=new TextureRegion(fonts,81,-1,40,51);
        fontarray[3]=new TextureRegion(fonts,121,-1,40,51);
        fontarray[4]=new TextureRegion(fonts,162,-1,40,51);
        fontarray[5]=new TextureRegion(fonts,202,-1,40,51);
        fontarray[6]=new TextureRegion(fonts,243,-1,40,51);
        fontarray[7]=new TextureRegion(fonts,283,-1,40,51);
        fontarray[8]=new TextureRegion(fonts,323,-1,40,51);
        fontarray[9]=new TextureRegion(fonts,364,-1,38,51);

*/

        fontarray[0]=new TextureRegion(fonts,0,-1,29,36);
        fontarray[1]=new TextureRegion(fonts,28,-1,29,36);
        fontarray[2]=new TextureRegion(fonts,56,-1,29,36);
        fontarray[3]=new TextureRegion(fonts,84,-1,29,36);
        fontarray[4]=new TextureRegion(fonts,112,-1,30,36);
        fontarray[5]=new TextureRegion(fonts,142,-1,29,36);
        fontarray[6]=new TextureRegion(fonts,169,-1,29,36);
        fontarray[7]=new TextureRegion(fonts,197,-1,29,36);
        fontarray[8]=new TextureRegion(fonts,225,-1,29,36);
        fontarray[9]=new TextureRegion(fonts,255,-1,27,36);

        



        TextureRegion[] animducks={duck1,duck2,duck3,duck4,duck5,duck6,duck7,duck8,duck9,duck10};
        duckAnimation=new Animation(.06f,animducks);
        duckAnimation.setPlayMode(Animation.PlayMode.LOOP);
        runTime+=Gdx.graphics.getDeltaTime();
        currentFrame =duckAnimation.getKeyFrame(runTime, true);


        xpos=origx;
        ypos=origy;












           // AssetLoader.backgroundmusic.loop(.2f);

    }



    public  static void dispose() {

       jump.dispose();
        wood.dispose();
        stick.dispose();
        left.dispose();
        right.dispose();
        rock.dispose();
        home.dispose();
        grasstop.dispose();
        sand.dispose();
        switch1.dispose();
        pause.dispose();
        resume.dispose();
        blackenemy.dispose();
        levelfailed.dispose();
        retry.dispose();
        levels.dispose();
        levelimage.dispose();
        rapple.dispose();
        gapple.dispose();

    }}


