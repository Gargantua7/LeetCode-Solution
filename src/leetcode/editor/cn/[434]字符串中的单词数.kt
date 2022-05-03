//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 👍 98 👎 0


package leetcode.editor.cn

/**
 * 434
 * 字符串中的单词数
 *
 * @author Gargantua丶
 * 2021-10-07 00:01:35
 */
class NumberOfSegmentsInAString {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun countSegments(s: String): Int {
            return s.foldIndexed(0) { i, ans, c -> ans + if (c != ' ' && (i == 0 || s[i - 1] == ' ')) 1 else 0 }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}