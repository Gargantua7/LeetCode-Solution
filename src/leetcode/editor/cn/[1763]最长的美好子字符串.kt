//当一个字符串 s 包含的每一种字母的大写和小写形式 同时 出现在 s 中，就称这个字符串 s 是 美好 字符串。比方说，"abABB" 是美好字符串，因为 
//'A' 和 'a' 同时出现了，且 'B' 和 'b' 也同时出现了。然而，"abA" 不是美好字符串因为 'b' 出现了，而 'B' 没有出现。 
//
// 给你一个字符串 s ，请你返回 s 最长的 美好子字符串 。如果有多个答案，请你返回 最早 出现的一个。如果不存在美好子字符串，请你返回一个空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "YazaAay"
//输出："aAa"
//解释："aAa" 是一个美好字符串，因为这个子串中仅含一种字母，其小写形式 'a' 和大写形式 'A' 也同时出现了。
//"aAa" 是最长的美好子字符串。
// 
//
// 示例 2： 
//
// 
//输入：s = "Bb"
//输出："Bb"
//解释："Bb" 是美好字符串，因为 'B' 和 'b' 都出现了。整个字符串也是原字符串的子字符串。 
//
// 示例 3： 
//
// 
//输入：s = "c"
//输出：""
//解释：没有美好子字符串。 
//
// 示例 4： 
//
// 
//输入：s = "dDzeE"
//输出："dD"
//解释："dD" 和 "eE" 都是最长美好子字符串。
//由于有多个美好子字符串，返回 "dD" ，因为它出现得最早。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含大写和小写英文字母。 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 👍 43 👎 0

package leetcode.editor.cn

/**
 * 1763
 * 最长的美好子字符串
 * 
 * @author Gargantua丶
 * 2022-02-01 02:06:55
 */
class LongestNiceSubstring {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private var maxPos = 0
    private var maxLen = 0

    fun longestNiceSubstring(s: String): String? {
        maxPos = 0
        maxLen = 0
        var types = 0
        for (element in s) {
            types = types or (1 shl element.toLowerCase() - 'a')
        }
        types = Integer.bitCount(types)
        for (i in 1..types) {
            check(s, i)
        }
        return s.substring(maxPos, maxPos + maxLen)
    }

    fun check(s: String, typeNum: Int) {
        val lowerCnt = IntArray(26)
        val upperCnt = IntArray(26)
        var cnt = 0
        var l = 0
        var r = 0
        var total = 0
        while (r < s.length) {
            var idx = s[r].toLowerCase() - 'a'
            if (Character.isLowerCase(s[r])) {
                ++lowerCnt[idx]
                if (lowerCnt[idx] == 1 && upperCnt[idx] > 0) {
                    ++cnt
                }
            } else {
                ++upperCnt[idx]
                if (upperCnt[idx] == 1 && lowerCnt[idx] > 0) {
                    ++cnt
                }
            }
            total += if (lowerCnt[idx] + upperCnt[idx] == 1) 1 else 0
            while (total > typeNum) {
                idx = s[l].toLowerCase() - 'a'
                total -= if (lowerCnt[idx] + upperCnt[idx] == 1) 1 else 0
                if (Character.isLowerCase(s[l])) {
                    --lowerCnt[idx]
                    if (lowerCnt[idx] == 0 && upperCnt[idx] > 0) {
                        --cnt
                    }
                } else {
                    --upperCnt[idx]
                    if (upperCnt[idx] == 0 && lowerCnt[idx] > 0) {
                        --cnt
                    }
                }
                ++l
            }
            if (cnt == typeNum && r - l + 1 > maxLen) {
                maxPos = l
                maxLen = r - l + 1
            }
            ++r
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
