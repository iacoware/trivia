package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class SomeTest {

	@Test
	public void runGame() throws FileNotFoundException {
		System.setOut(new PrintStream("trivia-output-2.txt"));
		GameRunner.main(null);
	}
}
