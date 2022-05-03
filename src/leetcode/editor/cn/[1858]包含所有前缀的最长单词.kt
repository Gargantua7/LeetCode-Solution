//给定一个字符串数组 words，找出 words 中所有的前缀都在 words 中的最长字符串。 
//
// 
// 例如，令 words = ["a", "app", "ap"]。字符串 "app" 含前缀 "ap" 和 "a" ，都在 words 中。 
// 
//
// 返回符合上述要求的字符串。如果存在多个（符合条件的）相同长度的字符串，返回字典序中最小的字符串，如果这样的字符串不存在，返回 ""。 
//
// 
//
// 示例 1: 
//
// 输入： words = ["k","ki","kir","kira", "kiran"]
//输出： "kiran"
//解释： "kiran" 含前缀 "kira"、 "kir"、 "ki"、 和 "k"，这些前缀都出现在 words 中。
// 
//
// 示例 2: 
//
// 输入： words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
//输出： "apple"
//解释： "apple" 和 "apply" 都在 words 中含有各自的所有前缀。
//然而，"apple" 在字典序中更小，所以我们返回之。
// 
//
// 示例 3: 
//
// 输入： words = ["abc", "bc", "ab", "qwe"]
//输出： ""
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁵ 
// 1 <= words[i].length <= 10⁵ 
// 1 <= sum(words[i].length) <= 10⁵ 
// 
// Related Topics 深度优先搜索 字典树 👍 6 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 1858
 * 包含所有前缀的最长单词
 *
 * @author Gargantua丶
 * 2021-12-06 13:48:17
 */
class LongestWordWithAllPrefixes {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val root = TrieNode('0')

    class TrieNode(val c: Char) {
        var end = false
        val children = Array<TrieNode?>(26) { null }
    }

    fun insert(word: String) {
        var temp = root
        word.forEach { c ->
            if(temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = TrieNode(c)
            }
            temp = temp.children[c - 'a']!!
        }
        temp.end = true
    }

    fun dfs(node: TrieNode, sb: StringBuilder, ans: Queue<String>) {
        ans.offer(sb.toString())
        node.children.forEachIndexed { i, child ->
            child?.let {
                if (it.end) {
                    sb.append('a' + i)
                    dfs(it, sb, ans)
                    sb.deleteCharAt(sb.lastIndex)
                }
            }
        }
    }

    fun longestWord(words: Array<String>): String {
        words.forEach { word -> insert(word) }
        val ans = PriorityQueue<String> { a, b ->
            if (a.length != b.length) b.length - a.length
            else a.compareTo(b)
        }
        buildString { dfs(root, this, ans) }
        return ans.peek()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}