//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。 
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 187 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 39
 * 数组中出现次数超过一半的数字
 *
 * @author Gargantua丶
 * 2021-08-10 01:23:03
 */
class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun majorityElement(nums: IntArray): Int {
            val map = HashMap<Int, Int>()
            nums.forEach { num ->
                map[num] = 1 + (map[num] ?: 0)
                if (map[num]!! > nums.size / 2) return num
            }
            return nums[0]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}