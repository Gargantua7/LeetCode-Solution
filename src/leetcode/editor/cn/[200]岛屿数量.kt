//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1603 👎 0

package leetcode.editor.cn

/**
 * 200
 * 岛屿数量
 * 
 * @author Gargantua丶
 * 2022-03-16 21:32:02
 */
class NumberOfIslands {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val redirection = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        grid.forEachIndexed { i, chars ->
            chars.forEachIndexed { j, c ->
                if (c == '1') {
                    count++
                    grid[i][j] = '0'
                    toZero(grid, i, j)
                }
            }
        }
        return count
    }

    fun toZero(grid: Array<CharArray>, x: Int, y: Int) {
        redirection.forEach { (u, v) ->
            if (x + u in grid.indices && y + v in grid[0].indices && grid[x + u][y + v] == '1') {
                grid[x + u][y + v] = '0'
                toZero(grid, x + u, y + v)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
