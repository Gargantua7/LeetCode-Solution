//可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。 
// 
//
// 给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 
//取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：8
//解释：
//有 8 种长度为 2 的记录将被视为可奖励：
//"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
//只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：n = 10101
//输出：183236316
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 105 
// 
// Related Topics 动态规划 
// 👍 149 👎 0


package leetcode.editor.cn

/**
 * 552
 * 学生出勤记录 II
 *
 * @author Gargantua丶
 * 2021-08-18 02:14:31
 */
class StudentAttendanceRecordIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun checkRecord(n: Int): Int {
            val dp = Array(n + 1) { IntArray(4) }
            dp[0] = intArrayOf(0, 0, 0, 0)
            dp[1] = intArrayOf(1, 1, 1, 0)
            dp[2] = intArrayOf(3, 3, 2, 1)
            for (i in 3..n) {
                dp[i][3] = dp[i - 1][3] * 2 + dp[i - 1][2]
                val lastTotal = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
                dp[i][0] = lastTotal
                dp[i][1] = lastTotal - dp[i - 1][1] + dp[i - 2][0] + dp[i - 2][2]
                dp[i][3] -= dp[i - 3][3]
                dp[i][2] = lastTotal - dp[i][3]
            }
            println("P:${dp[n][0]} L:${dp[n][1]} A:${dp[n][2]}")
            return dp[n][0] + dp[n][1] + dp[n][2]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}