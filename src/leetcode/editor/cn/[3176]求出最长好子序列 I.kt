//给你一个整数数组 nums 和一个 非负 整数 k 。如果一个整数序列 seq 满足在下标范围 [0, seq.length - 2] 中 最多只有 k 个
//下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。 
//
// 请你返回 nums 中 好 子序列 的最长长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,1,1,3], k = 2 
// 
//
// 输出：4 
//
// 解释： 
//
// 最长好子序列为 [1,2,1,1,3] 。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,2,3,4,5,1], k = 0 
// 
//
// 输出：2 
//
// 解释： 
//
// 最长好子序列为 [1,2,3,4,5,1] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 500 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= min(nums.length, 25) 
// 
//
// Related Topics 数组 哈希表 动态规划 👍 29 👎 0


package leetcode.editor.cn

/**
 * 3176
 * 求出最长好子序列 I
 *
 * @author Gargantua丶
 * 2024-09-06 14:06:14
 */
class FindTheMaximumLengthOfAGoodSubsequenceI {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val dp = HashMap<Int, IntArray>()
        val record = IntArray(k + 1)
        nums.forEach { n ->
            val arr = dp.getOrPut(n) { IntArray(k + 1) }
            (arr.lastIndex downTo 0).forEach { m ->
                arr[m] = maxOf(record.getOrNull(m - 1) ?: 0, arr[m]) + 1
                record[m] = maxOf(arr[m], record[m])
            }
        }
        return record.last()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}