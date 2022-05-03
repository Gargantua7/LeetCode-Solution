//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1747 👎 0


package leetcode.editor.cn
/**
 * 70
 * 爬楼梯
 *
 * @author Gargantua丶
 * 2021-07-16 00:16:02
 */
class ClimbingStairs { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun climbStairs(n: Int): Int {
        return when(n) {
            0, 1 -> 1
            else -> {
                val init = arrayOf(intArrayOf(1, 1))
                val map = arrayOf(intArrayOf(1, 1), intArrayOf(1, 0))
                (init * (map pow n - 1)).first().first()
            }
        }
    }

    operator fun Array<IntArray>.times(other: Array<IntArray>): Array<IntArray> {
        val res = Array(size) { IntArray(this[0].size) }
        for (i in res.indices) {
            for (j in res[0].indices) {
                for (k in res[0].indices) {
                    res[i][j] += this[i][k] * other[k][j]
                }
            }
        }
        return res
    }

    infix fun Array<IntArray>.pow(index: Int): Array<IntArray> {
        var res = Array(size) { IntArray(this[0].size) }
        var curr = this.copyOf()
        var idx = index
        for (i in res.indices) res[i][i] = 1
        while (idx > 0) {
            if (idx and 1 == 1)
                res *= curr
            curr *= curr
            idx = idx shr 1
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    fun climbStairs(n: Int): Int {
        if(n == 1) return 1
        var a = 1
        var b = 2
        (3..n).forEach { _ ->
            val count = b
            b += a
            a = count
        }
        return b
    }

}
