//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 
// 👍 1962 👎 0


package leetcode.editor.cn
/**
 * 136
 * 只出现一次的数字
 *
 * @author Gargantua丶
 * 2021-08-12 00:40:03
 */
class SingleNumber { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun singleNumber(nums: IntArray): Int {
        return nums.fold(0) { ans, n -> ans xor n }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}