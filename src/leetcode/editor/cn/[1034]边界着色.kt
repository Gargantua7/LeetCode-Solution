//给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色
//。 
//
// 当两个网格块的颜色相同，而且在四个方向中任意一个方向上相邻时，它们属于同一 连通分量 。 
//
// 连通分量的边界 是指连通分量中的所有与不在分量中的网格块相邻（四个方向上）的所有网格块，或者在网格的边界上（第一行/列或最后一行/列）的所有网格块。 
//
// 请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
//输出：[[3,3],[3,2]] 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
//输出：[[1,3,3],[2,3,3]] 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
//输出：[[2,2,2],[2,1,2],[2,2,2]] 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// 1 <= grid[i][j], color <= 1000 
// 0 <= row < m 
// 0 <= col < n 
// 
//
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 90 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 1034
 * 边界着色
 *
 * @author Gargantua丶
 * 2021-12-07 13:24:28
 */
class ColoringABorder {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        val direction = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

        fun colorBorder(grid: Array<IntArray>, row: Int, col: Int, color: Int): Array<IntArray> {
            val search = Array(grid.size) { BooleanArray(grid[0].size) }
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            val temp = grid[row][col]
            queue.offer(row to col)
            search[row][col] = true
            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                direction.forEach { (u, v) ->
                    if (x + u !in grid.indices || y + v !in grid[0].indices) grid[x][y] = color
                    else if (!search[x + u][y + v]) {
                        if (grid[x + u][y + v] == temp) queue.offer(x + u to y + v)
                        else grid[x][y] = color
                    }
                }
                search[x][y] = true
            }
            return grid
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}