//给定从 0 到 n-1 标号的 n 个结点，和一个无向边列表（每条边以结点对来表示），请编写一个函数用来判断这些边是否能够形成一个合法有效的树结构。 
//
// 示例 1： 
//
// 输入: n = 5, 边列表 edges = [[0,1], [0,2], [0,3], [1,4]]
//输出: true 
//
// 示例 2: 
//
// 输入: n = 5, 边列表 edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
//输出: false 
//
// 注意：你可以假定边列表 edges 中不会出现重复的边。由于所有的边是无向边，边 [0,1] 和边 [1,0] 是相同的，因此不会同时出现在边列表 
//edges 中。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 137 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 261
 * 以图判树
 *
 * @author Gargantua丶
 * 2021-10-17 12:13:29
 */
class GraphValidTree { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        val adjacency = Array(n) { ArrayList<Int>() }
        edges.forEach { (s, e) ->
            adjacency[s].add(e)
            adjacency[e].add(s)
        }
        val queue: Queue<Int> = LinkedList(listOf(0))
        val map = hashMapOf(0 to 0)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            for (k in adjacency[node]) {
                if (k in map) {
                    if (map[k] == 0) return false
                    map[k] = map[k]!! - 1
                    continue
                }
                queue.offer(k)
                map[k] = 0
                map[node] = (map[node]?: 0) + 1
            }
        }
        return map.size == adjacency.size
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}