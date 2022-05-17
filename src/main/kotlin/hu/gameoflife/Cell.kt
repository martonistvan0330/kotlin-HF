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

    fun update() {
        state = nextState
    }
}
