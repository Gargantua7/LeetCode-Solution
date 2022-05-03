package leetcode.editor.cn.weekly

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/**
 * @author Gargantua丶
 **/
class DoubleWeekly63 {

    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var ans = 0
        for (i in seats.indices) {
            ans += kotlin.math.abs(seats[i] - students[i])
        }
        return ans
    }

    fun winnerOfGame(colors: String): Boolean {
        var alice = 0
        var bob = 0
        for (i in 1 until colors.lastIndex) {
            if (colors[i - 1] == colors[i] && colors[i] == colors[i + 1]) {
                if (colors[i] == 'A') alice++ else bob++
            }
        }
        return alice > bob
    }

    fun networkBecomesIdle(edges: Array<IntArray>, patience: IntArray): Int {
        val choose = Array(patience.size) { HashSet<Int>() }
        edges.forEach { (s, e) ->
            choose[s].add(e)
            choose[e].add(s)
        }
        val road = IntArray(patience.size)
        road[0] = 0
        val mo = BooleanArray(patience.size)
        mo[0] = true
        val queue: Queue<Int> = LinkedList()
        queue.offer(0)
        while (queue.isNotEmpty()) {
            val n = queue.poll()
            choose[n].forEach { e ->
                if (!mo[e]) {
                    road[e] = road[n] + 1
                    mo[e] = true
                    queue.offer(e)
                }
            }
        }
        val max = road.maxOrNull()!! * 2
        var wait = 0
        for (i in 1..road.lastIndex) {
            val w = road[i] * 2 / patience[i]
            val t = max - patience[i] * if (road[i] * 2 % patience[i] > 0) w else w - 1
            wait = wait.coerceAtLeast(road[i] * 2 - t)
        }
        return max + wait + 1
    }

    fun networkBecomesIdle1(edges: Array<IntArray>, patience: IntArray): Int {
        val road = IntArray(patience.size) { Int.MAX_VALUE }
        road[0] = 0
        val need = ArrayList<Int>()
        edges.forEach { (s, e) ->
            if (s == 0 && road[e] > 1) {
                road[e] = 1
                need.add(e)
            }
            if (e == 0 && road[s] > 1) {
                road[s] = 1
                need.add(s)
            }
        }
        need.forEach { e ->
            dfs(edges, e, road)
        }
        val max = road.maxOrNull()!! * 2
        var wait = 0
        for (i in 1..road.lastIndex) {
            val w = road[i] * 2 / patience[i]
            val t = max - patience[i] * if (road[i] * 2 % patience[i] > 0) w else w - 1
            wait = wait.coerceAtLeast(road[i] * 2 - t)
        }
        return max + wait + 1
    }

    fun dfs(edges: Array<IntArray>, curr: Int, length: IntArray) {
        val need = ArrayList<Int>()
        edges.forEach { (s, e) ->
            if (s == curr && length[e] > length[s] + 1) {
                length[e] = length[s] + 1
                need.add(e)
            }
            if (e == curr && length[s] > length[e] + 1) {
                length[s] = length[e] + 1
                need.add(s)
            }
        }
        need.forEach { e ->
            dfs(edges, e, length)
        }
    }

}