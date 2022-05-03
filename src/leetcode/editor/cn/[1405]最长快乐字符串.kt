//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 62 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 1405
 * 最长快乐字符串
 * 
 * @author Gargantua丶
 * 2022-02-07 00:23:57
 */
class LongestHappyString {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        val res = StringBuilder()
        val arr = arrayOf(Pair(a, 'a'), Pair(b, 'b'), Pair(c, 'c'))
        while (true) {
            Arrays.sort(arr) { p1: Pair, p2: Pair -> p2.freq - p1.freq }
            var hasNext = false
            for (pair in arr) {
                if (pair.freq <= 0) {
                    break
                }
                val m = res.length
                if (m >= 2 && res[m - 2] == pair.ch && res[m - 1] == pair.ch) {
                    continue
                }
                hasNext = true
                res.append(pair.ch)
                pair.freq--
                break
            }
            if (!hasNext) {
                break
            }
        }
        return res.toString()
    }

    internal class Pair(var freq: Int, var ch: Char)
}
//leetcode submit region end(Prohibit modification and deletion)

}
