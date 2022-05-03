//给定一个正整数 n ，你可以做如下操作： 
//
// 
// 如果 n 是偶数，则用 n / 2替换 n 。 
// 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。 
// 
//
// n 变为 1 所需的最小替换次数是多少？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 182 👎 0

package leetcode.editor.cn

/**
 * 397
 * 整数替换
 *
 * @author Gargantua丶
 * 2021-11-19 19:28:23
 */
class IntegerReplacement {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun integerReplacement(n: Int): Int {
            var curr = n.toLong()
            var step = 0
            while (curr != 1L) {
                if (curr and 1 == 0L) {
                    curr = curr shr 1
                } else if (curr == 3L || curr and 3 == 1L) {
                    curr--
                } else {
                    curr++
                }
                step++
            }
            return step
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}