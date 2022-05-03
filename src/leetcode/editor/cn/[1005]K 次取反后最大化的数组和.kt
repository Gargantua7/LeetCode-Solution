//给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组： 
//
// 
// 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 
// 
//
// 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。 
//
// 以这种方式修改数组后，返回数组 可能的最大和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,2,3], k = 1
//输出：5
//解释：选择下标 1 ，nums 变为 [4,-2,3] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,-1,0,2], k = 3
//输出：6
//解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,-3,-1,5,-4], k = 2
//输出：13
//解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -100 <= nums[i] <= 100 
// 1 <= k <= 10⁴ 
// 
// Related Topics 贪心 数组 排序 👍 184 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 1005
 * K 次取反后最大化的数组和
 *
 * @author Gargantua丶
 * 2021-12-03 21:03:30
 */
class MaximizeSumOfArrayAfterKNegations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun largestSumAfterKNegations(nums: IntArray, k1: Int): Int {
            var k = k1
            val freq: MutableMap<Int, Int> = HashMap()
            for (num in nums) {
                freq[num] = freq.getOrDefault(num, 0) + 1
            }
            var ans = nums.sum()
            for (i in -100..-1) {
                if (freq.containsKey(i)) {
                    val ops = Math.min(k, freq[i]!!)
                    ans += -i * ops * 2
                    freq[i] = freq[i]!! - ops
                    freq[-i] = freq.getOrDefault(-i, 0) + ops
                    k -= ops
                    if (k == 0) {
                        break
                    }
                }
            }
            if (k > 0 && k % 2 == 1 && !freq.containsKey(0)) {
                for (i in 1..100) {
                    if (freq.containsKey(i)) {
                        ans -= i * 2
                        break
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}