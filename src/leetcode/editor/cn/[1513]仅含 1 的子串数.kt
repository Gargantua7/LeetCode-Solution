//给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。 
//
// 返回所有字符都为 1 的子字符串的数目。 
//
// 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。 
//
// 
//
// 示例 1： 
//
// 输入：s = "0110111"
//输出：9
//解释：共有 9 个子字符串仅由 '1' 组成
//"1" -> 5 次
//"11" -> 3 次
//"111" -> 1 次 
//
// 示例 2： 
//
// 输入：s = "101"
//输出：2
//解释：子字符串 "1" 在 s 中共出现 2 次
// 
//
// 示例 3： 
//
// 输入：s = "111111"
//输出：21
//解释：每个子字符串都仅由 '1' 组成
// 
//
// 示例 4： 
//
// 输入：s = "000"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// s[i] == '0' 或 s[i] == '1' 
// 1 <= s.length <= 10^5 
// 
//
// Related Topics 数学 字符串 👍 35 👎 0


package leetcode.editor.cn

import kotlin.math.max

/*** 1513
* 仅含 1 的子串数
*
* @author Gargantua7
* 2025-11-16 03:44:44
*/
class NumberOfSubstringsWithOnly1s {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    companion object {
        const val MOD = 1_000_000_007
    }

    fun numSub(s: String): Int {
        var ans = 0L
        var count = 0L
        s.forEachIndexed { i, c ->
            if (c == '1') count++

            if ((c == '0' || i == s.lastIndex) && count > 0) {
                ans += (1 + count) * count / 2
                ans %= MOD
                count = 0
            }
        }

        return ans.toInt()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}