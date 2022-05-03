//给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= 
//t ，同时又满足 abs(i - j) <= k 。 
//
// 如果存在则返回 true，不存在返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3, t = 0
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1, t = 2
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,5,9,1,5,9], k = 2, t = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 2 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 0 <= k <= 10⁴ 
// 0 <= t <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 220 题相同： https://leetcode-cn.com/problems/contains-duplicate-iii/ 
// Related Topics 数组 桶排序 有序集合 排序 滑动窗口 👍 5 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 057
 * 值和下标之差都在给定的范围内
 *
 * @author Gargantua丶
 * 2021-10-16 14:29:49
 */
class SevenWqeDu { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        val set = TreeSet<Long>()
        for (i in nums.indices) {
            set.ceiling(nums[i].toLong() - t)?.let {
                if (it <= nums[i].toLong() + t) return true
            }
            set += nums[i].toLong()
            if (i >= k) {
                set -= nums[i - k].toLong()
            }
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}