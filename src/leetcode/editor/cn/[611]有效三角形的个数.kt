//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 190 👎 0


package leetcode.editor.cn

/**
 * 611
 * 有效三角形的个数
 *
 * @author Gargantua丶
 * 2021-08-04 03:25:35
 */
class ValidTriangleNumber {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun triangleNumber(nums: IntArray): Int {
            var ans = 0
            nums.sort()
            nums.forEachIndexed { i, num ->
                var k = i
                for (j in i + 1..nums.lastIndex) {
                    while (k + 1 < nums.size && num + nums[j] > nums[k + 1]) ++k
                    if(k > j) ans += k - j
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}