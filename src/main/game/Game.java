package main.game;

import main.game.util.NumberGenerator;
import main.game.util.UserInputReceiver;

import java.util.Arrays;

public class Game {
    private final int LENGTH_OF_NUMBER = 3;

    public void start() {
        int[] computerNumbers = generateNumbers();
        System.out.println(Arrays.toString(computerNumbers));

        System.out.println("연속된 3개의 숫자를 입력하세요. ex) 123");
        int[] userNumbers = receiveUserNumbers();
        System.out.println(Arrays.toString(userNumbers));
    }

    private int[] receiveUserNumbers() {
        UserInputReceiver receiver = new UserInputReceiver();
        return receiver.receiveNumbersFromUser();
    }

    private int[] generateNumbers() {
        NumberGenerator generator = new NumberGenerator();
        return generator.generateNumbers(LENGTH_OF_NUMBER);
    }
}