//给你一个字符串数组 words 和一个字符串 target。 
//
// 如果字符串 x 是 words 中 任意 字符串的 前缀，则认为 x 是一个 有效 字符串。 
//
// 现计划通过 连接 有效字符串形成 target ，请你计算并返回需要连接的 最少 字符串数量。如果无法通过这种方式形成 target，则返回 -1。 
//
// 
//
// 示例 1： 
//
// 
// 输入： words = ["abc","aaaaa","bcdef"], target = "aabcdabc" 
// 
//
// 输出： 3 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[1] 的长度为 2 的前缀，即 "aa"。 
// words[2] 的长度为 3 的前缀，即 "bcd"。 
// words[0] 的长度为 3 的前缀，即 "abc"。 
// 
//
// 示例 2： 
//
// 
// 输入： words = ["abababab","ab"], target = "ababaababa" 
// 
//
// 输出： 2 
//
// 解释： 
//
// target 字符串可以通过连接以下有效字符串形成： 
//
// 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// words[0] 的长度为 5 的前缀，即 "ababa"。 
// 
//
// 示例 3： 
//
// 
// 输入： words = ["abcdef"], target = "xyz" 
// 
//
// 输出： -1 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 5 * 10⁴ 
// 输入确保 sum(words[i].length) <= 10⁵. 
// words[i] 只包含小写英文字母。 
// 1 <= target.length <= 5 * 10⁴ 
// target 只包含小写英文字母。 
// 
//
// Related Topics 线段树 数组 字符串 二分查找 动态规划 字符串匹配 哈希函数 滚动哈希 👍 30 👎 0


package leetcode.editor.cn

/**
 * 3292
 * 形成目标字符串需要的最少字符串数 II
 *
 * @author Gargantua丶
 * 2024-12-18 16:20:43
 */
private class MinimumNumberOfValidStringsToFormTargetIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minValidStrings(words: Array<String>, target: String): Int {

        val maxJump = IntArray(target.length)

        words.forEachIndexed { idx, word ->
            val s = "$word#$target"
            val z = IntArray(s.length)

            var zBoxLeft = 0
            var zBoxRight = 0

            z[0] = s.length

            for (i in 1..s.lastIndex) {
                if (i <= zBoxRight) {
                    z[i] = minOf(z[i - zBoxLeft], zBoxRight - i + 1)
                }

                while (i + z[i] < s.length && s[z[i]] == s[i + z[i]]) {
                    zBoxLeft = i
                    zBoxRight = i + z[i]
                    z[i]++
                }
            }

            for (i in target.indices) {
                maxJump[i] = maxOf(maxJump[i], z[i + word.length + 1])
            }
        }

        var res = 0
        var curr = 0
        var next = 0

        maxJump.forEachIndexed { i, jump ->
            next = maxOf(next, i + jump)
            if (i == curr) {
                if (i == next) return -1
                curr = next
                res++
            }
        }

        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}