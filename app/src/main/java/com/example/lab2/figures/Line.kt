package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Line(private val startX: Float, private val startY: Float) : Shape() {

    private var endX = startX
    private var endY = startY

    init {
        paint.color = Color.BLACK
        paint.strokeWidth = strokeWidth
    }

    override fun move(x: Float, y: Float) {
        endX = x
        endY = y
    }

    override fun draw(canvas: Canvas) {
        canvas.drawLine(startX, startY, endX, endY, paint)
    }

    override fun drawShadow(canvas: Canvas) {
        canvas.drawLine(startX, startY, endX, endY, bordersPaint)
    }
}