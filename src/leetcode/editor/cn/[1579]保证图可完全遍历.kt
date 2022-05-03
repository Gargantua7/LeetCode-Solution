//Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3 种类型的边： 
//
// 
// 类型 1：只能由 Alice 遍历。 
// 类型 2：只能由 Bob 遍历。 
// 类型 3：Alice 和 Bob 都可以遍历。 
// 
//
// 给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。请
//你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图
//是可以完全遍历的。 
//
// 返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,3],[1,2,4],[1,1,2],[2,3,4]]
//输出：2
//解释：如果删除 [1,1,2] 和 [1,1,3] 这两条边，Alice 和 Bob 仍然可以完全遍历这个图。再删除任何其他的边都无法保证图可以完全遍历。所
//以可以删除的最大边数是 2 。
// 
//
// 示例 2： 
//
// 
//
// 输入：n = 4, edges = [[3,1,2],[3,2,3],[1,1,4],[2,1,4]]
//输出：0
//解释：注意，删除任何一条边都会使 Alice 和 Bob 无法完全遍历这个图。
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 4, edges = [[3,2,3],[1,1,2],[2,3,4]]
//输出：-1
//解释：在当前图中，Alice 无法从其他节点到达节点 4 。类似地，Bob 也不能达到节点 1 。因此，图无法完全遍历。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10^5 
// 1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2) 
// edges[i].length == 3 
// 1 <= edges[i][0] <= 3 
// 1 <= edges[i][1] < edges[i][2] <= n 
// 所有元组 (typei, ui, vi) 互不相同 
// 
// Related Topics 并查集 图 👍 126 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 1579
 * 保证图可完全遍历
 * 
 * @author Gargantua丶
 * 2021-11-28 12:32:57
 */
class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val ufa: UnionFind = UnionFind(n)
        val ufb: UnionFind = UnionFind(n)
        var ans = 0

        // 节点编号改为从 0 开始
        for (edge in edges) {
            --edge[1]
            --edge[2]
        }

        // 公共边
        for (edge in edges) {
            if (edge[0] == 3) {
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans
                } else {
                    ufb.unite(edge[1], edge[2])
                }
            }
        }

        // 独占边
        for (edge in edges) {
            if (edge[0] == 1) {
                // Alice 独占边
                if (!ufa.unite(edge[1], edge[2])) {
                    ++ans
                }
            } else if (edge[0] == 2) {
                // Bob 独占边
                if (!ufb.unite(edge[1], edge[2])) {
                    ++ans
                }
            }
        }
        return if (ufa.setCount != 1 || ufb.setCount != 1) {
            -1
        } else ans
    }
}

    // 并查集模板
    class UnionFind(n: Int) {
        val parent: IntArray
        val size: IntArray
        var n = 0

        // 当前连通分量数目
        var setCount = 0

        init {
            this.n = n
            setCount = n
            parent = IntArray(n)
            size = IntArray(n)
            Arrays.fill(size, 1)
            for (i in 0 until n) {
                parent[i] = i
            }
        }

        fun findset(x: Int): Int {
            return if (parent[x] == x) x else findset(parent[x]).also { parent[x] = it }
        }

        fun unite(x: Int, y: Int): Boolean {
            var x = x
            var y = y
            x = findset(x)
            y = findset(y)
            if (x == y) {
                return false
            }
            if (size[x] < size[y]) {
                val temp = x
                x = y
                y = temp
            }
            parent[y] = x
            size[x] += size[y]
            --setCount
            return true
        }

        fun connected(i: Int, j: Int): Boolean {
            var x = i
            var y = j
            x = findset(x)
            y = findset(y)
            return x == y
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}