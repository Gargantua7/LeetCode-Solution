//给你一棵 n 个节点的无向树，节点编号为 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i]
// = [ai, bi] 表示树中节点 ai 和 bi 有一条边。 
//
// 同时给你一个下标从 0 开始长度为 n 的整数数组 values ，其中 values[i] 是第 i 个节点的 值 。再给你一个整数 k 。 
//
// 你可以从树中删除一些边，也可以一条边也不删，得到若干连通块。一个 连通块的值 定义为连通块中所有节点值之和。如果所有连通块的值都可以被 k 整除，那么我们
//说这是一个 合法分割 。 
//
// 请你返回所有合法分割中，连通块数目的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
//输出：2
//解释：我们删除节点 1 和 2 之间的边。这是一个合法分割，因为：
//- 节点 1 和 3 所在连通块的值为 values[1] + values[3] = 12 。
//- 节点 0 ，2 和 4 所在连通块的值为 values[0] + values[2] + values[4] = 6 。
//最多可以得到 2 个连通块的合法分割。 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]], values = [3,0,6,1,5,2
//,1], k = 3
//输出：3
//解释：我们删除节点 0 和 2 ，以及节点 0 和 1 之间的边。这是一个合法分割，因为：
//- 节点 0 的连通块的值为 values[0] = 3 。
//- 节点 2 ，5 和 6 所在连通块的值为 values[2] + values[5] + values[6] = 9 。
//- 节点 1 ，3 和 4 的连通块的值为 values[1] + values[3] + values[4] = 6 。
//最多可以得到 3 个连通块的合法分割。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 3 * 10⁴ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// values.length == n 
// 0 <= values[i] <= 10⁹ 
// 1 <= k <= 10⁹ 
// values 之和可以被 k 整除。 
// 输入保证 edges 是一棵无向树。 
// 
//
// Related Topics 树 深度优先搜索 👍 31 👎 0


package leetcode.editor.cn

/*** 2872
* 可以被 K 整除连通块的最大数目
*
* @author Gargantua7
* 2025-11-28 22:26:32
*/
class MaximumNumberOfKDivisibleComponents {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val edgeMap = HashMap<Int, ArrayList<Int>>()
        edges.forEach { (s, e) ->
            edgeMap.getOrPut(s, ::ArrayList).add(e)
            edgeMap.getOrPut(e, ::ArrayList).add(s)
        }

        val route = HashMap<Int, ArrayList<Int>>()
        val queue = ArrayDeque<Int>()

        route[0] = ArrayList()
        queue.addLast(0)

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()
            edgeMap[curr]?.forEach { next ->
                if (next !in route) {
                    route[curr]!!.add(next)
                    route[next] = ArrayList()
                    queue.add(next)
                }
            }
        }

        var res = 0

        fun end(curr: Int): Long {
            val sum = (route[curr]?.sumOf(::end) ?: 0) + values[curr]
            return if (sum % k == 0L) {
                res++
                0
            } else sum
        }

        end(0)

        return res
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}