//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构) 
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。 
//
// 例如: 
//给定的树 A: 
//
// 3 
// / \ 
// 4 5 
// / \ 
// 1 2 
//给定的树 B： 
//
// 4 
// / 
// 1 
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。 
//
// 示例 1： 
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true 
//
// 限制： 
//
// 0 <= 节点个数 <= 10000 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 315 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 26
 * 树的子结构
 *
 * @author Gargantua丶
 * 2021-08-09 00:29:15
 */
class ShuDeZiJieGouLcof {
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

        fun isSubStructure(A: TreeNode?, B: TreeNode?): Boolean {
            return if (A == null || B == null) false else judge(A, B)
                    || isSubStructure(A.left, B) || isSubStructure(A.right, B)
        }

        private fun judge(A: TreeNode?, B: TreeNode?): Boolean {
            return if (A == null || B == null) B == null else A.`val` == B.`val`
                    && judge(A.left, B.left) && judge(A.right, B.right)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}