package com.example.lab2

import com.example.lab2.figures.Shape

object MyEditor {
    val figures = mutableListOf<Shape>()
    private var selectedIndex: Int = -1
        set(value) {
            field = value
            figures.forEachIndexed { i, shape ->
                run {
                    shape.isSelected = value == i
                }
            }
        }

    fun removeFigure(index: Int) {
        figures.removeAt(index)
        recalcSelectingFigure(index)
    }

    private fun recalcSelectingFigure(index: Int) {
        if (index < selectedIndex)
            selectedIndex--
        else if (index == selectedIndex)
            selectedIndex = -1
    }
}