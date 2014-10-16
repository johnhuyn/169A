package com.main.room8.flameengine;

import com.badlogic.gdx.Screen;

public abstract class FlameScreen implements Screen {
	
	public abstract void update(float delta);
	
	public abstract void load();
	
	public abstract void postAssetLoad();
	
	/**
	 * Should this screen block updates below?
	 * @return
	 */
	public abstract boolean blockUpdates();
	
	/**
	 * Should this screen block rendering of screens below?
	 * @return
	 */
	public abstract boolean blockRendering();
}
