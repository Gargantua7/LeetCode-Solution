//你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。 
//
// 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。 
//
// 请你返回 nums 中 所有 整数对里，数位不同之和。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [13,23,12] 
// 
//
// 输出：4 
//
// 解释： 计算过程如下： - 13 和 23 的数位不同为 1 。 - 13 和 12 的数位不同为 1 。 - 23 和 12 的数位不同为 2 。 所以
//所有整数数对的数位不同之和为 1 + 1 + 2 = 4 。 
//
// 示例 2： 
//
// 
// 输入：nums = [10,10,10,10] 
// 
//
// 输出：0 
//
// 解释： 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] < 10⁹ 
// nums 中的整数都有相同的数位长度。 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 35 👎 0


package leetcode.editor.cn

/**
 * 3153
 * 所有数对中数位不同之和
 *
 * @author Gargantua丶
 * 2024-08-30 13:54:46
 */
class SumOfDigitDifferencesOfAllPairs {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun sumDigitDifferences(nums: IntArray): Long {
        return nums.first().toString().indices.fold(0L) { acc, index ->
            val arr = IntArray(10)
            nums.forEach { n ->
                arr[n.toString()[index].digitToInt()]++
            }
            var size = nums.size
            acc + arr.fold(0L) { ac, it ->
                size -= it
                ac + (it.toLong() * size)
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}