//给你一个 非负 整数数组 nums 和一个整数 k 。 
//
// 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。 
//
// 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3], k = 2 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。 
//
// 示例 2： 
//
// 
// 输入：nums = [2,1,8], k = 10 
// 
//
// 输出：3 
//
// 解释： 
//
// 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。 
//
// 示例 3： 
//
// 
// 输入：nums = [1,2], k = 0 
// 
//
// 输出：1 
//
// 解释： 
//
// 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 109 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 位运算 数组 滑动窗口 👍 37 👎 0


package leetcode.editor.cn

import java.io.File.separator
import javax.management.Query.and
import kotlin.math.min

/**
 * 3097
 * 或值至少为 K 的最短子数组 II
 * 
 * @author Gargantua丶
 * 2025-01-17 13:40:38
 */
private class ShortestSubarrayWithOrAtLeastKIi {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {

        var ans = Int.MAX_VALUE
        val n = nums.size

        for (i in 0..< n) {

            if (nums[i] >= k) return 1

            var sum = 0
            for (j in i + 1..< minOf(n.toLong(), i.toLong() + ans).toInt()) {
                sum = sum or nums[j]
                if (nums[i] or sum == sum) break
                if (nums[i] or sum >= k) {
                    ans = minOf(ans, j - i + 1)
                    break
                }
            }
        }

        return if (ans == Int.MAX_VALUE) -1 else ans

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}