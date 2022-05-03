//你现在手里有一份大小为 n x n 的 网格 grid，上面的每个 单元格 都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地。 
//
// 请你找出一个海洋单元格，这个海洋单元格到离它最近的陆地单元格的距离是最大的，并返回该距离。如果网格上只有陆地或者海洋，请返回 -1。 
//
// 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个单元格之间的距离是 |x0 - 
//x1| + |y0 - y1| 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,0,1],[0,0,0],[1,0,1]]
//输出：2
//解释： 
//海洋单元格 (1, 1) 和所有陆地单元格之间的距离都达到最大，最大距离为 2。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,0,0],[0,0,0],[0,0,0]]
//输出：4
//解释： 
//海洋单元格 (2, 2) 和所有陆地单元格之间的距离都达到最大，最大距离为 4。
// 
//
// 
//
// 提示： 
//
// 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 不是 0 就是 1 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 256 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 1162
 * 地图分析
 * 
 * @author Gargantua丶
 * 2022-03-19 23:25:04
 */
class AsFarFromLandAsPossible {
//leetcode submit region begin(Prohibit modification and deletion)
internal class Solution {
    fun maxDistance(grid: Array<IntArray>): Int {
        val INF = 1000000
        val dx = intArrayOf(-1, 0, 1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val n = grid.size
        val d = Array(n) { IntArray(n) }
        val queue = PriorityQueue<IntArray> { status1, status2 -> status1[0] - status2[0] }
        for (i in 0 until n) {
            for (j in 0 until n) {
                d[i][j] = INF
            }
        }
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    d[i][j] = 0
                    queue.offer(intArrayOf(0, i, j))
                }
            }
        }
        while (!queue.isEmpty()) {
            val f = queue.poll()
            for (i in 0..3) {
                val nx = f[1] + dx[i]
                val ny = f[2] + dy[i]
                if (!(nx >= 0 && nx < n && ny >= 0 && ny < n)) {
                    continue
                }
                if (f[0] + 1 < d[nx][ny]) {
                    d[nx][ny] = f[0] + 1
                    queue.offer(intArrayOf(d[nx][ny], nx, ny))
                }
            }
        }
        var ans = -1
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    ans = Math.max(ans, d[i][j])
                }
            }
        }
        return if (ans == INF) -1 else ans
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
