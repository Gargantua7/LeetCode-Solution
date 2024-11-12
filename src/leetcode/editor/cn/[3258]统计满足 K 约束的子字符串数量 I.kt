//给你一个 二进制 字符串 s 和一个整数 k。 
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束： 
//
// 
// 字符串中 0 的数量最多为 k。 
// 字符串中 1 的数量最多为 k。 
// 
//
// 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "10101", k = 1 
// 
//
// 输出：12 
//
// 解释： 
//
// s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。 
//
// 示例 2： 
//
// 
// 输入：s = "1010101", k = 2 
// 
//
// 输出：25 
//
// 解释： 
//
// s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。 
//
// 示例 3： 
//
// 
// 输入：s = "11111", k = 1 
// 
//
// 输出：15 
//
// 解释： 
//
// s 的所有子字符串都满足 k 约束。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// 1 <= k <= s.length 
// s[i] 是 '0' 或 '1'。 
// 
//
// Related Topics 字符串 滑动窗口 👍 30 👎 0


package leetcode.editor.cn

/**
 * 3258
 * 统计满足 K 约束的子字符串数量 I
 *
 * @author Gargantua丶
 * 2024-11-12 15:03:29
 */
private class CountSubstringsThatSatisfyKConstraintI {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countKConstraintSubstrings(s: String, k: Int): Int {
        val zeroArr = IntArray(s.length + 1)
        val oneArr = IntArray(s.length + 1)
        zeroArr[0] = -1
        oneArr[0] = -1
        var zeroIndex = 0
        var oneIndex = 0

        return s.foldIndexed(0) { idx, sum, it ->
            if (it == '0') zeroArr[++zeroIndex] = idx else oneArr[++oneIndex] = idx
            val leastIndex = minOf(zeroArr[(zeroIndex - k).coerceAtLeast(0)], oneArr[(oneIndex - k).coerceAtLeast(0)]) + 1

            sum + idx - leastIndex + 1
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}