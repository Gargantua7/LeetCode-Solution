//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 588 👎 0


package leetcode.editor.cn

/**
 * 581
 * 最短无序连续子数组
 *
 * @author Gargantua丶
 * 2021-08-03 01:09:46
 */
class ShortestUnsortedContinuousSubarray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findUnsortedSubarray(nums: IntArray): Int {
            var (max, min, left, right) = arrayOf(Int.MIN_VALUE, Int.MAX_VALUE, -1, -1)
            nums.forEachIndexed { index, num ->
                if (max > num) right = index
                else max = num
                if (min < nums[nums.size - index - 1]) left = nums.size - index - 1
                else min = nums[nums.size - index - 1]
            }
            return if(right == -1) 0 else right - left + 1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}