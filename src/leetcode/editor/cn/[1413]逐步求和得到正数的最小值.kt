//给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。 
//
// 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。 
//
// 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-3,2,-3,4,2]
//输出：5
//解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
//                累加求和
//                startValue = 4 | startValue = 5 | nums
//                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2]
//输出：1
//解释：最小的 startValue 需要是正数。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-2,-3]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// -100 <= nums[i] <= 100 
// 
//
// Related Topics 数组 前缀和 👍 54 👎 0

package leetcode.editor.cn

import kotlin.math.abs

/**
 * 1413
 * 逐步求和得到正数的最小值
 *
 * @author Gargantua丶
 * 2022-08-09 09:25:58
 */
class MinimumValueToGetPositiveStepByStepSum {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minStartValue(nums: IntArray): Int {
        var sum = 0
        var min = Int.MAX_VALUE
        nums.forEach {
            sum += it
            min = min.coerceAtMost(sum)
        }
        return kotlin.math.abs(minOf(0, min)) + 1
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}