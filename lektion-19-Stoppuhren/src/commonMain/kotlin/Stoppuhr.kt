import com.soywiz.klock.*
import com.soywiz.korio.async.launch
import kotlinx.coroutines.*
import me.emig.engineEmi.*
import me.emig.engineEmi.screenElements.canvasElements.*

abstract class Stoppuhr : CanvasElement() {

    var misst = false
    var pause = false

    var hunderdstel = (zeitDifferenz.milliseconds / 10)
    var zehntel = (zeitDifferenz.milliseconds / 100)
    var sekunden = zeitDifferenz.seconds
    var minuten = zeitDifferenz.minutes

    // Zeitstempel in Millisekunden
    // Wird bei jedem Aufruf aktualisiert
    private val jetzt: Double
        get() {
            return DateTime.now().unixMillis
        }


    // ZeitDifferenz in Millisekunden
    val zeitDifferenz: TimeSpan
        get() {
            return if (startZeit != 0.0) TimeSpan(jetzt - startZeit) else TimeSpan(0.0)
        }

    // Startpunkt der Messung
    private var startZeit = 0.0

    fun start() {
        start(jetzt)
    }

    fun start(zeit: Double) {
        misst = true
        pause = false
        startZeit = zeit
        refreshTimeLoop()
    }

    fun stop() {
        startZeit = zeitDifferenz.milliseconds.toDouble()
        pause = !pause
    }

    private fun refreshTimeLoop() {
        engine.sceneContainer?.stage?.launch {
            while (true) {
                delay(10)
                if (misst && !pause) {
                    hunderdstel = (zeitDifferenz.milliseconds / 10)
                    zehntel = (zeitDifferenz.milliseconds / 100)
                    sekunden = zeitDifferenz.seconds
                    minuten = zeitDifferenz.minutes
                }
            }
        }
    }
}






