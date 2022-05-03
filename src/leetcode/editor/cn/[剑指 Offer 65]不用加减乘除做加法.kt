//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 
// 👍 202 👎 0


package leetcode.editor.cn

import kotlin.math.ceil

/**
 * 剑指 Offer 65
 * 不用加减乘除做加法
 *
 * @author Gargantua丶
 * 2021-08-12 00:17:05
 */
class BuYongJiaJianChengChuZuoJiaFaLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun add(a: Int, b: Int): Int {
            var currA = a
            var currB = b
            while (currB != 0) {
                val c = (currA and currB) shl 1
                currA = currA xor currB
                currB = c
            }
            return currA
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}