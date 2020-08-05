package com.floppy.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class FloppyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture bird_wings_up;
	Texture [] bird;
	int birdStateFlag = 0;
	float flyHeight;
	float fallingSpeed = 0;
	int gameStateFLag = 0;
	Texture topTube;
	Texture bottomTube;
	int spaceBetweenTubes = 1000;
	float tubeShift;
	Random random;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("background.png");
		bird_wings_up = new Texture("bird_wings_up.png");
		bird = new Texture[2];
		bird[0] = new Texture("bird_wings_up.png");
		bird[1] = new Texture("bird_wings_down.png");
		flyHeight = Gdx.graphics.getHeight() / 2 - bird[0].getHeight() / 2;

		topTube = new Texture("top_tube.png");
		bottomTube = new Texture("bottom_tube.png");
		random = new Random();
	}


	@Override
	public void render () {
		batch.begin();
		batch.draw(background,0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		if(Gdx.input.justTouched()){
			Gdx.app.log("Tab","Oops!");
			gameStateFLag = 1;
		}
		if(gameStateFLag == 1){

		if (gameStateFLag == 1){
			if(Gdx.input.justTouched()){
				fallingSpeed = - 30;
				tubeShift = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - spaceBetweenTubes - 200);
			}
			if(flyHeight > 0 || fallingSpeed < 0){
				fallingSpeed++;
				flyHeight -= fallingSpeed;
			}

		}else {
			if(Gdx.input.justTouched()){
				Gdx.app.log("Tab","Oops!");
				gameStateFLag = 1;
			}
		}
			batch.draw(topTube,Gdx.graphics.getWidth() / 2
					- topTube.getWidth() / 2, Gdx.graphics.getHeight() / 2 +
					spaceBetweenTubes / 2 + tubeShift);
			batch.draw(bottomTube,Gdx.graphics.getWidth() / 2
					- bottomTube.getWidth() / 2, Gdx.graphics.getHeight() / 2 + spaceBetweenTubes / 2
					- spaceBetweenTubes / 2 - bottomTube.getHeight() + tubeShift);
		}

		if (birdStateFlag == 0) {
			birdStateFlag = 1;
		} else{
			birdStateFlag = 0;
		}

		batch.draw(bird[birdStateFlag], Gdx.graphics.getWidth() / 2
						- bird[birdStateFlag].getWidth() / 2 ,
						flyHeight);
		batch.end();
	}
	

}
