//给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 
//
// 示例 1: 
//
// 输入: 5
//输出: 5
//解释: 
//下面是带有相应二进制表示的非负整数<= 5：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。 
//
// 说明: 1 <= n <= 10⁹ 
// Related Topics 动态规划 👍 111 👎 0


package leetcode.editor.cn

import kotlin.math.log2

/**
 * 600
 * 不含连续1的非负整数
 *
 * @author Gargantua丶
 * 2021-09-11 00:11:02
 */
class NonNegativeIntegersWithoutConsecutiveOnes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        val dp = IntArray(31)

        init {
            dp[0] = 1
            dp[1] = 1
            for (i in 2..30) dp[i] = dp[i - 1] + dp[i - 2]
        }

        fun findIntegers(n: Int): Int {
            var flag = false
            var ans = 0
            var curr = n
            for (i in 29 downTo 0) {
                val f = 1 shl i
                flag = if (f and curr != 0) {
                    curr -= f
                    ans += dp[i + 1]
                    if (flag) break
                    true
                } else false

                if (i == 0) ans++
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}