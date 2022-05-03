//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 6 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 014
 * 字符串中的变位词
 *
 * @author Gargantua丶
 * 2021-10-02 19:53:14
 */
class MPnaiL { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s2.length < s1.length) return false
        val count = IntArray(26)
        val temp = IntArray(26)
        for (i in s1.indices) {
            count[s1[i] - 'a']++
            temp[s2[i] - 'a']++
        }
        for (i in s1.length..s2.lastIndex) {
            if (count.contentEquals(temp)) return true
            temp[s2[i - s1.length] - 'a']--
            temp[s2[i] - 'a']++
        }
        return count.contentEquals(temp)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}