package com.example.lab2

import android.graphics.Color
import com.example.lab2.figures.Shape

object MyEditor {
    val figures = mutableListOf<Shape>()
    private var selectedIndex: Int = -1
        set(value) {
            field = value
            figures.forEachIndexed { i, shape ->
                run {
                    if(value == i)
                        shape.paint.color = Color.CYAN
                    else
                        shape.paint.color = Color.BLACK
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