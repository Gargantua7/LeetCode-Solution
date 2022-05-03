//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1190 👎 0


package leetcode.editor.cn

/**
 * 152
 * 乘积最大子数组
 *
 * @author Gargantua丶
 * 2021-07-20 01:02:43
 */
class MaximumProductSubarray {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun maxProduct(nums: IntArray): Int {
            var max = nums[0]
            var min = nums[0]
            var ans = nums[0]
            nums.forEachIndexed { i, num ->
                if(i > 0) {
                    val temp = max
                    max = maxOf(maxOf(num, min * num), max * num)
                    min = minOf(minOf(num, min * num), temp * num)
                    ans = maxOf(ans, max)
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}