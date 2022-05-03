//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// Related Topics 数组 双指针 排序 
// 👍 146 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 21
 * 调整数组顺序使奇数位于偶数前面
 *
 * @author Gargantua丶
 * 2021-08-08 00:15:31
 */
class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun exchange(nums: IntArray): IntArray {
        val odd = ArrayList<Int>()
        val even = ArrayList<Int>()
        nums.forEach { if (it % 2 == 0) even += it else odd += it }
        odd += even
        return odd.toIntArray()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}