//给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[
//j]) 都应当满足：
// 
// answer[i] % answer[j] == 0 ，或 
// answer[j] % answer[i] == 0 
// 
//
// 如果存在多个有效解子集，返回其中任何一个均可。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,2]
//解释：[1,3] 也会被视为正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,8]
//输出：[1,2,4,8]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 2 * 10⁹ 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 数学 动态规划 排序 👍 391 👎 0


package leetcode.editor.cn

/**
 * 368
 * 最大整除子集
 *
 * @author Gargantua丶
 * 2021-09-25 16:51:09
 */
class LargestDivisibleSubset {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun largestDivisibleSubset(nums: IntArray): List<Int> {
            nums.sort()
            val dp = Array<ArrayList<Int>>(nums.size) { ArrayList() }
            var ans = ArrayList<Int>()
            for (i in nums.indices) {
                for (j in i - 1 downTo 0) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[i].size < dp[j].size)
                            dp[i] = ArrayList(dp[j].toList())
                    }
                }
                dp[i].add(nums[i])
                if (dp[i].size > ans.size) ans = dp[i]
            }
            return ans
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}