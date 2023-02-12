//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。 
//
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。 
//
// 
//
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。 
//
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 
//
// 请返回待替换子串的最小可能长度。 
//
// 如果原字符串自身就是一个平衡字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "QWER"
//输出：0
//解释：s 已经是平衡的了。 
//
// 示例 2： 
//
// 
//输入：s = "QQWE"
//输出：1
//解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
// 
//
// 示例 3： 
//
// 
//输入：s = "QQQW"
//输出：2
//解释：我们可以把前面的 "QQ" 替换成 "ER"。 
// 
//
// 示例 4： 
//
// 
//输入：s = "QQQQ"
//输出：3
//解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s.length 是 4 的倍数 
// s 中只含有 'Q', 'W', 'E', 'R' 四种字符 
// 
//
// Related Topics 字符串 滑动窗口 👍 101 👎 0


package leetcode.editor.cn

/**
 * 1234
 * 替换子串得到平衡字符串
 *
 * @author Gargantua丶
 * 2023-02-13 00:10:28
 */
class ReplaceTheSubstringForBalancedString {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun balancedString(s: String): Int {
        val ch = arrayOf('Q', 'W', 'E', 'R')
        val counts = IntArray(4) { i -> s.count { c -> c == ch[i] } }
        if (counts.count{ it == s.length / 4 } == 4) return 0

        var left = 0
        var right = 0
        var ans = Int.MAX_VALUE
        while (left <= right && right <= s.length) {
            if (counts.count { it <= s.length / 4 } == 4) {
                ans = minOf(ans, right - left)
                counts[ch.indexOf(s[left++])]++
            } else if (right < s.length) {
                counts[ch.indexOf(s[right++])]--
            } else break
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}