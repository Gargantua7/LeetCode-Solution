//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 461 👎 0


package leetcode.editor.cn

/**
 * 59
 * 螺旋矩阵 II
 *
 * @author Gargantua丶
 * 2021-08-14 01:02:15
 */
class SpiralMatrixIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun generateMatrix(n: Int): Array<IntArray> {
            var count = 0
            val step = arrayOf(arrayOf(1, 0), arrayOf(0, 1), arrayOf(-1, 0), arrayOf(0, -1))
            val ans = Array(n) { IntArray(n) }
            var i = 0
            var j = 0
            var currStep = 0
            var kabe = 0
            while (count < n * n) {
                ans[i][j] = 1 + count++
                if (j + step[currStep][0] * (1 + kabe) !in 0 until n || i + step[currStep][1] * (1 + kabe) !in 0 until n) {
                    if (currStep == 2) kabe++
                    currStep = (currStep + 1) % 4
                }
                j += step[currStep][0]
                i += step[currStep][1]
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}