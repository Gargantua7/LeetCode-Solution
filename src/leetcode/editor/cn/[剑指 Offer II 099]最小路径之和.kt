//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：一个机器人每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
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
//
// 
//
// 注意：本题与主站 64 题相同： https://leetcode-cn.com/problems/minimum-path-sum/ 
// Related Topics 数组 动态规划 矩阵 👍 4 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 099
 * 最小路径之和
 *
 * @author Gargantua丶
 * 2021-10-30 13:40:34
 */
class ZeroI0mDW {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minPathSum(grid: Array<IntArray>): Int {
            for (i in 1..grid.lastIndex) grid[i][0] += grid[i - 1][0]
            for (j in 1..grid[0].lastIndex) grid[0][j] += grid[0][j - 1]
            for (i in 1..grid.lastIndex) {
                for (j in 1..grid[0].lastIndex) {
                    grid[i][j] += minOf(grid[i - 1][j], grid[i][j - 1])
                }
            }
            return grid.last().last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}