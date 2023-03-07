//在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直
//到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？ 
//
// 
//
// 示例 1: 
//
// 输入: 
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 12
//解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物 
//
// 
//
// 提示： 
//
// 
// 0 < grid.length <= 200 
// 0 < grid[0].length <= 200 
// 
// Related Topics 数组 动态规划 矩阵 👍 176 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 47
 * 礼物的最大价值
 *
 * @author Gargantua丶
 * 2021-09-06 13:14:56
 */
class LiWuDeZuiDaJieZhiLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxValue(grid: Array<IntArray>): Int {
        val dp = IntArray(grid[0].size)
        dp[0] = grid[0][0]
        for (i in 1..grid[0].lastIndex) dp[i] = dp[i - 1] + grid[0][i]
        for (i in 1..grid.lastIndex) {
            dp[0] += grid[i][0]
            for (j in 1..grid[0].lastIndex) {
                dp[j] = maxOf(dp[j], dp[j - 1]) + grid[i][j]
            }
        }
        return dp.last()
    }
}
//leetcode submit region end(Prohibit modification and deletion)
fun maxValue(grid: Array<IntArray>): Int {
    val dp = Array(grid.size) { IntArray(grid[0].size) }
    dp[0][0] = grid[0][0]
    for (i in 1..grid.lastIndex) dp[i][0] = grid[i][0] + dp[i - 1][0]
    for (j in 1..grid[0].lastIndex) dp[0][j] = grid[0][j] + dp[0][j - 1]
    for (i in 1..grid.lastIndex) {
        for (j in 1..grid[0].lastIndex) {
            dp[i][j] = kotlin.math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
        }
    }
    return dp.last().last()
}
}