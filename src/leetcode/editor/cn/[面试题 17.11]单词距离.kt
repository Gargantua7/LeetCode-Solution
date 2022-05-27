//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 61 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 面试题 17.11
 * 单词距离
 * 
 * @author Gargantua丶
 * 2022-05-27 11:46:57
 */
class FindClosestLcci {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun findClosest(words: Array<String>, word1: String, word2: String): Int {
        var start = -10000
        var end = 10000
        var min = 10000
        for (i in words.indices) {
            if (words[i] == word1) {
                start = i
            }
            if (words[i] == word2) {
                end = i
            }
            min = Math.min(min, Math.abs(end - start))
        }
        return min
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
