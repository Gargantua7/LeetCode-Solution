//给你一个 下标从 0 开始 的整数数组 nums ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ： 
//
// 
// nums[a] + nums[b] + nums[c] == nums[d] ，且 
// a < b < c < d 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,3,6]
//输出：1
//解释：满足要求的唯一一个四元组是 (0, 1, 2, 3) 因为 1 + 2 + 3 == 6 。
// 
//
// 示例 2： 
//
// 输入：nums = [3,3,6,4,5]
//输出：0
//解释：[3,3,6,4,5] 中不存在满足要求的四元组。
// 
//
// 示例 3： 
//
// 输入：nums = [1,1,1,3,5]
//输出：4
//解释：满足要求的 4 个四元组如下：
//- (0, 1, 2, 3): 1 + 1 + 1 == 3
//- (0, 1, 3, 4): 1 + 1 + 3 == 5
//- (0, 2, 3, 4): 1 + 1 + 3 == 5
//- (1, 2, 3, 4): 1 + 1 + 3 == 5
// 
//
// 
//
// 提示： 
//
// 
// 4 <= nums.length <= 50 
// 1 <= nums[i] <= 100 
// 
// Related Topics 数组 枚举 👍 77 👎 0

package leetcode.editor.cn

/**
 * 1995
 * 统计特殊四元组
 * 
 * @author Gargantua丶
 * 2021-12-29 19:26:59
 */
class CountSpecialQuadruplets {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    var count = 0

    fun countQuadruplets(nums: IntArray): Int {
        val n = nums.size
        count = 0
        if (n < 4) return 0
        dfs(nums, 0, n, 0, 0)
        return count
    }

    fun dfs(nums: IntArray, depth: Int, len: Int, s: Int, begin: Int) {
        var sum = s
        if (depth == 3) {
            for (i in begin until len) {
                if (sum == nums[i]) {
                    count++
                }
            }
            return
        }
        for (i in begin until len - 1) {
            sum += nums[i]
            dfs(nums, depth + 1, len, sum, i + 1)
            sum -= nums[i]
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}