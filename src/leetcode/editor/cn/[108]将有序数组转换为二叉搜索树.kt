//给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。 
//
// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-10,-3,0,5,9]
//输出：[0,-3,9,-10,null,5]
//解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
//
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：[3,1]
//解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 按 严格递增 顺序排列 
// 
// Related Topics 树 二叉搜索树 数组 分治 二叉树 👍 818 👎 0


package leetcode.editor.cn
/**
 * 108
 * 将有序数组转换为二叉搜索树
 *
 * @author Gargantua丶
 * 2021-08-26 00:08:06
 */
class ConvertSortedArrayToBinarySearchTree { 
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
    fun sortedArrayToBST(nums: IntArray): TreeNode {
        val head = TreeNode(nums[nums.size / 2])
        buildTree(nums, 0, nums.size / 2, head)
        buildTree(nums, nums.size / 2 + 1, nums.size, head)
        return head
    }

    fun buildTree(nums: IntArray, low: Int, top: Int, head: TreeNode) {
        if(low == top) return
        val mid = (top + low) / 2
        val node = TreeNode(nums[mid])
        if (head.`val` > nums[mid]) head.left = node else head.right = node
        buildTree(nums, low, mid, node)
        buildTree(nums, mid + 1, top, node)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}