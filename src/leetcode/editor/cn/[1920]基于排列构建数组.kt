//给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.
//length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。 
//
// 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,2,1,5,3,4]
//输出：[0,1,2,4,5,3]
//解释：数组 ans 构建如下：
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4
//]], nums[nums[5]]]
//    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
//    = [0,1,2,4,5,3] 
//
// 示例 2： 
//
// 
//输入：nums = [5,0,1,2,3,4]
//输出：[4,5,0,1,2,3]
//解释：数组 ans 构建如下：
//ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4
//]], nums[nums[5]]]
//    = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
//    = [4,5,0,1,2,3] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] < nums.length 
// nums 中的元素 互不相同 
// 
//
// 
//
// 进阶：你能在不使用额外空间的情况下解决此问题吗（即 O(1) 内存）？ 
//
// Related Topics 数组 模拟 👍 100 👎 0


package leetcode.editor.cn

/**
 * 1920
 * 基于排列构建数组
 * 
 * @author Gargantua丶
 * 2025-05-06 14:58:21
 */
private class BuildArrayFromPermutation {	
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun buildArray(nums: IntArray): IntArray {

        for (i in nums.indices) {
            nums[i] = nums[i] shl 10
        }

        for (i in nums.indices) {
            val value = nums[nums[i] ushr 10] ushr 10
            nums[i] = nums[i] or value
        }

        for (i in nums.indices) {
            nums[i] = nums[i] and ((1 shl 10) - 1)
        }

        return nums
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}