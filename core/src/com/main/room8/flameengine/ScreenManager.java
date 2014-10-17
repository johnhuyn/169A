package com.main.room8.flameengine;

import com.main.room8.flameengine.thread.LoadAndAdd;
import com.main.room8.flameengine.thread.PreloadScreen;
import com.main.room8.game.screens.LoadingScreen;

import java.util.ArrayList;
import java.util.Arrays;

public class ScreenManager {

	private ArrayList<FlameScreen> m_screens;

    private int m_updateStart = 0;
    private int m_renderStart = 0;
    private boolean m_screenListDirty = false;

	private LoadAndAdd m_loadAndAddScreens;
	private Thread m_loadAndAddThread;
	private PreloadScreen m_preloadScreens;
	private Thread m_preloadingThread;

	public ScreenManager() {
		m_screens = new ArrayList<FlameScreen>();

		m_preloadScreens = new PreloadScreen();
		m_loadAndAddScreens = new LoadAndAdd();
		m_loadAndAddThread = new Thread(m_loadAndAddScreens, "LoadAndAdd Thread");
		m_preloadingThread = new Thread(m_preloadScreens, "Preloading Thread");
	}

	public void render(float delta) {
        cleanScreenList();
		for(int i = m_renderStart; i < m_screens.size(); ++i)
		{
			m_screens.get(i).render(delta);
		}
	}

	public void update(float delta) {
        cleanScreenList();
        for(int i = m_updateStart; i < m_screens.size(); ++i) {
			m_screens.get(i).update(delta);
		}
	}

    private void cleanScreenList() {
        if(m_screenListDirty) {
            m_renderStart = findRenderBottom();
            m_updateStart = findUpdateBottom();
            m_screenListDirty = false;
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
            unsafePop();
		}
	}
	
	public synchronized void unsafePop() {
		m_screens.remove(m_screens.size()-1);
        m_screenListDirty = true;
	}

	public void pushPreloadedScreen(FlameScreen screen) {
		while(m_screens.size() > 0 && m_screens.get(m_screens.size()-1).getClass().equals(LoadingScreen.class))
		{
			unsafePop();
		}
		m_screens.add(screen);
        m_screenListDirty = true;
	}

    private int findRenderBottom() {
        for(int i = m_screens.size()-1; i >= 0; --i)
        {
            if(m_screens.get(i).blockRendering() || i == 0) {
                return i;
            }
        }
        return 0;
    }

    private int findUpdateBottom() {
        for(int i = m_screens.size()-1; i >= 0; --i) {
            if(m_screens.get(i).blockUpdates() || i == 0) {
                return i;
            }
        }
        return 0;
    }
}
