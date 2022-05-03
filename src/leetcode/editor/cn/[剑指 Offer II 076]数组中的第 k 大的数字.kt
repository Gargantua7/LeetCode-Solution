//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-
//array/ 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 7 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 076
 * 数组中的第 k 大的数字
 *
 * @author Gargantua丶
 * 2021-10-23 13:53:01
 */
class Xx4gT2 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findKthLargest(nums: IntArray, k: Int): Int {
            return quick(nums,0, nums.lastIndex, nums.size - k)
        }

        fun quick(nums: IntArray, left: Int, right: Int, index: Int): Int {
            val r = (left..right).random()
            nums.swap(r, right)
            var i = left - 1
            for (j in left until right) {
                if (nums[j] <= nums[right]) nums.swap(++i, j)
            }
            nums.swap(++i, right)
            return if (i == index) nums[i]
            else if (i < index) quick(nums, i + 1, right, index)
            else quick(nums, left, i - 1, index)
        }

        fun IntArray.swap(i: Int, j: Int) {
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}