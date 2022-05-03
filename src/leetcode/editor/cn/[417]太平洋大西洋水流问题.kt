//有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。 
//
// 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上
//单元格 高于海平面的高度 。 
//
// 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。 
//
// 返回 网格坐标 result 的 2D列表 ，其中 result[i] = [ri, ci] 表示雨水可以从单元格 (ri, ci) 流向 太平洋和大西洋
// 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
//输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// 
//
// 示例 2： 
//
// 
//输入: heights = [[2,1],[1,2]]
//输出: [[0,0],[0,1],[1,0],[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == heights.length 
// n == heights[r].length 
// 1 <= m, n <= 200 
// 0 <= heights[r][c] <= 10⁵ 
// 
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 350 👎 0

package leetcode.editor.cn


/**
 * 417
 * 太平洋大西洋水流问题
 * 
 * @author Gargantua丶
 * 2022-03-23 03:15:57
 */
class PacificAtlanticWaterFlow {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun pacificAtlantic(matrix: Array<IntArray>): List<IntArray>? {
        val ret: MutableList<IntArray> = ArrayList()
        val m = matrix.size
        if (m < 1) return ret
        val n = matrix[0].size
        val Pacific = Array(m) { BooleanArray(n) }
        val Atlantic = Array(m) { BooleanArray(n) }
        for (i in 0 until m) {
            dfs(matrix, i, 0, Pacific, matrix[i][0])
            dfs(matrix, i, n - 1, Atlantic, matrix[i][n - 1])
        }
        for (i in 0 until n) {
            dfs(matrix, 0, i, Pacific, matrix[0][i])
            dfs(matrix, m - 1, i, Atlantic, matrix[m - 1][i])
        }
        for (i in 0 until m) {
            for (j in 0 until n) if (Pacific[i][j] && Atlantic[i][j]) ret.add(intArrayOf(i, j))
        }
        return ret
    }

    private fun dfs(m: Array<IntArray>, x: Int, y: Int, visited: Array<BooleanArray>, pre: Int) {
        if (x < 0 || y < 0 || x >= m.size || y >= m[0].size || visited[x][y] || m[x][y] < pre) return
        visited[x][y] = true
        dfs(m, x + 1, y, visited, m[x][y])
        dfs(m, x - 1, y, visited, m[x][y])
        dfs(m, x, y + 1, visited, m[x][y])
        dfs(m, x, y - 1, visited, m[x][y])
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
