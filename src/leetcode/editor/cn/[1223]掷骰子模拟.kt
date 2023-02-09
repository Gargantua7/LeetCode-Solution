//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 111 👎 0


package leetcode.editor.cn

/**
 * 1223
 * 掷骰子模拟
 *
 * @author Gargantua丶
 * 2023-02-10 02:17:41
 */
class DiceRollSimulation {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val mod = 1_000_000_007

    fun dieSimulator(n: Int, rollMax: IntArray): Int {
        val dp = Array(n) { IntArray(6) }
        val sum = IntArray(n)
        repeat(6) { dp[0][it] = 1 }
        sum[0] = 6
        for (i in 1 until n) {
            repeat(6) {
                if (i - rollMax[it] < 0) dp[i][it] = sum[i - 1]
                else for (j in i - 1 downTo i - rollMax[it]) {
                    dp[i][it] += (sum[j] - dp[j][it] + mod) % mod
                    dp[i][it] %= mod
                }
                sum[i] += dp[i][it]
                sum[i] %= mod
            }
        }

        return sum.last()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}