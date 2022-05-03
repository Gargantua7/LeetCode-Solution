//给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。 
//
// 返回满足此条件的 任一数组 作为答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,1,2,4]
//输出：[2,4,3,1]
//解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// 0 <= nums[i] <= 5000 
// 
// Related Topics 数组 双指针 排序 👍 288 👎 0

package leetcode.editor.cn

/**
 * 905
 * 按奇偶排序数组
 * 
 * @author Gargantua丶
 * 2022-04-28 16:37:35
 */
class SortArrayByParity {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var i = 0
        var j = nums.lastIndex
        while (i < j) {
            if (nums[i] % 2 == 1) {
                while (nums[j] % 2 == 1 && i < j) {
                    j--
                }
                if (i >= j) break
                nums.swap(i, j)
            }
            i++
        }
        return nums
    }

    fun IntArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
