//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 305 👎 0

package leetcode.editor.cn

/**
 * 475
 * 供暖器
 *
 * @author Gargantua丶
 * 2021-12-20 14:14:48
 */
class Heaters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun findRadius(houses: IntArray, heaters: IntArray): Int {
            houses.sort()
            heaters.sort()
            var i = 0
            return houses.fold(0) { ans, h ->
                ans.coerceAtLeast(
                    when {
                        h <= heaters.first() -> heaters.first() - h
                        h >= heaters.last() -> h - heaters.last()
                        else -> {
                            while (h !in heaters[i]..heaters[i + 1]) i++
                            minOf(h - heaters[i], heaters[i + 1] - h)
                        }
                    }
                )
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}