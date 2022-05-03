//给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。 
//
// 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
//输出："apple"
// 
//
// 示例 2： 
//
// 
//输入：s = "abpcplea", dictionary = ["a","b","c"]
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// 1 <= dictionary.length <= 1000 
// 1 <= dictionary[i].length <= 1000 
// s 和 dictionary[i] 仅由小写英文字母组成 
// 
// Related Topics 数组 双指针 字符串 排序 👍 163 👎 0


package leetcode.editor.cn
/**
 * 524
 * 通过删除字母匹配到字典里最长单词
 *
 * @author Gargantua丶
 * 2021-09-14 00:04:02
 */
class LongestWordInDictionaryThroughDeleting { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        dictionary.sortedWith { a, b ->
            if (a.length != b.length) b.length - a.length
            else a.compareTo(b)
        }.forEach { str ->
            var index = 0
            s.forEach { c ->
                if (c == str[index] && index++ == str.lastIndex) return str
            }
        }
        return ""
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}