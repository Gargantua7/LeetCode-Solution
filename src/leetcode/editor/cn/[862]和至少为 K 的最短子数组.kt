//返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。 
//
// 如果没有和至少为 K 的非空子数组，返回 -1 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = [1], K = 1
//输出：1
// 
//
// 示例 2： 
//
// 输入：A = [1,2], K = 4
//输出：-1
// 
//
// 示例 3： 
//
// 输入：A = [2,-1,2], K = 3
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -10 ^ 5 <= A[i] <= 10 ^ 5 
// 1 <= K <= 10 ^ 9 
// 
// Related Topics 队列 数组 二分查找 前缀和 滑动窗口 单调队列 堆（优先队列） 👍 323 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 862
 * 和至少为 K 的最短子数组
 * 
 * @author Gargantua丶
 * 2021-11-20 14:08:36
 */
class ShortestSubarrayWithSumAtLeastK {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun shortestSubarray(nums: IntArray, k: Int): Int {
        val pre = LongArray(nums.size + 1)
        for (i in nums.indices) {
            pre[i + 1] = pre[i] + nums[i]
        }
        val dq: Deque<Int> = LinkedList()
        return pre.foldIndexed(pre.size) { i, max, _ ->
            var t = max
            while (dq.isNotEmpty() && pre[i] <= pre[dq.peekLast()]) dq.pollLast()
            while (dq.isNotEmpty() && pre[i] >= k + pre[dq.peekFirst()])
                t = t.coerceAtMost(i - dq.pollFirst())
            dq.offerLast(i)
            t
        }.run {
            if (this < pre.size) this
            else -1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}