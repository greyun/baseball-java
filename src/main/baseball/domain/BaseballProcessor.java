package main.baseball.domain;

import main.baseball.domain.result.*;

import java.util.Objects;

public class BaseballProcessor {

    public BaseballResult getProcessResult(int[] a, int[] b) {
        Strike strike = getStrike(a, b);
        Ball ball = getBall(a, b);

        if (Objects.nonNull(strike) && Objects.nonNull(ball)) return new StrikeWithBall(strike, ball);
        if (Objects.nonNull(strike)) return strike;
        if (Objects.nonNull(ball)) return ball;

        return new Nothing();
    }

    private Ball getBall(int[] a, int[] b) {
        int ballCount = getBallCount(a, b);
        if (ballCount > 0) return new Ball(ballCount);
        return null;
    }

    private int getBallCount(int[] a, int[] b) {
        int ballCount = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++) {
                if (i == j) continue;
                if (a[i] == b[j]) ballCount++;
            }
        return ballCount;
    }

    private Strike getStrike(int[] a, int[] b) {
        int strikeCount = getStrikeCount(a, b);
        if (strikeCount > 0) return new Strike(strikeCount);
        return null;
    }

    private int getStrikeCount(int[] a, int[] b) {
        int strikeCount = 0;
        for (int i = 0; i < a.length; i++)
            if (a[i] == b[i]) strikeCount++;
        return strikeCount;
    }
}