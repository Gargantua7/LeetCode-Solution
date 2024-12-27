//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
// 
//
// 示例 2： 
//
// 
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
// 
//
// 示例 3： 
//
// 
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。 
//
// 
//
// 提示： 
//
// 
// 输入必须是长度为 32 的 二进制串 。 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 如果多次调用这个函数，你将如何优化你的算法？ 
// 
// Related Topics 位运算 👍 372 👎 0


package leetcode.editor.cn

/**
 * 191
 * 位1的个数
 *
 * @author Gargantua丶
 * 2021-08-24 02:50:14
 */
class NumberOf1Bits {
//leetcode submit region begin(Prohibit modification and deletion)
    /**
     * @see Integer.bitCount
     */
    class Solution {
        // you need treat n as an unsigned value
        fun hammingWeight(n: Int): Int {
            var i = n
            // ab -> a + b = ?? -> ab - a = ??
            // 11 -> 1 + 1 = 10 -> 11 - 1 = 10
            // 10 -> 1 + 0 = 01 -> 10 - 1 = 01
            // 01 -> 0 + 1 = 00 -> 01 - 0 = 01
            // 00 -> 0 + 0 = 00 => 00 - 0 = 00
            i -= i ushr 1 and 0x55555555 // i = i - (i >>> 1 & 0x55555555)
            // standard
            i = (i and 0x33333333) + (i ushr 2 and 0x33333333) // i = (i & 0x33333333) + (i >>> 2 & 0x33333333)
            // 0adc 0xyz                    -> 0adc + 0xyz = ????
            //  -> 0abc 0xyz + 0abc and 1111 = 0adc + 0xyz = ????
            // (abc & xyz must be less than 100, because at most 4 bits 1)

            // 0000 0100                    -> 0000 + 0100 = 0100
            //  -> 0000 0100 + 0000 and 1111 = 0000 + 0100 = 0100

            // 0100 0100                    -> 0100 + 0100 = 1000
            //  -> 0100 0100 + 0100 and 1111 = 0100 + 0100 = 1000

            // 0011 0011                    -> 0011 + 0011 = 1010
            //  -> 0011 0011 + 0011 and 1111 = 0011 + 0011 = 1010

            // and more...
            i = (i + (i ushr 4)) and 0x0f0f0f0f // i = (i + (i >>> 4) & 0x0f0f0f0f
            // the final answer must be less than 10 0000, because at most 32 bits 1,
            // but per-unit in 0x00ff00ff is 1111 1111, it is more than 32,
            // so it doesn't matter if ignore it.
            i = i ushr 8 // i = i + (i >>> 8)
            // ditto
            i += i ushr 16 // i = i + (i >>> 16)
            // at the end, we should clean the bits where more than 10 0000
            // 0x3f -> 11 1111
            return i and 0x3f
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
