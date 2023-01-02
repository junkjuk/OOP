package com.example.lab2.figures

import android.graphics.*


abstract class Shape {

    protected val strokeWidth = 14f

    val bordersPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        bordersPaint.color = Color.RED
        bordersPaint.style = Paint.Style.STROKE
        bordersPaint.pathEffect = DashPathEffect(floatArrayOf(30f, 20f), 0F)
        bordersPaint.strokeWidth = strokeWidth
    }

    abstract fun move(x: Float, y: Float)

    abstract fun draw(canvas: Canvas)

    abstract fun drawShadow(canvas: Canvas)

    abstract fun setCords(startx: Float, starty: Float, endx: Float, endy: Float)

    abstract fun buildCsvStr() : String
}