//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 贪心 哈希表 字符串 👍 349 👎 0

package leetcode.editor.cn

import java.util.stream.Collectors

/**
 * 409
 * 最长回文串
 *
 * @author Gargantua丶
 * 2021-11-14 14:05:23
 */
class LongestPalindrome {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestPalindrome(s: String): Int {
        val count = HashMap<Char, Int>()
        s.forEach { count[it] = (count[it]?: 0) + 1 }
        return count.values.fold(0) { ans, n -> ans + n - (ans and 1) * (n and 1) }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    fun longestPalindrome(s: String): Int {
        return s.chars().boxed()
            .collect(Collectors.toMap<Int, Char, Int>({ k -> k.toChar() }, { 1 }, Integer::sum))
            .values.fold(0) { ans, n -> ans + n - (ans and 1) * (n and 1) }
    }

}