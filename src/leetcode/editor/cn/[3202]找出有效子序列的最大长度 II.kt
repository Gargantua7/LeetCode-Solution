//给你一个整数数组 nums 和一个 正 整数 k 。
//
// nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ： 
//
// 
// (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x 
//- 1]) % k 
// 返回 
//nums 的 
//最长
//有效子序列 的长度。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,4,5], k = 2 
// 
//
// 输出：5 
//
// 解释： 
//
// 最长有效子序列是 [1, 2, 3, 4, 5] 。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,4,2,3,1,4], k = 3 
// 
//
// 输出：4 
//
// 解释： 
//
// 最长有效子序列是 [1, 4, 1, 4] 。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10³ 
// 1 <= nums[i] <= 10⁷ 
// 1 <= k <= 10³ 
// 
//
// Related Topics 数组 动态规划 👍 31 👎 0


package leetcode.editor.cn

/**
 * 3202
 * 找出有效子序列的最大长度 II
 * 
 * @author Gargantua丶
 * 2025-07-17 15:36:42
 */
private class FindTheMaximumLengthOfValidSubsequenceIi {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {

        val dp = Array(k) { IntArray(k) }
        var res = 0

        nums.map { it % k }.forEach { n ->

            repeat(k) { mod ->
                dp[mod][n] = dp[n][mod] + 1
                res = maxOf(res, dp[mod][n])
            }

        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}