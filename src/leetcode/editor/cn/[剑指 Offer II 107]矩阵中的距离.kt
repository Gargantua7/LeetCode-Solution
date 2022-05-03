//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
//
// 
//
// 注意：本题与主站 542 题相同：https://leetcode-cn.com/problems/01-matrix/ 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 👍 1 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 107
 * 矩阵中的距离
 *
 * @author Gargantua丶
 * 2021-11-02 14:44:35
 */
class TwoBCMpM {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private val road = arrayOf(0 to -1, 0 to 1, -1 to 0, 1 to 0)

        fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
            val ans = Array(mat.size) { IntArray(mat[0].size) { Int.MAX_VALUE } }
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            for (i in mat.indices) {
                for (j in mat[0].indices) {
                    if (mat[i][j] == 0) {
                        ans[i][j] = 0
                        queue.offer(i to j)
                    }
                }
            }
            while (queue.isNotEmpty()) {
                val (x, y) = queue.poll()
                val length = ans[x][y]
                road.forEach { (u, v) ->
                    if (x + u in mat.indices && y + v in mat[0].indices && mat[x + u][y + v] == 1 && ans[x + u][y + v] > length + 1) {
                        ans[x + u][v + y] = length + 1
                        queue.offer(x + u to y + v)
                    }
                }
            }
            return ans
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}