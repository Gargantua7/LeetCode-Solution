//给你一个长度为 n 的整数数组 nums 。 
//
// 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。 
//
// 
// 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。 
// 
//
// 返回满足要求的 最长 子数组的长度。 
//
// 数组的按位与就是对数组中的所有数字进行按位与运算。 
//
// 子数组 是数组中的一个连续元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,3,2,2]
//输出：2
//解释：
//子数组按位与运算的最大值是 3 。
//能得到此结果的最长子数组是 [3,3]，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：1
//解释：
//子数组按位与运算的最大值是 4 。 
//能得到此结果的最长子数组是 [4]，所以返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 脑筋急转弯 数组 👍 30 👎 0


package leetcode.editor.cn

/**
 * 2419
 * 按位与最大的最长子数组
 * 
 * @author Gargantua丶
 * 2025-07-07 16:23:28
 */
private class LongestSubarrayWithMaximumBitwiseAnd {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val max = nums.max()
        var ans = 0
        var length = 0
        nums.forEach {
            if (it == max) length++
            else length = 0

            ans = maxOf(ans, length)
        }

        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}