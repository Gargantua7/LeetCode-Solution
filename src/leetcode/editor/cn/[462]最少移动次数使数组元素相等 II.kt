//给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。 
//
// 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：2
//解释：
//只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
//[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,2,9]
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 数学 排序 👍 247 👎 0

package leetcode.editor.cn

/**
 * 462
 * 最少移动次数使数组元素相等 II
 * 
 * @author Gargantua丶
 * 2022-05-20 23:09:38
 */
class MinimumMovesToEqualArrayElementsIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val mid = nums[nums.lastIndex / 2]
        // Warning : sumOf since Kotlin 1.4, replace of sumBy in Kotlin 1.3
        return nums.sumOf { Math.abs(it - mid) }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
