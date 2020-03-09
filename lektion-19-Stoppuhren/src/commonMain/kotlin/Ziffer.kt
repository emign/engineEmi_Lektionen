import com.soywiz.korim.color.*
import me.emig.engineEmi.screenElements.canvasElements.*

class Ziffer(x: Number, y: Number) : CanvasElement(x = x.toDouble(), y = y.toDouble()) {
    // Segmente

    var nummer = 0
        set(value) {
            field = value
            this.updateGraphics()
        }

    private val offsetX = x.toInt()
    private val offsetY = y.toInt()
    private val sH = 10 // Segmenthöhe
    private val sB = 100 // Segmentbreite

    private val a = Segment(offsetX + sH + 0, offsetY + 0, sH, sB)
    private val b = Segment(offsetX + sH + sB, offsetY + sH, sB, sH)
    private val c = Segment(offsetX + sH + sB, offsetY + sH + sB + sH, sB, sH)
    private val d = Segment(offsetX + sH + 0, offsetY + sH + sB + sH + sB, sH, sB)
    private val e = Segment(offsetX + 0, offsetY + sH + sB + sH, sB, sH)
    private val f = Segment(offsetX + 0, offsetY + sH, sB, sH)
    private val g = Segment(offsetX + sH, offsetY + sH + sB, sH, sB)

    private val aBck = Segment(offsetX + sH + 0, offsetY + 0, sH, sB, RGBA(240, 240, 240))
    private val bBck = Segment(offsetX + sH + sB, offsetY + sH, sB, sH, RGBA(240, 240, 240))
    private val cBck = Segment(offsetX + sH + sB, offsetY + sH + sB + sH, sB, sH, RGBA(240, 240, 240))
    private val dBck = Segment(offsetX + sH + 0, offsetY + sH + sB + sH + sB, sH, sB, RGBA(240, 240, 240))
    private val eBck = Segment(offsetX + 0, offsetY + sH + sB + sH, sB, sH, RGBA(240, 240, 240))
    private val fBck = Segment(offsetX + 0, offsetY + sH, sB, sH, RGBA(240, 240, 240))
    private val gBck = Segment(offsetX + sH, offsetY + sH + sB, sH, sB, RGBA(240, 240, 240))

    init {

        addChild(aBck)
        addChild(bBck)
        addChild(cBck)
        addChild(dBck)
        addChild(eBck)
        addChild(fBck)
        addChild(gBck)

        addChild(a)
        addChild(b)
        addChild(c)
        addChild(d)
        addChild(e)
        addChild(f)
        addChild(g)

    }

    override fun updateGraphics() {
        when (nummer) {
            0 -> {
                a.an(); b.an(); c.an(); d.an(); e.an(); f.an(); g.aus()
            }
            1 -> {
                a.aus(); b.an(); c.an(); d.aus(); e.aus(); f.aus(); g.aus()
            }
            2 -> {
                a.an(); b.an(); c.aus(); d.an(); e.an(); f.aus(); g.an()
            }
            3 -> {
                a.an(); b.an(); c.an(); d.an(); e.aus(); f.aus(); g.an()
            }
            4 -> {
                a.aus(); b.an(); c.an(); d.aus(); e.aus(); f.an(); g.an()
            }
            5 -> {
                a.an(); b.aus(); c.an(); d.an(); e.aus(); f.an(); g.an()
            }
            6 -> {
                a.an(); b.aus(); c.an(); d.an(); e.an(); f.an(); g.an()
            }
            7 -> {
                a.an(); b.an(); c.an(); d.aus(); e.aus(); f.aus(); g.aus()
            }
            8 -> {
                a.an(); b.an(); c.an(); d.an(); e.an(); f.an(); g.an()
            }
            9 -> {
                a.an(); b.an(); c.an(); d.an(); e.aus(); f.an(); g.an()
            }
        }
    }

}

