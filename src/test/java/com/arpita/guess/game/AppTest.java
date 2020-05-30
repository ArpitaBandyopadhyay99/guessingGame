package com.arpita.guess.game;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Unit test for Guessing Game.
 */
public class AppTest 
{
    @Test
    public void testFileIsPresent() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("StateCapitalListr");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertNotNull("File not found ",fileReader);
    }
}
