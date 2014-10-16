package com.main.room8.flameengine.thread;

import java.util.ArrayList;

import com.main.room8.flameengine.Flame;
import com.main.room8.flameengine.FlameScreen;
import com.main.room8.game.screens.LoadingScreen;

public class LoadAndAdd implements Runnable {
	
	public ArrayList<FlameScreen> LoadAndAddScreens;
	
	private ArrayList<FlameScreen> m_loadedScreensDestination;
	
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
			while(m_loadedScreensDestination.size() > 0 && m_loadedScreensDestination.get(m_loadedScreensDestination.size()-1).getClass().equals(LoadingScreen.class))
			{
				Flame.INSTANCE.screenManager.pop();
			}
			m_loadedScreensDestination.add(screen);
		}
		LoadAndAddScreens.clear();
		
		synchronized(this)
		{
			this.notify();
		}
	}

	public void setLoadedScreensDestination(ArrayList<FlameScreen> destination) {
		m_loadedScreensDestination = destination;
	}
}
