import me.emig.engineEmi.*

class DigitalStoppuhr : Stoppuhr() {
    private val stelle1: Ziffer = TODO()
    private val stelle2: Ziffer = TODO()
    private val stelle3: Ziffer = TODO()
    private val stelle4: Ziffer = TODO()
    private val stelle5: Ziffer = TODO()
    private val stelle6: Ziffer = TODO()

    init {
        TODO()
        engine.register(ZiffernController(stelle6))
    }

    override suspend fun onEveryFrame() {
        TODO()
    }

}