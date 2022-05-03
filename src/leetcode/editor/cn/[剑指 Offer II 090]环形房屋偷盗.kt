//一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同
//时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
//
// 
//
// 注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/ 
// Related Topics 数组 动态规划 👍 2 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 090
 * 环形房屋偷盗	
 *
 * @author Gargantua丶
 * 2021-10-27 13:41:11
 */
class PzWKhm { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(rob(nums, 0, nums.lastIndex - 1), rob(nums, 1, nums.lastIndex))
    }

    fun rob(nums: IntArray, s: Int, e: Int): Int {
        val dp = Array(e - s + 1) { IntArray(2) }
        dp[0][0] = nums[s]
        for (i in 1..e - s) {
            dp[i][0] = nums[s + i] + dp[i - 1][1]
            dp[i][1] = maxOf(dp[i - 1][0], dp[i - 1][1])
        }
        return maxOf(dp[e - s][0], dp[e - s][1])
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}