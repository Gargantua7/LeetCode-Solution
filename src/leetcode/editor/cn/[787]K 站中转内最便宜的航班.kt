//有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城
//市 fromi 开始，以价格 toi 抵达 pricei。 
//
// 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便
//宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 1
//输出: 200
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 1 站中转以内的最便宜价格是 200，如图中红色所示。 
//
// 示例 2： 
//
// 
//输入: 
//n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
//src = 0, dst = 2, k = 0
//输出: 500
//解释: 
//城市航班图如下
//
//
//从城市 0 到城市 2 在 0 站中转以内的最便宜价格是 500，如图中蓝色所示。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= flights.length <= (n * (n - 1) / 2) 
// flights[i].length == 3 
// 0 <= fromi, toi < n 
// fromi != toi 
// 1 <= pricei <= 10⁴ 
// 航班没有重复，且不存在自环 
// 0 <= src, dst, k < n 
// src != dst 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 动态规划 最短路 堆（优先队列） 👍 299 👎 0


package leetcode.editor.cn

import java.lang.Double.NaN
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 787
 * K 站中转内最便宜的航班
 *
 * @author Gargantua丶
 * 2021-08-24 02:15:17
 */
class CheapestFlightsWithinKStops {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private val INF = 1000007

        fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
            val map = HashMap<Int, ArrayList<Pair<Int, Int>>>()
            flights.forEach { (from, to, price) ->
                if (from !in map) map[from] = ArrayList()
                map[from]!!.add(to to price)
            }
            return bfs(map, src, dst, k + 1).run { if (this >= INF) -1 else this }
        }

        fun bfs(map: HashMap<Int, out List<Pair<Int, Int>>>, curr: Int, dst: Int, k: Int): Int {
            if (k == 0) return INF
            var min = INF
            map[curr]?.forEach { (to, price) ->
                min = min.coerceAtMost(
                    if (to == dst) price else price + bfs(map, to, dst, k - 1)
                )
            }
            return min
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // Dynamic Programming
    private val INF = 10000 * 101 + 1

    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int {
        val dp = Array(n) { IntArray(k + 2) { INF } }
        dp[src][0] = 0
        for (i in 1..k + 1) {
            flights.forEach { (from, to, price) ->
                dp[to][i] = dp[to][i].coerceAtMost(dp[from][i - 1] + price)
            }
        }
        val min = dp[dst].minOrNull()!!
        return if (min == INF) -1 else min
    }

}