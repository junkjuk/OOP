package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

open class Line(protected val startX: Float, protected val startY: Float) : Shape() {

    protected var endX = startX
    protected var endY = startY

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