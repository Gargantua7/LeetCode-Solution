//给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返
//回答案中字典序最小的单词。 
//
// 若无答案，则返回空字符串。 
//
// 
//
// 示例 1： 
//
// 输入：
//words = ["w","wo","wor","worl", "world"]
//输出："world"
//解释： 
//单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
// 
//
// 示例 2： 
//
// 输入：
//words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出："apple"
//解释：
//"apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
// 
//
// 
//
// 提示： 
//
// 
// 所有输入的字符串都只包含小写字母。 
// words数组长度范围为[1,1000]。 
// words[i]的长度范围为[1,30]。 
// 
// Related Topics 字典树 数组 哈希表 字符串 排序 👍 156 👎 0


package leetcode.editor.cn

import java.util.*


/**
 * 720
 * 词典中最长的单词
 *
 * @author Gargantua丶
 * 2021-09-13 15:15:37
 */
class LongestWordInDictionary { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun longestWord(words: Array<String>): String {
        val trie = Trie(words)
        for ((index, word) in words.withIndex()) {
            trie.insert(word, index + 1) //indexed by 1
        }
        return trie.dfs()
    }
}

    class Node(var c: Char) {

        var children = HashMap<Char, Node>()
        var end = 0
    }

    class Trie(var words: Array<String>) {

        var root: Node = Node('0')

        fun insert(word: String, index: Int) {
            var cur: Node? = root
            for (c in word.toCharArray()) {
                cur!!.children.putIfAbsent(c, Node(c))
                cur = cur.children[c]
            }
            cur!!.end = index
        }

        fun dfs(): String {
            var ans = ""
            val stack: Deque<Node> = LinkedList()
            stack.push(root)
            while (stack.isNotEmpty()) {
                val node = stack.pop()
                if (node!!.end > 0 || node === root) {
                    if (node !== root) {
                        val word = words[node.end - 1]
                        if (word.length > ans.length ||
                            word.length == ans.length && word < ans
                        ) {
                            ans = word
                        }
                    }
                    for (nei in node.children.values) {
                        stack.push(nei)
                    }
                }
            }
            return ans
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}