//给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 1, b = 2
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// -1000 <= a, b <= 1000 
// 
// Related Topics 位运算 数学 👍 426 👎 0


package leetcode.editor.cn
/**
 * 371
 * 两整数之和
 *
 * @author Gargantua丶
 * 2021-09-26 00:00:51
 */
class SumOfTwoIntegers { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun getSum(x: Int, y: Int): Int {
        var a = x
        var b = y
        while (b != 0) {
            val carry = (a and b) shl 1
            a = a xor b
            b = carry
        }
        return a
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}