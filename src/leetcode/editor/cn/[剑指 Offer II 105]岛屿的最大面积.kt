//给定一个由 0 和 1 组成的非空二维数组 grid ，用来表示海洋岛屿地图。 
//
// 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 
//0（代表水）包围着。 
//
// 找到给定的二维数组中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1
//,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0
//,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
//输出: 6
//解释: 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。 
//
// 示例 2: 
//
// 
//输入: grid = [[0,0,0,0,0,0,0,0]]
//输出: 0 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 50 
// grid[i][j] is either 0 or 1 
// 
//
// 
//
// 注意：本题与主站 695 题相同： https://leetcode-cn.com/problems/max-area-of-island/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 10 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 105
 * 岛屿的最大面积
 *
 * @author Gargantua丶
 * 2021-11-02 14:02:23
 */
class ZL6zAn {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private val road = arrayOf(arrayOf(0, -1), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(1, 0))

        fun maxAreaOfIsland(grid: Array<IntArray>): Int {
            var max = 0
            val though = Array(grid.size) { BooleanArray(grid[0].size) }
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == 1) max = max.coerceAtLeast(dfs(grid, though, i, j))
                }
            }
            return max
        }

        fun dfs(grid: Array<IntArray>, though: Array<BooleanArray>, x: Int, y: Int): Int {
            if (though[x][y]) return 0
            var sum = 1
            though[x][y] = true
            road.forEach { (u, v) ->
                if (x + u in grid.indices && y + v in grid[0].indices && grid[x + u][y + v] == 1) {
                    sum += dfs(grid, though, x + u, y + v)
                }
            }
            return sum
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}