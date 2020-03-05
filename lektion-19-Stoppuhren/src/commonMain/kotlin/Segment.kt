import com.soywiz.korim.color.*
import me.emig.engineEmi.screenElements.canvasElements.*

class Segment(x: Number, y: Number, hoehe: Number, breite: Number, farbe: RGBA = Colors.RED) : Rechteck(x = x.toInt(), y = y.toInt(), breite = breite.toInt(), hoehe = hoehe.toInt(), fuellFarbe = farbe) {



    init {
        //fillColor = Colors.RED
    }

    fun an() {
        alpha = 1.0
    }

    fun aus() {
        alpha = 0.0
    }


}

