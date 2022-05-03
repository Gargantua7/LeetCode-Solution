//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 提示：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
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
// Related Topics 字符串 动态规划 👍 540 👎 0


package leetcode.editor.cn

/**
 * 97
 * 交错字符串
 *
 * @author Gargantua丶
 * 2021-09-13 15:26:47
 */
class InterleavingString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun isInterleave(s1: String, s2: String, s3: String): Boolean {
            if (s1.length + s2.length != s3.length) return false
            val dp = BooleanArray(s2.length + 1)
            dp[0] = true
            for (i in 0..s1.length) {
                for (j in dp.indices) {
                    if (i > 0) dp[j] = dp[j] && s1[i - 1] == s3[i + j - 1]
                    if (j > 0) dp[j] = dp[j] || (dp[j - 1] && s2[j - 1] == s3[i + j - 1])
                }
            }
            return dp.last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}