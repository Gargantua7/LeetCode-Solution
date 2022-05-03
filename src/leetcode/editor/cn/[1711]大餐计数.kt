//大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。 
//
// 你可以搭配 任意 两道餐品做一顿大餐。 
//
// 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大
//餐 的数量。结果需要对 109 + 7 取余。 
//
// 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：deliciousness = [1,3,5,7,9]
//输出：4
//解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
//它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
// 
//
// 示例 2： 
//
// 
//输入：deliciousness = [1,1,1,3,3,3,7]
//输出：15
//解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。 
//
// 
//
// 提示： 
//
// 
// 1 <= deliciousness.length <= 105 
// 0 <= deliciousness[i] <= 220 
// 
// Related Topics 数组 哈希表 
// 👍 85 👎 0


package leetcode.editor.cn

/**
 * 1711
 * 大餐计数
 *
 * @author Gargantua丶
 * 2021-07-07 15:33:44
 */
class CountGoodMeals {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun countPairs(deliciousness: IntArray): Int {
            val max = (deliciousness.maxOrNull() ?: 0) * 2
            var ans = 0
            val map = HashMap<Int, Int>()
            deliciousness.forEach {
                var sum = 1
                while (sum <= max) {
                    ans = (ans + (map[sum - it] ?: 0)) % 1000000007
                    sum = sum shl 1
                }
                map[it] = (map[it]?: 0) + 1
            }
            return ans
        }

        // Leetcode的版本没有还行
        private fun IntArray.maxOrNull(): Int? {
            if (isEmpty()) return null
            var max = this[0]
            for (i in 1..lastIndex) {
                val e = this[i]
                if (max < e) max = e
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}