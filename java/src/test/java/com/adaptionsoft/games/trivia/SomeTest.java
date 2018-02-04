package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class SomeTest {
	@Test
	public void runGame() throws IOException {
		System.setOut(new PrintStream("trivia-current-output.txt"));
		GameRunner.run(new Random(11));

		List<String> goldenMaster = Files.readAllLines(Paths.get("trivia-golden-master.txt"));
		List<String> currentOutput = Files.readAllLines(Paths.get("trivia-current-output.txt"));

		assertEquals(goldenMaster, currentOutput);
	}
}
