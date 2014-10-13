package com.room8.flameengine.Thread;

import java.util.ArrayList;

import com.room8.flameengine.Flame;
import com.room8.flameengine.FlameScreen;

public class PreloadScreen implements Runnable {
	
	public ArrayList<FlameScreen> PreloadScreens;
	public ArrayList<FlameScreen> FinishedScreens;

	public PreloadScreen() {
		PreloadScreens = new ArrayList<FlameScreen>();
		FinishedScreens = new ArrayList<FlameScreen>();
	}

	@Override
	public void run() {
		for(FlameScreen screen : PreloadScreens) {
			screen.load();
		}
		
		synchronized(Flame.INSTANCE.assetManager) {
			while(!Flame.INSTANCE.assetManager.update()) {
				//wait for the assetmanager to be finished loading
				try {
					Flame.INSTANCE.assetManager.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(FlameScreen screen : PreloadScreens) {
			FinishedScreens.add(screen);
		}
		PreloadScreens.clear();
	}
}
