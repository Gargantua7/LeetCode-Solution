//给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。 
//
// 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离
//。 
//
// 返回一对观光景点能取得的最高分。 
//
// 
//
// 示例 1： 
//
// 
//输入：values = [8,1,5,2,6]
//输出：11
//解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
// 
//
// 示例 2： 
//
// 
//输入：values = [1,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 2 <= values.length <= 5 * 104 
// 1 <= values[i] <= 1000 
// 
// Related Topics 数组 动态规划 
// 👍 204 👎 0


package leetcode.editor.cn

/**
 * 1014
 * 最佳观光组合
 *
 * @author Gargantua丶
 * 2021-07-21 04:08:52
 */
class BestSightseeingPair {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun maxScoreSightseeingPair(values: IntArray): Int {
            var ans = values[0]
            var max = values[0]
            values.forEachIndexed { i, value ->
                if (i != 0) {
                    max = kotlin.math.max(max, values[i - 1]) - 1
                    ans = kotlin.math.max(ans, max + value)
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}