//给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶: 采用的方案可以在 O(log n) 时间复杂度和 O(1) 空间复杂度中运行吗？ 
//
// 
//
// 注意：本题与主站 540 题相同：https://leetcode-cn.com/problems/single-element-in-a-sorted-
//array/ 
// Related Topics 数组 二分查找 👍 7 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 070
 * 排序数组中只出现一次的数字
 *
 * @author Gargantua丶
 * 2021-10-20 13:06:03
 */
class SkFtm2 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun singleNonDuplicate(nums: IntArray): Int {
            var left = 0
            var right = nums.lastIndex
            while (left <= right) {
                val mid = left + (right - left) / 2
                if (mid + 1 in nums.indices && nums[mid] == nums[mid + 1]) {
                    if (mid and 1 == 0) left = mid + 2
                    else right = mid - 1
                } else if (mid - 1 in nums.indices && nums[mid] == nums[mid - 1]) {
                    if (mid and 1 == 1) left = mid + 1
                    else right = mid - 2
                } else {
                    return nums[mid]
                }
            }
            return 0
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}