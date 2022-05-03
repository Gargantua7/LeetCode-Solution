//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 0 👎 0


package leetcode.editor.cn

import kotlin.math.min

/**
 * 剑指 Offer II 035
 * 最小时间差
 *
 * @author Gargantua丶
 * 2021-10-08 13:40:28
 */
class Five69nqc { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        val set = HashSet<Int>()
        var ans = Int.MAX_VALUE
        timePoints.forEach { t ->
            val minutes = t.substring(0..1).toInt() * 60 + t.substring(3..4).toInt()
            set.forEach { m ->
                ans = minOf(ans, minOf(kotlin.math.abs(minutes - m),  24 * 60 - kotlin.math.abs(minutes - m)))
            }
            set += minutes
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}