package hu.gameoflife

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.event.Event
import javafx.event.EventHandler
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Slider
import javafx.scene.layout.BorderPane
import javafx.stage.Stage

class Game : Application() {

    private lateinit var mainScene: Scene

    private val board = BoardView()

    private var lastFrameTime: Long = System.nanoTime()
    private var elapsedNanosSum: Long = 0

    private var started = false
    private var updatesPerSecond = 10.0

    override fun start(mainStage: Stage) {
        mainStage.title = "Game of Life"
        mainStage.isResizable = false
        val root = createLayout()
        mainScene = Scene(root)
        mainStage.scene = mainScene

        // Main loop
        object : AnimationTimer() {
            override fun handle(currentNanoTime: Long) {
                tickAndRender(currentNanoTime)
            }
        }.start()

        mainStage.show()
    }

    private fun createLayout(): Parent {
        val root = BorderPane()
        root.center = board.canvas
        root.bottom = createControls().layout
        return root
    }

    private fun createControls(): Controls {
        val startEventHandler: EventHandler<Event> = EventHandler {
            started = true
        }
        val stopEventHandler: EventHandler<Event> = EventHandler {
            started = false
        }
        val stepEventHandler: EventHandler<Event> = EventHandler {
            board.update()
        }
        val resetEventHandler: EventHandler<Event> = EventHandler {
            started = false
            board.reset()
        }
        val sliderEventHandler: EventHandler<Event> = EventHandler { event ->
            val slider = event.source as Slider
            updatesPerSecond = slider.value
        }
        return Controls(startEventHandler, stopEventHandler, stepEventHandler, resetEventHandler, sliderEventHandler)
    }

    private fun tickAndRender(currentNanoTime: Long) {
        val elapsedNanos = currentNanoTime - lastFrameTime
        lastFrameTime = currentNanoTime

        board.draw()

        if (started) {
            elapsedNanosSum += elapsedNanos
            val timeUntilUpdate =  1_000_000_000 / updatesPerSecond
            if (elapsedNanosSum >= timeUntilUpdate) {
                board.update()
                elapsedNanosSum = 0
            }
        }
    }
}
