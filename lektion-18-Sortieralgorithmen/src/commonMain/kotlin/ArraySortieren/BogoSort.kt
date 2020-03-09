package ArraySortieren

import UebungArraySortieren.*
import me.emig.engineEmi.screenElements.canvasElements.*

object BogoSort : Sortieralgorithmus() {
    override suspend fun sortieren(array: Array<Rechteck>) {
        while (!isSorted(array)) {

            array.shuffle()
            ArrayController.positionenAktualisieren()
            ArrayController.countVergleich()
        }
    }


    fun isSorted(array: Array<Rechteck>): Boolean {
        for (i in 0 until array.size - 1) {
            if (array[i].hoehe.toInt() > array[i + 1].hoehe.toInt()) return false
        }
        return true
    }


}

fun <T> Array<T>.shuffle(): Array<T> {


    for (index in this.indices) {
        val left = this.indices.random()
        val right = this.indices.random()

        val temp = this[right]
        this[right] = this[left]
        this[left] = temp
    }

    return this
}

