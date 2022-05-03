//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 128 👎 0

package leetcode.editor.cn

/**
 * 1305
 * 两棵二叉搜索树中的所有元素
 * 
 * @author Gargantua丶
 * 2022-05-01 20:17:42
 */
class AllElementsInTwoBinarySearchTrees {
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
    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list1 = ArrayList<Int>()
        val list2 = ArrayList<Int>()
        mid(root1, list1)
        mid(root2, list2)
        val list = ArrayList<Int>()
        var idx1 = 0
        var idx2 = 0
        while (idx1 in list1.indices || idx2 in list2.indices) {
            if (idx1 in list1.indices && idx2 in list2.indices) {
                if (list1[idx1] < list2[idx2]) {
                    list.add(list1[idx1])
                    idx1++
                } else {
                    list.add(list2[idx2])
                    idx2++
                }
            } else if (idx1 in list1.indices) {
                list.add(list1[idx1])
                idx1++
            } else {
                list.add(list2[idx2])
                idx2++
            }
        }
        return list
    }

    fun mid(node: TreeNode?, target: ArrayList<Int>) {
        node?: return
        mid(node.left, target)
        target.add(node.`val`)
        mid(node.right, target)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
