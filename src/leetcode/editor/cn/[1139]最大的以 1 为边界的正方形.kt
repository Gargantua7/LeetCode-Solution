//给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0
//。 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
//输出：9
// 
//
// 示例 2： 
//
// 输入：grid = [[1,1,0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length <= 100 
// 1 <= grid[0].length <= 100 
// grid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 109 👎 0


package leetcode.editor.cn

/**
 * 1139
 * 最大的以 1 为边界的正方形
 *
 * @author Gargantua丶
 * 2023-02-17 00:54:13
 */
class Largest1BorderedSquare {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val left = Array(m + 1) { IntArray(n + 1) }
        val up = Array(m + 1) { IntArray(n + 1) }
        var maxBorder = 0
        for (i in 1..m) {
            for (j in 1..n) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1
                    up[i][j] = up[i - 1][j] + 1
                    var border = minOf(left[i][j], up[i][j])
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                        border--
                    }
                    maxBorder = maxOf(maxBorder, border)
                }
            }
        }
        return maxBorder * maxBorder
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}