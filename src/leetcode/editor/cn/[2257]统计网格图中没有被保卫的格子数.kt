//给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i]
// = [rowi, coli] 且 walls[j] = [rowj, colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。 
//
// 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，
//那么我们说这个格子被 保卫 了。 
//
// 请你返回空格子中，有多少个格子是 没被保卫 的。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
//输出：7
//解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
//总共有 7 个没有被保卫的格子，所以我们返回 7 。
// 
//
// 示例 2： 
//
// 
//
// 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
//输出：4
//解释：上图中，没有被保卫的格子用绿色表示。
//总共有 4 个没有被保卫的格子，所以我们返回 4 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 10⁵ 
// 2 <= m * n <= 10⁵ 
// 1 <= guards.length, walls.length <= 5 * 10⁴ 
// 2 <= guards.length + walls.length <= m * n 
// guards[i].length == walls[j].length == 2 
// 0 <= rowi, rowj < m 
// 0 <= coli, colj < n 
// guards 和 walls 中所有位置 互不相同 。 
// 
//
// Related Topics 数组 矩阵 模拟 👍 27 👎 0


package leetcode.editor.cn

import java.util.TreeMap
import java.util.TreeSet

/*** 2257
* 统计网格图中没有被保卫的格子数
*
* @author Gargantua7
* 2025-11-02 01:31:07
*/
class CountUnguardedCellsInTheGrid {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {

        val memo = Array(m) { Array(n) { BooleanArray(3) } }
        val direction = arrayOf(0 to 1, 0 to -1, -1 to 0, 1 to 0)

        val queue = ArrayDeque<Pair<Pair<Int, Int>, Int>>()

        walls.forEach { (x, y) -> memo[x][y][2] = true }

        guards.forEach { (x, y) ->
            memo[x][y][2] = true
            direction.forEachIndexed { idx, (dx, dy) ->
                if (memo[x + dx, y + dy]?.getOrNull(2) == false) {
                    memo[x + dx, y + dy]!![idx / 2] = true
                    queue.addLast((x + dx to y + dy) to idx)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (pos, dir) = queue.removeFirst()
            val (x, y) = pos
            val (dx, dy) = direction[dir]
            val nextX = x + dx
            val nextY = y + dy
            val check = memo[nextX, nextY] ?: continue

            if (check[2] || check[dir / 2]) continue

            check[dir / 2] = true

            queue.addLast(nextX to nextY to dir)
        }

        return memo.sumOf { row ->
            row.count { check ->
                check.all(Boolean::not)
            }
        }
    }

    operator fun <T> Array<Array<T>>.get(i: Int, j: Int): T? {
        return getOrNull(i)?.getOrNull(j)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

fun main() {
    CountUnguardedCellsInTheGrid.Solution()
        .countUnguarded(
            m = 5, n = 5,
            guards = arrayOf(intArrayOf(1, 4), intArrayOf(4, 1), intArrayOf(0, 3)),
            walls = arrayOf(intArrayOf(3, 2))
        ).let(::println)
}

// - - - G -
// - - - - G
// X - X - -
// X - W - -
// - G - - -