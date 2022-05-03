//给定一个未排序的整数数组，找到最长递增子序列的个数。 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。 
// Related Topics 树状数组 线段树 数组 动态规划 👍 373 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 673
 * 最长递增子序列的个数
 *
 * @author Gargantua丶
 * 2021-09-20 00:02:16
 */
class NumberOfLongestIncreasingSubsequence {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findNumberOfLIS(nums: IntArray): Int {
            var maxLength = 0
            var ans = 0
            val dp = IntArray(nums.size) { 1 }
            val count = IntArray(nums.size) { 1 }
            for (i in 0..dp.lastIndex) {
                for (j in 0 until i) {
                    if (nums[j] < nums[i]) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1
                            count[i] = 0
                        }
                        if (dp[i] == dp[j] + 1) count[i] += count[j]
                    }
                }
                if (dp[i] > maxLength) {
                    maxLength = dp[i]
                    ans = 0
                }
                if (dp[i] == maxLength) ans += count[i]
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}