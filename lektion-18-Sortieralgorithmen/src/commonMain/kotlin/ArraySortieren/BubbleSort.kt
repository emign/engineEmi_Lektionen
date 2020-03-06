package UebungArraySortieren

import me.emig.engineEmi.screenElements.canvasElements.*

object BubbleSort : Sortieralgorithmus() {
    override suspend fun sortieren(array: Array<Rechteck>) {
        // Blauer Zeigefinger
        for (i in array.indices) {
            for (j in 0 until array.indices.last) {
                ArrayController.countVergleich()
                if (array[j].hoehe.toInt() > array[j + 1].hoehe.toInt()) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
                ArrayController.positionenAktualisieren()
            }

        }
    }
}