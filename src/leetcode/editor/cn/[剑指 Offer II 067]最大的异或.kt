//给定一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
// 
// 
//
// 
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 注意：本题与主站 421 题相同： https://leetcode-cn.com/problems/maximum-xor-of-two-
//numbers-in-an-array/ 
// Related Topics 位运算 字典树 数组 哈希表 👍 6 👎 0


package leetcode.editor.cn

import kotlin.math.sign

/**
 * 剑指 Offer II 067
 * 最大的异或
 *
 * @author Gargantua丶
 * 2021-10-19 14:17:58
 */
class Ms70jA {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class BinaryTrieNode {

            var zero: BinaryTrieNode? = null
            var one: BinaryTrieNode? = null

            operator fun get(value: Int) = if (value == 0) zero else one
            operator fun set(value: Int, node: BinaryTrieNode) = if (value == 0) zero = node else one = node
        }

        fun findMaximumXOR(nums: IntArray): Int {
            val root = BinaryTrieNode()
            nums.forEach { num ->
                var temp = root
                for (i in 30 downTo 0) {
                    val n = num shr i and 1
                    if (temp[n] == null) temp[n] = BinaryTrieNode()
                    temp = temp[n]!!
                }
            }
            return dfs(root, root, 0)
        }

        fun dfs(node1: BinaryTrieNode, node2: BinaryTrieNode, temp: Int): Int {
            var xor = false
            var max = temp
            if (node1[0] != null && node2[1] != null) {
                max = max.coerceAtLeast(dfs(node1[0]!!, node2[1]!!, (temp shl 1) + 1))
                xor = true
            }
            if (node1[1] != null && node2[0] != null) {
                max = max.coerceAtLeast(dfs(node1[1]!!, node2[0]!!, (temp shl 1) + 1))
                xor = true
            }
            if (!xor) {
                if (node1[0] != null && node2[0] != null)
                    max = max.coerceAtLeast(dfs(node1[0]!!, node2[0]!!, temp shl 1))
                if (node1[1] != null && node2[1] != null)
                    max = max.coerceAtLeast(dfs(node1[1]!!, node2[1]!!, temp shl 1))
            }
            return max
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}