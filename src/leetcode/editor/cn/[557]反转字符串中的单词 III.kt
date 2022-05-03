//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 313 👎 0


package leetcode.editor.cn

/**
 * 557
 * 反转字符串中的单词 III
 *
 * @author Gargantua丶
 * 2021-08-15 01:21:46
 */
class ReverseWordsInAStringIii {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun reverseWords(s: String): String {
            return buildString {
                s.split(" ").forEach { str ->
                    append(str.reversed())
                    append(" ")
                }
                deleteCharAt(count() - 1)
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}