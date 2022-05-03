//你有一大块巧克力，它由一些甜度不完全相同的小块组成。我们用数组 sweetness 来表示每一小块的甜度。 
//
// 你打算和 K 名朋友一起分享这块巧克力，所以你需要将切割 K 次才能得到 K+1 块，每一块都由一些 连续 的小块组成。 
//
// 为了表现出你的慷慨，你将会吃掉 总甜度最小 的一块，并将其余几块分给你的朋友们。 
//
// 请找出一个最佳的切割策略，使得你所分得的巧克力 总甜度最大，并返回这个 最大总甜度。 
//
// 
//
// 示例 1： 
//
// 输入：sweetness = [1,2,3,4,5,6,7,8,9], K = 5
//输出：6
//解释：你可以把巧克力分成 [1,2,3], [4,5], [6], [7], [8], [9]。
// 
//
// 示例 2： 
//
// 输入：sweetness = [5,6,7,8,9,1,2,3,4], K = 8
//输出：1
//解释：只有一种办法可以把巧克力分成 9 块。
// 
//
// 示例 3： 
//
// 输入：sweetness = [1,2,2,1,2,2,1,2,2], K = 2
//输出：5
//解释：你可以把巧克力分成 [1,2,2], [1,2,2], [1,2,2]。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= K < sweetness.length <= 10^4 
// 1 <= sweetness[i] <= 10^5 
// 
// Related Topics 数组 二分查找 👍 63 👎 0

package leetcode.editor.cn

/**
 * 1231
 * 分享巧克力
 * 
 * @author Gargantua丶
 * 2021-12-08 15:38:07
 */
class DivideChocolate {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maximizeSweetness(sweetness: IntArray, k: Int): Int {
        var left = sweetness[0]
        var right = sweetness[0]
        val len = sweetness.size
        for (i in 1 until len) {
            left = Math.min(left, sweetness[i])
            right += sweetness[i]
        }
        var ans = 0
        while (left <= right) {
            val mid = (left + right) / 2
            val `val` = check(sweetness, k + 1, mid)
            if (`val`[0] <= 0) {
                left = mid + 1
                ans = `val`[1]
            } else right = mid - 1
        }
        return ans
    }

    fun check(nums: IntArray, k1: Int, mid: Int): IntArray {
        var k = k1
        val len = nums.size
        var sum = 0
        var min = Int.MAX_VALUE
        for (i in 0 until len) {
            sum += nums[i]
            if (sum >= mid) {
                min = Math.min(sum, min)
                sum = 0
                k--
            }
        }
        return intArrayOf(k, min)
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}