//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 👍 126 👎 0

package leetcode.editor.cn

/**
 * 423
 * 从英文中重建数字
 * 
 * @author Gargantua丶
 * 2021-11-24 13:48:07
 */
class ReconstructOriginalDigitsFromEnglish {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val target = arrayOf("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine")

    val ch = charArrayOf('z', 'w', 'u', 'o', 'f', 'x', 'v', 'g', 't', 'e')

    val num = intArrayOf(0, 2, 4, 1, 5, 6, 7, 8, 3, 9)

    fun originalDigits(s: String): String {
        val count = IntArray(26)
        val ans = ArrayList<Int>()
        for (c in s) {
            count[c - 'a']++
        }
        for (i in 0..9) {
            val n = count[ch[i] - 'a']
            for (j in 0 until n) {
                ans.add(num[i])
            }
            for (j in target[num[i]]) {
                count[j - 'a'] -= n
            }
        }
        ans.sort()
        return buildString {
            ans.forEach { append(it) }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}