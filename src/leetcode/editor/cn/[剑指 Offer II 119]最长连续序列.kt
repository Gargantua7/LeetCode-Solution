//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 注意：本题与主站 128 题相同： https://leetcode-cn.com/problems/longest-consecutive-
//sequence/ 
// Related Topics 并查集 数组 哈希表 👍 7 👎 0

package leetcode.editor.cn


/**
 * 剑指 Offer II 119
 * 最长连续序列	
 *
 * @author Gargantua丶
 * 2021-11-06 13:01:02
 */
class WhsWhI { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = HashSet<Int>()
        for (num in nums) {
            set.add(num)
        }
        var longestStreak = 0
        for (num in set) {
            if (!set.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1
                while (set.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }
                longestStreak = maxOf(longestStreak, currentStreak)
            }
        }
        return longestStreak
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}