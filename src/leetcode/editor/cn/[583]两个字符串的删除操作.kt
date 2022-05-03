//给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。 
//
// 
//
// 示例： 
//
// 输入: "sea", "eat"
//输出: 2
//解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
// 
//
// 
//
// 提示： 
//
// 
// 给定单词的长度不超过500。 
// 给定单词中的字符只含有小写字母。 
// 
// Related Topics 字符串 动态规划 👍 235 👎 0


package leetcode.editor.cn

/**
 * 583
 * 两个字符串的删除操作
 *
 * @author Gargantua丶
 * 2021-09-25 00:16:46
 */
class DeleteOperationForTwoStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun minDistance(word1: String, word2: String): Int {
            val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
            for (i in dp.indices) dp[i][0] = i
            for (i in dp[0].indices) dp[0][i] = i
            for (i in 1..dp.lastIndex) {
                for (j in 1..dp[0].lastIndex) {
                    dp[i][j] = if (word1[i - 1] == word2[j - 1]) dp[i - 1][j - 1]
                    else minOf(dp[i - 1][j], dp[i][j - 1]) + 1
                }
            }
            return dp.last().last()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}