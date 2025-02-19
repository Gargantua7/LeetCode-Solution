//给定 m 个数组，每个数组都已经按照升序排好序了。 
//
// 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。 
//
// 返回最大距离。 
//
// 示例 1： 
//
// 
//输入：[[1,2,3],[4,5],[1,2,3]]
//输出：4
//解释：
//一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
// 
//
// 示例 2： 
//
// 
//输入：arrays = [[1],[1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == arrays.length 
// 2 <= m <= 10⁵ 
// 1 <= arrays[i].length <= 500 
// -10⁴ <= arrays[i][j] <= 10⁴ 
// arrays[i] 以 升序 排序。 
// 所有数组中最多有 10⁵ 个整数。 
// 
//
// 
//
// Related Topics 贪心 数组 👍 137 👎 0


package leetcode.editor.cn

import java.util.PriorityQueue

/**
 * 624
 * 数组列表中的最大距离
 * 
 * @author Gargantua丶
 * 2025-02-19 14:27:46
 */
private class MaximumDistanceInArrays {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxDistance(arrays: List<List<Int>>): Int {
        val minQueue = PriorityQueue<Int> { a, b -> arrays[b].first() - arrays[a].first() }
        val maxQueue = PriorityQueue<Int> { a, b -> arrays[a].last() - arrays[b].last() }

        arrays.forEachIndexed { idx, list ->

            minQueue.offer(idx)
            maxQueue.offer(idx)

            if (minQueue.size > 2) {
                minQueue.poll()
            }

            if (maxQueue.size > 2) {
                maxQueue.poll()
            }
        }

        val sMinIdx = minQueue.poll()
        val sMaxIdx = maxQueue.poll()
        val minIdx = minQueue.poll()
        val maxIdx = maxQueue.poll()

        return if (minIdx != maxIdx) {
            arrays[maxIdx].last() - arrays[minIdx].first()
        } else {
            maxOf(arrays[maxIdx].last() - arrays[sMinIdx].first(), arrays[sMaxIdx].last() - arrays[minIdx].first())
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}