//给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：[3] 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：[1,1,1,3,3,2,2,2]
//输出：[1,2] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。 
// Related Topics 数组 哈希表 计数 排序 👍 413 👎 0


package leetcode.editor.cn

/**
 * 229
 * 求众数 II
 *
 * @author Gargantua丶
 * 2021-10-22 00:18:01
 */
class MajorityElementIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun majorityElement(nums: IntArray): List<Int> {
            val element = IntArray(2)
            val vote = IntArray(2)
            nums.forEach { n ->
                when (n) {
                    element[0] -> vote[0]++
                    element[1] -> vote[1]++
                    else -> when (0) {
                        vote[0] -> {
                            element[0] = n
                            vote[0]++
                        }
                        vote[1] -> {
                            element[1] = n
                            vote[1]++
                        }
                        else -> {
                            vote[0]--
                            vote[1]--
                        }
                    }
                }

            }

            val ans = ArrayList<Int>()
            if (vote[0] > 0 && nums.count { it == element[0] } > nums.size / 3) ans += element[0]
            if (vote[1] > 0 && nums.count { it == element[1] } > nums.size / 3) ans += element[1]
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}