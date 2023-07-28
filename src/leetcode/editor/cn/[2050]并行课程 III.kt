//给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。同时给你一个二维整数数组 relations ，其中 relations[j] = [
//prevCoursej, nextCoursej] ，表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。同时给你一个下
//标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。 
//
// 请你根据以下规则算出完成所有课程所需要的 最少 月份数： 
//
// 
// 如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。 
// 你可以 同时 上 任意门课程 。 
// 
//
// 请你返回完成所有课程所需要的 最少 月份数。 
//
// 注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
//输出：8
//解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
//你可以在月份 0 同时开始课程 1 和 2 。
//课程 1 花费 3 个月，课程 2 花费 2 个月。
//所以，最早开始课程 3 的时间是月份 3 ，完成所有课程所需时间为 3 + 5 = 8 个月。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
//输出：12
//解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
//你可以在月份 0 同时开始课程 1 ，2 和 3 。
//在月份 1，2 和 3 分别完成这三门课程。
//课程 4 需在课程 3 之后开始，也就是 3 个月后。课程 4 在 3 + 4 = 7 月完成。
//课程 5 需在课程 1，2，3 和 4 之后开始，也就是在 max(1,2,3,7) = 7 月开始。
//所以完成所有课程所需的最少时间为 7 + 5 = 12 个月。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 0 <= relations.length <= min(n * (n - 1) / 2, 5 * 10⁴) 
// relations[j].length == 2 
// 1 <= prevCoursej, nextCoursej <= n 
// prevCoursej != nextCoursej 
// 所有的先修课程对 [prevCoursej, nextCoursej] 都是 互不相同 的。 
// time.length == n 
// 1 <= time[i] <= 10⁴ 
// 先修课程图是一个有向无环图。 
// 
//
// Related Topics 图 拓扑排序 数组 动态规划 👍 64 👎 0


package leetcode.editor.cn

import java.util.PriorityQueue

/**
 * 2050
 * 并行课程 III
 *
 * @author Gargantua丶
 * 2023-07-28 14:40:07
 */
class ParallelCoursesIii {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val prevMap = HashMap<Int, ArrayList<Int>>()

        relations.forEach { (prev, next) ->
            prevMap.getOrPut(next - 1, ::ArrayList).add(prev - 1)
        }

        val ans = IntArray(n) { -1 }
        repeat(n) { dp(it, prevMap, ans, time) }
        return ans.max()!!
    }

    fun dp(target: Int, map: HashMap<Int, out List<Int>>, ans: IntArray, time: IntArray): Int {
        var max = 0
        map[target]?.forEach {
            val t = if (ans[it] >= 0) ans[it] else dp(it, map, ans, time)
            max = maxOf(max, t)
        }
        ans[target] = max + time[target]
        return max + time[target]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val nextMap = HashMap<Int, ArrayList<Int>>()
        val prevMap = HashMap<Int, ArrayList<Int>>()

        val learn = HashSet<Int>()
        val alarm = PriorityQueue<Pair<Int, Int>> { (a, _), (b, _) -> a - b }

        val started = (0 until n).toHashSet()
        relations.forEach { (prev, next) ->
            nextMap.getOrPut(prev - 1, ::ArrayList).add(next - 1)
            prevMap.getOrPut(next - 1, ::ArrayList).add(prev - 1)
            started.remove(next - 1)
        }

        started.forEach {
            alarm.offer(time[it] to it)
        }

        var ans = 0

        while (learn.size < n && alarm.isNotEmpty()) {
            val (currTime, currCourse) = alarm.poll()
            learn.add(currCourse)
            ans = currTime
            nextMap[currCourse]?.forEach { next ->
                prevMap[next]?.let { prevList ->
                    if (prevList.all { prev -> prev in learn }) {
                        alarm.offer(currTime + time[next] to next)
                    }
                }
            }
        }

        return ans
    }
}