package com.room8.flameengine;

import java.util.ArrayList;
import java.util.Arrays;

import com.room8.flameengine.Thread.LoadAndAdd;
import com.room8.flameengine.Thread.PreloadScreen;
import com.room8.game.screens.LoadingScreen;

public class ScreenManager {

	private ArrayList<FlameScreen> m_screens;

	private LoadAndAdd m_loadAndAddScreens;
	private Thread m_loadAndAddThread;
	private PreloadScreen m_preloadScreens;
	private Thread m_preloadingThread;

	public ScreenManager() {
		m_screens = new ArrayList<FlameScreen>();

		m_preloadScreens = new PreloadScreen();
		m_loadAndAddScreens = new LoadAndAdd();
		m_loadAndAddScreens.setLoadedScreensDestination(m_screens);
		m_loadAndAddThread = new Thread(m_loadAndAddScreens, "LoadAndAdd Thread");
		m_preloadingThread = new Thread(m_preloadScreens, "Preloading Thread");
	}

	public void render(float delta) {
		for(int i = m_screens.size()-1; i >= 0; --i)
		{
			m_screens.get(i).render(delta);
			if(m_screens.get(i).blockRendering())
			{
				break;
			}
		}
	}

	public void update(float delta) {
		for(int i = m_screens.size()-1; i >= 0; --i) {
			m_screens.get(i).update(delta);
			if(m_screens.get(i).blockUpdates()) {
				break;
			}
		}
	}

	public void loadScreenAndAdd(FlameScreen screen) {
		m_loadAndAddScreens.LoadAndAddScreens.add(screen);
		m_loadAndAddThread.start();
	}

	public void preloadScreen(FlameScreen screen) {
		m_preloadScreens.PreloadScreens.add(screen);
		m_preloadingThread.start();
	}

	public void preloadScreens(FlameScreen[] screens) {
		m_preloadScreens.PreloadScreens.addAll(Arrays.asList(screens));
		m_preloadingThread.start();
	}

	public synchronized void pop() {
		if(!m_screens.isEmpty()) {
			m_screens.remove(m_screens.size()-1);
		}
	}
	
	public synchronized void unsafePop() {
		m_screens.remove(m_screens.size()-1);
	}

	public void pushPreloadedScreen(FlameScreen screen) {
		while(m_screens.size() > 0 && m_screens.get(m_screens.size()-1).getClass().equals(LoadingScreen.class))
		{
			unsafePop();
		}
		m_screens.add(screen);
	}
}
