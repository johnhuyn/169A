package com.main.room8.flameengine.thread;

import java.util.ArrayList;

import com.main.room8.flameengine.Flame;
import com.main.room8.flameengine.FlameScreen;
import com.main.room8.game.screens.LoadingScreen;

public class LoadAndAdd implements Runnable {
	
	public ArrayList<FlameScreen> LoadAndAddScreens;
	
	public LoadAndAdd() {
		LoadAndAddScreens = new ArrayList<FlameScreen>();
	}

	@Override
	public void run() {
		for(FlameScreen screen : LoadAndAddScreens) {
			screen.load();
		}
		
		synchronized(Flame.INSTANCE.assetManager)
		{
			while(!Flame.INSTANCE.assetManager.update()) {
				//wait for the assetmanager to be finished loading
				try {
					Flame.INSTANCE.assetManager.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		for(FlameScreen screen : LoadAndAddScreens)
		{
			screen.postAssetLoad();
            Flame.INSTANCE.screenManager.pushPreloadedScreen(screen);
		}
		LoadAndAddScreens.clear();
		
		synchronized(this)
		{
			this.notify();
		}
	}
}
