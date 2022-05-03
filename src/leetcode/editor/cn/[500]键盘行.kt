//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 141 👎 0

package leetcode.editor.cn

/**
 * 500
 * 键盘行
 *
 * @author Gargantua丶
 * 2021-10-31 00:36:25
 */
class KeyboardRow {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findWords(words: Array<String>): Array<String> {
            val dic = "12210111011122000010020202"
            val ans = ArrayList<String>()
            words.forEach { word ->
                var flag = true
                for (i in 1..word.lastIndex) {
                    if (dic[word[i].toLowerCase() - 'a'] != dic[word[i - 1].toLowerCase() - 'a']) {
                        flag = false
                        break
                    }
                }
                if (flag) ans += word
            }
            val arr = Array(ans.size) { "" }
            return ans.toArray(arr)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}