//给你一个二进制字符串 s。 
//
// 请你统计并返回其中 1 显著 的 子字符串 的数量。 
//
// 如果字符串中 1 的数量 大于或等于 0 的数量的 平方，则认为该字符串是一个 1 显著 的字符串 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "00011" 
// 
//
// 输出：5 
//
// 解释： 
//
// 1 显著的子字符串如下表所示。 
//
// 
// 
// 
// i 
// j 
// s[i..j] 
// 0 的数量 
// 1 的数量 
// 
// 
// 
// 
// 3 
// 3 
// 1 
// 0 
// 1 
// 
// 
// 4 
// 4 
// 1 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 01 
// 1 
// 1 
// 
// 
// 3 
// 4 
// 11 
// 0 
// 2 
// 
// 
// 2 
// 4 
// 011 
// 1 
// 2 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：s = "101101" 
// 
//
// 输出：16 
//
// 解释： 
//
// 1 不显著的子字符串如下表所示。 
//
// 总共有 21 个子字符串，其中 5 个是 1 不显著字符串，因此有 16 个 1 显著子字符串。 
//
// 
// 
// 
// i 
// j 
// s[i..j] 
// 0 的数量 
// 1 的数量 
// 
// 
// 
// 
// 1 
// 1 
// 0 
// 1 
// 0 
// 
// 
// 4 
// 4 
// 0 
// 1 
// 0 
// 
// 
// 1 
// 4 
// 0110 
// 2 
// 2 
// 
// 
// 0 
// 4 
// 10110 
// 2 
// 3 
// 
// 
// 1 
// 5 
// 01101 
// 2 
// 3 
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 4 * 10⁴ 
// s 仅包含字符 '0' 和 '1'。 
// 
//
// Related Topics 字符串 枚举 滑动窗口 👍 20 👎 0


package leetcode.editor.cn

import kotlin.math.min

/*** 3234
* 统计 1 显著的字符串的数量
*
* @author Gargantua7
* 2025-11-15 00:34:37
*/
class CountTheNumberOfSubstringsWithDominantOnes {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numberOfSubstrings(s: String): Int {
        val pre = s.runningFoldIndexed(-1) { index, prev, c ->
            if (index == 0 || s[index - 1] == '0') index else prev
        }

        var res = 0
        for (i in 1..s.length) {
            var cnt0 = if (s[i - 1] == '0') 1 else 0
            var j = i
            while (j > 0 && cnt0 * cnt0 <= s.length) {
                val cnt1 = (i - pre[j]) - cnt0
                if (cnt0 * cnt0 <= cnt1) {
                    res += min(j - pre[j], cnt1 - cnt0 * cnt0 + 1)
                }
                j = pre[j]
                cnt0++
            }
        }
        return res

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}