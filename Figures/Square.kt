package Figures

class Square(var x: Int, var y: Int, var _width: Int) : Figure(0), Movable, Transforming {
    var width = _width

    constructor(square: Square) : this(square.x, square.y, square.width)

    override fun area(): Float {
        return (width * width).toFloat()
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        width *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        val (signX, signY) = if (direction == RotateDirection.CounterClockwise) Pair(-1, 1) else Pair(1, -1)

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }
    }

    override fun toString(): String {
        return "Square {x: $x, y: $y, width: $width}"
    }
}