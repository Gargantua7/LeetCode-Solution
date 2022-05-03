//找出数组中重复的数字。 
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 
// 👍 500 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 03
 * 数组中重复的数字
 *
 * @author Gargantua丶
 * 2021-08-05 00:45:53
 */
class ShuZuZhongZhongFuDeShuZiLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun findRepeatNumber(nums: IntArray): Int {
            val set = HashSet<Int>()
            nums.forEach { num ->
                if (num in set) return num else set += num
            }
            return nums[0]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}