import com.soywiz.korge.*
import me.emig.engineEmi.*
import me.emig.engineEmi.screenElements.canvasElements.*

suspend fun main() {


    engine.run {
        init {
            view.width = 950
            view.height = 420
        }

        viewWillLoad {

            //val stoppuhr = DigitalStoppuhr()
            //register(StoppuhrController(stoppuhr))


            val stoppuhr = TextStoppuhr()
            register(stoppuhr)

            val stoppKnopf = TextButton(x = 50, y = 200, breite = 50, text = "Stop") {
                stoppuhr.stop()
            }



            register(TextButton(50, 100, 50, 32, "Start") {
                stoppuhr.start()
            })

            register(stoppKnopf)

        }




        viewDidLoad {
        }

        start()
    }
}

