//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 360 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import kotlin.math.max

class Solution525 {
    fun findMaxLength(nums: IntArray): Int {
        var ans = 0
        val map = HashMap<Int, Int>()
        var counter = 0
        map[counter] = -1
        nums.forEachIndexed { i, num ->
            if (num == 1) counter++ else counter--
            map[counter]?.let { ans = max(ans, i - it) } ?: let { map[counter] = i }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)
