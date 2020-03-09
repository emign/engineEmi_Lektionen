import me.emig.engineEmi.*

suspend fun main() {


    engine.run {
        init {
            view.width = 950
            view.height = 420
        }

        viewWillLoad {
            val stoppuhr: Stoppuhr = DigitalStoppuhr()
            register(stoppuhr)
            stoppuhr.start()


            /* val stoppKnopf = TextButton(x = 50, y = 200, breite = 50, text = "Stop") {
                 stoppuhr.stop()
             }

             register(TextButton(50, 100, 50, 32, "Start") {
                 stoppuhr.start()
             })

             register(stoppKnopf)


             */
        }




        viewDidLoad {
        }

        start()
    }
}

