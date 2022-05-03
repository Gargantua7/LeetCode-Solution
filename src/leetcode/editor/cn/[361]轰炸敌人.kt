//想象一下炸弹人游戏，在你面前有一个二维的网格来表示地图，网格中的格子分别被以下三种符号占据： 
//
// 
// 'W' 表示一堵墙 
// 'E' 表示一个敌人 
// '0'（数字 0）表示一个空位 
// 
//
// 
//
// 请你计算一个炸弹最多能炸多少敌人。 
//
// 由于炸弹的威力不足以穿透墙体，炸弹只能炸到同一行和同一列没被墙体挡住的敌人。 
//
// 注意：你只能把炸弹放在一个空的格子里 
//
// 示例: 
//
// 输入: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//输出: 3 
//解释: 对于如下网格
//
//0 E 0 0 
//E 0 W E 
//0 E 0 0
//
//假如在位置 (1,1) 放置炸弹的话，可以炸到 3 个敌人
// 
// Related Topics 数组 动态规划 矩阵 👍 63 👎 0


package leetcode.editor.cn

/**
 * 361
 * 轰炸敌人
 *
 * @author Gargantua丶
 * 2021-09-25 22:04:49
 */
class BombEnemy {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun maxKilledEnemies(grid: Array<CharArray>): Int {
            val position = arrayOf(arrayOf(-1, 0), arrayOf(0, -1), arrayOf(1, 0), arrayOf(0, 1))
            val dp = Array(grid.size) { Array(grid[0].size) { IntArray(4) } }

            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    for (k in 0..1) {
                        val (x, y) = position[k]
                        if (i + x in grid.indices && j + y in grid[0].indices && grid[i][j] != 'W') {
                            dp[i][j][k] = when (grid[i + x][j + y]) {
                                'E' -> dp[i + x][j + y][k] + 1
                                else -> dp[i + x][j + y][k]
                            }
                        }
                    }
                }
            }

            for (i in grid.indices.reversed()) {
                for (j in grid[0].indices.reversed()) {
                    for (k in 2..3) {
                        val (x, y) = position[k]
                        if (i + x in grid.indices && j + y in grid[0].indices && grid[i][j] != 'W') {
                            dp[i][j][k] = when (grid[i + x][j + y]) {
                                'E' -> dp[i + x][j + y][k] + 1
                                else -> dp[i + x][j + y][k]
                            }
                        }
                    }
                }
            }

            var ans = 0
            for (i in grid.indices) {
                for (j in grid[0].indices) {
                    if (grid[i][j] == '0')
                        ans = ans.coerceAtLeast(dp[i][j].sum())
//                    print(dp[i][j].contentToString())
                }
//                println()
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}