//给你一个整数数组 nums。 
//
// nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列： 
//
// 
// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x 
//- 1]) % 2 
// 
//
// 返回 nums 的 最长的有效子序列 的长度。 
//
// 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3,4] 
// 
//
// 输出： 4 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 3, 4]。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,1,1,2,1,2] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,3] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 最长的有效子序列是 [1, 3]。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 数组 动态规划 👍 21 👎 0


package leetcode.editor.cn

/**
 * 3201
 * 找出有效子序列的最大长度 I
 * 
 * @author Gargantua丶
 * 2025-07-16 14:37:46
 */
private class FindTheMaximumLengthOfValidSubsequenceI {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximumLength(nums: IntArray): Int {

        var even = 0
        var odd = 0

        nums.forEach {
            if (it % 2 == 1) even = maxOf(even, odd + 1)
            else odd = maxOf(even + 1, odd)
        }

        val evenCount = nums.count { it % 2 == 1 }
        val oddCount = nums.size - evenCount

        return maxOf(even, odd, evenCount, oddCount)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}