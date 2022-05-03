//你的任务是计算 aᵇ 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。 
//
// 
//
// 示例 1： 
//
// 
//输入：a = 2, b = [3]
//输出：8
// 
//
// 示例 2： 
//
// 
//输入：a = 2, b = [1,0]
//输出：1024
// 
//
// 示例 3： 
//
// 
//输入：a = 1, b = [4,3,3,8,5,2]
//输出：1
// 
//
// 示例 4： 
//
// 
//输入：a = 2147483647, b = [2,0,0]
//输出：1198
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a <= 2³¹ - 1 
// 1 <= b.length <= 2000 
// 0 <= b[i] <= 9 
// b 不含前导 0 
// 
// Related Topics 数学 分治 👍 229 👎 0

package leetcode.editor.cn

/**
 * 372
 * 超级次方
 *
 * @author Gargantua丶
 * 2021-12-05 23:20:37
 */
class SuperPow {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        val mod = 1337

        fun superPow(a1: Int, b: IntArray): Int {
            var a = a1
            var ans = 1
            for (i in b.lastIndex downTo 0) {
                ans = (ans.toLong() * (a pow b[i]) % mod).toInt()
                a = a pow 10
            }
            return ans
        }

        infix fun Int.pow(n: Int): Int {
            var res = 1
            var temp = n
            var curr = this
            while (temp != 0) {
                if (temp and 1 == 1) {
                    res = (res.toLong() * curr % mod).toInt()
                }
                curr = (curr.toLong() * curr % mod).toInt()
                temp /= 2
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}