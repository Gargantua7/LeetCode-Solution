//给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。 
//
// 注意，根节点 root 位于深度 1 。 
//
// 加法规则如下: 
//
// 
// 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。 
// cur 原来的左子树应该是新的左子树根的左子树。 
// cur 原来的右子树应该是新的右子树根的右子树。 
// 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [4,2,6,3,1,5], val = 1, depth = 2
//输出: [4,1,1,2,null,null,6,3,1,5] 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [4,2,null,3,1], val = 1, depth = 3
//输出:  [4,2,null,1,1,3,null,null,1]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// 树的深度在 [1, 10⁴]范围内 
// -100 <= Node.val <= 100 
// -10⁵ <= val <= 10⁵ 
// 1 <= depth <= the depth of tree + 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 141 👎 0

package leetcode.editor.cn

/**
 * 623
 * 在二叉树中增加一行
 *
 * @author Gargantua丶
 * 2022-08-05 09:16:19
 */
class AddOneRowToTree {
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
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 1) return TreeNode(`val`).apply { left = root }
        root?: return null
        dfs(true, root, `val`, depth, 2)
        dfs(false, root, `val`, depth, 2)
        return root
    }

    fun dfs(isLeft: Boolean, parent: TreeNode, n: Int, depth: Int, curr: Int) {
        val node = if (isLeft) parent.left else parent.right
        if (depth == curr) {
            val next = TreeNode(n)
            if (isLeft) {
                parent.left = next.apply { left = node }
            } else {
                parent.right = next.apply { right = node }
            }
            return
        }
        node?: return

        dfs(true, node, n, depth, curr + 1)
        dfs(false, node, n, depth, curr + 1)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}