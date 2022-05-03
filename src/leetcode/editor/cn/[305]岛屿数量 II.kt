//给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有
//单元格都是 0）。 
//
// 可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是
//要执行第 i 次操作的位置 (ri, ci) 。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。 
//
// 岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。 
// 
//
// 示例 1： 
//
// 
//输入：m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//输出：[1,1,2,3]
//解释：
//起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
//- 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。此时存在 2 个岛屿。
//- 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。此时存在 3 个岛屿。
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 1, positions = [[0,0]]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n, positions.length <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度 O(k log(mn)) 的算法解决此问题吗？（其中 k == positions.length） 
// Related Topics 并查集 数组 👍 105 👎 0

package leetcode.editor.cn


/**
 * 305
 * 岛屿数量 II
 * 
 * @author Gargantua丶
 * 2021-11-28 12:30:09
 */
class NumberOfIslandsIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private val DIRECTIONS = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

    fun numIslands2(m: Int, n: Int, positions: Array<IntArray>): List<Int>? {
        val unionFind = UnionFind(m * n)
        val visited = BooleanArray(m * n)
        val res: MutableList<Int> = ArrayList()
        for (position in positions) {
            val currX = position[0]
            val currY = position[1]
            val index = currX * n + currY
            if (!visited[index]) {
                // 把水变成陆地，连通分量个数加 1
                unionFind.addCount()
                visited[index] = true
                for (direction in DIRECTIONS) {
                    val newX = currX + direction[0]
                    val newY = currY + direction[1]
                    val newIndex = newX * n + newY
                    // 下面这三个条件很重要
                    if (inArea(newX, newY, m, n)
                        && visited[newIndex]
                        && !unionFind.isConnected(index, newIndex)
                    ) {
                        unionFind.union(index, newIndex)
                    }
                }
            }
            res.add(unionFind.count)
        }
        return res
    }

    fun inArea(x: Int, y: Int, m: Int, n: Int): Boolean {
        return x in 0 until m && y in 0 until n
    }

    private class UnionFind(n: Int) {
        private val parent: IntArray
        var count: Int
            private set

        fun addCount() {
            count++
        }

        fun isConnected(x: Int, y: Int): Boolean {
            return find(x) == find(y)
        }

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x])
            }
            return parent[x]
        }

        fun union(x: Int, y: Int) {
            val rootX = find(x)
            val rootY = find(y)
            if (rootX == rootY) {
                return
            }
            parent[rootX] = rootY
            count--
        }

        init {
            parent = IntArray(n)
            for (i in 0 until n) {
                parent[i] = i
            }
            count = 0
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}