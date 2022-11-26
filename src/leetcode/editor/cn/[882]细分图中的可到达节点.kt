//给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。 
//
// 图用由边组成的二维数组 edges 表示，其中 edges[i] = [ui, vi, cnti] 表示原始图中节点 ui 和 vi 之间存在一条边，
//cnti 是将边 细分 后的新节点总数。注意，cnti == 0 表示边不可细分。 
//
// 要 细分 边 [ui, vi] ，需要将其替换为 (cnti + 1) 条新边，和 cnti 个新节点。新节点为 x1, x2, ..., xcnti ，
//新边为 [ui, x1], [x1, x2], [x2, x3], ..., [xcnti+1, xcnti], [xcnti, vi] 。 
//
// 现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。 
//
// 给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [[0,1,10],[0,2,1],[1,2,2]], maxMoves = 6, n = 3
//输出：13
//解释：边的细分情况如上图所示。
//可以到达的节点已经用黄色标注出来。
// 
//
// 示例 2： 
//
// 
//输入：edges = [[0,1,4],[1,2,6],[0,2,8],[1,3,1]], maxMoves = 10, n = 4
//输出：23
// 
//
// 示例 3： 
//
// 
//输入：edges = [[1,2,4],[1,4,5],[1,3,1],[2,3,4],[3,4,5]], maxMoves = 17, n = 5
//输出：1
//解释：节点 0 与图的其余部分没有连通，所以只有节点 0 可以到达。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= edges.length <= min(n * (n - 1) / 2, 10⁴) 
// edges[i].length == 3 
// 0 <= ui < vi < n 
// 图中 不存在平行边 
// 0 <= cnti <= 10⁴ 
// 0 <= maxMoves <= 10⁹ 
// 1 <= n <= 3000 
// 
//
// Related Topics 图 最短路 堆（优先队列） 👍 114 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 882
 * 细分图中的可到达节点
 * 
 * @author Gargantua丶
 * 2022-11-26 17:23:36
 */
class ReachableNodesInSubdividedGraph {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun reachableNodes(edges: Array<IntArray>, maxMoves: Int, n: Int): Int {
        val nodeMaxMove = IntArray(n) { -1 }
        nodeMaxMove[0] = maxMoves

        val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()
        edges.forEach { (s, e, c) ->
            map.getOrPut(s, ::ArrayList).add(e to c)
            map.getOrPut(e, ::ArrayList).add(s to c)
        }

        val queue = PriorityQueue<Int>() { a, b -> nodeMaxMove[b] - nodeMaxMove[a] }
        queue.offer(0)

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            val moves = nodeMaxMove[curr]
            map[curr]?.forEach { (e, c) ->
                val nextMoves = moves - c - 1
                if (nextMoves >= 0 && nextMoves > nodeMaxMove[e]) {
                    queue.remove(e)
                    nodeMaxMove[e] = nextMoves
                    queue.offer(e)
                }
            }
        }

        var ans = 0
        for (s in 0 until n) {
            if (nodeMaxMove[s] >= 0) {
                ans++
            }
            map[s]?.forEach { (e, c) ->
                if (e > s) {
                    ans += minOf(c, (if (nodeMaxMove[s] < 0) 0 else nodeMaxMove[s]) + (if (nodeMaxMove[e] < 0) 0 else nodeMaxMove[e]))
                }
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}