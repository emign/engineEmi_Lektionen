package UebungArraySortieren

import me.emig.engineEmi.screenElements.canvasElements.*

object BubbleSortSchlau : Sortieralgorithmus() {
    override suspend fun sortieren(array: Array<Rechteck>) {
        // Blauer Zeigefinger

        var i = 0
        do {
            var getauscht = false
            for (j in 0 until array.indices.last - i) {
                ArrayController.countVergleich()
                if (array[j].hoehe.toInt() > array[j + 1].hoehe.toInt()) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                    getauscht = true
                }

                ArrayController.positionenAktualisieren()
            }
            i++
        } while (getauscht)
    }
}