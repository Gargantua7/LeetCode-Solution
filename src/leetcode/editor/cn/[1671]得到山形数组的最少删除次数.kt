//我们定义 arr 是 山形数组 当且仅当它满足： 
//
// 
// arr.length >= 3 
// 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且： 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给你整数数组 nums ，请你返回将 nums 变成 山形状数组 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1]
//输出：0
//解释：数组本身就是山形数组，所以我们不需要删除任何元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,1,5,6,2,3,1]
//输出：3
//解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 题目保证 nums 删除一些元素后一定能得到山形数组。 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 👍 87 👎 0


package leetcode.editor.cn

/**
 * 1671
 * 得到山形数组的最少删除次数
 *
 * @author Gargantua丶
 * 2023-12-22 13:54:02
 */
class MinimumNumberOfRemovalsToMakeMountainArray {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun minimumMountainRemovals(nums: IntArray): Int {
        val pre = lengthOfLIS(nums)
        val suf = lengthOfLIS(nums.reversedArray()).reversedArray()

        var ans = 0
        for (i in nums.indices) {
            if (pre[i] > 1 && suf[i] > 1) {
                ans = maxOf(ans, pre[i] + suf[i] - 1)
            }
        }

        return nums.size - ans
    }

    fun lengthOfLIS(nums: IntArray): IntArray {
        val dp = IntArray(nums.size) { 1 }
        for (i in 1..dp.lastIndex) {
            for (j in 0 until i) {
                if(nums[j] < nums[i]) dp[i] = maxOf(dp[i], dp[j] + 1)
            }
        }
        return dp
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}