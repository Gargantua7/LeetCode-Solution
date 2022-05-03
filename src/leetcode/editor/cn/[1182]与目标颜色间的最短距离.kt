//给你一个数组 colors，里面有 1、2、 3 三种颜色。 
//
// 我们需要在 colors 上进行一些查询操作 queries，其中每个待查项都由两个整数 i 和 c 组成。 
//
// 现在请你帮忙设计一个算法，查找从索引 i 到具有目标颜色 c 的元素之间的最短距离。 
//
// 如果不存在解决方案，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：colors = [1,1,2,1,3,2,2,3,3], queries = [[1,3],[2,2],[6,1]]
//输出：[3,0,3]
//解释： 
//距离索引 1 最近的颜色 3 位于索引 4（距离为 3）。
//距离索引 2 最近的颜色 2 就是它自己（距离为 0）。
//距离索引 6 最近的颜色 1 位于索引 3（距离为 3）。
// 
//
// 示例 2： 
//
// 输入：colors = [1,2], queries = [[0,3]]
//输出：[-1]
//解释：colors 中没有颜色 3。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= colors.length <= 5*10^4 
// 1 <= colors[i] <= 3 
// 1 <= queries.length <= 5*10^4 
// queries[i].length == 2 
// 0 <= queries[i][0] < colors.length 
// 1 <= queries[i][1] <= 3 
// 
// Related Topics 数组 二分查找 动态规划 👍 26 👎 0


package leetcode.editor.cn

/**
 * 1182
 * 与目标颜色间的最短距离
 *
 * @author Gargantua丶
 * 2021-09-26 13:22:47
 */
class ShortestDistanceToTargetColor {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): List<Int> {
            val dp = Array(colors.size) { Array(4) { IntArray(2) } }
            for (i in 1..3) {
                dp[0][i][0] = if (colors[0] == i) 0 else Int.MAX_VALUE
                dp.last()[i][1] = if (colors.last() == i) 0 else Int.MAX_VALUE
            }
            for (i in 1..dp.lastIndex) {
                for (j in 1..3) {
                    dp[i][j][0] = if (j == colors[i]) 0
                    else if (dp[i - 1][j][0] == Int.MAX_VALUE) Int.MAX_VALUE
                    else dp[i - 1][j][0] + 1

                    dp[dp.lastIndex - i][j][1] = if (j == colors[dp.lastIndex - i]) 0
                    else if (dp[dp.lastIndex - i + 1][j][1] == Int.MAX_VALUE) Int.MAX_VALUE
                    else dp[dp.lastIndex - i + 1][j][1] + 1
                }
            }
            val ans = ArrayList<Int>()
            queries.forEach { (index, target) ->
                val min = minOf(dp[index][target][0], dp[index][target][1])
                ans.add(if (min != Int.MAX_VALUE) min else -1)
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}