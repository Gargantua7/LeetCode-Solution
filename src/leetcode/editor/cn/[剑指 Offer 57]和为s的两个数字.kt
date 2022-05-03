//输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,7,11,15], target = 9
//输出：[2,7] 或者 [7,2]
// 
//
// 示例 2： 
//
// 输入：nums = [10,26,30,31,47,60], target = 40
//输出：[10,30] 或者 [30,10]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= nums[i] <= 10^6 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 122 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 57
 * 和为s的两个数字
 *
 * @author Gargantua丶
 * 2021-08-11 00:59:17
 */
class HeWeiSdeLiangGeShuZiLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun twoSum(nums: IntArray, target: Int): IntArray {
            var left = 0
            var right = nums.lastIndex
            while (left < right) {
                val sum = nums[left] + nums[right]
                if (sum > target) right--
                else if (sum < target) left++
                else return intArrayOf(nums[left], nums[right])
            }
            return emptyArray<Int>().toList().toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}