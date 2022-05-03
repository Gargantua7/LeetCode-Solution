//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3885 👎 0


package leetcode.editor.cn

import jdk.internal.org.jline.utils.Colors


/**
 * 5
 * 最长回文子串
 *
 * @author Gargantua丶
 * 2021-07-31 00:19:50
 */
class LongestPalindromicSubstring {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun longestPalindrome(s: String): String {
            val len: Int = s.length
            if (len < 2) {
                return s
            }

            var maxLen = 1
            var begin = 0
            // dp[i][j] 表示 s[i..j] 是否是回文串
            // dp[i][j] 表示 s[i..j] 是否是回文串
            val dp = Array(len) { BooleanArray(len) }
            // 初始化：所有长度为 1 的子串都是回文串
            // 初始化：所有长度为 1 的子串都是回文串
            for (i in 0 until len) {
                dp[i][i] = true
            }

            val charArray = s.toCharArray()
            // 递推开始
            // 先枚举子串长度
            // 递推开始
            // 先枚举子串长度
            for (L in 2..len) {
                // 枚举左边界，左边界的上限设置可以宽松一些
                for (i in 0 until len) {
                    // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                    val j = L + i - 1
                    // 如果右边界越界，就可以退出当前循环
                    if (j >= len) {
                        break
                    }
                    if (charArray[i] != charArray[j]) {
                        dp[i][j] = false
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true
                        } else {
                            dp[i][j] = dp[i + 1][j - 1]
                        }
                    }

                    // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1
                        begin = i
                    }
                }
            }
            return s.substring(begin, begin + maxLen)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}