//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 1046 👎 0


package leetcode.editor.cn

/**
 * 560
 * 和为K的子数组
 *
 * @author Gargantua丶
 * 2021-08-16 01:16:21
 */
class SubarraySumEqualsK {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun subarraySum(nums: IntArray, k: Int): Int {
            val map = HashMap<Int, Int>()
            var sum = 0
            var count = 0
            nums.forEach { n ->
                map[sum] = (map[sum] ?: 0) + 1
                sum += n
                if (sum - k in map) count += map[sum - k]!!
            }
            return count
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}