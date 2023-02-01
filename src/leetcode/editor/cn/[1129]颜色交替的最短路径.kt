//在一个有向图中，节点分别标记为 0, 1, ..., n-1。图中每条边为红色或者蓝色，且存在自环或平行边。 
//
// red_edges 中的每一个 [i, j] 对表示从节点 i 到节点 j 的红色有向边。类似地，blue_edges 中的每一个 [i, j] 对表示从
//节点 i 到节点 j 的蓝色有向边。 
//
// 返回长度为 n 的数组 answer，其中 answer[X] 是从节点 0 到节点 X 的红色边和蓝色边交替出现的最短路径的长度。如果不存在这样的路径，
//那么 answer[x] = -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
//输出：[0,1,-1]
// 
//
// 示例 2： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
//输出：[0,1,-1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
//输出：[0,-1,-1]
// 
//
// 示例 4： 
//
// 
//输入：n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
//输出：[0,1,2]
// 
//
// 示例 5： 
//
// 
//输入：n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
//输出：[0,1,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// red_edges.length <= 400 
// blue_edges.length <= 400 
// red_edges[i].length == blue_edges[i].length == 2 
// 0 <= red_edges[i][j], blue_edges[i][j] < n 
// 
//
// Related Topics 广度优先搜索 图 👍 127 👎 0


package leetcode.editor.cn

import java.util.LinkedList

/**
 * 1129
 * 颜色交替的最短路径
 *
 * @author Gargantua丶
 * 2023-02-02 00:15:49
 */
class ShortestPathWithAlternatingColors {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    companion object {
        const val RED = 0
        const val BLUE = 1
    }

    fun shortestAlternatingPaths(n: Int, redEdges: Array<IntArray>, blueEdges: Array<IntArray>): IntArray {
        val map = Array(2) { HashMap<Int, ArrayList<Int>>() }
        redEdges.forEach { (s, e) -> map[RED].getOrPut(s, ::ArrayList).add(e) }
        blueEdges.forEach { (s, e) -> map[BLUE].getOrPut(s, ::ArrayList).add(e) }

        val router = Array(2) { IntArray(n) { Int.MAX_VALUE } }
        router[RED][0] = 0
        router[BLUE][0] = 0

        val queue = LinkedList<Pair<Int, Int>>()
        queue.offer(0 to RED)
        queue.offer(0 to BLUE)

        while (queue.isNotEmpty()) {
            val (node, color) = queue.poll()
            val step = router[color][node]
            val nextColor = color xor 1
            map[nextColor][node]?.forEach {
                if (router[nextColor][it] > step + 1) {
                    router[nextColor][it] = step + 1
                    queue.offer(it to nextColor)
                }
            }
        }

        return IntArray(n) {
            val ans = minOf(router[0][it], router[1][it])
            if (ans == Int.MAX_VALUE) -1 else ans
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}