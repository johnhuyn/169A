package com.room8.flameengine.test;

import com.main.room8.flameengine.ScreenManager;
import com.main.room8.game.screens.GamePlayScreen;
import com.main.room8.game.screens.LoadingScreen;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

public class ScreenManagerTest {
	
	ScreenManager m_screenManager;

	LoadingScreen m_loadingScreen;
	GamePlayScreen m_gameplay1;
	GamePlayScreen m_gameplay2;
    GamePlayScreen m_gameplay3;

	@Before
	public void setupScreenManager()
	{
		m_screenManager = new ScreenManager();
		
		m_loadingScreen = mock(LoadingScreen.class);
		m_gameplay1 = mock(GamePlayScreen.class);
		m_gameplay2 = mock(GamePlayScreen.class);
        m_gameplay3 = mock(GamePlayScreen.class);
	}
	
	@After
	public void endSpriteBatch()
	{
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
    public void testRenderShouldRenderBottomToTop() {
        when(m_gameplay1.blockRendering()).thenReturn(true);
        when(m_gameplay2.blockRendering()).thenReturn(true);
        when(m_gameplay3.blockRendering()).thenReturn(false);
        m_screenManager.pushPreloadedScreen(m_gameplay1);
        m_screenManager.pushPreloadedScreen(m_gameplay2);
        m_screenManager.pushPreloadedScreen(m_gameplay3);
        InOrder inOrder = inOrder(m_gameplay1, m_gameplay2, m_gameplay3);
        m_screenManager.render(0);
        //verify m_gameplay2 renders first
        inOrder.verify(m_gameplay2).render(0);
        //verify m_gameplay3 renders second
        inOrder.verify(m_gameplay3).render(0);
        //verify m_gameplay1 doesn't render
        verify(m_gameplay1,never()).render(0);
    }

    @Test
    public void testUpdateShouldUpdateBottomToTop() {
        when(m_gameplay1.blockUpdates()).thenReturn(true);
        when(m_gameplay2.blockUpdates()).thenReturn(true);
        when(m_gameplay3.blockUpdates()).thenReturn(false);
        m_screenManager.pushPreloadedScreen(m_gameplay1);
        m_screenManager.pushPreloadedScreen(m_gameplay2);
        m_screenManager.pushPreloadedScreen(m_gameplay3);
        InOrder inOrder = inOrder(m_gameplay1, m_gameplay2, m_gameplay3);
        m_screenManager.update(0);
        //verify m_gameplay2 updates first
        inOrder.verify(m_gameplay2).update(0);
        //verify m_gameplay3 updates second
        inOrder.verify(m_gameplay3).update(0);
        //verify m_gameplay1 doesn't update
        verify(m_gameplay1,never()).update(0);
    }
}
