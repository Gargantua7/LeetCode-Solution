//给定一个数组 nums 和一个目标值 k，找到和等于 k 的最长连续子数组长度。如果不存在任意一个符合要求的子数组，则返回 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,-1,5,-2,3], k = 3
//输出: 4 
//解释: 子数组 [1, -1, 5, -2] 和等于 3，且长度最长。
// 
//
// 示例 2: 
//
// 
//输入: nums = [-2,-1,2,1], k = 1
//输出: 2 
//解释: 子数组 [-1, 2] 和等于 1，且长度最长。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁹ <= k <= 10⁹ 
// 
//
// 
//
// 进阶: 
//你能使时间复杂度在 O(n) 内完成此题吗? 
// Related Topics 数组 哈希表 👍 136 👎 0

package leetcode.editor.cn

/**
 * 325
 * 和等于 k 的最长子数组长度	
 *
 * @author Gargantua丶
 * 2021-11-09 13:54:18
 */
class MaximumSizeSubarraySumEqualsK { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        map[nums[0]] = 0
        map[0] = -1
        for (i in 1..nums.lastIndex) {
            nums[i] += nums[i - 1]
            if (nums[i] !in map) map[nums[i]] = i
        }
        return nums.foldIndexed(0) { i, max, n ->
            max.coerceAtLeast(i - (map[n - k]?: i))
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}