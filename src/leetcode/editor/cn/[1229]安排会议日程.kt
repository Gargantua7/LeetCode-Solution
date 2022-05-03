//你是一名行政助理，手里有两位客户的空闲时间表：slots1 和 slots2，以及会议的预计持续时间 duration，请你为他们安排合适的会议时间。 
//
// 「会议时间」是两位客户都有空参加，并且持续时间能够满足预计时间 duration 的 最早的时间间隔。 
//
// 如果没有满足要求的会议时间，就请返回一个 空数组。 
//
// 
//
// 「空闲时间」的格式是 [start, end]，由开始时间 start 和结束时间 end 组成，表示从 start 开始，到 end 结束。 
//
// 题目保证数据有效：同一个人的空闲时间不会出现交叠的情况，也就是说，对于同一个人的两个空闲时间 [start1, end1] 和 [start2, end2
//]，要么 start1 > end2，要么 start2 > end1。 
//
// 
//
// 示例 1： 
//
// 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 8
//输出：[60,68]
// 
//
// 示例 2： 
//
// 输入：slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], 
//duration = 12
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= slots1.length, slots2.length <= 10^4 
// slots1[i].length, slots2[i].length == 2 
// slots1[i][0] < slots1[i][1] 
// slots2[i][0] < slots2[i][1] 
// 0 <= slots1[i][j], slots2[i][j] <= 10^9 
// 1 <= duration <= 10^6 
// 
// Related Topics 数组 双指针 排序 👍 44 👎 0

package leetcode.editor.cn

/**
 * 1229
 * 安排会议日程
 * 
 * @author Gargantua丶
 * 2021-12-09 13:46:48
 */
class MeetingScheduler {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minAvailableDuration(slots1: Array<IntArray>, slots2: Array<IntArray>, duration: Int): List<Int> {
        var point1 = 0
        var point2 = 0
        slots1.sortBy { it[0] }
        slots2.sortBy { it[0] }
        while (point1 < slots1.size && point2 < slots2.size) {
            val (s1, e1) = slots1[point1]
            val (s2, e2) = slots2[point2]
            val s = maxOf(s1, s2)
            val e = minOf(e1, e2)
            if (e - s >= duration) {
                return listOf(s, s + duration)
            } else {
                if (e1 < e2) point1++ else point2++
            }
        }
        return emptyList()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}