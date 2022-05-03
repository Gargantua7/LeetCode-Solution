//给定两个以升序排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 示例 3: 
//
// 
//输入: nums1 = [1,2], nums2 = [3], k = 3 
//输出: [1,3],[2,3]
//解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁴ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1, nums2 均为升序排列 
// 1 <= k <= 1000 
// 
// Related Topics 数组 堆（优先队列） 👍 247 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

/**
 * 373
 * 查找和最小的K对数字
 *
 * @author Gargantua丶
 * 2022-01-14 00:15:15
 */
class FindKPairsWithSmallestSums {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
            val queue = PriorityQueue<Pair<Int, Int>>() { (i, j), (x, y) -> nums1[i] + nums2[j] - nums1[x] - nums2[y] }
            val map = HashSet<Pair<Int, Int>>()
            queue.offer(0 to 0)
            map.add(0 to 0)
            val ans = ArrayList<List<Int>>()
            while (queue.isNotEmpty() && ans.size < k) {
                val (i, j) = queue.poll()
                ans.add(listOf(nums1[i], nums2[j]))
                if (i + 1 in nums1.indices && i + 1 to j !in map) {
                    queue.offer(i + 1 to j)
                    map.add(i + 1 to j)
                }
                if (j + 1 in nums2.indices && i to j + 1 !in map) {
                    queue.offer(i to j + 1)
                    map.add(i to j + 1)
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
