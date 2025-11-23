//给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,5,1,8]
//输出：18
//解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。 
//
// 示例 2： 
//
// 
//输入：nums = [4]
//输出：0
//解释：4 不能被 3 整除，所以无法选出数字，返回 0。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,4,4]
//输出：12
//解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 4 * 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 406 👎 0


package leetcode.editor.cn

import java.util.PriorityQueue
import kotlin.math.max

/*** 1262
* 可被三整除的最大和
*
* @author Gargantua7
* 2025-11-23 19:25:54
*/
class GreatestSumDivisibleByThree {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        var dp = intArrayOf(0, Int.MIN_VALUE, Int.MIN_VALUE)
        nums.forEach { n ->
            val next = IntArray(3)
            val mod = n % 3
            repeat(3) { i ->
                next[i] = max(dp[i], dp[(i + 3 - mod) % 3] + n)
            }
            dp = next
        }
        return dp[0]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}