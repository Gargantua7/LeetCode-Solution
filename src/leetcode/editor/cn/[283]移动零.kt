//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1171 👎 0


package leetcode.editor.cn

/**
 * 283
 * 移动零
 *
 * @author Gargantua丶
 * 2021-08-14 00:16:53
 */
class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun moveZeroes(nums: IntArray): Unit {
            var temp = 0
            for (i in nums.indices) {
                if (i + temp > nums.lastIndex) {
                    nums[i] = 0
                    continue
                }
                nums[i] = nums[i + temp]
                while (nums[i] == 0) {
                    temp++
                    if (i + temp > nums.lastIndex) break
                    nums[i] = nums[i + temp]
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}