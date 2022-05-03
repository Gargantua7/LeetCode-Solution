//给定一个表示整数的字符串 n ，返回与它最近的回文整数（不包括自身）。如果不止一个，返回较小的那个。 
//
// “最近的”定义为两个整数差的绝对值最小。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = "123"
//输出: "121"
// 
//
// 示例 2: 
//
// 
//输入: n = "1"
//输出: "0"
//解释: 0 和 2是最近的回文，但我们返回最小的，也就是 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n.length <= 18 
// n 只由数字组成 
// n 不含前导 0 
// n 代表在 [1, 10¹⁸ - 1] 范围内的整数 
// 
// Related Topics 数学 字符串 👍 113 👎 0

package leetcode.editor.cn

/**
 * 564
 * 寻找最近的回文数
 *
 * @author Gargantua丶
 * 2022-03-02 00:20:27
 */
class FindTheClosestPalindrome {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun nearestPalindromic(n: String): String? {
            val len = n.length
            if (len == 1) // 一位数的最近回文串就是它减1
                return (n.toInt() - 1).toString() + ""
            val org = n.toLong()
            var thousand = Math.pow(10.0, (len - 1).toDouble()).toLong()
            if (org == thousand || org == thousand + 1) // org是10,100,1000,10000,..., 或 11,101,1001,10001,...
                return (thousand - 1).toString() // 返回9,99,999,9999,...
            thousand = thousand * 10L - 1L
            if (org == thousand) // org是99,999,9999,...
                return (thousand + 2L).toString() // 返回101,1001,10001,...
            // 特判结束，下面是普通数字。处理左半段后逆转填到右半段上
            val left = n.substring(0, (len + 1) / 2).toInt()
            var ans = Long.MAX_VALUE
            var diff = Long.MAX_VALUE
            for (a in intArrayOf(1, 0, -1)) {  // 处理左半段：不变或加减1
                val lf = (left + a).toString() + ""
                val full = StringBuilder(if (len % 2 == 0) lf else lf.substring(0, lf.length - 1))
                    .reverse().insert(0, lf).toString()
                if (n == full) continue
                val _full = full.toLong()
                if (Math.abs(_full - org) <= diff) {
                    diff = Math.abs(_full - org)
                    ans = Math.min(ans, _full)
                }
            }
            return ans.toString() + ""
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
