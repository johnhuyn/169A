package com.main.room8.flameengine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Similar to Gdx but specific to our game
 * @author George Wang
 *
 */
public class Flame {
	
	/**
	 * Flag on whether debugging is true.
	 * If true cheats are ON.
	 */
	public static final boolean DEBUG = true;
	
	/**
	 * Name tag of project.
	 */
	public static final String TAG = "Room8";
	
	/**
	 * Approximately 60 frames per second
	 */
	public static final int MILLISECONDS_PER_FRAME = 16;
	
	public static final Flame INSTANCE = new Flame(); 

	public static int getWidth()
	{
		return Gdx.graphics.getWidth();
	}
	
	public static int getHeight()
	{
		return Gdx.graphics.getHeight();
	}

	public ScreenManager screenManager;
	public SpriteBatch spriteBatch;
	/**
	 * Manages assets like textures.
	 */
	public AssetManager assetManager;
	
	private Flame() {
		screenManager = new ScreenManager();
		spriteBatch = new SpriteBatch();
		assetManager = new AssetManager();
	}
	
	public void update(float delta) {
		screenManager.update(delta);
		assetManager.update();
	}
	
	public void render(float delta) {

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();

		screenManager.render(delta);

		spriteBatch.end();
	}
	
	/**
	 * Loads a texture asynchronously
	 * @param texture the location to store texture data
	 * @param location the name of the texture
	 */
	public void loadTexture(Texture texture, String location) {
		Flame.INSTANCE.assetManager.load(location, Texture.class);
	}
}
