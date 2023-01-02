package com.example.lab2.figures

import android.graphics.Canvas

//class LineOO(startX: Float, startY: Float) : Line(startX, startY) {
//
//    private var StartEllipse: Ellipse? = null
//    private var EndEllipse: Ellipse? = null
//
//
//    init {
//        StartEllipse =  Ellipse(startX, startY);
//    }
//
//    override fun drawShadow(canvas: Canvas) {
//        initOO(canvas)
//        canvas.drawLine(startX, startY, endX, endY, bordersPaint)
//    }
//
//    override fun draw(canvas: Canvas) {
//        canvas.drawLine(startX, startY, endX, endY, paint)
//        StartEllipse?.draw(canvas)
//        EndEllipse?.draw(canvas)
//    }
//
//    private fun initOO(canvas: Canvas){
//        StartEllipse = Ellipse(startX, startY)
//        StartEllipse?.move(startX + 50, startY + 50)
//        StartEllipse?.drawShadow(canvas)
//
//        EndEllipse = Ellipse(endX, endY)
//        EndEllipse?.move(endX + 50, endY + 50)
//        EndEllipse?.drawShadow(canvas)
//    }
//
//    override fun setCords(startx: Float, starty: Float, endx: Float, endy: Float) {
//        startX = startx
//        startY = starty
//        endX = endx
//        endY = endy
//    }
//
//    override fun buildCsvStr() : String{
//        return "LineOO, $startX, $startY, $endX, $endY\n"
//    }
//}