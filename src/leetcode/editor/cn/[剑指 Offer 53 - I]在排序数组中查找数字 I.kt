//统计一个数字在排序数组中出现的次数。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 
// 👍 148 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 53 - I
 * 在排序数组中查找数字 I
 *
 * @author Gargantua丶
 * 2021-07-16 00:12:30
 */
class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        val leftIdx = binarySearch(nums, target, true)
        val rightIdx = binarySearch(nums, target, false) - 1
        return if (leftIdx <= rightIdx && rightIdx < nums.size && nums[leftIdx] == target && nums[rightIdx] == target) {
            rightIdx - leftIdx + 1
        } else 0
    }

    private fun binarySearch(nums: IntArray, target: Int, lower: Boolean): Int {
        var left = 0
        var right = nums.size - 1
        var ans = nums.size
        while (left <= right) {
            val mid = (left + right) / 2
            if (nums[mid] > target || lower && nums[mid] >= target) {
                right = mid - 1
                ans = mid
            } else {
                left = mid + 1
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}