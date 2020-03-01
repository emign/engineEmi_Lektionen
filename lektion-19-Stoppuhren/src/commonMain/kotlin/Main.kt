import me.emig.engineEmi.*

suspend fun main() {


    engine.run {
        init {
            view.width = 950
            view.height = 420
        }

        viewWillLoad {
            /*
            val stoppuhr = DigitalStoppuhr()
            register(StoppuhrController(stoppuhr))
            register(stoppuhr)
            stoppuhr.start()

             */

            val stoppuhr = AnalogStoppuhr()
            register(stoppuhr)
            stoppuhr.start()


        }


        viewDidLoad {
        }

        start()
    }
}

