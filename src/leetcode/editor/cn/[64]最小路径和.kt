//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 945 👎 0


package leetcode.editor.cn

/**
 * 64
 * 最小路径和
 *
 * @author Gargantua丶
 * 2021-07-30 00:20:30
 */
class MinimumPathSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun minPathSum(grid: Array<IntArray>): Int {
            val dp = IntArray(grid[0].size)
            dp[0] = grid[0][0]
            for (i in 1..dp.lastIndex) {
                dp[i] = grid[0][i] + dp[i - 1]
            }
            for (i in 1..grid.lastIndex) {
                dp[0] += grid[i][0]
                for (j in 1..dp.lastIndex) {
                    dp[j] = grid[i][j] + kotlin.math.min(dp[j], dp[j - 1])
                }
            }
            return dp.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}