//给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。 
//
// 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,2,6,7,5,1], k = 2
//输出：[0,3,5]
//解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
//也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
//输出：[0,2,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] < 2¹⁶ 
// 1 <= k <= floor(nums.length / 3) 
// 
// Related Topics 数组 动态规划 👍 226 👎 0

package leetcode.editor.cn

/**
 * 689
 * 三个无重叠子数组的最大和
 *
 * @author Gargantua丶
 * 2021-12-08 14:49:34
 */
class MaximumSumOf3NonOverlappingSubarrays {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxSumOfThreeSubarrays(nums: IntArray, k: Int): IntArray {
            val dp = Array(nums.size - k + 1) { Array(3) { (-1 to -1) to -1 } }
            for (i in dp.indices) {
                val group = IntArray(3)
                for (j in 0 until k) {
                    group[0] += nums[i + j]
                    if (i >= k) group[1] += nums[i + j]
                    if (i >= 2 * k) group[2] += nums[i + j]
                }
                if (i == 0) dp[0][0] = (0 to -1) to group[0]
                else dp[i][0] = if (group[0] > dp[i - 1][0].second) (i to -1) to group[0] else dp[i - 1][0]

                if (i == k) dp[k][1] = (k to 0) to group[1] + dp[0][0].second
                else if (i > k) dp[i][1] =
                    if (group[1] + dp[i - k][0].second > dp[i - 1][1].second)
                        (i to dp[i - k][0].first.first) to group[1] + dp[i - k][0].second
                    else dp[i - 1][1]

                if (i == 2 * k) dp[2 * k][2] = (2 * k to k) to group[2] + dp[k][1].second
                else if (i > 2 * k) dp[i][2] =
                    if (group[2] + dp[i - k][1].second > dp[i - 1][2].second)
                        (i to dp[i - k][1].first.first) to group[2] + dp[i - k][1].second
                    else dp[i - 1][2]

            }
            //dp.forEach { println(it.contentToString()) }

            return intArrayOf(
                dp[dp.last().last().first.second][1].first.second,
                dp.last().last().first.second,
                dp.last().last().first.first
            )
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}