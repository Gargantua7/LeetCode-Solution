//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1752 👎 0


package leetcode.editor.cn
/**
 * 300
 * 最长递增子序列
 *
 * @author Gargantua丶
 * 2021-08-01 01:56:46
 */
class LongestIncreasingSubsequence { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        var ans = 1
        for (i in 1..dp.lastIndex) {
            for (j in 0 until i) {
                if(nums[j] < nums[i]) dp[i] = kotlin.math.max(dp[i], dp[j] + 1)
            }
            ans = kotlin.math.max(ans, dp[i])
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}