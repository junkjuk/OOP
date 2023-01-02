package com.example.lab2.figures

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class Cube(startX: Float, startY: Float): Rectangle(startX, startY){
    private var behaindRectangle: Rectangle? = null
    private var line1: Line? = null
    private var line2: Line? = null
    private var line3: Line? = null
    private var line4: Line? = null

    init {
        behaindRectangle = Rectangle(startX + 50, startY - 50)
        line1 = Line(startX, startY)
        line1?.move(startX + 50, startY - 50)
        line2 = Line(startX, startY)
        line3 = Line(startX, startY)
        line4 = Line(startX, startY)
    }

    override fun move(x: Float, y: Float) {
        endX = x
        endY = y
        behaindRectangle?.move(endX + 50, endY - 50)
        line2?.move(endX, startY, endX + 50, startY - 50)
        line3?.move(startX, endY, startX + 50, endY - 50)
        line4?.move(endX, endY, endX + 50, endY - 50)
    }

    override fun drawShadow(canvas: Canvas) {
        canvas.drawRect(startX, startY, endX, endY, bordersPaint)
        behaindRectangle?.drawShadow(canvas)

        line1?.drawShadow(canvas)
        line2?.drawShadow(canvas)
        line3?.drawShadow(canvas)
        line4?.drawShadow(canvas)
    }

    override fun draw(canvas: Canvas) {
        behaindRectangle?.draw(canvas)
        line1?.draw(canvas)
        line2?.draw(canvas)
        line3?.draw(canvas)
        line4?.draw(canvas)
        canvas.drawRect(startX, startY, endX, endY, paint)
    }

    override fun setCords(startx: Float, starty: Float, endx: Float, endy: Float) {
        startX = startx
        startY = starty
        endX = endx
        endY = endy
    }

    override fun buildCsvStr() : String{
        return "Cube, $startX, $startY, $endX, $endY\n"
    }
}