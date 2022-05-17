package hu.gameoflife

import javafx.animation.AnimationTimer
import javafx.application.Application
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.canvas.GraphicsContext
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage

class Game : Application() {

    private lateinit var mainScene: Scene
    private lateinit var graphicsContext: GraphicsContext

    private val board = BoardView()

    private var lastFrameTime: Long = System.nanoTime()
    private var elapsedNanosSum: Long = 0

    private var started: Boolean = false

    override fun start(mainStage: Stage) {
        mainStage.title = "Game of Life"
        mainStage.isResizable = false
        val root = BorderPane()
        mainScene = Scene(root)
        mainStage.scene = mainScene

        val allGroup = StackPane()

        val group1 = BorderPane()
        val button1 = Button("START")
        val button3 = Button("STEP")
        group1.center = button1
        group1.right = button3

        val group2 = BorderPane()
        val button2 = Button("STOP")
        group2.center = button2

        button1.onMouseClicked = EventHandler {
            group1.isVisible = false
            group2.isVisible = true
            started = true
        }
        button2.onMouseClicked = EventHandler {
            group1.isVisible = true
            group2.isVisible = false
            started = false
        }
        group2.isVisible = false

        allGroup.children.add(group1)
        allGroup.children.add(group2)

        root.center = board.canvas
        root.bottom = allGroup

        // for fps count
        graphicsContext = board.graphicsContext

        // Main loop
        object : AnimationTimer() {
            override fun handle(currentNanoTime: Long) {
                tickAndRender(currentNanoTime)
            }
        }.start()

        mainStage.show()
    }

    private fun tickAndRender(currentNanoTime: Long) {
        // the time elapsed since the last frame, in nanoseconds
        // can be used for physics calculation, etc
        val elapsedNanos = currentNanoTime - lastFrameTime
        lastFrameTime = currentNanoTime

        // draw board
        board.draw()

        if (started) {
            elapsedNanosSum += elapsedNanos
            if (elapsedNanosSum >= 50_000_000) {
                board.update()
                elapsedNanosSum = 0
            }
        }

        // display crude fps counter
        val elapsedMs = elapsedNanos / 1_000_000
        if (elapsedMs != 0L) {
            graphicsContext.fill = Color.WHITE
            graphicsContext.fillText("${1000 / elapsedMs} fps", 10.0, 10.0)
        }
    }

}
