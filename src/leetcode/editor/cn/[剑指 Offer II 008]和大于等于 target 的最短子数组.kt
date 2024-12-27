//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
//
// 
//
// 注意：本题与主站 209 题相同：https://leetcode-cn.com/problems/minimum-size-subarray-sum/ 
//
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 9 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 008
 * 和大于等于 target 的最短子数组
 *
 * @author Gargantua丶
 * 2021-09-30 21:41:50
 */
class TwoVG8Kg {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun minSubArrayLen(target: Int, nums: IntArray): Int {
            var fast = 1
            var slow = 0
            var sum = nums[0]
            var ans = Int.MAX_VALUE
            while (slow < fast) {
                if (sum < target && fast < nums.size) {
                    sum += nums[fast]
                    fast++
                } else {
                    if (sum >= target) ans = ans.coerceAtMost(fast - slow)
                    sum -= nums[slow]
                    slow++
                }
            }
            return if (ans == Int.MAX_VALUE) 0 else ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}