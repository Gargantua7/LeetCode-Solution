//给定一个数组 A，我们可以将它按一个非负整数 K 进行轮调，这样可以使数组变为 A[K], A[K+1], A{K+2], ... A[A.length -
// 1], A[0], A[1], ..., A[K-1] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。 
//
// 例如，如果数组为 [2, 4, 1, 3, 0]，我们按 K = 2 进行轮调后，它将变成 [1, 3, 0, 2, 4]。这将记作 3 分，因为 1 >
// 0 [no points], 3 > 1 [no points], 0 <= 2 [one point], 2 <= 3 [one point], 4 <= 
//4 [one point]。 
//
// 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调索引 K。如果有多个答案，返回满足条件的最小的索引 K。 
//
// 
//
// 示例 1： 
//
// 输入：[2, 3, 1, 4, 0]
//输出：3
//解释：
//下面列出了每个 K 的得分：
//K = 0,  A = [2,3,1,4,0],    score 2
//K = 1,  A = [3,1,4,0,2],    score 3
//K = 2,  A = [1,4,0,2,3],    score 3
//K = 3,  A = [4,0,2,3,1],    score 4
//K = 4,  A = [0,2,3,1,4],    score 3
//所以我们应当选择 K = 3，得分最高。 
//
// 示例 2： 
//
// 输入：[1, 3, 0, 2, 4]
//输出：0
//解释：
//A 无论怎么变化总是有 3 分。
//所以我们将选择最小的 K，即 0。
// 
//
// 
//
// 提示： 
//
// 
// A 的长度最大为 20000。 
// A[i] 的取值范围是 [0, A.length]。 
// 
// Related Topics 数组 前缀和 👍 77 👎 0

package leetcode.editor.cn

/**
 * 798
 * 得分最高的最小轮调
 *
 * @author Gargantua丶
 * 2022-03-09 01:46:32
 */
class SmallestRotationWithHighestScore {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun bestRotation(nums: IntArray): Int {
            val diffs = IntArray(nums.size)
            for (i in nums.indices) {
                val low = (i + 1) % nums.size
                val high = (i - nums[i] + nums.size + 1) % nums.size
                diffs[low]++
                diffs[high]--
                if (low >= high) {
                    diffs[0]++
                }
            }
            var bestIndex = 0
            var maxScore = 0
            var score = 0
            for (i in nums.indices) {
                score += diffs[i]
                if (score > maxScore) {
                    bestIndex = i
                    maxScore = score
                }
            }
            return bestIndex


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
