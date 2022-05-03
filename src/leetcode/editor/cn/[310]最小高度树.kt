//树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。 
//
// 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中
// edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。 
//
// 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度
//树 。 
//
// 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。 
//树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, edges = [[1,0],[1,2],[1,3]]
//输出：[1]
//解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。 
//
// 示例 2： 
//
// 
//输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//输出：[3,4]
// 
//
// 
//
// 
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10⁴ 
// edges.length == n - 1 
// 0 <= ai, bi < n 
// ai != bi 
// 所有 (ai, bi) 互不相同 
// 给定的输入 保证 是一棵树，并且 不会有重复的边 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 👍 472 👎 0

package leetcode.editor.cn


/**
 * 310
 * 最小高度树
 * 
 * @author Gargantua丶
 * 2022-04-06 04:20:54
 */
class MinimumHeightTrees {
//leetcode submit region begin(Prohibit modification and deletion)
internal class Solution {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val res: MutableList<Int> = ArrayList()
        val gra = arrayOfNulls<IntArray>(n)
        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]
            if (gra[a] == null) gra[a] = edge else gra[b] = edge
        }
        var root = getRoot(gra)
        var node = getNode(gra, root)
        root = reverse(gra, root, node[0])
        node = getNode(gra, root)

        //System.out.println(root + "/" + node[0] + ":" + node[1]);
        var len = node[1] / 2
        var p = node[0]
        while (len-- != 0) p = getNext(gra, p)
        res.add(p)
        if (node[1] and 1 == 1) res.add(getNext(gra, p))
        return res
    }

    private fun reverse(gra: Array<IntArray?>, root: Int, p: Int): Int {
        var p = p
        val ret = p
        var pre: IntArray? = null
        while (p != root) {
            val next = getNext(gra, p)
            val temp = gra[p]
            gra[p] = pre
            pre = temp
            p = next
        }
        gra[root] = pre
        return ret
    }

    private fun getNode(gra: Array<IntArray?>, root: Int): IntArray {
        val n = gra.size
        var max = 0
        var node = 0
        val h = IntArray(n)
        val stack = IntArray(n)
        var size = 0
        for (i in 0 until n) {
            var p = i
            val count = 0
            while (p != root && h[p] == 0) {
                stack[size++] = p
                p = getNext(gra, p)
            }
            while (size != 0) {
                val temp = stack[--size]
                h[temp] = h[p] + 1
                if (h[temp] > max) {
                    max = h[temp]
                    node = temp
                }
                p = temp
            }
        }
        return intArrayOf(node, h[node])
    }

    private fun getRoot(gra: Array<IntArray?>): Int {
        var p = 0
        while (gra[p] != null) p = getNext(gra, p)
        return p
    }

    private fun getNext(gra: Array<IntArray?>, p: Int): Int {
        val ret = gra[p]
        return if (ret!![0] == p) ret[1] else ret[0]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
