//给定编号从 0 到 n-1 的 n 个节点和一个无向边列表（每条边都是一对节点），请编写一个函数来计算无向图中连通分量的数目。 
//
// 示例 1: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [3, 4]]
//
//     0          3
//     |          |
//     1 --- 2    4 
//
//输出: 2
// 
//
// 示例 2: 
//
// 输入: n = 5 和 edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
//
//     0           4
//     |           |
//     1 --- 2 --- 3
//
//输出:  1
// 
//
// 注意: 
//你可以假设在 edges 中不会出现重复的边。而且由于所以的边都是无向边，[0, 1] 与 [1, 0] 相同，所以它们不会同时在 edges 中出现。 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 113 👎 0

package leetcode.editor.cn

/**
 * 323
 * 无向图中连通分量的数目
 * 
 * @author Gargantua丶
 * 2021-11-29 16:39:48
 */
class NumberOfConnectedComponentsInAnUndirectedGraph {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val uf = UnionFind(n)
        edges.forEach { (i, j) -> uf.union(i, j) }
        return uf.count
    }

    class UnionFind(val n: Int) {
        val parent = IntArray(n) { it }
        val size = IntArray(n) { 1 }
        var count = n

        operator fun get(i: Int): Int = if (parent[i] == i) i else run {
            parent[i] = this[parent[i]]
            parent[i]
        }

        fun union(i: Int, j: Int): Boolean {
            var x = this[i]
            var y = this[j]
            if (x == y) return false
            if (size[x] < size[y]) {
                val temp = x
                x = y
                y = temp
            }
            parent[y] = x
            size[x] += size[y]
            count--
            return true
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}