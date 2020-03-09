import com.soywiz.korev.*
import kotlinx.coroutines.*
import me.emig.engineEmi.*

class ZiffernController(vararg val ziffer: Ziffer) : Controller {
    override fun reactToKeyEvent(event: KeyEvent) {
        CoroutineScope(Dispatchers.Default).launch {
            reactAsync(event)
        }
    }

    suspend fun reactAsync(event: KeyEvent) {
        if (event.type == KeyEvent.Type.DOWN) {
            when (event.key) {
                Key.N1 -> ziffer.forEach { it.nummer = 1 }
                Key.N2 -> ziffer.forEach { it.nummer = 2 }
                Key.N3 -> ziffer.forEach { it.nummer = 3 }
                Key.N4 -> ziffer.forEach { it.nummer = 4 }
                Key.N5 -> ziffer.forEach { it.nummer = 5 }
                Key.N6 -> ziffer.forEach { it.nummer = 6 }
                Key.N7 -> ziffer.forEach { it.nummer = 7 }
                Key.N8 -> ziffer.forEach { it.nummer = 8 }
                Key.N9 -> ziffer.forEach { it.nummer = 9 }
                Key.N0 -> ziffer.forEach { it.nummer = 0 }
            }
        }
    }
}