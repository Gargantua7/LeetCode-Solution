//给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
//输出: 4
//解释: 下雨后，雨水将会被上图蓝色的方块中。总的接雨水量为1+2+1=4。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: heightMap = [[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]
//输出: 10
// 
//
// 
//
// 提示: 
//
// 
// m == heightMap.length 
// n == heightMap[i].length 
// 1 <= m, n <= 200 
// 0 <= heightMap[i][j] <= 2 * 10⁴ 
// 
//
// 
// Related Topics 广度优先搜索 数组 矩阵 堆（优先队列） 👍 393 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 407
 * 接雨水 II
 *
 * @author Gargantua丶
 * 2021-11-03 00:18:48
 */
class TrappingRainWaterIi {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun trapRainWater(heightMap: Array<IntArray>): Int {
            if (heightMap.size <= 2 || heightMap[0].size <= 2) {
                return 0
            }
            val visit = Array(heightMap.size) { BooleanArray(heightMap[0].size) }
            val pq = PriorityQueue { o1: IntArray, o2: IntArray ->
                o1[1] - o2[1]
            }

            for (i in heightMap.indices) {
                for (j in heightMap[0].indices) {
                    if (i == 0 || i == heightMap.lastIndex || j == 0 || j == heightMap[0].lastIndex) {
                        pq.offer(intArrayOf(i * heightMap[0].size + j, heightMap[i][j]))
                        visit[i][j] = true
                    }
                }
            }
            var res = 0
            val dirs = intArrayOf(-1, 0, 1, 0, -1)
            while (!pq.isEmpty()) {
                val curr = pq.poll()
                for (k in 0..3) {
                    val nx = curr[0] / heightMap[0].size + dirs[k]
                    val ny = curr[0] % heightMap[0].size + dirs[k + 1]
                    if (nx in heightMap.indices && ny in heightMap[0].indices && !visit[nx][ny]) {
                        if (curr[1] > heightMap[nx][ny]) {
                            res += curr[1] - heightMap[nx][ny]
                        }
                        pq.offer(intArrayOf(nx * heightMap[0].size + ny, maxOf(heightMap[nx][ny], curr[1])))
                        visit[nx][ny] = true
                    }
                }
            }
            return res
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}