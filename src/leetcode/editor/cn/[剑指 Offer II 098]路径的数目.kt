//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：m = 3, n = 7
//输出：28 
//
// 示例 2： 
//
// 
//输入：m = 3, n = 2
//输出：3
//解释：
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向下
// 
//
// 示例 3： 
//
// 
//输入：m = 7, n = 3
//输出：28
// 
//
// 示例 4： 
//
// 
//输入：m = 3, n = 3
//输出：6 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10⁹ 
// 
//
// 
//
// 注意：本题与主站 62 题相同： https://leetcode-cn.com/problems/unique-paths/ 
// Related Topics 数学 动态规划 组合数学 👍 3 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 098
 * 路径的数目
 *
 * @author Gargantua丶
 * 2021-10-30 13:37:52
 */
class TwoAoeFn {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun uniquePaths(m: Int, n: Int): Int {
            val dp = Array(m) { IntArray(n) }
            for (i in dp.indices) dp[i][0] = 1
            for (j in dp[0].indices) dp[0][j] = 1
            for (i in 1..dp.lastIndex) {
                for (j in 1..dp[0].lastIndex) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
                }
            }
            return dp.last().last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}