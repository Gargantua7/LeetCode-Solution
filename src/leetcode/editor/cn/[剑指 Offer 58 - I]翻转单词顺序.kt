//输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，
//则输出"student. a am I"。 
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/ 
//
//
// 注意：此题对比原题有改动 
// Related Topics 双指针 字符串 
// 👍 123 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 58 - I
 * 翻转单词顺序
 *
 * @author Gargantua丶
 * 2021-08-11 01:10:15
 */
class FanZhuanDanCiShunXuLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun reverseWords(s: String): String {
            val sb = StringBuilder()
            val ch = s.trim().split(" ")
            for (i in ch.lastIndex downTo 0) {
                if(ch[i] == "") continue
                sb.append(ch[i])
                if (i > 0) sb.append(" ")
            }
            return sb.toString()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}