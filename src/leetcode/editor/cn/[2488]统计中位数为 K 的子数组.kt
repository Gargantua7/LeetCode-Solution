//给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。 
//
// 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。 
//
// 注意： 
//
// 
// 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。 
// 
//
// 
// 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。 
// 
// 
// 子数组是数组中的一个连续部分。 
//
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,4,5], k = 4
//输出：3
//解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,1], k = 3
//输出：1
//解释：[3] 是唯一一个中位数等于 3 的子数组。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i], k <= n 
// nums 中的整数互不相同 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 37 👎 0


package leetcode.editor.cn

/**
 * 2488
 * 统计中位数为 K 的子数组
 *
 * @author Gargantua丶
 * 2023-03-16 00:08:20
 */
class CountSubarraysWithMedianK {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Int {
        val map = HashMap<Int, Int>()
        var prev = 0
        var index = -1
        map[0] = 1
        while (nums[++index] != k) {
            prev += if (nums[index] < k) -1 else 1
            map[prev] = (map[prev]?: 0) + 1
        }
        var ans = 0
        ans += map[prev]?: 0
        ans += map[prev - 1]?: 0
        while (++index < nums.size) {
            prev += if (nums[index] < k) -1 else 1
            ans += map[prev]?: 0
            ans += map[prev - 1]?: 0
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}