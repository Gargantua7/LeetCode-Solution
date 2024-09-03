//给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 
//最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[
//i2] * ... * nums[ik] 。 
//
// 请你返回老师创建的小组能得到的最大实力值为多少。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,-1,-5,2,5,-9]
//输出：1350
//解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这
//是可以得到的最大实力值。
// 
//
// 示例 2： 
//
// 输入：nums = [-4,-5,-4]
//输出：20
//解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 13 
// -9 <= nums[i] <= 9 
// 
//
// Related Topics 贪心 位运算 数组 动态规划 回溯 枚举 排序 👍 46 👎 0


package leetcode.editor.cn

/**
 * 2708
 * 一个小组的最大实力值
 *
 * @author Gargantua丶
 * 2024-09-03 15:08:36
 */
class MaximumStrengthOfAGroup {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxStrength(nums: IntArray): Long {
        if (nums.size == 1) return nums.single().toLong()
        val arr = nums.filterNot { it == 0 }
        return when (arr.size) {
            0 -> 0L
            1 -> arr.single().toLong().takeIf { it > 0 } ?: 0
            else -> {
                var maxNeg = Int.MIN_VALUE
                arr.fold(1L) { acc, it ->
                    if (it < 0) maxNeg = maxOf(maxNeg, it)
                    acc * it
                }.let {
                    if (it > 0) it else it / maxNeg
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}