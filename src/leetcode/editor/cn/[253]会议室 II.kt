//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// 0 <= starti < endi <= 10⁶ 
// 
// Related Topics 贪心 数组 双指针 排序 堆（优先队列） 👍 351 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 253
 * 会议室 II
 * 
 * @author Gargantua丶
 * 2021-11-30 13:41:54
 */
class MeetingRoomsIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        intervals.sortBy { it.first() }
        val queue = PriorityQueue<Int>()
        intervals.forEach { (s, e) ->
            queue.offer(e)
            if ((queue.peek()?: Int.MAX_VALUE) <= s) {
                queue.poll()
            }
        }
        return queue.size
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}