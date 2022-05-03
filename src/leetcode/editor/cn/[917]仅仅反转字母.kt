//给你一个字符串 s ，根据下述规则反转字符串： 
//
// 
// 所有非英文字母保留在原有位置。 
// 所有英文字母（小写或大写）位置反转。 
// 
//
// 返回反转后的 s 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：s = "ab-cd"
//输出："dc-ba"
// 
//
// 
// 
//
// 示例 2： 
//
// 
//输入：s = "a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 
// 
//
// 示例 3： 
//
// 
//输入：s = "Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示 
//
// 
// 1 <= s.length <= 100 
// s 仅由 ASCII 值在范围 [33, 122] 的字符组成 
// s 不含 '\"' 或 '\\' 
// 
// Related Topics 双指针 字符串 👍 106 👎 0

package leetcode.editor.cn

/**
 * 917
 * 仅仅反转字母
 * 
 * @author Gargantua丶
 * 2022-02-23 01:32:10
 */
class ReverseOnlyLetters {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseOnlyLetters(s: String): String {
        val arr = s.toCharArray()
        var l = 0
        var r = arr.lastIndex
        while (l < r) {
            when {
                !arr[l].isLetter() -> l++
                !arr[r].isLetter() -> r--
                else -> arr.swap(l++, r--)
            }
        }
        return String(arr)
    }

    fun CharArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
