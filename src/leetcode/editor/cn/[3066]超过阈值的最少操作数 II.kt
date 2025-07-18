//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一次操作中，你将执行： 
//
// 
// 选择 nums 中最小的两个整数 x 和 y 。 
// 将 x 和 y 从 nums 中删除。 
// 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。 
// 
//
// 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。 
//
// 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,11,10,1,3], k = 10
//输出：2
//解释：第一次操作中，我们删除元素 1 和 2 ，然后添加 1 * 2 + 2 到 nums 中，nums 变为 [4, 11, 10, 3] 。
//第二次操作中，我们删除元素 3 和 4 ，然后添加 3 * 2 + 4 到 nums 中，nums 变为 [10, 11, 10] 。
//此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
//使数组中所有元素都大于等于 10 需要的最少操作次数为 2 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2,4,9], k = 20
//输出：4
//解释：第一次操作后，nums 变为 [2, 4, 9, 3] 。
//第二次操作后，nums 变为 [7, 4, 9] 。
//第三次操作后，nums 变为 [15, 9] 。
//第四次操作后，nums 变为 [33] 。
//此时，数组中的所有元素都大于等于 20 ，所以我们停止操作。
//使数组中所有元素都大于等于 20 需要的最少操作次数为 4 。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。 
// 
//
// Related Topics 数组 模拟 堆（优先队列） 👍 21 👎 0


package leetcode.editor.cn

import java.util.PriorityQueue

/**
 * 3066
 * 超过阈值的最少操作数 II
 * 
 * @author Gargantua丶
 * 2025-01-15 14:27:10
 */
private class MinimumOperationsToExceedThresholdValueIi {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Long>(nums.filter { it < k }.map { it.toLong() })
        var count = 0
        while (queue.isNotEmpty()) {
            count++
            val res = queue.poll() * 2 + (queue.poll() ?: break)
            if (res < k) queue.offer(res)
        }
        return count
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}