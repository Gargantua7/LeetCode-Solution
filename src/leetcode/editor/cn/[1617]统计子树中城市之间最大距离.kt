//给你 n 个城市，编号为从 1 到 n 。同时给你一个大小为 n-1 的数组 edges ，其中 edges[i] = [ui, vi] 表示城市 ui 和
// vi 之间有一条双向边。题目保证任意城市之间只有唯一的一条路径。换句话说，所有城市形成了一棵 树 。 
//
// 一棵 子树 是城市的一个子集，且子集中任意城市之间可以通过子集中的其他城市和边到达。两个子树被认为不一样的条件是至少有一个城市在其中一棵子树中存在，但在另
//一棵子树中不存在。 
//
// 对于 d 从 1 到 n-1 ，请你找到城市间 最大距离 恰好为 d 的所有子树数目。 
//
// 请你返回一个大小为 n-1 的数组，其中第 d 个元素（下标从 1 开始）是城市间 最大距离 恰好等于 d 的子树数目。 
//
// 请注意，两个城市间距离定义为它们之间需要经过的边的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 4, edges = [[1,2],[2,3],[2,4]]
//输出：[3,4,0]
//解释：
//子树 {1,2}, {2,3} 和 {2,4} 最大距离都是 1 。
//子树 {1,2,3}, {1,2,4}, {2,3,4} 和 {1,2,3,4} 最大距离都为 2 。
//不存在城市间最大距离为 3 的子树。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, edges = [[1,2]]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：n = 3, edges = [[1,2],[2,3]]
//输出：[2,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 15 
// edges.length == n-1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 题目保证 (ui, vi) 所表示的边互不相同。 
// 
//
// Related Topics 位运算 树 动态规划 状态压缩 枚举 👍 51 👎 0


package leetcode.editor.cn


/**
 * 1617
 * 统计子树中城市之间最大距离
 *
 * @author Gargantua丶
 * 2023-03-12 00:31:45
 */
class CountSubtreesWithMaxDistanceBetweenCities {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var mask = 0
    var diameter = 0

    fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
        val adj = Array(n) { ArrayList<Int>() }
        for (edge in edges) {
            val x = edge[0] - 1
            val y = edge[1] - 1
            adj[x].add(y)
            adj[y].add(x)
        }
        val ans = IntArray(n - 1)
        for (i in 1 until (1 shl n)) {
            val root = 32 - Integer.numberOfLeadingZeros(i) - 1
            mask = i
            diameter = 0
            dfs(root, adj)
            if (mask == 0 && diameter > 0) {
                ans[diameter - 1]++
            }
        }
        return ans
    }

    fun dfs(root: Int, adj: Array<ArrayList<Int>>): Int {
        var first = 0
        var second = 0
        mask = mask and (1 shl root).inv()
        for (vertex in adj[root]) {
            if (mask and (1 shl vertex) != 0) {
                mask = mask and (1 shl vertex).inv()
                val distance = 1 + dfs(vertex, adj)
                if (distance > first) {
                    second = first
                    first = distance
                } else if (distance > second) {
                    second = distance
                }
            }
        }
        diameter = Math.max(diameter, first + second)
        return first
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}