package leetcode.editor.cn.cup

import leetcode.editor.cn.TreeNode
import java.util.LinkedList
import java.util.TreeSet

/**
 * @author Gargantua7
 */
class Solution {
    fun giveGem(gem: IntArray, operations: Array<IntArray>): Int {
        operations.forEach { (f, t) ->
            val n = gem[f] / 2
            gem[f] -= n
            gem[t] += n
        }
        return gem.max()!! - gem.min()!!
    }

    fun perfectMenu(materials: IntArray, cookbooks: Array<IntArray>, attribute: Array<IntArray>, limit: Int): Int {
        val dp = Array(cookbooks.size + 1) { HashMap<Pair<Int, Int>, IntArray>() }
        dp[0][0 to 0] = materials
        for (i in cookbooks.indices) {
            val idx = i + 1
            dp[i].forEach { (d, h), l ->
                val curr = l.copyOf()
                var flag = true
                dp[idx][d to h] = l
                for (j in l.indices) {
                    if (curr[j] >= cookbooks[i][j]) {
                        curr[j] -= cookbooks[i][j]
                    } else {
                        flag = false
                        break
                    }
                }
                if (flag) {
                    if (d + attribute[i][0] to h + attribute[i][1] !in dp[idx])
                        dp[idx][d + attribute[i][0] to h + attribute[i][1]] = curr
                }
            }
        }
        var max = -1
        dp.last().forEach { (d, h), _ ->
            if (h > limit) {
                max = maxOf(max, d)
            }
        }
        return max
    }

    fun getNumber(root: TreeNode?, ops: Array<IntArray>): Int {
        val tree = TreeSet<Int>()
        val queue = LinkedList<TreeNode>()
        queue.offer(root ?: return 0)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            tree.add(node.`val`)
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        var count = 0
        for (i in ops.lastIndex downTo 0) {
            val (type, min, max) = ops[i]
            while (tree.isNotEmpty()) {
                val m = tree.ceiling(min) ?: break
                if (m > max) break
                if (type == 1) {
                    tree.remove(m)
                    count++
                } else {
                    tree.remove(m)
                }
            }
        }
        return count
    }

    fun defendSpaceCity1(time: IntArray, position: IntArray): Int {
        val window = HashMap<Int, TreeSet<Int>>()
        val t = HashMap<Int, TreeSet<Int>>()
        val times = time.toSortedSet()
        for (i in time.indices) {
            window.getOrPut(position[i], ::TreeSet).add(time[i])
            t.getOrPut(time[i], ::TreeSet).add(position[i])
        }
        val open = HashMap<Int, Int>()
        var e = 0
        while (times.isNotEmpty()) {
            val next = times.first()
            times.remove(next)
            t[next]?.forEach {
                if (it in open) e++
                else {
                    e += 2
                    open[it] = if (it - 1 in open) it - 1 else it
                }
            }
        }

        return 0
    }

//    fun defendSpaceCity(time: IntArray, position: IntArray): Int {
//        val dp = Array(500) { IntArray(500) }
//        val window = HashMap<Int, TreeSet<Int>>()
//        val t = HashMap<Int, TreeSet<Int>>()
//        for (i in dp.indices) {
//            for (j in dp[i].indices) {
//                dp[i][j] = if (j == 0) 0 else dp[i][j - 1]
//                if (i)
//            }
//        }
//
//    }

    fun getMinimumTime(time: IntArray, fruits: Array<IntArray>, limit: Int): Int {
        return fruits.fold(0) { acc, (type, n) ->
            acc + time[type] * Math.ceil(n.toDouble() / limit).toInt()
        }
    }

    fun conveyorBelt(matrix: Array<String>, start: IntArray, end: IntArray): Int {
        val map = Array(matrix.size) { IntArray(matrix[0].length) { Int.MAX_VALUE } }
        var set = hashSetOf(start[0] to start[1])
        for (i in 0..10000) {
            val next = HashSet<Pair<Int, Int>>()
            set.forEach {
                run(matrix, map, it.first, it.second, i, next)
            }
            set = next
            if (map[end[0]][end[1]] != Int.MAX_VALUE) {
                return map[end[0]][end[1]]
            }
        }
        return -1
    }

    fun run(matrix: Array<String>, map: Array<IntArray>, x: Int, y: Int, p: Int, next: HashSet<Pair<Int, Int>>) {
        println("$x $y")
        if (map[x][y] <= p) return
        next.remove(x to y)
        map[x][y] = p
        val (u, v) = when (matrix[x][y]) {
            '^' -> -1 to 0
            '>' -> 0 to 1
            'v' -> 1 to 0
            '<' -> 0 to -1
            else -> throw IllegalArgumentException()
        }
        println("$x $y -> ${x + u} ${y + v}")
        arrayOf(0 to -1,1 to 0,0 to 1,-1 to 0).forEach { (u, v) ->
            if (x + u in matrix.indices && y + v in matrix[0].indices && map[x + u][y + v] == Int.MAX_VALUE) {
                next.add(x + u to y + v)
            }
        }
        if (x + u in map.indices && y + v in map[0].indices) run(matrix, map, x + u, y + v, p, next)
    }

    fun getMaximumNumber(moles: Array<IntArray>): Int {
        moles.sortBy { it[0] }
        val m = arrayOf(intArrayOf(0, 1, 1)) + moles
        val maxArray = IntArray(m.size)
        val dp = IntArray(m.size)
        for (i in 1..m.lastIndex) {
            val (t, x, y) = m[i]
            if (kotlin.math.abs(x - 1) + kotlin.math.abs(y - 1) > t) {
                continue
            }
            var max = maxArray[maxOf(0, i - 5)]
            for (j in i - 1 downTo 0) {
                val (lt, lx, ly) = m[j]
                if (lt < t - 4) break
                if (kotlin.math.abs(x - lx) + kotlin.math.abs(y - ly) <= t - lt) {
                    max = maxOf(max, dp[j])
                }
            }
            dp[i] = max + 1
            maxArray[i] = maxOf(maxArray[i - 1], dp[i])
        }
        println(dp.contentToString())
        return dp.max()!!
    }
}
