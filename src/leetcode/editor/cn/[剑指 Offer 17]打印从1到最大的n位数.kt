//输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。 
//
// 示例 1: 
//
// 输入: n = 1
//输出: [1,2,3,4,5,6,7,8,9]
// 
//
// 
//
// 说明： 
//
// 
// 用返回一个整数列表来代替打印 
// n 为正整数 
// 
// Related Topics 数组 数学 
// 👍 141 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 17
 * 打印从1到最大的n位数
 *
 * @author Gargantua丶
 * 2021-08-07 02:17:33
 */
class DaYinCong1daoZuiDaDeNweiShuLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun printNumbers(n: Int): IntArray {
        var max = 0
        for (i in 1..n) {
            max = max * 10 + 9
        }
        return IntArray(max) { it + 1 }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}