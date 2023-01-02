package com.example.lab2

//import com.example.lab2.figures.*
//
//class CsvParser {
//    fun figures(csvStr: String): MutableList<Shape> {
//        var figures = mutableListOf<Shape>()
//        for (line in csvStr.split("\n")) {
//            figures.add(getFigureFromLine(line))
//        }
//        return figures
//    }
//
//    fun getCsvStr(figures: MutableList<Shape>): String {
//        var csvStr = ""
//        for (shape in figures) {
//            csvStr += shape.buildCsvStr()
//        }
//        return csvStr
//    }
//
//    private fun getFigureFromLine(line: String): Shape {
//        val elements = line.split(",")
//        val type = FigureType.valueOf(elements[0])
//        val currentFigure: Shape
//
//        val startX = elements[1].toFloat()
//        val startY = elements[2].toFloat()
//        val endX = if (elements.getOrNull(3) != null) elements[3].toFloat() else 0f
//        val endY = if (elements.getOrNull(4) != null) elements[4].toFloat() else 0f
//
//        when (type) {
//            FigureType.POINT -> {
//                currentFigure = Point(startX, startY)
//            }
//            FigureType.LINE -> {
//                currentFigure = Line(startX, startY)
//            }
//            FigureType.LineOO -> {
//                currentFigure = LineOO(startX, startY)
//            }
//            FigureType.RECTANGLE -> {
//                currentFigure = Rectangle(startX, startY)
//            }
//            FigureType.CUBE -> {
//                currentFigure = Cube(startX, startY)
//            }
//            FigureType.ELLIPSE -> {
//                currentFigure = Ellipse(startX, startY)
//            }
//        }
//        currentFigure.setCords(startX, startY, endX, endY)
//        return currentFigure
//    }
//}