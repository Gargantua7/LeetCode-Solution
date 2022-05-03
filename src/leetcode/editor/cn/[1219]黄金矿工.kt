//你要开发一座金矿，地质勘测学家已经探明了这座金矿中的资源分布，并用大小为 m * n 的网格 grid 进行了标注。每个单元格中的整数就表示这一单元格中的黄
//金数量；如果该单元格是空的，那么就是 0。 
//
// 为了使收益最大化，矿工需要按以下规则来开采黄金： 
//
// 
// 每当矿工进入一个单元，就会收集该单元格中的所有黄金。 
// 矿工每次可以从当前位置向上下左右四个方向走。 
// 每个单元格只能被开采（进入）一次。 
// 不得开采（进入）黄金数目为 0 的单元格。 
// 矿工可以从网格中 任意一个 有黄金的单元格出发或者是停止。 
// 
//
// 
//
// 示例 1： 
//
// 输入：grid = [[0,6,0],[5,8,7],[0,9,0]]
//输出：24
//解释：
//[[0,6,0],
// [5,8,7],
// [0,9,0]]
//一种收集最多黄金的路线是：9 -> 8 -> 7。
// 
//
// 示例 2： 
//
// 输入：grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
//输出：28
//解释：
//[[1,0,7],
// [2,0,6],
// [3,4,5],
// [0,3,0],
// [9,0,20]]
//一种收集最多黄金的路线是：1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 15 
// 0 <= grid[i][j] <= 100 
// 最多 25 个单元格中有黄金。 
// 
// Related Topics 数组 回溯 矩阵 👍 110 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 1219
 * 黄金矿工
 * 
 * @author Gargantua丶
 * 2022-02-05 00:32:25
 */
class PathWithMaximumGold {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val direct = arrayOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    fun getMaximumGold(grid: Array<IntArray>): Int {
        var max = 0
        grid.forEachIndexed { x, row ->
            row.forEachIndexed { y, it ->
                if (it > 0) {
                    direct.forEach { (u, v) ->
                        if (x + u !in grid.indices || y + v !in grid[0].indices || grid[x + u][y + v] == 0) {
                            max = max.coerceAtLeast(dfs(grid, x, y, Array(grid.size) { BooleanArray(row.size) }))
                            return@forEach
                        }
                    }
                }
            }
        }
        return max
    }

    fun dfs(grid: Array<IntArray>, x: Int, y: Int, found: Array<BooleanArray>): Int {
        var max = 0
        found[x][y] = true
        direct.forEach { (u, v) ->
            if (x + u in grid.indices && y + v in grid[0].indices && !found[x + u][y + v] && grid[x + u][y + v] > 0) {
                max = max.coerceAtLeast(dfs(grid, x + u, y + v, found))
            }
        }
        found[x][y] = false
        return max + grid[x][y]
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
