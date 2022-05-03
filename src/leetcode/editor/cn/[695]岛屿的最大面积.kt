//给你一个大小为 m x n 的二进制矩阵 grid 。 
//
// 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都
//被 0（代表水）包围着。 
//
// 岛屿的面积是岛上值为 1 的单元格的数目。 
//
// 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,
//0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,
//0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出：6
//解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0,0,0,0,0,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 723 👎 0

package leetcode.editor.cn

/**
 * 695
 * 岛屿的最大面积
 * 
 * @author Gargantua丶
 * 2022-03-17 02:02:09
 */
class MaxAreaOfIsland {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val redirection = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        grid.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c == 1) {
                    grid[i][j] = 0
                    max = maxOf(max, toZero(grid, i, j))
                }
            }
        }
        return max
    }

    fun toZero(grid: Array<IntArray>, x: Int, y: Int): Int {
        var sum = 1
        redirection.forEach { (u, v) ->
            if (x + u in grid.indices && y + v in grid[0].indices && grid[x + u][y + v] == 1) {
                grid[x + u][y + v] = 0
                sum += toZero(grid, x + u, y + v)
            }
        }
        return sum
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
