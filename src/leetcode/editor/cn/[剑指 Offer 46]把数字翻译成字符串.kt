//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 279 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 46
 * 把数字翻译成字符串
 *
 * @author Gargantua丶
 * 2021-09-06 13:27:27
 */
class BaShuZiFanYiChengZiFuChuanLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun translateNum(num: Int): Int {
        val s = num.toString()
        if (s.length < 2) return 1
        val dp = IntArray(s.length)
        dp[0] = 1
        dp[1] = if ("${s[0]}${s[1]}".toInt() in 10..25) 2 else 1
        for (i in 2..s.lastIndex) {
            dp[i] = dp[i - 1] + if ("${s[i - 1]}${s[i]}".toInt() in 10..25) dp[i - 2] else 0
        }
        return dp.last()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}