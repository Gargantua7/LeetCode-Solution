//累加数 是一个字符串，组成它的数字可以形成累加序列。 
//
// 一个有效的 累加序列 必须 至少 包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。 
//
// 给你一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是 累加数 。如果是，返回 true ；否则，返回 false 。 
//
// 说明：累加序列里的数 不会 以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。 
//
// 
//
// 示例 1： 
//
// 
//输入："112358"
//输出：true 
//解释：累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
// 
//
// 示例 2： 
//
// 
//输入："199100199"
//输出：true 
//解释：累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 35 
// num 仅由数字（0 - 9）组成 
// 
//
// 
//
// 进阶：你计划如何处理由过大的整数输入导致的溢出? 
// Related Topics 字符串 回溯 👍 206 👎 0

package leetcode.editor.cn

/**
 * 306
 * 累加数
 * 
 * @author Gargantua丶
 * 2022-01-10 02:40:13
 */
class AdditiveNumber {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isAdditiveNumber(num: String): Boolean {
        if (num.length < 3) return false
        val n = num.length
        for (i in 1..(n - 1) / 2) {
            if (i > 1 && num[0] == '0') break
            var j = i + 1
            while (n - j >= i && n - j >= j - i) {
                if (j - i > 1 && num[i] == '0') break
                val num1 = num.substring(0, i).toLong()
                val num2 = num.substring(i, j).toLong()
                if (isAdditive(num.substring(j), num1, num2)) return true
                j++
            }
        }
        return false
    }

    private fun isAdditive(remain: String, num1: Long, num2: Long): Boolean {
        if (remain == "") return true
        val sum = num1 + num2
        val str = sum.toString()
        return if (!remain.startsWith(str)) false else isAdditive(remain.substring(str.length), num2, sum)
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
