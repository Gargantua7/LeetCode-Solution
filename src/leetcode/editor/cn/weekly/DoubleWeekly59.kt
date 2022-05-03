package leetcode.editor.cn.weekly

import java.util.*
import kotlin.math.abs

/**
 * @author Gargantua丶
 **/
class DoubleWeekly59 {

    fun minTimeToType(word: String): Int {
        var temp = 'a'
        var count = 0
        word.forEach { c ->
            val length = abs(c - temp)
            count += kotlin.math.min(length, 26 - length) + 1
            temp = c
        }
        return count
    }

//    fun maxMatrixSum(matrix: Array<IntArray>): Long {
//        var sum = 0
//        val n = matrix.size
//        var tempI: Int? = null
//        var tempJ: Int? = null
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                tempI = i
//                tempJ = j
//                while (tempI != null) {
//                    if (matrix[tempI][tempJ] < 0) {
//                        var min = Int.MAX_VALUE
//                        var nextI = 0
//                        var nextJ = 0
//                        for (r in -1..1 step 2) {
//                            for (c in -1..1 step 2)
//                                if (matrix[tempI + r][tempJ + c] < min) {
//                                    min
//                                }
//                        }
//                        if (min < 0 || min < -1 * matrix[i][j]) {
//
//                        }
//                    }
//                }
//            }
//        }

    fun maxMatrixSum(matrix: Array<IntArray>): Long {
        var sum = 0L
        var min = Int.MAX_VALUE
        var count = 0
        matrix.forEach { row -> row.forEach { num ->
            sum += abs(num).toLong()
            if (num < 0) count++
            min = min.coerceAtMost(abs(num))
        } }
        if (count % 2 != 0) {
            sum -= 2 * abs(min)
        }
        return sum
    }

//    fun countPaths(n: Int, roads: Array<IntArray>): Int {
//        val min = IntArray(n) { Int.MAX_VALUE }
//        min[0] = 0
//        roads.sortWith ( Comparator<IntArray> { a: IntArray, b: IntArray ->
//            a[0] - b[0]
//        })
//        roads.forEach { (s, e, t) ->
//            if (min[s] != Int.MAX_VALUE) {
//                min[e] = kotlin.math.min(min[e], min[s] + t)
//            }
//        }
//        roads.sortWith ( Comparator<IntArray> { a: IntArray, b: IntArray ->
//            b[0] - a[0]
//        })
//        roads.forEach { (e, s, t) ->
//            if (min[s] != Int.MAX_VALUE) {
//                min[e] = kotlin.math.min(min[e], min[s] + t)
//            }
//        }
//
//    }

    fun countPaths(n: Int, roads: Array<IntArray>): Int {
        val node = Array(n) { Node(it) }
        val queue: Queue<Int> = LinkedList()
        queue.offer(0)
        node[0].time = 0
        while (queue.isNotEmpty()) {
            val temp = queue.poll()
            roads.forEach { (s, e, t) ->
                if (s == temp) {
                    val endTime = node[e].time
                    val tempTime = node[temp].time
                    if (endTime == tempTime + t) node[e].roads++
                    else if (endTime > tempTime + t) {
                        node[e].time = tempTime + t
                        node[e].roads = 1
                        queue.offer(e)
                    }
                    node[e].roads %= 1000000007
                }
                if (e == temp) {
                    val endTime = node[s].time
                    val tempTime = node[temp].time
                    if (endTime == tempTime + t) node[s].roads++
                    else if (endTime > tempTime + t) {
                        node[s].time = tempTime + t
                        node[s].roads = 1
                        queue.offer(s)
                    }
                    node[e].roads %= 1000000007
                }
            }
        }
        return node[n - 1].roads
    }

    class Node(val id: Int, var time: Int = Int.MAX_VALUE, var roads: Int = 1, var isGo: Boolean = false)
}