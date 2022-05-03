package leetcode.editor.cn.weekly

import kotlin.math.abs

/**
 * @author Gargantua丶
 *
 * [第 259 场周赛](https://leetcode-cn.com/contest/weekly-contest-259/)
 **/
class Weekly259 {

    fun finalValueAfterOperations(operations: Array<String>): Int {
        return operations.fold(0) { ans, s ->
            ans + if (s[1] == '+') 1 else -1
        }
    }

    fun sumOfBeauties(nums: IntArray): Int {
        val ans = IntArray(nums.size)
        var temp = nums[0]
        for (i in 1 until nums.lastIndex) {
            if (temp < nums[i]) {
                ans[i] += 1
                temp = nums[i]
            }
        }
        temp = nums.last()
        for (i in nums.lastIndex downTo 1) {
            if (temp > nums[i]) {
                ans[i] += 1
                temp = nums[i]
            }
        }
        for (i in 1 until nums.lastIndex) {
            if (ans[i] != 2) {
                ans[i] = if (nums[i - 1] < nums[i] && nums[i + 1] > nums[i]) 1 else 0
            }
        }
        println(ans.contentToString())
        return ans.sum()
    }

    class DetectSquares {

        val map = HashMap<Pair<Int, Int>, Int>()

        fun add(point: IntArray) {
            val (x, y) = point
            map[x to y] = (map[x to y] ?: 0) + 1
        }

        fun count(point: IntArray): Int {
            val (x, y) = point
            var ans = 0
            map.forEach { (o, v), n ->
                if (o != x && v != y && abs(x - o) == abs(y - v)) {
                    ans += (map[x to v]?: 0) * (map[o to y]?: 0) * n
                }
            }
            return ans
        }
    }
}