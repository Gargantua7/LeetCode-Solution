//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 4 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 018
 * 有效的回文
 *
 * @author Gargantua丶
 * 2021-10-03 18:35:36
 */
class XltzEq { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            when {
                !s[left].isLetterOrDigit() -> left++
                !s[right].isLetterOrDigit() -> right--
                else -> {
                    val l = if (s[left].isUpperCase()) s[left].lowercaseChar() else s[left]
                    val r = if (s[right].isUpperCase()) s[right].lowercaseChar() else s[right]
                    if (l != r) return false
                    left++
                    right--
                }
            }
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}