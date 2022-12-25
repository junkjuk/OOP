package com.example.lab2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.figures.FigureType

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainCanvas: MainCanvas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        initMainCanvas()
        initSpinner()
        initListeners()
    }

    private fun initMainCanvas() {
        mainCanvas = MainCanvas(this)
        mainCanvas.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        binding.boardLayout.addView(mainCanvas)
    }

    private fun initSpinner() {
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, index: Int, id: Long) {
                val selectedFigureType = when(index) {
                    FigureType.POINT.index -> FigureType.POINT
                    FigureType.LINE.index -> FigureType.LineOO
                    FigureType.RECTANGLE.index -> FigureType.RECTANGLE
                    FigureType.ELLIPSE.index -> FigureType.ELLIPSE
                    else -> FigureType.POINT
                }
                highlightSelectedFigure(selectedFigureType)
                mainCanvas.setDrawingFigure(selectedFigureType)
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    private fun highlightSelectedFigure(figureType: FigureType) {
        binding.pointBtn.setBackgroundColor(
            if (figureType == FigureType.POINT) getColor(R.color.selected)
            else Color.TRANSPARENT)

        binding.lineBtn.setBackgroundColor(
            if (figureType == FigureType.LINE) getColor(R.color.selected)
            else Color.TRANSPARENT)

        binding.lineBtn.setBackgroundColor(
            if (figureType == FigureType.LineOO) getColor(R.color.selected)
            else Color.TRANSPARENT)

        binding.rectBtn.setBackgroundColor(
            if (figureType == FigureType.RECTANGLE) getColor(R.color.selected)
            else Color.TRANSPARENT)

        binding.ellipseBtn.setBackgroundColor(
            if (figureType == FigureType.ELLIPSE) getColor(R.color.selected)
            else Color.TRANSPARENT)
    }

    private fun initListeners() {
        binding.pointBtn.setOnClickListener {
            binding.spinner.setSelection(0)
            highlightSelectedFigure(FigureType.POINT)
            mainCanvas.setDrawingFigure(FigureType.POINT)
        }
        binding.lineBtn.setOnClickListener {
            binding.spinner.setSelection(1)
            highlightSelectedFigure(FigureType.LineOO)
            mainCanvas.setDrawingFigure(FigureType.LineOO)
        }
        binding.rectBtn.setOnClickListener {
            binding.spinner.setSelection(2)
            highlightSelectedFigure(FigureType.RECTANGLE)
            mainCanvas.setDrawingFigure(FigureType.RECTANGLE)
        }
        binding.ellipseBtn.setOnClickListener {
            binding.spinner.setSelection(3)
            highlightSelectedFigure(FigureType.ELLIPSE)
            mainCanvas.setDrawingFigure(FigureType.ELLIPSE)
        }
    }
}