package hu.gameoflife

import hu.gameoflife.State.Alive
import hu.gameoflife.State.Dead

enum class State {
    Alive,
    Dead
}

class Cell(var x: Int, var y: Int, var state: State = Dead) {
    var nextState: State = state

    fun switchState() {
        state = when (state) {
            Alive -> Dead
            Dead -> Alive
        }
    }

    fun calculateNextState(aliveNeighbours: Int) {
        nextState = when (state) {
            Alive -> if (aliveNeighbours !in 2..3) Dead else Alive
            Dead -> if (aliveNeighbours == 3) Alive else Dead
        }
    }

    fun update() {
        state = nextState
    }
}
