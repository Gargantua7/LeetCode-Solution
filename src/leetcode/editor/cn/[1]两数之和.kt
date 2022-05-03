//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？ 
// Related Topics 数组 哈希表 
// 👍 11584 👎 0


package leetcode.editor.cn

/**
 * 1
 * 两数之和
 *
 * @author Gargantua丶
 * 2021-07-16 00:29:49
 */
class TwoSum {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun twoSum(nums: IntArray, target: Int): IntArray {
            val map = HashMap<Int, Int>()
            nums.forEachIndexed { i, num ->
                val n = target - num
                if (n in map) return intArrayOf(i, map[n]!!)
                map[num] = i
            }
            return intArrayOf(0, 1)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}