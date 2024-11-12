//给你一个 二进制 字符串 s 和一个整数 k。 
//
// 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。 
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束： 
//
// 
// 字符串中 0 的数量最多为 k。 
// 字符串中 1 的数量最多为 k。 
// 
//
// 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的 子字符串 的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "0001111", k = 2, queries = [[0,6]] 
// 
//
// 输出：[26] 
//
// 解释： 
//
// 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "0
//001111" 外，其余子字符串都满足 k 约束。 
//
// 示例 2： 
//
// 
// 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]] 
// 
//
// 输出：[15,9,3] 
//
// 解释： 
//
// s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 是 '0' 或 '1' 
// 1 <= k <= s.length 
// 1 <= queries.length <= 10⁵ 
// queries[i] == [li, ri] 
// 0 <= li <= ri < s.length 
// 所有查询互不相同 
// 
//
// Related Topics 数组 字符串 二分查找 前缀和 滑动窗口 👍 16 👎 0


package leetcode.editor.cn

import java.util.TreeMap

/**
 * 3261
 * 统计满足 K 约束的子字符串数量 II
 *
 * @author Gargantua丶
 * 2024-11-12 15:47:07
 */
private class CountSubstringsThatSatisfyKConstraintIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countKConstraintSubstrings(s: String, k: Int, queries: Array<IntArray>): LongArray {
        val zeroArr = IntArray(s.length + 1)
        val oneArr = IntArray(s.length + 1)
        zeroArr[0] = -1
        oneArr[0] = -1
        var zeroIndex = 0
        var oneIndex = 0

        val farMap = TreeMap<Int, Int>()
        val map = s.scanIndexed(0L) { idx, sum , it ->
            if (it == '0') zeroArr[++zeroIndex] = idx else oneArr[++oneIndex] = idx
            val leastIndex = minOf(zeroArr[(zeroIndex - k).coerceAtLeast(0)], oneArr[(oneIndex - k).coerceAtLeast(0)]) + 1
            farMap[leastIndex] = idx
            sum + idx - leastIndex + 1
        }

        return queries.map { (left, right) ->

            if (left == 0) return@map map[right + 1]

            val point = farMap.floorEntry(left)?.value?.coerceAtMost(right) ?: left

            (point - left + 2L) * (point - left + 1L) / 2L + map[right + 1] - map[point + 1]
        }.toLongArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}