//给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。 
//
// 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
//输出：4 
//解释：最长递增路径为 [1, 2, 6, 9]。 
//
// 示例 2： 
//
// 
//输入：matrix = [[3,4,5],[3,2,6],[2,2,1]]
//输出：4 
//解释：最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
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
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 记忆化搜索 动态规划 👍 519 👎 0


package leetcode.editor.cn

/**
 * 329
 * 矩阵中的最长递增路径
 *
 * @author Gargantua丶
 * 2021-09-16 12:25:05
 */
class LongestIncreasingPathInAMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun longestIncreasingPath(matrix: Array<IntArray>): Int {
            var ans = 0
            val memo = Array(matrix.size) { IntArray(matrix[0].size) }
            matrix.forEachIndexed { i, it ->
                it.forEachIndexed { j, _ ->
                    ans = ans.coerceAtLeast(dfs(matrix, i, j, -1, memo))
                }
            }
            return ans
        }

        fun dfs(matrix: Array<IntArray>, i: Int, j: Int, last: Int, memo: Array<IntArray>): Int {


            val n = matrix[i][j]

            if (n == -1 || n <= last) return 0

            if (memo[i][j] > 0) return memo[i][j]

            matrix[i][j] = -1

            var max = 0

            if (i + 1 < matrix.size) {
                max = max.coerceAtLeast(dfs(matrix, i + 1, j, n, memo))
            }
            if (j + 1 < matrix[0].size) {
                max = max.coerceAtLeast(dfs(matrix, i, j + 1, n, memo))
            }
            if (i - 1 >= 0) {
                max = max.coerceAtLeast(dfs(matrix, i - 1, j, n, memo))
            }
            if (j - 1 >= 0) {
                max = max.coerceAtLeast(dfs(matrix, i, j - 1, n, memo))
            }

            matrix[i][j] = n

            memo[i][j] = max + 1

            return max + 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}