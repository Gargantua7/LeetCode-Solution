//泰波那契序列 Tn 定义如下： 
//
// T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2 
//
// 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4
//输出：4
//解释：
//T_3 = 0 + 1 + 1 = 2
//T_4 = 1 + 1 + 2 = 4
// 
//
// 示例 2： 
//
// 输入：n = 25
//输出：1389537
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 37 
// 答案保证是一个 32 位整数，即 answer <= 2^31 - 1。 
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 79 👎 0


package leetcode.editor.cn
/**
 * 1137
 * 第 N 个泰波那契数
 *
 * @author Gargantua丶
 * 2021-07-15 01:43:46
 */
class NThTribonacciNumber { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun tribonacci(n: Int) = arrayOf(0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609,
            19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, 15902591,
            29249425, 53798080, 98950096, 181997601, 334745777, 615693474, 1132436852, 2082876103)[n]
}
//leetcode submit region end(Prohibit modification and deletion)

}