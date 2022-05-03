//二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。 
//
// 请返回 封闭岛屿 的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,
//0,1],[1,1,1,1,1,1,1,0]]
//输出：2
//解释：
//灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,1,1,1,1,1,1],
//             [1,0,0,0,0,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,1,0,1,0,1],
//             [1,0,1,1,1,0,1],
//             [1,0,0,0,0,0,1],
//             [1,1,1,1,1,1,1]]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length, grid[0].length <= 100 
// 0 <= grid[i][j] <=1 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 121 👎 0

package leetcode.editor.cn

/**
 * 1254
 * 统计封闭岛屿的数目
 * 
 * @author Gargantua丶
 * 2022-03-17 02:08:20
 */
class NumberOfClosedIslands {
//leetcode submit region begin(Prohibit modification and deletion)
internal class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        // 统计符合条件的所有封闭岛屿
        var count = 0
        // 如果只有一行或者一列那么无论如何都不会有封闭岛屿
        if (grid.size == 1 || grid[0].size == 1) {
            return count
        }
        // 挨个去找所有符合条件的封闭岛屿，如果找到就将计数器加一
        // 因为四边出现的岛屿无论如何也不会是封闭岛屿，所以直接跳过他们的判断
        for (i in 1 until grid.size - 1) {
            for (j in 1 until grid[i].size - 1) {
                // 如果当前是岛屿，那么就进行dfs判断，如果返回true就表示符合条件，反之不符合
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++
                    }
                }
            }
        }
        return count
    }

    /**
     * 深度优先搜索，只要是岛屿就将当前位置的值设置为非1或0的数（这里用的是2），然后继续向四周搜索，如果搜索到头超过了四边的限制，那么当前岛屿就不是封闭岛屿，反之是封闭岛屿
     */
    fun dfs(grid: Array<IntArray>, x: Int, y: Int): Boolean {
        // 如果深度优先搜索搜索的边界超过了四边那么一定不是封闭岛屿，举个例子
        // 1 1 0 1 1
        // 1 1 0 0 1
        // 1 1 1 1 1
        // ||
        // \/
        //    递归到这里时还会向上尝试递归，此时就会越界，所以说如果越界了。那么就不是一个封闭的岛屿
        //     |
        //     v
        // 1 1 2 1 1
        // 1 1 2 2 1
        // 1 1 1 1 1
        if (x < 0 || x == grid.size || y < 0 || y == grid[0].size) {
            return false
        }
        // 如果当前不是岛屿就返回true
        if (grid[x][y] != 0) {
            return true
        }
        // 给访问过的地方添加一个标记 防止重复判断 走走过的路导致死循环
        grid[x][y] = 2
        val up = dfs(grid, x - 1, y)
        val right = dfs(grid, x, y + 1)
        val down = dfs(grid, x + 1, y)
        val left = dfs(grid, x, y - 1)
        return up && right && down && left
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
