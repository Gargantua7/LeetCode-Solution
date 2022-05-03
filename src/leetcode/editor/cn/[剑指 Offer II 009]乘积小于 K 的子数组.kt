//给定一个正整数数组 nums和整数 k ，请找出该数组内乘积小于 k 的连续的子数组的个数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [10,5,2,6], k = 100
//输出: 8
//解释: 8 个乘积小于 100 的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
//需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3], k = 0
//输出: 0 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 1 <= nums[i] <= 1000 
// 0 <= k <= 10⁶ 
// 
//
// 
//
// 注意：本题与主站 713 题相同：https://leetcode-cn.com/problems/subarray-product-less-than-
//k/ 
// Related Topics 数组 滑动窗口 👍 9 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 009
 * 乘积小于 K 的子数组
 *
 * @author Gargantua丶
 * 2021-09-30 22:03:39
 */
class ZVAVXX { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {
        var left = 0
        var ret = 0
        var total = 1
        for (right in nums.indices) {
            total *= nums[right]
            while (left <= right && total >= k) {
                total /= nums[left++]
            }
            if (left <= right) {
                ret += right - left + 1
            }
        }
        return ret
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}