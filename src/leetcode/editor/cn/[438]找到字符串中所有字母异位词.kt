//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 679 👎 0

package leetcode.editor.cn

/**
 * 438
 * 找到字符串中所有字母异位词
 * 
 * @author Gargantua丶
 * 2021-11-28 12:10:15
 */
class FindAllAnagramsInAString {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {
        val ans = ArrayList<Int>()
        val count = IntArray(26)
        val temp = IntArray(26)
        for (i in p.indices) {
            count[p[i] - 'a']++
        }
        for (i in s.indices) {
            temp[s[i] - 'a']++
            if (i > p.lastIndex) temp[s[i - p.length] - 'a']--
            if (count.contentEquals(temp)) {
                ans.add(i - p.lastIndex)
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}