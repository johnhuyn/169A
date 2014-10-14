package com.room8.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.room8.flameengine.Flame;
import com.room8.flameengine.FlameScreen;

public class GamePlayScreen extends FlameScreen {
	
	/**
	 * Temp stuff
	 */
	public Texture img;

	public GamePlayScreen() {
	}

	public void render(float delta) {
		// TODO Auto-generated method stub
		Flame.INSTANCE.spriteBatch.draw(img, 200, 200);
	}

	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}
	
	public void show() {
		// TODO Auto-generated method stub
		
	}

	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		Flame.INSTANCE.loadTexture(img, "badlogic.jpg");
	}

	@Override
	public boolean blockUpdates() {
		return true;
	}

	@Override
	public boolean blockRendering() {
		return true;
	}

	@Override
	public void postAssetLoad() {
		img = Flame.INSTANCE.assetManager.get("badlogic.jpg", Texture.class);
	}
}
