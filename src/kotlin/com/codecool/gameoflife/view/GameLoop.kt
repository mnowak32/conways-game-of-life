package com.codecool.gameoflife.view

import javafx.animation.AnimationTimer

class GameLoop(delayInMs: Int, private val action: Runnable) : AnimationTimer() {

    private var previousTime = System.nanoTime()
    private var delay = delayToNano(delayInMs)

    fun setDelay(delayInMs: Int) {
        this.delay = delayToNano(delayInMs)
    }

    private fun delayToNano(delayInMs: Int) = (delayInMs * 1000000).toLong()

    override fun handle(now: Long) {
        if (now - previousTime > delay) {
            action.run()
            previousTime = now
        }
    }
}
