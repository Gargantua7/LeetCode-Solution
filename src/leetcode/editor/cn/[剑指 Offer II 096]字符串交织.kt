//给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。 
//
// 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 97 题相同： https://leetcode-cn.com/problems/interleaving-string/ 
// Related Topics 字符串 动态规划 👍 3 👎 0

package leetcode.editor.cn

/**
 * 剑指 Offer II 096
 * 字符串交织
 *
 * @author Gargantua丶
 * 2021-10-29 13:58:52
 */
class IY6buf {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            if (s1.length + s2.length != s3.length) return false
            val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }
            dp[0][0] = true
            for (i in dp.indices) {
                for (j in dp[0].indices) {
                    val sum = i + j - 1
                    if (i > 0) dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1[i - 1] == s3[sum])
                    if (j > 0) dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2[j - 1] == s3[sum])
                }
            }
            return dp.last().last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}