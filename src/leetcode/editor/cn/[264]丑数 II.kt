//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 700 👎 0


package leetcode.editor.cn
/**
 * 264
 * 丑数 II
 *
 * @author Gargantua丶
 * 2021-07-25 01:28:28
 */
class UglyNumberIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        val dp = ArrayList<Int>().apply {
            add(0)
            add(1)
        }
        var p2 = 1
        var p3 = 1
        var p5 = 1
        fun nthUglyNumber(n: Int): Int {
            if (n < dp.size) return dp[n]
            else for (i in dp.size..n) {
                val n2 = dp[p2] * 2
                val n3 = dp[p3] * 3
                val n5 = dp[p5] * 5
                dp.add(i, kotlin.math.min(n2, kotlin.math.min(n3, n5)))
                if (dp[i] == n2) p2++
                if (dp[i] == n3) p3++
                if (dp[i] == n5) p5++
            }
            return dp[n]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}