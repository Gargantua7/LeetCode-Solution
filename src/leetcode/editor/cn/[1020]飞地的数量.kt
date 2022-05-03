//给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。 
//
// 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。 
//
// 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
//输出：3
//解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
//输出：0
//解释：所有 1 都在边界上或可以到达边界。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 的值为 0 或 1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 67 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 1020
 * 飞地的数量
 * 
 * @author Gargantua丶
 * 2022-02-12 00:34:50
 */
class NumberOfEnclaves {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {
        val found = Array(grid.size) { BooleanArray(grid[0].size) }
        val stack = LinkedList<Pair<Int, Int>>()
        val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        for (i in 1 until grid[0].lastIndex) {
            if (grid[0][i] == 1) {
                stack.push(0 to i)
                found[0][i] = true
            }
            if (grid.last()[i] == 1) {
                stack.push(grid.lastIndex to i)
                found.last()[i] = true
            }
        }
        for (i in grid.indices) {
            if (grid[i][0] == 1) {
                stack.push(i to 0)
                found[i][0] = true
            }
            if (grid[i].last() == 1) {
                stack.push(i to grid[i].lastIndex)
                found[i][grid[i].lastIndex] = true
            }
        }
        while (stack.isNotEmpty()) {
            val (x, y) = stack.pop()
            direction.forEach { (u, v) ->
                if (x + u in grid.indices && y + v in grid[0].indices && grid[x + u][y + v] == 1 && !found[x + u][y + v]) {
                    stack.push(x + u to y + v)
                    found[x + u][y + v] = true
                }
            }
        }
        var res = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1 && !found[i][j]) res++
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
