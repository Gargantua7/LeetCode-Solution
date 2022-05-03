//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 
// 👍 152 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 61
 * 扑克牌中的顺子
 *
 * @author Gargantua丶
 * 2021-08-11 01:38:44
 */
class BuKePaiZhongDeShunZiLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun isStraight(nums: IntArray): Boolean {
        var joker = 0
        nums.sort()
        for (i in 0 until 4) {
            if (nums[i] == 0) joker++
            else if (nums[i] == nums[i + 1]) return false
        }
        return nums[4] - nums[joker] < 5
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}