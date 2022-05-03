//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 846 👎 0

package leetcode.editor.cn

/**
 * 50
 * Pow(x, n)
 * 
 * @author Gargantua丶
 * 2022-01-17 19:35:07
 */
class PowxN {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun myPow(x: Double, n: Int): Double {
        var res = 1.0
        var (curr, idx) = if (n < 0) 1 / x to -n.toLong() else x to n.toLong()
        while (idx > 0) {
            if (idx and 1L == 1L)
                res *= curr
            curr *= curr
            idx = idx shr 1
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
