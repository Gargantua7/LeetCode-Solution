//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 
// 👍 1240 👎 0


package leetcode.editor.cn

/**
 * 96
 * 不同的二叉搜索树
 *
 * @author Gargantua丶
 * 2021-07-25 02:05:29
 */
class UniqueBinarySearchTrees {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun numTrees(n: Int): Int {
            val dp = IntArray(n + 2)
            dp[1] = 1
            for (i in 2..n + 1) {
                var sum = 0
                for (j in 1..i / 2) {
                    sum += dp[j] * dp[i - j] * if (j == i - j) 1 else 2
                }
                dp[i] = sum
            }
            return dp[n + 1]
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}