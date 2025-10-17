//给你一个由 正整数 组成的数组 nums 。 
//
// 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。 
//
// 元素的 频率 是指该元素在数组中出现的次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,3,1,4]
//输出：4
//解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
//因此具有最大频率的元素在数组中的数量是 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：5
//解释：数组中的所有元素的频率都为 1 ，是最大频率。
//因此具有最大频率的元素在数组中的数量是 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 100 
// 
//
// Related Topics 数组 哈希表 计数 👍 24 👎 0


package leetcode.editor.cn

/*** 3005
* 最大频率元素计数
*
* @author Gargantua7
* 2025-10-17 20:17:25
*/
class CountElementsWithMaximumFrequency {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxFrequencyElements(nums: IntArray): Int {
        val map = nums.toList().groupingBy { it }.eachCount()
        val max = map.maxOf { it.value }
        return map.count { it.value == max } * max
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}