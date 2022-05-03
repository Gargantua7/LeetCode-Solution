//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 
// 
// Related Topics 双指针 字符串 
// 👍 170 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 345
 * 反转字符串中的元音字母
 *
 * @author Gargantua丶
 * 2021-08-19 00:48:48
 */
class ReverseVowelsOfAString { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reverseVowels(s: String): String {
        val arr = s.toCharArray()
        val vowel = arrayOf('a', 'i', 'u', 'e', 'o', 'A', 'I', 'U', 'E', 'O')
        var left = 0
        var right = arr.lastIndex
        while (left < right) {
            if (arr[left] in vowel && arr[right] in vowel) {
                val temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
                left++
                right--
                continue
            }
            if (arr[left] !in vowel) left++
            if (arr[right] !in vowel) right--
        }
        return String(arr)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}