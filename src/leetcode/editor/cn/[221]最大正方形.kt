//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 数组 动态规划 矩阵 
// 👍 824 👎 0


package leetcode.editor.cn

/**
 * 221
 * 最大正方形
 *
 * @author Gargantua丶
 * 2021-07-30 00:38:37
 */
class MaximalSquare {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun maximalSquare(matrix: Array<CharArray>): Int {
            var ans = 0
            val dp = Array(matrix.size) { IntArray(matrix[0].size) }
            for (i in dp.indices) {
                for (j in dp[0].indices) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = if (i * j == 0) 1
                        else kotlin.math.min(kotlin.math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1
                        ans = kotlin.math.max(ans, dp[i][j])
                    }
                }
            }
            return ans * ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}