//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 数组 动态规划 
// 👍 828 👎 0


package leetcode.editor.cn
/**
 * 309
 * 最佳买卖股票时机含冷冻期
 *
 * @author Gargantua丶
 * 2021-07-22 01:01:24
 */
class BestTimeToBuyAndSellStockWithCooldown { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxProfit(prices: IntArray): Int {
        var ans = 0
        var flag = false
        prices.forEachIndexed { i, price ->
            if(i == prices.lastIndex ) return ans + if(flag) price else 0
            if(prices[i + 1] > price && !flag) {
                ans -= price
                flag = true
            }
            if(prices[i + 1] < price && flag) {
                ans += price
                flag = false
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}