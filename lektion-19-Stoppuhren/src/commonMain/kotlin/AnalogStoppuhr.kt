import com.soywiz.korim.color.*
import com.soywiz.korio.async.launch
import kotlinx.coroutines.*
import me.emig.engineEmi.*
import me.emig.engineEmi.screenElements.canvasElements.*

class AnalogStoppuhr : Stoppuhr() {


    val sekundenZeiger = Gerade(0, -engine.view.height / 2.1, engine.view.width / 2, engine.view.height / 2, 2, Colors.RED)
    val minutenZeiger = Gerade(0, -engine.view.height / 2.1, engine.view.width / 2, engine.view.height / 2, 2, Colors.BLUE)


    init {
        repeat(60) {
            addChild(Gerade(1000, 0, engine.view.width / 2, engine.view.height / 2, 1, Colors.DARKGRAY).apply { rotationDegrees = it.toDouble() * 6 })
        }
        addChild(Kreis(170, engine.view.width / 2, engine.view.height / 2, Colors.WHITE))
        addChild(Kreis(400, engine.view.width / 2, engine.view.height / 2, Colors.TRANSPARENT_WHITE, Colors.WHITE, 400))

        addChild(sekundenZeiger)
        addChild(minutenZeiger)
    }

    override fun start() {
        super.start()
        CoroutineScope(Dispatchers.Default).launch {
            while (true) {
                delay(10)
                val hunderdstel = (zeitDifferenz.milliseconds / 10)
                val zehntel = (zeitDifferenz.milliseconds / 100)
                val sekunden = zeitDifferenz.seconds
                val minuten = zeitDifferenz.minutes


                // sekundenZeiger.rotateBy(Angle.fromDegrees(sekunden%60), 5.milliseconds)
                sekundenZeiger.rotationDegrees = (sekunden % 60) * 6

                minutenZeiger.rotationDegrees = (minuten.toInt() * 6.0)

            }
        }
    }

    override fun updateGraphics() {

    }
}