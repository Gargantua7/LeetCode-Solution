//给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。 
//
// 返回这个矩形可能的 最小 面积。 
//
// 
//
// 示例 1： 
//
// 
// 输入： grid = [[0,1,0],[1,0,1]] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。 
//
// 示例 2： 
//
// 
// 输入： grid = [[0,0],[1,0]] 
// 
//
// 输出： 1 
//
// 解释： 
//
// 
//
// 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[i].length <= 1000 
// grid[i][j] 是 0 或 1。 
// 输入保证 grid 中至少有一个 1 。 
// 
//
// Related Topics 数组 矩阵 👍 15 👎 0


package leetcode.editor.cn

/**
 * 3195
 * 包含所有 1 的最小矩形面积 I
 * 
 * @author Gargantua丶
 * 2025-08-22 16:14:24
 */
private class FindTheMinimumAreaToCoverAllOnesI {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumArea(grid: Array<IntArray>): Int {
        var maxX = 0
        var minX = grid.size - 1

        var maxY = 0
        var minY = grid.first().size - 1

        grid.forEachIndexed { x, row ->
            row.forEachIndexed { y, v ->
                if (v == 1) {
                    maxX = maxOf(maxX, x)
                    minX = minOf(minX, x)
                    maxY = maxOf(maxY, y)
                    minY = minOf(minY, y)
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}