package com.adaptionsoft.games.trivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.stream.IntStream;

import org.approvaltests.Approvals;
import org.junit.Test;
import com.adaptionsoft.games.trivia.runner.GameRunner;

public class GameTest {

	@Test
	public void itsLockedDown()  {
	    ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultStream));

        Random random = new Random(123455);
        IntStream.range(1,15).forEach(i -> GameRunner.playGame(random));

        Approvals.verify(resultStream.toString());
	}
}
