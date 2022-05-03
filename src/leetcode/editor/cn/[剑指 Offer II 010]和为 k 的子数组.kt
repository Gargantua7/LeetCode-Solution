//给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2
//解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
// 
//
// 示例 2 : 
//
// 
//输入:nums = [1,2,3], k = 3
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// 
// -10⁷ <= k <= 10⁷ 
// 
// 
//
// 
//
// 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/ 
// Related Topics 数组 哈希表 前缀和 👍 14 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 010
 * 和为 k 的子数组
 *
 * @author Gargantua丶
 * 2021-10-01 13:23:11
 */
class QTMn0o {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun subarraySum(nums: IntArray, k: Int): Int {
            val map = HashMap<Int, Int>()
            var ans = 0
            map[0] = 1
            for (i in 1..nums.lastIndex) nums[i] += nums[i - 1]
            nums.forEach { num ->
                ans += map[num - k] ?: 0
                map[num] = (map[num] ?: 0) + 1
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}