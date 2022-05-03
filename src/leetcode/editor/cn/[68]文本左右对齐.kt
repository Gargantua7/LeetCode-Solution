//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to",
//"explain",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 👍 152 👎 0


package leetcode.editor.cn


/**
 * 68
 * 文本左右对齐
 *
 * @author Gargantua丶
 * 2021-09-09 00:13:37
 */
class TextJustification { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val ans = ArrayList<String>()
        var i = 0
        var j = 0
        var length = 0
        while (i < words.size) {
            if (length + words[i].length > maxWidth) {
                length -= (i - j)
                var sub = maxWidth - length
                ans += buildString {
                    if (i - 1 == j) {
                        append(words[j])
                        for (k in 1..sub) append(' ')
                        j++
                    } else while (j < i) {
                        append(words[j])
                        if (j < i - 1) {
                            val space = kotlin.math.ceil(sub.toDouble() / (i - j - 1)).toInt()
                            for (k in 1..space) append(' ')
                            sub -= space
                        }
                        j++
                    }
                }
                length = 0
            } else {
                length += words[i].length + 1
                i++
            }
        }
        if (j < i) {
            ans += buildString {
                while (j < i) {
                    append(words[j])
                    if (j < i - 1) {
                        append(' ')
                    } else {
                        val space = maxWidth - count()
                        for (k in 1..space) append(' ')
                    }
                    j++
                }
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}