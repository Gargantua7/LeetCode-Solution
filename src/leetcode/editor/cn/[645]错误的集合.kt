//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 位运算 数组 哈希表 排序 
// 👍 208 👎 0


package leetcode.editor.cn
/**
 * 645
 * 错误的集合
 *
 * @author Gargantua丶
 * 2021-07-04 20:36:33
 */
class SetMismatch { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findErrorNums(nums: IntArray): IntArray {
        val xor = nums.foldIndexed(0) { i, curr, num -> (curr xor num) xor (i + 1) }
        val lowBit = xor and -xor
        var num1 = 0
        var num2 = 0
        nums.forEachIndexed { i, num ->
            if((num and lowBit) == 0) num1 = num1 xor num else num2 = num2 xor num
            if(((i + 1) and lowBit) == 0) num1 = num1 xor (i + 1) else num2 = num2 xor (i + 1)
        }
        nums.forEach { num -> if(num == num1) return intArrayOf(num1, num2) }
        return intArrayOf(num2, num1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}