import com.soywiz.klock.*
import com.soywiz.korio.async.launch
import kotlinx.coroutines.*
import me.emig.engineEmi.*
import me.emig.engineEmi.screenElements.canvasElements.*

abstract class Stoppuhr : CanvasElement() {

    /**
     * Ist true während einer Messung
     */
    var misst = false

    /**
     * Ist true während einer Pause
     */
    var pause = false

    /**
     * Gibt die Werte der Zeiteinheiten an, die seit dem Beginn der Messung
     * verstrichen sind
     */
    var hunderdstel = (zeitDifferenz.milliseconds / 10)
    var zehntel = (zeitDifferenz.milliseconds / 100)
    var sekunden = zeitDifferenz.seconds
    var minuten = zeitDifferenz.minutes

    /**
     * Zeitstempel in Millisekunden
     * Wird bei jedem Aufruf aktualisiert
     */
    private val jetzt: Double
        get() {
            return DateTime.now().unixMillis
        }

    /**
     * ZeitDifferenz in Millisekunden
     */
    val zeitDifferenz: TimeSpan
        get() {
            return if (startZeit != 0.0) TimeSpan(jetzt - startZeit) else TimeSpan(0.0)
        }

    /**
     * Startpunkt der Messung
     */
    private var startZeit = 0.0

    /**
     * Startet die Messung
     */
    fun start() {
        start(jetzt)
    }

    /**
     * Startet Die Messung zu einem Zeitpunkt
     * @param zeit Double
     */
    fun start(zeit: Double) {
        misst = true
        pause = false
        startZeit = zeit
        refreshTimeLoop()
    }

    /**
     * Stoppt die Messung
     */
    fun stop() {
        startZeit = zeitDifferenz.milliseconds.toDouble()
        pause = !pause
    }

    /**
     * Aktualisiert die gemessenen Zeiteinheiten im Hintergrund
     */
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






