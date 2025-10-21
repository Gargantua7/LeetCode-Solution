//给你一个整数数组 nums 和两个整数 k 和 numOperations 。 
//
// 你必须对 nums 执行 操作 numOperations 次。每次操作中，你可以： 
//
// 
// 选择一个下标 i ，它在之前的操作中 没有 被选择过。 
// 将 nums[i] 增加范围 [-k, k] 中的一个整数。 
// 
//
// 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。 
//
// 一个元素 x 的 频率 指的是它在数组中出现的次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,4,5], k = 1, numOperations = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。 
// 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [5,11,20,20], k = 5, numOperations = 1 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 0 <= k <= 10⁵ 
// 0 <= numOperations <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 排序 滑动窗口 👍 29 👎 0


package leetcode.editor.cn

/*** 3346
* 执行操作后元素的最高频率 I
*
* @author Gargantua7
* 2025-10-21 20:48:16
*/
class MaximumFrequencyOfAnElementAfterPerformingOperationsI {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxFrequency(nums: IntArray, k: Int, numOperations: Int): Int {
        nums.sort()

        var ans = 0

        var left = 0
        var right = 0
        var count = 0

        nums.forEachIndexed { i, n ->

            count++

            if (i == nums.lastIndex || nums[i] != nums[i + 1]) {
                while (nums[left] < n - k) left++
                while (right < nums.size && nums[right] <= n + k) right++

                ans = maxOf(ans, minOf(right - left, count + numOperations))
                count = 0
            }
        }

        if (ans >= numOperations || k == 0) return ans

        left = 0
        right = 0
        while (right < nums.size) {
            if (nums[right] - nums[left] <= 2 * k) {
                ans = maxOf(ans, ++right - left)
            } else {
                left++
            }
        }

        return ans.coerceAtMost(numOperations)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    MaximumFrequencyOfAnElementAfterPerformingOperationsI.Solution()
        .maxFrequency(intArrayOf(1,2,4,5), 2, 4)
        .let(::println)
}