//给你一个整数数组 nums，每次 操作 会从中选择一个元素并 将该元素的值减少 1。 
//
// 如果符合下列情况之一，则数组 A 就是 锯齿数组： 
//
// 
// 每个偶数索引对应的元素都大于相邻的元素，即 A[0] > A[1] < A[2] > A[3] < A[4] > ... 
// 或者，每个奇数索引对应的元素都大于相邻的元素，即 A[0] < A[1] > A[2] < A[3] > A[4] < ... 
// 
//
// 返回将数组 nums 转换为锯齿数组所需的最小操作次数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3]
//输出：2
//解释：我们可以把 2 递减到 0，或把 3 递减到 1。
// 
//
// 示例 2： 
//
// 输入：nums = [9,6,1,6,2]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 
//
// Related Topics 贪心 数组 👍 48 👎 0


package leetcode.editor.cn

/**
 * 1144
 * 递减元素使数组呈锯齿状
 *
 * @author Gargantua丶
 * 2023-02-27 00:04:24
 */
class DecreaseElementsToMakeArrayZigzag {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun movesToMakeZigzag(nums: IntArray): Int {
        return minOf(f(nums, 0), f(nums, 1))
    }

    fun f(nums: IntArray, start: Int): Int {
        var operation = 0
        for (i in start..nums.lastIndex step 2) {
            val left = if (i - 1 >= 0) nums[i - 1] else Int.MAX_VALUE
            val right = if (i + 1 < nums.size) nums[i + 1] else Int.MAX_VALUE
            val target = minOf(left, right)
            if (nums[i] >= target) operation += nums[i] - target + 1
        }
        return operation
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}