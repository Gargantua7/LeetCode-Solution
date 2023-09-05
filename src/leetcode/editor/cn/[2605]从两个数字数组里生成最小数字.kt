//给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数
//字的某个数位。
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,1,3], nums2 = [5,7]
//输出：15
//解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
//输出：3
//解释：数字 3 的数位 3 在两个数组中都出现了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 9 
// 1 <= nums1[i], nums2[i] <= 9 
// 每个数组中，元素 互不相同 。 
// 
//
// Related Topics 数组 哈希表 枚举 👍 58 👎 0


package leetcode.editor.cn

/**
 * 2605
 * 从两个数字数组里生成最小数字
 *
 * @author Gargantua丶
 * 2023-09-05 14:59:12
 */
class FormSmallestNumberFromTwoDigitArrays {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        val set1 = nums1.toSet()
        nums2.filter { it in set1 }.minOrNull()?.let { return it }
        val a = nums1.min()!!
        val b = nums2.min()!!
        return minOf(a, b) * 10 + maxOf(a, b)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}