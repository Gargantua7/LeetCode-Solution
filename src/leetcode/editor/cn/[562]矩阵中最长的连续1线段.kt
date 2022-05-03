//给定一个01矩阵 M，找到矩阵中最长的连续1线段。这条线段可以是水平的、垂直的、对角线的或者反对角线的。 
//
// 示例: 
//
// 输入:
//[[0,1,1,0],
// [0,1,1,0],
// [0,0,0,1]]
//输出: 3
// 
//
// 提示: 给定矩阵中的元素数量不会超过 10,000。 
// Related Topics 数组 动态规划 矩阵 👍 46 👎 0


package leetcode.editor.cn

/**
 * 562
 * 矩阵中最长的连续1线段
 *
 * @author Gargantua丶
 * 2021-09-23 13:23:28
 */
class LongestLineOfConsecutiveOneInMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        val direction = arrayOf(-1 to -1, -1 to 0, -1 to 1, 0 to -1)

        fun longestLine(mat: Array<IntArray>): Int {
            val dp = Array(mat.size) { Array(mat[0].size) { IntArray(4) } }
            var max = 0
            for (i in dp.indices) {
                for (j in dp[i].indices) {
                    if (mat[i][j] == 1) {
                        for (k in dp[i][j].indices) {
                            val x = i + direction[k].first
                            val y = j + direction[k].second
                            dp[i][j][k] = (if (x in 0..dp.lastIndex && y in 0..dp[0].lastIndex) dp[x][y][k] else 0) + 1
                            max = max.coerceAtLeast(dp[i][j][k])
                        }
                    }
                }
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}