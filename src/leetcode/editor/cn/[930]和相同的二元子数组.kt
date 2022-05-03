//给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。 
//
// 子数组 是数组的一段连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,0,1], goal = 2
//输出：4
//解释：
//如下面黑体所示，有 4 个满足题目要求的子数组：
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
//[1,0,1,0,1]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0,0,0], goal = 0
//输出：15
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// nums[i] 不是 0 就是 1 
// 0 <= goal <= nums.length 
// 
// Related Topics 数组 哈希表 前缀和 滑动窗口 
// 👍 113 👎 0


package leetcode.editor.cn
/**
 * 930
 * 和相同的二元子数组
 *
 * @author Gargantua丶
 * 2021-07-08 02:26:25
 */
class BinarySubarraysWithSum { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        val map = HashMap<Int, Int>()
        var sum = 0
        var ans = 0
        nums.forEach { num ->
            map[sum] = (map[sum]?: 0) + 1
            sum += num
            ans += map[sum - goal]?: 0
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}