//给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。其中 a、b、c 和 
//d 都是 nums 中的元素，且 a != b != c != d 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,4,6]
//输出：8
//解释：存在 8 个满足题意的元组：
//(2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
//(3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,4,5,10]
//输出：16
//解释：存在 16 个满足题意的元组：
//(1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
//(2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
//(2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,5,4)
//(4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁴ 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 数组 哈希表 👍 76 👎 0


package leetcode.editor.cn

/**
 * 1726
 * 同积元组
 *
 * @author Gargantua丶
 * 2023-10-19 14:33:32
 */
class TupleWithSameProduct {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun tupleSameProduct(nums: IntArray): Int {
        var ans = 0
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            for (j in 0..< i) {
                val key = nums[i] * nums[j]
                val value = (map[key]?: 0)
                ans += value * 8
                map[key] = value + 1
            }
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}