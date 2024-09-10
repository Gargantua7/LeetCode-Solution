//给你一个长度为 n 下标从 0 开始的整数数组 nums ，它包含 1 到 n 的所有数字，请你返回上升四元组的数目。 
//
// 如果一个四元组 (i, j, k, l) 满足以下条件，我们称它是上升的： 
//
// 
// 0 <= i < j < k < l < n 且 
// nums[i] < nums[k] < nums[j] < nums[l] 。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,3,2,4,5]
//输出：2
//解释：
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 3 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//- 当 i = 0 ，j = 1 ，k = 2 且 l = 4 时，有 nums[i] < nums[k] < nums[j] < nums[l] 。
//没有其他的四元组，所以我们返回 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4]
//输出：0
//解释：只存在一个四元组 i = 0 ，j = 1 ，k = 2 ，l = 3 ，但是 nums[j] < nums[k] ，所以我们返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 4000 
// 1 <= nums[i] <= nums.length 
// nums 中所有数字 互不相同 ，nums 是一个排列。 
// 
//
// Related Topics 树状数组 数组 动态规划 枚举 前缀和 👍 74 👎 0


package leetcode.editor.cn

/**
 * 2552
 * 统计上升四元组
 *
 * @author Gargantua丶
 * 2024-09-10 16:20:15
 */
class CountIncreasingQuadruplets {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countQuadruplets(nums: IntArray): Long {
        val sum = Array(nums.lastIndex) { IntArray(nums.lastIndex - it) }

        for (j in 0..< nums.lastIndex) {
            var moreThen = 0
            for (k in nums.lastIndex downTo j + 1) {
                if (nums[j] > nums[k]) {

                    sum[j][k - j - 1] = moreThen

                } else moreThen++
            }
        }

        for (k in 1..nums.lastIndex) {
            var lessThen = 0
            for (j in 0..< k) {
                if (nums[j] > nums[k]) {

                    sum[j][k - j - 1] *= lessThen

                } else lessThen++
            }
        }

        return sum.sumOf { it.sumOf { it.toLong() } }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}