import com.soywiz.korev.*
import me.emig.engineEmi.*

class StoppuhrController(val stoppuhr: Stoppuhr) : Controller {
    override fun reactToKeyEvent(event: KeyEvent) {
        if (event.type == KeyEvent.Type.DOWN && event.key == Key.SPACE) {

        }
    }
}