//给你一个整数数组 nums 和一个整数 k。 
//
// 你可以对数组中的每个元素 最多 执行 一次 以下操作： 
//
// 
// 将一个在范围 [-k, k] 内的整数加到该元素上。 
// 
//
// 返回执行这些操作后，nums 中可能拥有的不同元素的 最大 数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,2,3,3,4], k = 2 
// 
//
// 输出： 6 
//
// 解释： 
//
// 对前四个元素执行操作，nums 变为 [-1, 0, 1, 2, 3, 4]，可以获得 6 个不同的元素。 
//
// 示例 2： 
//
// 
// 输入： nums = [4,4,4,4], k = 1 
// 
//
// 输出： 3 
//
// 解释： 
//
// 对 nums[0] 加 -1，以及对 nums[1] 加 1，nums 变为 [3, 5, 4, 4]，可以获得 3 个不同的元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// 
//
// Related Topics 贪心 数组 排序 👍 13 👎 0


package leetcode.editor.cn

/*** 3397
* 执行操作后不同元素的最大数量
*
* @author Gargantua7
* 2025-10-18 02:32:33
*/
class MaximumNumberOfDistinctElementsAfterOperations {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxDistinctElements(nums: IntArray, k: Int): Int {
        nums.sort()

        for (i in nums.indices) {
            nums[i] = (nums.getOrElse(i - 1) { Int.MIN_VALUE } + 1).coerceIn(nums[i] - k, nums[i] + k)
        }

        return nums.toSet().size
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}