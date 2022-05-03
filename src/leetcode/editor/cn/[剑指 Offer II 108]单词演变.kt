//在字典（单词列表） wordList 中，从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给定两个长度相同但内容不同的单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 
//的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// 
//
// 注意：本题与主站 127 题相同： https://leetcode-cn.com/problems/word-ladder/ 
// Related Topics 广度优先搜索 哈希表 字符串 👍 1 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 剑指 Offer II 108
 * 单词演变	
 *
 * @author Gargantua丶
 * 2021-11-03 14:27:49
 */
class Om3reC { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var wordId: MutableMap<String, Int> = HashMap()
    var edge: MutableList<MutableList<Int>> = ArrayList()
    var nodeNum = 0

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        for (word in wordList) {
            addEdge(word)
        }
        addEdge(beginWord)
        if (!wordId.containsKey(endWord)) {
            return 0
        }
        val disBegin = IntArray(nodeNum)
        Arrays.fill(disBegin, Int.MAX_VALUE)
        val beginId = wordId[beginWord]!!
        disBegin[beginId] = 0
        val queBegin: Queue<Int> = LinkedList()
        queBegin.offer(beginId)
        val disEnd = IntArray(nodeNum)
        Arrays.fill(disEnd, Int.MAX_VALUE)
        val endId = wordId[endWord]!!
        disEnd[endId] = 0
        val queEnd: Queue<Int> = LinkedList()
        queEnd.offer(endId)
        while (!queBegin.isEmpty() && !queEnd.isEmpty()) {
            val queBeginSize = queBegin.size
            for (i in 0 until queBeginSize) {
                val nodeBegin = queBegin.poll()
                if (disEnd[nodeBegin] != Int.MAX_VALUE) {
                    return (disBegin[nodeBegin] + disEnd[nodeBegin]) / 2 + 1
                }
                for (it in edge[nodeBegin]) {
                    if (disBegin[it] == Int.MAX_VALUE) {
                        disBegin[it] = disBegin[nodeBegin] + 1
                        queBegin.offer(it)
                    }
                }
            }
            val queEndSize = queEnd.size
            for (i in 0 until queEndSize) {
                val nodeEnd = queEnd.poll()
                if (disBegin[nodeEnd] != Int.MAX_VALUE) {
                    return (disBegin[nodeEnd] + disEnd[nodeEnd]) / 2 + 1
                }
                for (it in edge[nodeEnd]) {
                    if (disEnd[it] == Int.MAX_VALUE) {
                        disEnd[it] = disEnd[nodeEnd] + 1
                        queEnd.offer(it)
                    }
                }
            }
        }
        return 0
    }

    fun addEdge(word: String) {
        addWord(word)
        val id1 = wordId[word]!!
        val array = word.toCharArray()
        val length = array.size
        for (i in 0 until length) {
            val tmp = array[i]
            array[i] = '*'
            val newWord = String(array)
            addWord(newWord)
            val id2 = wordId[newWord]!!
            edge[id1].add(id2)
            edge[id2].add(id1)
            array[i] = tmp
        }
    }

    fun addWord(word: String) {
        if (!wordId.containsKey(word)) {
            wordId[word] = nodeNum++
            edge.add(ArrayList())
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}