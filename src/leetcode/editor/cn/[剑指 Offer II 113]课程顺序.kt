//现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。 
//
// 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 
//prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。 
//
// 请根据给出的总课程数 numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。 
//
// 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。 
//
// 
//
// 示例 1: 
//
// 
//输入: numCourses = 2, prerequisites = [[1,0]] 
//输出: [0,1]
//解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。 
//
// 示例 2: 
//
// 
//输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
//输出: [0,1,2,3] or [0,2,1,3]
//解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
// 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
// 
//
// 示例 3: 
//
// 
//输入: numCourses = 1, prerequisites = [] 
//输出: [0]
//解释: 总共 1 门课，直接修第一门课就可。 
//
// 
//
// 提示: 
//
// 
// 1 <= numCourses <= 2000 
// 0 <= prerequisites.length <= numCourses * (numCourses - 1) 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// ai != bi 
// prerequisites 中不存在重复元素 
// 
//
// 
//
// 注意：本题与主站 210 题相同：https://leetcode-cn.com/problems/course-schedule-ii/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 4 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 * 剑指 Offer II 113
 * 课程顺序	
 *
 * @author Gargantua丶
 * 2021-11-04 13:57:09
 */
class QA2IGt { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val bases = HashMap<Int, ArrayList<Int>>()
        val expands = HashMap<Int, ArrayList<Int>>()
        prerequisites.forEach { (expand, base) ->
            if (expand !in expands) expands[expand] = ArrayList()
            expands[expand]!!.add(base)
            if (base !in bases) bases[base] = ArrayList()
            bases[base]!!.add(expand)
        }
        val ans = ArrayList<Int>()
        val queue: Queue<Int> = LinkedList()
        val go = BooleanArray(numCourses)
        for (i in 0 until numCourses) {
            if (i !in expands) {
                queue.offer(i)
                ans.add(i)
                go[i] = true
            }
        }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            bases[node]?.forEach { next ->
                if (!go[next] && expands[next]!!.fold(true) { check, expand -> check && go[expand] }) {
                    queue.offer(next)
                    ans.add(next)
                    go[next] = true
                }
            }
        }
        return if (ans.size == numCourses) ans.toIntArray() else intArrayOf()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}