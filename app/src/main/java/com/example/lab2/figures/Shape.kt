package com.example.lab2.figures

import android.graphics.*


abstract class Shape {

    protected val strokeWidth = 14f

    val bordersPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    protected var paint = Paint(Paint.ANTI_ALIAS_FLAG)
    init {
        bordersPaint.color = Color.BLUE
        bordersPaint.style = Paint.Style.STROKE
        bordersPaint.pathEffect = PathEffect()
        bordersPaint.strokeWidth = strokeWidth
    }

    abstract fun move(x: Float, y: Float)

    abstract fun draw(canvas: Canvas)

    abstract fun drawShadow(canvas: Canvas)
}