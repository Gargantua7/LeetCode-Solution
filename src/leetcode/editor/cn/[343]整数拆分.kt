//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 566 👎 0


package leetcode.editor.cn
/**
 * 343
 * 整数拆分
 *
 * @author Gargantua丶
 * 2021-08-04 03:41:59
 */
class IntegerBreak { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun integerBreak(n: Int): Int {
        if(n < 4) return n - 1
        val dp = IntArray(n + 1) { it }
        for (i in 2..n) {
            for (j in 1 until i) {
                dp[i] = kotlin.math.max(dp[i], dp[j] * dp[i - j])
            }
        }
        return dp[n]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}