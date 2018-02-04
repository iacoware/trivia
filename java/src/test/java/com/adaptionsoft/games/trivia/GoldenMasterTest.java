package com.adaptionsoft.games.trivia;

import static org.junit.Assert.*;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.junit.Ignore;
import org.junit.Test;

import java.io.FileNotFoundException;
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
	@Ignore
	public void updateGoldenMaster() throws IOException {
		runMultipleTimesUsing(GOLDEN_MASTER);
	}

	@Test
	public void runGame() throws IOException {
		runMultipleTimesUsing(RUN_OUTPUT);

		assertEquals(contentOf(GOLDEN_MASTER), contentOf(RUN_OUTPUT));
	}

	private void runMultipleTimesUsing(String outputFile) throws FileNotFoundException {
		PrintStream prevOut = System.out;
		System.setOut(new PrintStream(outputFile));

		try {
			for (int i = 0; i < 1000; i++) {
				GameRunner.run(new Random(11 * i));
			}
		} finally {
			System.setOut(prevOut);
		}
	}

	private List<String> contentOf(String s) throws IOException {
		return Files.readAllLines(Paths.get(s));
	}
}
