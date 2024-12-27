//斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给你 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 
// 👍 289 👎 0


package leetcode.editor.cn

/**
 * 509
 * 斐波那契数
 *
 * @author Gargantua丶
 * 2021-07-15 01:33:13
 */
class FibonacciNumber {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        val list = ArrayList<Int>().apply {
//            add(0)
//            add(1)
//        }
//
//        fun fib(n: Int): Int {
//            if (list.lastIndex < n) (list.size..n).forEach { i -> list += list[i - 1] + list[i - 2] }
//            return list[n]
//        }

        fun fib(n: Int) = arrayOf(0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765,10946,17711,
                28657,46368,75025,121393,196418,317811,514229,832040)[n]
    }
//leetcode submit region end(Prohibit modification and deletion)

}