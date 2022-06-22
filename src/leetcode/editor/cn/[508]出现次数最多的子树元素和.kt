//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 190 👎 0

package leetcode.editor.cn


/**
 * 508
 * 出现次数最多的子树元素和
 * 
 * @author Gargantua丶
 * 2022-06-20 00:15:34
 */
class MostFrequentSubtreeSum {
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var cnt: MutableMap<Int, Int> = HashMap()
    var maxCnt = 0
    fun findFrequentTreeSum(root: TreeNode?): IntArray {
        dfs(root)
        val list: MutableList<Int> = ArrayList()
        for ((s, c) in cnt) {
            if (c == maxCnt) {
                list.add(s)
            }
        }
        val ans = IntArray(list.size)
        for (i in list.indices) {
            ans[i] = list[i]
        }
        return ans
    }

    fun dfs(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val sum = node.`val` + dfs(node.left) + dfs(node.right)
        cnt[sum] = cnt.getOrDefault(sum, 0) + 1
        maxCnt = Math.max(maxCnt, cnt[sum]!!)
        return sum
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}
