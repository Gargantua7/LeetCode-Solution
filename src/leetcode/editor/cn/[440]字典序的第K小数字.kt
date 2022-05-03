//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 281 👎 0

package leetcode.editor.cn

/**
 * 440
 * 字典序的第K小数字
 * 
 * @author Gargantua丶
 * 2022-03-23 00:39:31
 */
class KThSmallestInLexicographicalOrder {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findKthNumber(n: Int, k: Int): Int {
        var remain = k - 1
        var curr = 1L
        while (remain > 0) {
            val step = getStep(curr, n.toLong())
            if (step <= remain) {
                curr++
                remain -= step
            } else {
                curr *= 10
                remain--
            }
        }
        return curr.toInt()
    }

    fun getStep(curr: Long, n: Long): Int {
        var step = 0
        var first = curr
        var last = curr
        while (first <= n) {
            step += (minOf(last, n) - first + 1).toInt()
            first *= 10
            last = last * 10 + 9
        }
        return step
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
