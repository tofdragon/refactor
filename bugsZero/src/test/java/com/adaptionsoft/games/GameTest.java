package com.adaptionsoft.games;

import org.approvaltests.Approvals;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.stream.IntStream;

public class GameTest {

    @Test
    public void itsLockedDown() {
        Random random = new Random(123455);
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultStream));

        IntStream.range(1, 15).forEach(i -> GameRunner.playGame(random));

        Approvals.verify(resultStream.toString());
    }
}
