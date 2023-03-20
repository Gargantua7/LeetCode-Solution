//给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 20
//输出：1
//解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
// 
//
// 示例 2： 
//
// 
//输入：n = 100
//输出：10
//解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
// 
//
// 示例 3： 
//
// 
//输入：n = 1000
//输出：262
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数学 动态规划 👍 234 👎 0


package leetcode.editor.cn

/**
 * 1012
 * 至少有 1 位重复的数字
 *
 * @author Gargantua丶
 * 2023-03-20 22:47:43
 */
class NumbersWithRepeatedDigits {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numDupDigitsAtMostN(n: Int): Int {
        val s = n.toString()
        var sum = 0

        repeat(s.lastIndex) { len ->
            var temp = 9
            repeat(len) { bit ->
                temp *= 9 - bit
            }
            sum += temp
        }

        for (i in s.indices) {
            val prefix = s.substring(0, i)
            val set = prefix.toSet()
            if (set.size != i) break

            var temp = s[i] - '0'
            repeat(temp) {
                if ((i == 0 && it == 0) || ('0' + it) in set) {
                    temp--
                }
            }

            if (temp < 0) continue

            repeat(s.lastIndex - i) { bit ->
                temp *= 9 - bit - i
            }
            sum += temp
        }

        if (s.toSet().size == s.length) sum++

        return n - sum
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}