//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。 
//
// 
//
// 注意：n 是正数且在 32 位整数范围内（n < 2³¹）。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
// Related Topics 数学 二分查找 👍 181 👎 0


package leetcode.editor.cn
/**
 * 400
 * 第 N 位数字
 *
 * @author Gargantua丶
 * 2021-09-27 14:18:23
 */
class NthDigit { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findNthDigit(n: Int): Int {
        if (n < 10) return n
        var temp = n.toLong() - 1
        var curr = 9L
        var i = 1
        while (temp >= (curr * i)) {
            temp -= curr * i
            curr *= 10
            i++
        }
        val start = curr / 9L
        val target = (start + temp / i).toString()[(temp % i).toInt()]
        return target - '0'
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}