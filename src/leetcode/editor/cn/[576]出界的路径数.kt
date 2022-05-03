//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//10⁹ + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 👍 205 👎 0


package leetcode.editor.cn

/**
 * 576
 * 出界的路径数
 *
 * @author Gargantua丶
 * 2021-09-25 21:41:10
 */
class OutOfBoundaryPaths {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
            val mod = 1000000007
            val position = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, -1), arrayOf(0, 1))
            var dp = Array(m) { IntArray(n) }
            dp[startRow][startColumn] = 1
            var ans = 0
            for (move in 0 until maxMove) {
                val temp = Array(m) { IntArray(n) }
                for (i in maxOf(0, startRow - move)..minOf(startRow + move, dp.lastIndex)) {
                    for (j in maxOf(0, startColumn - move)..minOf(startColumn + move, dp[0].lastIndex)) {
                        position.forEach { (x, y) ->
                            if (i + x in dp.indices && j + y in dp[0].indices) {
                                temp[i + x][j + y] = (temp[i + x][j + y] + dp[i][j]) % mod
                            } else {
                                ans = (ans + dp[i][j]) % mod
                            }
                        }
                    }
                }
                dp = temp
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}