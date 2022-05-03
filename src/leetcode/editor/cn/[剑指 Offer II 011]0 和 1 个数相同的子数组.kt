//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// 
//
// 注意：本题与主站 525 题相同： https://leetcode-cn.com/problems/contiguous-array/ 
// Related Topics 数组 哈希表 前缀和 👍 11 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 011
 * 0 和 1 个数相同的子数组
 *
 * @author Gargantua丶
 * 2021-10-01 13:38:16
 */
class A1NYOS {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findMaxLength(nums: IntArray): Int {
            for (i in nums.indices) if (nums[i] == 0) nums[i] = -1
            for (i in 1..nums.lastIndex) nums[i] += nums[i - 1]
            val map = HashMap<Int, Int>()
            map[0] = -1
            var ans = 0
            nums.forEachIndexed { i, num ->
                ans = ans.coerceAtLeast(i - (map[num]?: i))
                map[num] = (map[num]?: Int.MAX_VALUE).coerceAtMost(i)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}