//给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 
//endDayi 。 
//
// 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。在任意一天 d 中只能参加一场会议。 
//
// 请你返回你可以参加的 最大 会议数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：events = [[1,2],[2,3],[3,4]]
//输出：3
//解释：你可以参加所有的三个会议。
//安排会议的一种方案如上图。
//第 1 天参加第一个会议。
//第 2 天参加第二个会议。
//第 3 天参加第三个会议。
// 
//
// 示例 2： 
//
// 
//输入：events= [[1,2],[2,3],[3,4],[1,2]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= events.length <= 10⁵ 
// events[i].length == 2 
// 1 <= startDayi <= endDayi <= 10⁵ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 317 👎 0


package leetcode.editor.cn

import jdk.internal.org.jline.utils.Colors.s
import sun.jvm.hotspot.HelloWorld.e
import java.util.PriorityQueue


/**
 * 1353
 * 最多可以参加的会议数目
 * 
 * @author Gargantua丶
 * 2025-07-07 15:25:38
 */
private class MaximumNumberOfEventsThatCanBeAttended {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxEvents(events: Array<IntArray>): Int {

        val maxDay = events.maxOf { it[1] }
        val queue = PriorityQueue<Int>()

        val map = events.groupBy { it[0] }
            .mapValues { (_, v) -> v.map { it[1] } }
            .toSortedMap()

        var ans = 0

        for (day in 1..maxDay) {

            map[day]?.forEach { queue.offer(it) }

            while (queue.isNotEmpty() && queue.peek() < day) {
                queue.poll()
            }

            if (queue.isNotEmpty()) {
                queue.poll()
                ans++
            }
        }

        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}