import com.soywiz.korio.async.launch
import kotlinx.coroutines.*
import me.emig.engineEmi.*

class DigitalStoppuhr : Stoppuhr() {

    val stelle1 = Ziffer(50, 50)
    val stelle2 = Ziffer(120, 50)
    val stelle3 = Ziffer(200, 50)
    val stelle4 = Ziffer(270, 50)
    val stelle5 = Ziffer(470, 140).apply { scale = 0.5 }
    val stelle6 = Ziffer(520, 140).apply { scale = 0.5 }

    init {
        addChild(stelle1)
        addChild(stelle2)
        addChild(stelle3)
        addChild(stelle4)
        addChild(stelle5)
        addChild(stelle6)
        engine.register(ZiffernController(stelle6))
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

                stelle5.nummer = (zehntel % 10).toInt()
                stelle6.nummer = (hunderdstel % 10).toInt()

                stelle4.nummer = (sekunden % 10).toInt()
                stelle3.nummer = (sekunden % 60 % 100 / 10 % 6).toInt()

                stelle2.nummer = (minuten % 10).toInt()
                stelle1.nummer = (minuten / 100 % 10).toInt()
            }
        }
    }

    override fun updateGraphics() {

    }
}