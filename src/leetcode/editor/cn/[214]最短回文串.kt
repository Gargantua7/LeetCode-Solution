//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 389 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 214
 * 最短回文串	
 *
 * @author Gargantua丶
 * 2021-11-15 19:04:56
 */
class ShortestPalindrome { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun shortestPalindrome(s: String): String {
        val n: Int = s.length
        val fail = IntArray(n)
        Arrays.fill(fail, -1)
        for (i in 1 until n) {
            var j = fail[i - 1]
            while (j != -1 && s[j + 1] != s[i]) {
                j = fail[j]
            }
            if (s[j + 1] == s[i]) {
                fail[i] = j + 1
            }
        }
        var best = -1
        for (i in n - 1 downTo 0) {
            while (best != -1 && s[best + 1] != s[i]) {
                best = fail[best]
            }
            if (s[best + 1] == s[i]) {
                ++best
            }
        }
        val add = if (best == n - 1) "" else s.substring(best + 1)
        val ans = StringBuffer(add).reverse()
        ans.append(s)
        return ans.toString()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}