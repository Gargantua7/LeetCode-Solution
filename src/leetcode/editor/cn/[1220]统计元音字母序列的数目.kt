//给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串： 
//
// 
// 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'） 
// 每个元音 'a' 后面都只能跟着 'e' 
// 每个元音 'e' 后面只能跟着 'a' 或者是 'i' 
// 每个元音 'i' 后面 不能 再跟着另一个 'i' 
// 每个元音 'o' 后面只能跟着 'i' 或者是 'u' 
// 每个元音 'u' 后面只能跟着 'a' 
// 
//
// 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：5
//解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：10
//解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
// 
//
// 示例 3： 
//
// 输入：n = 5
//输出：68 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10^4 
// 
// Related Topics 动态规划 👍 109 👎 0

package leetcode.editor.cn

/**
 * 1220
 * 统计元音字母序列的数目
 *
 * @author Gargantua丶
 * 2022-01-17 18:22:47
 */
class CountVowelsPermutation {
    //leetcode submit region begin(Prohibit modification and deletion)
    //      a  e  i  o  u
    // a -> -  e
    // e -> a  -  i
    // i -> a  e  -  o  u
    // o ->       i  -  u
    // u -> a           -

    class Solution {
        fun countVowelPermutation(n: Int): Int {
            val idx = n - 1
            val map = arrayOf(
                longArrayOf(0, 1, 0, 0, 0),
                longArrayOf(1, 0, 1, 0, 0),
                longArrayOf(1, 1, 0, 1, 1),
                longArrayOf(0, 0, 1, 0, 1),
                longArrayOf(1, 0, 0, 0, 0)
            )
            val init = arrayOf(longArrayOf(1, 1, 1, 1, 1))
            var res = 0
            (init * (map pow idx)).forEach { rows ->
                rows.forEach {
                    res += it.toInt()
                    res %= 1000000007
                }
            }
            return res
        }

        operator fun Array<LongArray>.times(other: Array<LongArray>): Array<LongArray> {
            val res = Array(size) { LongArray(this[0].size) }
            for (i in res.indices) {
                for (j in res[0].indices) {
                    for (k in res[0].indices) {
                        res[i][j] += (this[i][k] * other[k][j]) % 1000000007L
                        res[i][j] %= 1000000007L
                    }
                }
            }
            return res
        }

        infix fun Array<LongArray>.pow(index: Int): Array<LongArray> {
            var res = Array(size) { LongArray(this[0].size) }
            var curr = this.copyOf()
            var idx = index
            for (i in res.indices) res[i][i] = 1
            while (idx > 0) {
                if (idx and 1 == 1)
                    res *= curr
                curr *= curr
                idx = idx shr 1
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


    fun countVowelPermutation(n: Int): Int {
        val mod = 1000000007L
        return (1 until n).fold(LongArray(5) { 1L }) { prev, _ ->
            longArrayOf(
                (prev[1] + prev[2] + prev[4]) % mod,
                (prev[0] + prev[2]) % mod,
                (prev[1] + prev[3]) % mod,
                prev[2] % mod,
                (prev[2] + prev[3]) % mod
            )
        }.fold(0L) { prev, i -> (prev + i) % mod }.toInt()
    }

}
