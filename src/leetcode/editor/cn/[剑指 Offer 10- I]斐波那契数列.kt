//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下： 
//
// 
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1. 
//
// 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 179 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 10- I
 * 斐波那契数列
 *
 * @author Gargantua丶
 * 2021-08-05 01:57:11
 */
class FeiBoNaQiShuLieLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun fib(n: Int): Int {
        if (n < 2) return n
        var a = 0
        var b = 1
        for (i in 2..n) {
            val count = (a + b) % 1000000007
            a = b
            b = count
        }
        return b
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}