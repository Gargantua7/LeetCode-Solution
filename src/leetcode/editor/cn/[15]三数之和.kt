//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 3720 👎 0


package leetcode.editor.cn

import java.util.*


/**
 * 15
 * 三数之和
 *
 * @author Gargantua丶
 * 2021-09-07 13:27:12
 */
class ThreeSum { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        Arrays.sort(nums)
        val ans: MutableList<List<Int>> = ArrayList()
        // 枚举 a
        // 枚举 a
        for (first in 0 until n) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue
            }
            // c 对应的指针初始指向数组的最右端
            var third = n - 1
            val target = -nums[first]
            // 枚举 b
            for (second in first + 1 until n) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break
                }
                if (nums[second] + nums[third] == target) {
                    val list: MutableList<Int> = ArrayList()
                    list.add(nums[first])
                    list.add(nums[second])
                    list.add(nums[third])
                    ans.add(list)
                }
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}