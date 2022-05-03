//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 
// 👍 305 👎 0


package leetcode.editor.cn

/**
 * 119
 * 杨辉三角 II
 *
 * @author Gargantua丶
 * 2021-07-26 00:56:10
 */
class PascalsTriangleIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun getRow(rowIndex: Int): List<Int> {
            val dp = ArrayList<Int>(rowIndex + 1)
            dp.add(0, 1)
            for (i in 1..rowIndex) {
                dp.add(i, 1)
                for (j in i - 1 downTo 1) {
                    dp[j] = dp[j] + dp[j - 1]
                }
            }
            return dp
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}