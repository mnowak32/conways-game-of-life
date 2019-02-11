package com.codecool.gameoflife.view;

import javafx.animation.AnimationTimer;

public class GameLoop extends AnimationTimer {

    private long previousTime = System.nanoTime();
    private long delayInMs;
    private FrameAction action;

    GameLoop(int delayInMs, FrameAction action) {
        this.delayInMs = delayInMs * 1_000_000; // to nano seconds
        this.action = action;
    }

    public void setDelay(int delayInMs) {
        this.delayInMs = delayInMs * 1_000_000;
    }

    @Override
    public void handle(long now) {
        if (now - previousTime < delayInMs) {
            return;
        }
        action.run();
        previousTime = now;
    }
}
