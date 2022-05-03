//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100] 
//
// 示例 2： 
//
// 
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums 已按 非递减顺序 排序 
// 
//
// 
//
// 进阶： 
//
// 
// 请你设计时间复杂度为 O(n) 的算法解决本问题 
// 
// Related Topics 数组 双指针 排序 
// 👍 270 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayList

/**
 * 977
 * 有序数组的平方
 *
 * @author Gargantua丶
 * 2021-08-13 00:25:23
 */
class SquaresOfASortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun sortedSquares(nums: IntArray): IntArray {
            val list = ArrayList<Int>()
            var min = 0
            for (n in nums.indices) {
                if (Math.abs(nums[n]) < Math.abs(nums[min])) min = n
            }
            var left = min
            var right = min + 1
            while (left >= 0 || right < nums.size) {
                if (left < 0) {
                    list += nums[right] * nums[right]
                    right++
                } else if (right > nums.lastIndex) {
                    list += nums[left] * nums[left]
                    left--
                } else if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                    list += nums[left] * nums[left]
                    left--
                } else {
                    list += nums[right] * nums[right]
                    right++
                }
            }
            return list.toIntArray()
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}