//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 365 👎 0

package leetcode.editor.cn

/**
 * 219
 * 存在重复元素 II
 * 
 * @author Gargantua丶
 * 2022-01-19 03:12:02
 */
class ContainsDuplicateIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = HashSet<Int>()
        nums.forEachIndexed { i, n ->
            if (n in set) return true
            set += n
            if (set.size > k) set -= nums[i - k]
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { i, n ->
            val prev = map[n]?: (- k - 1)
            if (Math.abs(i - prev) <= k) return true
            map[n] = i
        }
        return false
    }
}
