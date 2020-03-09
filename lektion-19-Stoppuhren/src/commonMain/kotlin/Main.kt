import me.emig.engineEmi.*

suspend fun main() {


    engine.run {
        init {
            view.width = 950
            view.height = 420
        }

        viewWillLoad {
            val stoppuhr: Stoppuhr = TextStoppuhr()
            register(stoppuhr)
            stoppuhr.start()
        }




        viewDidLoad {
        }

        start()
    }
}

