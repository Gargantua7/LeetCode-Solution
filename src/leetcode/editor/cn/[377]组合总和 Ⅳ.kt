//给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。 
//
// 题目数据保证答案符合 32 位整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3], target = 4
//输出：7
//解释：
//所有可能的组合为：
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//请注意，顺序不同的序列被视作不同的组合。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9], target = 3
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// nums 中的所有元素 互不相同 
// 1 <= target <= 1000 
// 
//
// 
//
// 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？ 
// Related Topics 数组 动态规划 
// 👍 467 👎 0


package leetcode.editor.cn

/**
 * 377
 * 组合总和 Ⅳ
 *
 * @author Gargantua丶
 * 2021-08-04 03:34:15
 */
class CombinationSumIv {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun combinationSum4(nums: IntArray, target: Int): Int {
            val dp = IntArray(target + 1)
            dp[0] = 1
            for (i in 1..target) {
                for (j in nums) {
                    if (i >= j) dp[i] += dp[i - j]
                }
            }
            return dp[target]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}