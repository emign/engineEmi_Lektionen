import com.soywiz.klock.*
import me.emig.engineEmi.screenElements.canvasElements.*

abstract class Stoppuhr : CanvasElement() {

    // Zeitstempel in Millisekunden
    // Wird bei jedem Aufruf aktualisiert
    val jetzt: Double
        get() {
            return DateTime.now().unixMillis
        }

    // ZeitDifferenz in Millisekunden
    val zeitDifferenz: TimeSpan
        get() {
            return TimeSpan(jetzt - startZeit)
        }

    // Startpunkt der Messung
    var startZeit = 0.0

    open fun start() {
        startZeit = jetzt
    }

}

