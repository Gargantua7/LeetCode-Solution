//给定一个字符串 s，请将 s 分割成一些子串，使每个子串都是回文串。 
//
// 返回符合要求的 最少分割次数 。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：1
//解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：s = "ab"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2000 
// s 仅由小写英文字母组成 
// 
// 
// 
//
// 
//
// 注意：本题与主站 132 题相同： https://leetcode-cn.com/problems/palindrome-partitioning-
//ii/ 
// Related Topics 字符串 动态规划 👍 5 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 剑指 Offer II 094
 * 最少回文分割
 *
 * @author Gargantua丶
 * 2021-10-29 13:17:37
 */
class OmKAoA {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun minCut(s: String): Int {
            val g = Array(s.length) { BooleanArray(s.length) { true } }
            for (i in s.indices.reversed()) {
                for (j in i + 1..s.lastIndex) {
                    g[i][j] = s[i] == s[j] && g[i + 1][j - 1]
                }
            }
            val f = IntArray(s.length) { Int.MAX_VALUE }
            for (i in g.indices) {
                if (g[0][i]) f[i] = 0
                else for (j in 0 until i) {
                    if (g[j + 1][i]) f[i] = minOf(f[i], f[j] + 1)
                }
            }
            return f.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}