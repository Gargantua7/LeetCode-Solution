//给你两个 m x n 的二进制矩阵 grid1 和 grid2 ，它们只包含 0 （表示水域）和 1 （表示陆地）。一个 岛屿 是由 四个方向 （水平或者竖
//直）上相邻的 1 组成的区域。任何矩阵以外的区域都视为水域。 
//
// 如果 grid2 的一个岛屿，被 grid1 的一个岛屿 完全 包含，也就是说 grid2 中该岛屿的每一个格子都被 grid1 中同一个岛屿完全包含，那
//么我们称 grid2 中的这个岛屿为 子岛屿 。 
//
// 请你返回 grid2 中 子岛屿 的 数目 。 
//
// 
//
// 示例 1： 
//
// 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]], 
//grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
//输出：3
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
// 
//
// 示例 2： 
//
// 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]], 
//grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
//输出：2 
//解释：如上图所示，左边为 grid1 ，右边为 grid2 。
//grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
// 
//
// 
//
// 提示： 
//
// 
// m == grid1.length == grid2.length 
// n == grid1[i].length == grid2[i].length 
// 1 <= m, n <= 500 
// grid1[i][j] 和 grid2[i][j] 都要么是 0 要么是 1 。 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 41 👎 0

package leetcode.editor.cn

/**
 * 1905
 * 统计子岛屿
 * 
 * @author Gargantua丶
 * 2022-03-21 01:13:07
 */
class CountSubIslands {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var row = 0
    var col = 0
    var flag = true

    fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
        row = grid1.size
        col = grid1[0].size
        var count = 0
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (grid1[i][j] == 1 && grid2[i][j] == 1) {
                    flag = true
                    dfs(grid1, grid2, i, j)
                    if (flag) {
                        count++
                    }
                }
            }
        }
        return count
    }

    fun dfs(grid1: Array<IntArray>, grid2: Array<IntArray>, i: Int, j: Int) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return
        }
        if (grid1[i][j] == 0 && grid2[i][j] == 1) {
            flag = false
            return
        }
        if (grid1[i][j] != 1 || grid2[i][j] != 1) {
            return
        }
        grid1[i][j] = 2
        grid2[i][j] = 2
        dfs(grid1, grid2, i + 1, j)
        dfs(grid1, grid2, i - 1, j)
        dfs(grid1, grid2, i, j + 1)
        dfs(grid1, grid2, i, j - 1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
