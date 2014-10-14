package com.room8.flameengine.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.room8.flameengine.ScreenManager;
import com.room8.game.screens.GamePlayScreen;
import com.room8.game.screens.LoadingScreen;

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
	public void testUpdateShouldBlock() {
		m_screenManager.pushPreloadedScreen(m_gameplay1);
		m_screenManager.pushPreloadedScreen(m_gameplay2);
		when(m_gameplay2.blockUpdates()).thenReturn(true);
		m_screenManager.update(0);
		verify(m_gameplay2).update(0);
		verify(m_gameplay1, never()).update(0);
	}

	@Test
	public void testPopShouldRemoveScreen() {
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
