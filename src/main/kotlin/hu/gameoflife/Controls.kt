package hu.gameoflife

import javafx.event.Event
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.layout.BorderPane
import javafx.scene.layout.FlowPane
import javafx.scene.layout.StackPane

class Controls(
    private var startEventHandler: EventHandler<Event>,
    private var stopEventHandler: EventHandler<Event>,
    private var stepEventHandler: EventHandler<Event>,
    private var resetEventHandler: EventHandler<Event>,
    private var sliderEventHandler: EventHandler<Event>,
) {
    val layout = BorderPane()

    private var leftStopped: FlowPane = createLeftStoppedLayout()
    private var leftStarted: FlowPane = createLeftStartedLayout()

    init {
        layout.padding = Insets(10.0)
        layout.left = createLeftLayout()
        layout.center = createResetButton()
        layout.right = createRightLayout()
    }

    private fun createLeftLayout(): StackPane {
        val left = StackPane()
        left.children.add(leftStopped)
        left.children.add(leftStarted)
        return left
    }

    private fun createLeftStoppedLayout(): FlowPane {
        val leftStopped = FlowPane()
        leftStopped.hgap = 10.0
        leftStopped.children.add(createStartButton())
        leftStopped.children.add(createStepButton())
        return leftStopped
    }

    private fun createLeftStartedLayout(): FlowPane {
        val leftStarted = FlowPane()
        leftStopped.hgap = 10.0
        leftStarted.children.add(createStopButton())
        leftStarted.isVisible = false
        return leftStarted
    }

    private fun createStartButton(): Button {
        val startButton = Button("START")
        startButton.onMouseClicked = EventHandler {
            switchToStarted()
            startEventHandler.handle(it)
        }
        return startButton
    }

    private fun createStopButton(): Button {
        val stopButton = Button("STOP")
        stopButton.onMouseClicked = EventHandler {
            switchToStopped()
            stopEventHandler.handle(it)
        }
        return stopButton
    }

    private fun createStepButton(): Button {
        val stepButton = Button("STEP")
        stepButton.onMouseClicked = EventHandler {
            stepEventHandler.handle(it)
        }
        return stepButton
    }

    private fun createResetButton(): Button {
        val resetButton = Button("RESET")
        resetButton.onMouseClicked = EventHandler {
            switchToStopped()
            resetEventHandler.handle(it)
        }
        return resetButton
    }

    private fun createRightLayout(): FlowPane {
        val right = FlowPane()
        right.alignment = Pos.CENTER_RIGHT
        right.hgap = 10.0
        right.children.add(Label("Update rate:"))
        right.children.add(createSlider())
        return right
    }

    private fun createSlider(): Slider {
        val slider = Slider()
        slider.min = 0.2
        slider.max = 50.0
        slider.value = 10.0
        slider.onMouseDragged = EventHandler {
            sliderEventHandler.handle(it)
        }
        return slider
    }

    private fun switchToStarted() {
        leftStopped.isVisible = false
        leftStarted.isVisible = true
    }

    private fun switchToStopped() {
        leftStopped.isVisible = true
        leftStarted.isVisible = false
    }
}