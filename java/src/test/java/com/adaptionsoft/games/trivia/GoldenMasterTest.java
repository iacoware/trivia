package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GoldenMasterTest {

	public static final String GOLDEN_MASTER = "trivia-golden-master.txt";
	public static final String RUN_OUTPUT = "trivia-current-output.txt";

	@Test
	public void runGame() throws IOException {
		PrintStream prevOut = System.out;
		System.setOut(new PrintStream(RUN_OUTPUT));

		try {
			GameRunner.run(new Random(11));
		} finally {
			System.setOut(prevOut);
		}

		assertEquals(contentOf(GOLDEN_MASTER), contentOf(RUN_OUTPUT));
	}

	private List<String> contentOf(String s) throws IOException {
		return Files.readAllLines(Paths.get(s));
	}
}
