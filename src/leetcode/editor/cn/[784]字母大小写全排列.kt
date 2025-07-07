//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
//
// Related Topics 位运算 字符串 回溯 👍 602 👎 0


package leetcode.editor.cn

/**
 * 784
 * 字母大小写全排列
 * 
 * @author Gargantua丶
 * 2025-07-07 16:08:42
 */
private class LetterCasePermutation {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun letterCasePermutation(s: String): List<String> {

        return (0..((1 shl s.length) - 1)).map { n ->
            buildString {
                s.forEachIndexed { i, c ->
                    if (((n shr i) and 1) == 1) {
                        append(c.uppercase())
                    } else {
                        append(c.lowercase())
                    }
                }
            }
        }.distinct()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}