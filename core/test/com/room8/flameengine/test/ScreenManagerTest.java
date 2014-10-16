package com.room8.flameengine.test;

import com.main.room8.flameengine.ScreenManager;
import com.main.room8.game.screens.GamePlayScreen;
import com.main.room8.game.screens.LoadingScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ScreenManagerTest {
	
	ScreenManager m_screenManager;
	GamePlayScreen[] m_gameplayScreen;
	
	LoadingScreen m_loadingScreen;
	GamePlayScreen m_gameplay1;
	GamePlayScreen m_gameplay2;

	@Before
	public void setupScreenManager()
	{
		m_screenManager = new ScreenManager();
		
		m_loadingScreen = mock(LoadingScreen.class);
		m_gameplay1 = mock(GamePlayScreen.class);
		m_gameplay2 = mock(GamePlayScreen.class);
	}
	
	@After
	public void endSpriteBatch()
	{
	}
	
	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		m_screenManager.pushPreloadedScreen(m_gameplay1);
		m_screenManager.pushPreloadedScreen(m_gameplay2);
		m_screenManager.pop();
		m_screenManager.update(0);
		verify(m_gameplay2, never()).update(0);
	}

	@Test
	public void testPushPreloadedScreen() {
		fail("Not yet implemented");
	}

}
