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
	
	AssetManager m_assetManager;
	SpriteBatch m_spriteBatch;
	ScreenManager m_screenManager;
	LoadingScreen m_loadingScreen;
	GamePlayScreen[] m_gameplayScreen;

	@Before
	public void setupScreenManager()
	{
		m_screenManager = new ScreenManager();
		m_loadingScreen = mock(LoadingScreen.class);
		when(m_loadingScreen.render
		
		m_gameplayScreen = new GamePlayScreen[10];
		for(GamePlayScreen screen : m_gameplayScreen) {
			screen = new GamePlayScreen();
			screen.assetManager = m_assetManager;
			screen.spriteBatch = m_spriteBatch;
			screen.load();
		}
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
	
	@After
	public void endSpriteBatch()
	{
		m_spriteBatch.end();
	}
	
	@Test
	public void screenManagerRendersLoadingScreen() {
		m_screenManager.pushPreloadedScreen(m_loadingScreen);
		m_screenManager.render(10);
		assertTrue(m_spriteBatch.maxSpritesInBatch > 0);
	}
	
	@Test
	public void screenManagerRendersEmpty() {
		m_screenManager.render(10);
		assertTrue(m_spriteBatch.maxSpritesInBatch == 0);
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testPushPreloadedScreen() {
		fail("Not yet implemented");
	}

}
