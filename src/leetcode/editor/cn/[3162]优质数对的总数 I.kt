//给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。 
//
// 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <=
// m - 1）。 
//
// 返回 优质数对 的总数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1 
// 
//
// 输出：5 
//
// 解释： 
//
// 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。 
//
// 示例 2： 
//
// 
// 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3 
// 
//
// 输出：2 
//
// 解释： 
//
// 2个优质数对分别是 (3, 0) 和 (3, 1)。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 50 
// 1 <= nums1[i], nums2[j] <= 50 
// 1 <= k <= 50 
// 
//
// Related Topics 数组 哈希表 👍 14 👎 0


package leetcode.editor.cn

/**
 * 3162
 * 优质数对的总数 I
 *
 * @author Gargantua丶
 * 2024-10-10 14:24:51
 */
class FindTheNumberOfGoodPairsI {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
        val map1 = nums1.toTypedArray().groupingBy { it }.eachCount()
        val map2 = nums2.toTypedArray().groupingBy { it }.eachCount()

        return map1.entries.sumOf { (a, count1) ->
            count1 * map2.entries.sumOf { (b, count2) ->
                if (a % (b * k) == 0) count2 else 0
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}