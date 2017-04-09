package com.mygdx.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.gamehelpers.AssetLoader;

/**
 * Created by Personal on 22-Jun-16.
 */
public class FrogEnemy {

public Rectangle frogEnemyRect=new Rectangle();

   public float x;
    public float y;
    public  int posOffSet;
    public  int negOffSet;
    public boolean leftFrog;
    public boolean rightFrog;


    public FrogEnemy(float x,float y,int posOffSet,int negOffSet,boolean leftFrog,boolean rightFrog){
        this.x=x;
        this.y=y;
      this.frogEnemyRect.setPosition(this.x,this.y);
        this.frogEnemyRect.setSize(AssetLoader.duck.getWidth(),AssetLoader.duck.getHeight());
        this.posOffSet=posOffSet;
        this.negOffSet=negOffSet;
        this.leftFrog=leftFrog;
        this.rightFrog=rightFrog;

    }


    public void update(float delta) {
     //   Gdx.app.log("Frog y",""+this.frogEnemyRect.y);
        if (this.frogEnemyRect.x >= this.negOffSet && this.leftFrog) {
            this.frogEnemyRect.x -= 60 * delta;
            this.frogEnemyRect.y -= (((Math.sin(this.frogEnemyRect.x / 15) * 5))*60)*delta;
           // Gdx.app.log("",""+(Math.sin(this.frogEnemyRect.x / 15) * 5));

        }

        if (this.frogEnemyRect.x < this.negOffSet) {
            this.leftFrog = false;
            this.rightFrog = true;
        }


        if (this.rightFrog) {
            this.frogEnemyRect.x += 60 * delta;
            this.frogEnemyRect.y += (((Math.sin(this.frogEnemyRect.x / 15) * 5))*60)*delta;
        }

        if (this.frogEnemyRect.x >= this.posOffSet && this.rightFrog) {
            this.rightFrog = false;
            this.leftFrog = true;
        }
    }


}
