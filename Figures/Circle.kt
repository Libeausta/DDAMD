package Figures

class Circle(var _radius: Int, var x: Int, var y: Int) : Figure(0), Movable, Transforming  {
    var radius = _radius
    init { if (_radius == 0) throw Exception() }

    override fun area(): Float {
        return  kotlin.math.PI.toFloat() * (radius * radius).toFloat();
    }

    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
    }

    override fun resize(zoom: Int) {
        radius *= zoom
    }

    override fun rotate(direction: RotateDirection, centerX: Int, centerY: Int) {
        if (centerX == x && centerY == y) return
        val (signX, signY) = if (direction == RotateDirection.CounterClockwise) { Pair(-1, 1) } else { Pair(1, -1) }

        x = (signX * (y - centerY) + centerX).also {
            y = signY * (x - centerX) + centerY
        }
    }

    override fun toString(): String {
        return "Circle { x: $x, y: $y, radius: $radius }"
    }
}