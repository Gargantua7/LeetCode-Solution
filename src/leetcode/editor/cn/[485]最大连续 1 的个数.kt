//给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// Related Topics 数组 👍 462 👎 0


package leetcode.editor.cn

/*** 485
* 最大连续 1 的个数
*
* @author Gargantua7
* 2025-12-01 02:27:56
*/
class MaxConsecutiveOnes {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        return nums.runningFold(0) { acc, i -> if (i == 1) acc + 1 else 0 }.max()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}