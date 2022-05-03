//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// 0 <= matrix[i][j] <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 329 题相同： https://leetcode-cn.com/problems/longest-increasing-path-
//in-a-matrix/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 3 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 112
 * 最长递增路径
 *
 * @author Gargantua丶
 * 2021-11-04 13:32:00
 */
class FpTFWP {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private val road = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)

        fun longestIncreasingPath(matrix: Array<IntArray>): Int {
            val memo = Array(matrix.size) {IntArray(matrix[0].size)}
            var max = 0
            matrix.forEachIndexed { i, ints ->
                ints.forEachIndexed { j, _ ->
                    max = max.coerceAtLeast(dfs(matrix, memo, i, j))
                }
            }
            return max
        }

        fun dfs(matrix: Array<IntArray>, memo: Array<IntArray>, x: Int, y: Int): Int {
            if (memo[x][y] != 0) return memo[x][y]
            val value = matrix[x][y]
            var max = 0
            road.forEach { (u, v) ->
                if (x + u in matrix.indices && y + v in matrix[0].indices && matrix[x + u][y + v] > value) {
                    max = max.coerceAtLeast(dfs(matrix, memo, x + u, y + v))
                }
            }
            memo[x][y] = max + 1
            return max + 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}