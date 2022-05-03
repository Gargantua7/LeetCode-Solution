//给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["abcd","dcba","lls","s","sssll"]
//输出：[[0,1],[1,0],[3,2],[2,4]] 
//解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["bat","tab","cat"]
//输出：[[0,1],[1,0]] 
//解释：可拼接成的回文串为 ["battab","tabbat"] 
//
// 示例 3： 
//
// 
//输入：words = ["a",""]
//输出：[[0,1],[1,0]]
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 5000 
// 0 <= words[i].length <= 300 
// words[i] 由小写英文字母组成 
// 
// Related Topics 字典树 数组 哈希表 字符串 👍 273 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 336
 * 回文对
 * 
 * @author Gargantua丶
 * 2021-12-06 15:21:26
 */
class PalindromePairs {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var wordsRev: MutableList<String> = ArrayList()
    var indices: MutableMap<String, Int> = HashMap()

    fun palindromePairs(words: Array<String>): List<List<Int>>? {
        val n = words.size
        for (word in words) {
            wordsRev.add(StringBuffer(word).reverse().toString())
        }
        for (i in 0 until n) {
            indices[wordsRev[i]] = i
        }
        val ret: MutableList<List<Int>> = ArrayList()
        for (i in 0 until n) {
            val word = words[i]
            val m = words[i].length
            if (m == 0) {
                continue
            }
            for (j in 0..m) {
                if (isPalindrome(word, j, m - 1)) {
                    val leftId = findWord(word, 0, j - 1)
                    if (leftId != -1 && leftId != i) {
                        ret.add(listOf(i, leftId))
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    val rightId = findWord(word, j, m - 1)
                    if (rightId != -1 && rightId != i) {
                        ret.add(listOf(rightId, i))
                    }
                }
            }
        }
        return ret
    }

    fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        val len = right - left + 1
        for (i in 0 until len / 2) {
            if (s[left + i] != s[right - i]) {
                return false
            }
        }
        return true
    }

    fun findWord(s: String, left: Int, right: Int): Int {
        return indices.getOrDefault(s.substring(left, right + 1), -1)
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}