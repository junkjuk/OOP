package com.example.lab2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.MotionEvent
import android.view.SurfaceView
import com.example.lab2.figures.*

class MainCanvas(context: Context) : SurfaceView(context) {

    private var selectedFigureType = FigureType.POINT
    private var selectedFigure: Shape? = null
    fun setDrawingFigure(figure: FigureType) {
        selectedFigureType = figure
    }

    private val figures = mutableListOf<Shape>()
    private fun drawPreviousFigures(canvas: Canvas) {
        canvas.drawColor(Color.WHITE)
        for(figure in figures) { figure.draw(canvas) }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        val canvas = holder.lockCanvas()
        drawPreviousFigures(canvas)
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                onActionDown(canvas, event)
            }
            MotionEvent.ACTION_MOVE -> {
                onActionMove(canvas, event)
            }
            MotionEvent.ACTION_UP -> {
                onActionUp(canvas)
            }
        }
        holder.unlockCanvasAndPost(canvas)
        return true
    }

    private fun onActionDown(canvas: Canvas, event: MotionEvent) {
        when (selectedFigureType) {
            FigureType.POINT -> {
                selectedFigure = Point(event.x, event.y)
                selectedFigure?.draw(canvas)
            }
            FigureType.LINE -> {
                selectedFigure = Line(event.x, event.y)
                selectedFigure?.draw(canvas)
            }
            FigureType.RECTANGLE -> {
                selectedFigure = Rectangle(event.x, event.y)
                selectedFigure?.draw(canvas)
            }
            FigureType.ELLIPSE -> {
                selectedFigure = Ellipse(event.x, event.y)
                selectedFigure?.draw(canvas)
            }
        }
    }

    private fun onActionMove(canvas: Canvas, event: MotionEvent) {
        selectedFigure?.move(event.x, event.y)
        selectedFigure?.drawShadow(canvas)
    }

    private fun onActionUp(canvas: Canvas) {
        selectedFigure?.let {
            it.draw(canvas)
            figures.add(it)
        }
        selectedFigure = null
    }
}