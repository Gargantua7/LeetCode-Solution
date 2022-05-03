//给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 动态规划 👍 933 👎 0


package leetcode.editor.cn

/**
 * 416
 * 分割等和子集
 *
 * @author Gargantua丶
 * 2021-09-09 14:31:20
 */
class PartitionEqualSubsetSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun canPartition(nums: IntArray): Boolean {
            if (nums.size < 2) return false
            val sum = nums.sum()
            if (sum % 2 == 1) return false
            val target = sum / 2
            // WARNING: Function IntArray.maxOrNull() Since Kotlin 1.4. Replace with Int.max() in Kotlin 1.3
            if (nums.maxOrNull()!! > target) return false
            val dp = BooleanArray(target + 1)
            dp[0] = true
            nums.forEach { num ->
                for (j in target downTo num) {
                    dp[j] = dp[j] or dp[j - num]
                }
            }
            return dp.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}