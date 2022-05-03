//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// Related Topics 位运算 数组 👍 461 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 56 - I
 * 数组中数字出现的次数
 *
 * @author Gargantua丶
 * 2021-09-07 13:34:13
 */
class ShuZuZhongShuZiChuXianDeCiShuLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun singleNumbers(nums: IntArray): IntArray {
        var ret = 0
        for (n in nums) {
            ret = ret xor n
        }
        var div = 1
        while (div and ret == 0) {
            div = div shl 1
        }
        var a = 0
        var b = 0
        for (n in nums) {
            if (div and n != 0) {
                a = a xor n
            } else {
                b = b xor n
            }
        }
        return intArrayOf(a, b)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}