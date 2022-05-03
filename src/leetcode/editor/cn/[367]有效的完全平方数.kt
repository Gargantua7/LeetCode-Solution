//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。 
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 251 👎 0

package leetcode.editor.cn

/**
 * 367
 * 有效的完全平方数	
 *
 * @author Gargantua丶
 * 2021-11-04 00:33:48
 */
class ValidPerfectSquare { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun isPerfectSquare(num: Int): Boolean {
        var left = 1
        var right = 46341
        while (left < right) {
            val mid = left + (right - left) / 2
            if (mid * mid == num) return true
            if (mid * mid < num) left = mid + 1
            else right = mid
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}