package hu.gameoflife

import hu.gameoflife.State.Alive
import hu.gameoflife.State.Dead
import javafx.event.EventHandler
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.paint.Color
import kotlin.math.floor
import kotlin.math.roundToInt

class BoardView {

    companion object {
        private const val CELL_WIDTH: Double = 10.0
        private const val CELL_HEIGHT: Double = 10.0
        private const val WIDTH: Double = Board.CELL_COUNT_X * CELL_WIDTH
        private const val HEIGHT: Double = Board.CELL_COUNT_Y * CELL_HEIGHT
    }

    private val board = Board()

    val canvas = Canvas(WIDTH, HEIGHT)
    private val graphicsContext: GraphicsContext = canvas.graphicsContext2D

    init {
        prepareActionHandlers()
    }

    private fun prepareActionHandlers() {
        canvas.onMouseClicked = EventHandler { event ->
            val x = floor(event.x / CELL_WIDTH).roundToInt()
            val y = floor(event.y / CELL_HEIGHT).roundToInt()
            board.switchState(x, y)
        }
    }

    private fun clear() {
        graphicsContext.clearRect(0.0, 0.0, WIDTH, HEIGHT)
    }

    fun reset() {
        board.reset()
    }

    fun draw() {
        clear()
        for (cellRow in board.cells) {
            for (cell in cellRow) {
                graphicsContext.fill = when (cell.state) {
                    Alive -> {
                        Color.YELLOW
                    }
                    Dead -> {
                        Color.GRAY
                    }
                }
                val x = cell.x * CELL_WIDTH
                val y = cell.y * CELL_HEIGHT
                graphicsContext.fillRect(x, y, CELL_WIDTH, CELL_HEIGHT)
            }
        }
        for (i in 0 .. Board.CELL_COUNT_X) {
            val x = i * CELL_WIDTH
            graphicsContext.strokeLine(x, 0.0, x, HEIGHT)
        }
        for (i in 0 .. Board.CELL_COUNT_Y) {
            val y = i * CELL_HEIGHT
            graphicsContext.strokeLine(0.0, y, WIDTH, y)
        }
    }

    fun update() {
        board.update()
    }
}