//假如有一排房子，共 n 个，每个房子可以被粉刷成 k 种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。 
//
// 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x k 的矩阵来表示的。 
//
// 例如，costs[0][0] 表示第 0 号房子粉刷成 0 号颜色的成本花费；costs[1][2] 表示第 1 号房子粉刷成 2 号颜色的成本花费，以此
//类推。请你计算出粉刷完所有房子最少的花费成本。 
//
// 注意： 
//
// 所有花费均为正整数。 
//
// 示例： 
//
// 输入: [[1,5,3],[2,9,4]]
//输出: 5
//解释: 将 0 号房子粉刷成 0 号颜色，1 号房子粉刷成 2 号颜色。最少花费: 1 + 4 = 5; 
//     或者将 0 号房子粉刷成 2 号颜色，1 号房子粉刷成 0 号颜色。最少花费: 3 + 2 = 5. 
// 
//
// 进阶： 
//您能否在 O(nk) 的时间复杂度下解决此问题？ 
// Related Topics 数组 动态规划 👍 92 👎 0


package leetcode.editor.cn

import kotlin.math.cos

/**
 * 265
 * 粉刷房子 II
 *
 * @author Gargantua丶
 * 2021-09-21 13:43:01
 */
class PaintHouseIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun minCostII(costs: Array<IntArray>): Int {
            val dp = IntArray(costs[0].size) { costs[0][it] }
            var minIndex = 0
            for (i in 1..dp.lastIndex) {
                if (dp[minIndex] > dp[i]) minIndex = i
            }
            for (c in 1..costs.lastIndex) {
                val cost = costs[c]
                var currMinIndex = 0
                val last = dp.clone()
                for (i in dp.indices) {
                    dp[i] = cost[i] + if (i != minIndex) last[minIndex]
                    else last.foldIndexed(Int.MAX_VALUE) { index, min, n ->
                        if (index == i) min else minOf(min, n)
                    }
                    if (dp[currMinIndex] > dp[i]) currMinIndex = i
                }
                minIndex = currMinIndex
            }
            // Warning: Since Kotlin 1.4
            return dp.minOrNull()!!
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}