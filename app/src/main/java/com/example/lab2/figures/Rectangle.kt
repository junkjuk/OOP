package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.math.abs

open class Rectangle(protected var startX: Float, protected var startY: Float): Shape() {

    protected var endX = startX
    protected var endY = startY

    init {
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = strokeWidth
    }

    override fun move(x: Float, y: Float) {
        endX = x
        endY = y
    }

    override fun draw(canvas: Canvas) {
        canvas.drawRect(startX, startY, endX, endY, paint)
    }

    override fun drawShadow(canvas: Canvas) {
        canvas.drawRect(startX, startY, endX, endY, bordersPaint)
    }

    override fun setCords(startx: Float, starty: Float, endx: Float, endy: Float) {
        startX = startx
        startY = starty
        endX = endx
        endY = endy
    }

    override fun buildCsvStr() : String{
        return "Rectangle, $startX, $startY, $endX, $endY\n"
    }
}