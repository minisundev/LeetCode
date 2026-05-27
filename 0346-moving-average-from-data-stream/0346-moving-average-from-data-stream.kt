class MovingAverage(private val size: Int) {

    private var sum = 0.0
    private val q = ArrayDeque<Int>()

    fun next(value: Int): Double {
        if (q.size == size) {
            val first = q.removeFirst()
            sum -= first
        }

        q.addLast(value)
        sum += value

        return sum / q.size
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * var obj = MovingAverage(size)
 * var param_1 = obj.next(`val`)
 */