package com.room8.game;

import junit.framework.TestCase;
import main.com.room8.game.Room8Game;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Room8GameTest extends TestCase {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testReturnTrue() throws Exception {
        assertTrue(true);
    }

    @Test
    public void nullIsNull() throws Exception {
        assertNull(null);
    }

    @Test
    public void testMockito() throws Exception {
        Room8Game thing = mock(Room8Game.class);
        when(thing.returnTrue()).thenReturn(false);
        assertFalse(thing.returnTrue());
    }
}