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
// Related Topics 数组 数学 字符串 排序 👍 121 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 539
 * 最小时间差
 * 
 * @author Gargantua丶
 * 2022-01-18 01:29:54
 */
class MinimumTimeDifference {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMinDifference(timePoints: List<String>): Int {
        if (timePoints.size > 1440) return 0
        val list = timePoints.map { time ->
            val (h1, h2, _, m1, m2) = time.toCharArray()
            "$h1$h2".toInt() * 60 + "$m1$m2".toInt()
        }.sorted()
        var min = minOf(list.last() - list.first(), list.first() - list.last() + 1440)
        for (i in 1..list.lastIndex) {
            min = min.coerceAtMost(minOf(list[i] - list[i - 1], list[i - 1] - list[i] + 1440))
        }
        return min
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
