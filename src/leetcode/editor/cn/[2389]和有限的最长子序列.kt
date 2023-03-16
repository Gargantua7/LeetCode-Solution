//给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。 
//
// 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度
// 。 
//
// 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,2,1], queries = [3,10,21]
//输出：[2,3,4]
//解释：queries 对应的 answer 如下：
//- 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
//- 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
//- 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,4,5], queries = [1]
//输出：[0]
//解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// m == queries.length 
// 1 <= n, m <= 1000 
// 1 <= nums[i], queries[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 二分查找 前缀和 排序 👍 27 👎 0


package leetcode.editor.cn

/**
 * 2389
 * 和有限的最长子序列
 *
 * @author Gargantua丶
 * 2023-03-17 00:03:02
 */
class LongestSubsequenceWithLimitedSum {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun answerQueries(nums: IntArray, queries: IntArray): IntArray {
        val prev = IntArray(nums.size + 1)
        nums.sorted().forEachIndexed { index, i ->
            prev[index + 1] = i + prev[index]
        }
        return queries.map { binarySearch(prev, it) - 1 }.toIntArray()
    }

    fun binarySearch(arr: IntArray, target: Int): Int {
        var low = 1
        var high = arr.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (arr[mid] > target) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        return low
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}