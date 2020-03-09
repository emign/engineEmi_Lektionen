import com.soywiz.korim.color.*
import me.emig.engineEmi.*
import me.emig.engineEmi.screenElements.canvasElements.*

class AnalogStoppuhr : Stoppuhr() {
    private val sekundenZeiger: Gerade = TODO()
    private val minutenZeiger: Gerade = TODO()

    init {
        /**
         * Erzeugt ein angedeutetes Ziffernblatt
         */
        repeat(60) {
            addChild(Gerade(1000, 0, engine.view.width / 2, engine.view.height / 2, 1, Colors.DARKGRAY).apply { rotationDegrees = it.toDouble() * 6 })
        }
        addChild(Kreis(170, engine.view.width / 2, engine.view.height / 2, Colors.WHITE))
        addChild(Kreis(400, engine.view.width / 2, engine.view.height / 2, Colors.TRANSPARENT_WHITE, Colors.WHITE, 400))

        TODO()
    }

    override suspend fun onEveryFrame() {
        TODO()
    }
}