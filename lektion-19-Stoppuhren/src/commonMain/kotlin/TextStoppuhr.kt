import me.emig.engineEmi.screenElements.canvasElements.*

class TextStoppuhr : Stoppuhr() {
    val hundertstelText = Text(500, 100, "00", 100.0)
    val sekundenText = Text(300, 100, "00", 100.0)
    val minutenText = Text(100, 100, "00", 100.0)


    init {
        addChild(hundertstelText)
        addChild(sekundenText)
        addChild(minutenText)
    }

    override suspend fun onEveryFrame() {

        hundertstelText.text = (hunderdstel % 100).toInt().toString()
        sekundenText.text = (sekunden % 60).toInt().toString()
        minutenText.text = (minuten % 100).toInt().toString()

    }


}