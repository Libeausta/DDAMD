package Figures

class Rect(var x: Int, var y: Int, val _width: Int, val _height: Int) : Figure(0), Movable, Transforming {
    var width = _width
    init { if (_width < 0) throw Exception() }
    var height = _height
    init { if (_height < 0) throw Exception() }

//    var color: Int = -1
    lateinit var name: String
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    override fun area(): Float {
        return (width*height).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        val (signX, signY) = if (direction == RotateDirection.CounterClockwise) { Pair(-1, 1) } else { Pair(1, -1) }

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }

        width = height.also { height = width }
    }

    override fun toString(): String {
        return "Rectangle {x: $x, y: $y, width: $width, height: $height}"
    }
}