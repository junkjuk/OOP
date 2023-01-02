package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.lang.Math.abs

class Ellipse(private val centerX: Float, private val centerY: Float): Shape() {

    private var endX = centerX
    private var endY = centerY
    private var startX = centerX
    private var startY = centerY

    private var fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        fillPaint.style = Paint.Style.FILL
        fillPaint.color = Color.GREEN
        fillPaint.strokeWidth = strokeWidth

        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = strokeWidth
    }

    override fun move(x: Float, y: Float) {
        val offsetX = kotlin.math.abs(centerX - x)
        val offsetY = kotlin.math.abs(centerY - y)
        startX = centerX - offsetX
        startY = centerY - offsetY
        endX = centerX + offsetX
        endY = centerY + offsetY
    }

    override fun draw(canvas: Canvas) {
        canvas.drawOval(startX, startY, endX, endY, fillPaint)
        canvas.drawOval(startX, startY, endX, endY, paint)
    }

    override fun drawShadow(canvas: Canvas) {
        canvas.drawOval(startX, startY, endX, endY, bordersPaint)
    }

    override fun setCords(startx: Float, starty: Float, endx: Float, endy: Float) {
        startX = startx
        startY = starty
        endX = endx
        endY = endy
    }

    override fun buildCsvStr() : String{
        return "Ellipse, $startX, $startY, $endX, $endY\n"
    }

}