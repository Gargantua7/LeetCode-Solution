//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 5 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 剑指 Offer II 114
 * 外星文字典	
 *
 * @author Gargantua丶
 * 2021-11-05 12:44:08
 */
class Jf1JuT { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun alienOrder(words: Array<String>): String? {
        val graph: MutableMap<Char, MutableSet<Char>> = HashMap()
        val inDegree = IntArray(26)
        val q: Queue<Char> = LinkedList()
        val sb = StringBuilder()
        //把出现的字符保存在图HashMap里，每个不重复字符对应一个表示有序的有向边
        for (word in words) {
            for (ch in word.toCharArray()) {
                graph.putIfAbsent(ch, HashSet())
            }
        }
        //两两比较相邻字符串之间的关系
        for (i in 1 until words.size) {
            val w1 = words[i - 1]
            val w2 = words[i]
            if (checkPre(w1, w2) && w1 != w2) return "" //检查为不合法输入
            for (j in 0 until Math.min(w1.length, w2.length)) {
                val c1 = w1[j]
                val c2 = w2[j]
                //找到不同的字符才说明有顺序关系，把前一个字符指向后一字符，同时后一字符的入度+1
                if (c1 != c2) {
                    if (!graph[c1]!!.contains(c2)) {
                        graph[c1]!!.add(c2)
                        inDegree[c2 - 'a']++
                    }
                    break
                }
            }
        }
        //把所有入度为0的字符先加入队列，准备拓扑排序
        for (ch in graph.keys) {
            if (inDegree[ch - 'a'] == 0) q.offer(ch)
        }
        while (!q.isEmpty()) {
            val node = q.poll()
            //从队列出来的这个字符肯定是入度为0，可以确定它的顺序，就把它加进字符顺序的结果里
            sb.append(node)
            //取出当前出来的节点以后，该节点所有的出度(有向边指向所有节点的节点入度)都要减1，若有入度为0的节点字符出现，把它加进队列准备之后的拓扑排序遍历
            for (next in graph[node]!!) {
                inDegree[next - 'a']--
                if (inDegree[next - 'a'] == 0) q.offer(next)
            }
        }
        //如果结果集里的字符数量和图中所有节点数量相同，说明拓扑排序成功，返回结果集，否则不成功，不存在合法字母顺序
        return if (sb.length == graph.size) sb.toString() else ""
    }

    fun checkPre(s1: String, s2: String): Boolean {
        val m = s1.length
        val n = s2.length
        if (m < n) return false
        var i = 0
        var j = 0
        while (i < m && j < n) {
            if (s2[j] != s1[i]) return false
            i++
            j++
        }
        return true
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}