package com.room8.flameengine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.room8.screens.GamePlayScreen;
import com.room8.screens.LoadingScreen;

public class Room8Game extends ApplicationAdapter {
	
	@Override
	public void create () {
		//TODO : Change to main menu screen
		GamePlayScreen screen = new GamePlayScreen();
		LoadingScreen loadingScreen = new LoadingScreen();
		loadingScreen.load();
		Flame.INSTANCE.screenManager.pushPreloadedScreen(loadingScreen);
		Flame.INSTANCE.screenManager.loadScreenAndAdd(screen);
	}

	@Override
	public void render () {
		//Do update logic first
		Flame.INSTANCE.update(Gdx.graphics.getDeltaTime());
		
		//Then render
		Flame.INSTANCE.render(Gdx.graphics.getDeltaTime());
	}
}
