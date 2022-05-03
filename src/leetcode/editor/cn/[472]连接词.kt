//给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。 
//
// 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses",
//"rat","ratcatdogcat"]
//输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
//解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成; 
//     "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成; 
//     "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
// 
//
// 示例 2： 
//
// 
//输入：words = ["cat","dog","catdog"]
//输出：["catdog"] 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 0 <= words[i].length <= 1000 
// words[i] 仅由小写字母组成 
// 0 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics 深度优先搜索 字典树 数组 字符串 动态规划 👍 175 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 472
 * 连接词
 *
 * @author Gargantua丶
 * 2021-12-28 15:16:50
 */
class ConcatenatedWords {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Trie(val c: Char) {
            val children = Array<Trie?>(26) { null }
            var end = false
            operator fun get(i: Char) = children[i - 'a']
            operator fun set(i: Char, value: Trie) {
                children[i - 'a'] = value
            }

            override fun toString(): String {
                return "Trie(c=$c, end=$end, child=${children.count { it != null }})"
            }
        }

        val root = Trie(' ')

        fun add(word: String) {
//            println("add $word")
            var node = root
            word.forEach { c ->
                if (node[c] == null) node[c] = Trie(c)
                node = node[c]!!
            }
            node.end = true
        }

        fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
            val ans = ArrayList<String>()
            words.sortBy { it.length }
            words.forEach { word ->
                var node = root
                var i = 0
                val stack: Deque<Pair<Trie, Int>> = LinkedList()
                while (i < word.length) {
                    if (node.end) {
                        stack.push(node to i)
                        node = root
                    }
                    while ((node[word[i]] == null || (i == word.lastIndex && !node[word[i]]!!.end)) && stack.isNotEmpty()) {
                        val (n, j) = stack.pop()
                        node = n
                        i = j
                    }
//                    println("$word - ${word[i]} - ${node[word[i]]}")
                    node = node[word[i]]?: break
                    i++
                }
//                println("$word out in $i")
                if (i == word.length && node.end) {
                    ans.add(word)
                } else {
                    add(word)
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}