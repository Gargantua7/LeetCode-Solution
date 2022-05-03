//输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。 
//
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 521 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer 07
 * 重建二叉树
 *
 * @author Gargantua丶
 * 2021-08-05 01:19:14
 */
class ZhongJianErChaShuLcof {
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

        fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
            if (preorder.isEmpty()) return null
            val ans = TreeNode(preorder[0])
            val stack: Deque<TreeNode> = LinkedList(arrayListOf(ans))
            var index = 0
            for (i in 1..preorder.lastIndex) {
                val preVal = preorder[i]
                var node = stack.peek()
                if (inorder[index] != node.`val`) {
                    node.left = TreeNode(preVal)
                    stack.push(node.left)
                } else {
                    while (stack.isNotEmpty() && stack.peek().`val` == inorder[index]) {
                        node = stack.pop()
                        index++
                    }
                    node.right = TreeNode(preVal)
                    stack.push(node.right)
                }
            }
            return ans
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}