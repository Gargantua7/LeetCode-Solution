//给你一个字符串 s ，它由某个字符串 t 和若干 t 的 同位字符串 连接而成。 
//
// 请你返回字符串 t 的 最小 可能长度。 
//
// 同位字符串 指的是重新排列一个单词得到的另外一个字符串，原来字符串中的每个字符在新字符串中都恰好只使用一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "abba" 
// 
//
// 输出：2 
//
// 解释： 
//
// 一个可能的字符串 t 为 "ba" 。 
//
// 示例 2： 
//
// 
// 输入：s = "cdef" 
// 
//
// 输出：4 
//
// 解释： 
//
// 一个可能的字符串 t 为 "cdef" ，注意 t 可能等于 s 。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 30 👎 0


package leetcode.editor.cn


/**
 * 3138
 * 同位字符串连接的最小长度
 *
 * @author Gargantua丶
 * 2024-12-20 14:48:05
 */
private class MinimumLengthOfAnagramConcatenation {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minAnagramLength(s: String): Int {
        (s.groupingBy { it }.eachCount().values.reduce { acc, n -> gcd(acc, n) } downTo 2).forEach {
            if (s.length % it == 0) {
                val map = HashMap<Char, Int>()
                val step = s.length / it
                for (idx in s.indices step step) {
                    val m = s.substring(idx, idx + step).groupingBy { it }.eachCount()
                    if (map.isEmpty()) {
                        map.putAll(m)
                    } else if (map != m) {
                        return@forEach
                    }
                }
                return step
            }
        }

        return s.length
    }

    fun gcd(a: Int, b: Int): Int {
        return if (b == 0) kotlin.math.abs(a) else gcd(b, a % b)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}