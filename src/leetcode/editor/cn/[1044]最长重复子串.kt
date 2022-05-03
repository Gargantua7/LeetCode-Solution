//给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。 
//
// 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "banana"
//输出："ana"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出：""
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 3 * 10⁴ 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 二分查找 后缀数组 滑动窗口 哈希函数 滚动哈希 👍 260 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.HashSet


/**
 * 1044
 * 最长重复子串
 * 
 * @author Gargantua丶
 * 2021-12-23 21:25:46
 */
class LongestDuplicateSubstring {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestDupSubstring(s: String): String? {
        val random = Random()
        // 生成两个进制
        val a1: Int = random.nextInt(75) + 26
        val a2: Int = random.nextInt(75) + 26
        // 生成两个模
        val mod1: Int = random.nextInt(Int.MAX_VALUE - 1000000007 + 1) + 1000000007
        val mod2: Int = random.nextInt(Int.MAX_VALUE - 1000000007 + 1) + 1000000007
        val n = s.length
        // 先对所有字符进行编码
        val arr = IntArray(n)
        for (i in 0 until n) {
            arr[i] = s[i] - 'a'
        }
        // 二分查找的范围是[1, n-1]
        var l = 1
        var r = n - 1
        var length = 0
        var start = -1
        while (l <= r) {
            val m = l + (r - l + 1) / 2
            val idx = check(arr, m, a1, a2, mod1, mod2)
            if (idx != -1) {
                // 有重复子串，移动左边界
                l = m + 1
                length = m
                start = idx
            } else {
                // 无重复子串，移动右边界
                r = m - 1
            }
        }
        return if (start != -1) s.substring(start, start + length) else ""
    }

    fun check(arr: IntArray, m: Int, a1: Int, a2: Int, mod1: Int, mod2: Int): Int {
        val n = arr.size
        val aL1 = pow(a1, m, mod1)
        val aL2 = pow(a2, m, mod2)
        var h1: Long = 0
        var h2: Long = 0
        for (i in 0 until m) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2
            if (h1 < 0) {
                h1 += mod1.toLong()
            }
            if (h2 < 0) {
                h2 += mod2.toLong()
            }
        }
        // 存储一个编码组合是否出现过
        val seen: MutableSet<Long> = HashSet()
        seen.add(h1 * mod2 + h2)
        for (start in 1..n - m) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2
            if (h1 < 0) {
                h1 += mod1.toLong()
            }
            if (h2 < 0) {
                h2 += mod2.toLong()
            }
            val num = h1 * mod2 + h2
            // 如果重复，则返回重复串的起点
            if (!seen.add(num)) {
                return start
            }
        }
        // 没有重复，则返回-1
        return -1
    }

    fun pow(a: Int, m: Int, mod: Int): Long {
        var m = m
        var ans: Long = 1
        var contribute = a.toLong()
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod
                if (ans < 0) {
                    ans += mod.toLong()
                }
            }
            contribute = contribute * contribute % mod
            if (contribute < 0) {
                contribute += mod.toLong()
            }
            m /= 2
        }
        return ans
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}