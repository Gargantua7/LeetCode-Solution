//给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 
//大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。 
//
// 返回 nums[n - 1] 可能的 最小 值。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 3, x = 4 
// 
//
// 输出：6 
//
// 解释： 
//
// 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。 
//
// 示例 2： 
//
// 
// 输入：n = 2, x = 7 
// 
//
// 输出：15 
//
// 解释： 
//
// 数组 nums 可以是 [7,15] ，最后一个元素为 15 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, x <= 10⁸ 
// 
//
// Related Topics 位运算 👍 35 👎 0


package leetcode.editor.cn

/**
 * 3133
 * 数组最后一个元素的最小值
 *
 * @author Gargantua丶
 * 2024-08-22 14:55:11
 */
class MinimumArrayEnd {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minEnd(n: Int, x: Int): Long {
        var ans = x.toLong()
        var i = 0
        repeat(64) {
            val k = (ans shr it) and 1L
            if (k == 0L) {
                ans = ans or ((((n - 1L) shr i++) and 1L) shl it)
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}