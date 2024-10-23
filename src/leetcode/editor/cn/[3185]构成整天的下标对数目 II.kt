//给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标
//对 i, j 的数目。 
//
// 整天 定义为时间持续时间是 24 小时的 整数倍 。 
//
// 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。 
//
// 
//
// 示例 1： 
//
// 
// 输入： hours = [12,12,30,24,24] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1) 和 (3, 4)。 
//
// 示例 2： 
//
// 
// 输入： hours = [72,48,24,3] 
// 
//
// 输出： 3 
//
// 解释： 
//
// 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 5 * 10⁵ 
// 1 <= hours[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 计数 👍 25 👎 0


package leetcode.editor.cn

/**
 * 3185
 * 构成整天的下标对数目 II
 *
 * @author Gargantua丶
 * 2024-10-23 16:56:34
 */
class CountPairsThatFormACompleteDayIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countCompleteDayPairs(hours: IntArray): Long {
        val mod = LongArray(24)
        var count = 0L
        hours.forEach {
            count += mod[(24 - it % 24) % 24]
            mod[it % 24]++
        }
        return count
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}