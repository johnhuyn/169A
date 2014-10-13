package com.room8.screens;

import com.badlogic.gdx.graphics.Texture;
import com.room8.flameengine.Flame;
import com.room8.flameengine.FlameScreen;

public class LoadingScreen extends FlameScreen {
	
	public Texture img;

	public LoadingScreen() {
	}

	public void render(float delta) {
		Flame.INSTANCE.spriteBatch.draw(img, 100, 100);
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

	public void load() {
		Flame.INSTANCE.assetManager.load("badlogic.jpg", Texture.class);
		Flame.INSTANCE.assetManager.finishLoading();
		img = Flame.INSTANCE.assetManager.get("badlogic.jpg");
	}

	@Override
	public boolean blockUpdates() {
		return false;
	}

	@Override
	public boolean blockRendering() {
		return false;
	}

	@Override
	public void postAssetLoad() {
		
	}

}
