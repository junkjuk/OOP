package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Point(private var x: Float, private var y: Float) : Shape() {

    companion object {
        private const val radius = 16f
    }

    init {
        paint.color = Color.BLACK
    }

    override fun move(x: Float, y: Float) {}

    override fun draw(canvas: Canvas) {
        canvas.drawCircle(x, y, radius, paint)
    }

    override fun drawShadow(canvas: Canvas) {}

    override fun setCords(startx: Float, starty: Float, endx: Float, endy: Float) {
        x = startx
        y = starty
    }
    override fun buildCsvStr() : String{
        return "Point, $x, $y\n"
    }
}