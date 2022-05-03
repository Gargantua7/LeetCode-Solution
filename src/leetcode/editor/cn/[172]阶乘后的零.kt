//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁴ 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
// Related Topics 数学 👍 565 👎 0

package leetcode.editor.cn

/**
 * 172
 * 阶乘后的零
 *
 * @author Gargantua丶
 * 2022-03-25 01:01:26
 */
class FactorialTrailingZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun trailingZeroes(n: Int): Int {
            var count = 0
            var t = n
            while (t != 0) {
                t /= 5
                count += t
            }
            return count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
