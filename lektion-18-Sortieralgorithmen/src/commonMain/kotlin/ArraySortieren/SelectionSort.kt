package ArraySortieren

import UebungArraySortieren.*
import me.emig.engineEmi.screenElements.canvasElements.*

object SelectionSort : Sortieralgorithmus() {
    override suspend fun sortieren(array: Array<Rechteck>) {
        // Blauer Zeigefinger
        for (i in array.indices) {
            var min = array[i].hoehe.toInt()
            var minPos = i
            var j = i + 1
            // orangener Zeigefinger
            while (j < array.size) {
                ArrayController.countVergleich()
                if (array[j].hoehe.toInt() < min) {
                    // Neues Minimum gefunden
                    min = array[j].hoehe.toInt()
                    minPos = j
                }
                j++
            }
            val tmp = array[i]
            array[i] = array[minPos]
            array[minPos] = tmp
            ArrayController.positionenAktualisieren()
        }
    }
}