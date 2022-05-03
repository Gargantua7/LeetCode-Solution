//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 广度优先搜索 数组 动态规划 
// 👍 1398 👎 0


package leetcode.editor.cn
/**
 * 322
 * 零钱兑换
 *
 * @author Gargantua丶
 * 2021-08-03 01:16:49
 */
class CoinChange { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { if (it == 0) 0 else amount + 1}
        for (i in 1..dp.lastIndex) {
            for (coin in coins) {
                if (i - coin >= 0) {
                    dp[i] = kotlin.math.min(dp[i], dp[i - coin] + 1)
                }
            }
        }
        return if(dp.last() == amount + 1) -1 else dp.last()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}