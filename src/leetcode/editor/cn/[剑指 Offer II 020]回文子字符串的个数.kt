//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 7 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 020
 * 回文子字符串的个数
 *
 * @author Gargantua丶
 * 2021-10-03 19:03:54
 */
class A7VOhD {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun countSubstrings(s: String): Int {
            val dp = Array(s.length) { BooleanArray(it + 1) }
            var ans = 0
            for (i in 0..s.lastIndex) {
                for (j in 0..i) {
                    if (s[i] == s[j]) {
                        dp[i][j] = if (i - j <= 1) true else dp[i - 1][j + 1]
                        if (dp[i][j]) ans++
                    }
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}