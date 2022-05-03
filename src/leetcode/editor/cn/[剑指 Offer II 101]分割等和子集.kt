//给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：nums 不可以分为和相等的两部分
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-
//sum/ 
// Related Topics 数学 字符串 模拟 👍 11 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 101
 * 分割等和子集
 *
 * @author Gargantua丶
 * 2021-10-31 13:33:18
 */
class NUPfPr {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun canPartition(nums: IntArray): Boolean {
            if (nums.size == 1) return false
            val sum = nums.sum()
            if (sum and 1 != 0) return false
            val target = sum shr 1
            // WARNING: Since Kotlin 1.4
            if (nums.maxOrNull()!! > target) return false
            val dp = BooleanArray(target + 1)
            dp[0] = true
            for (num in nums) {
                for (j in target downTo num) {
                    dp[j] = dp[j] or dp[j - num]
                }
            }
            return dp.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}