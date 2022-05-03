//给你一棵二叉树，请按以下要求的顺序收集它的全部节点： 
//
// 
// 依次从左到右，每次收集并删除所有的叶子节点 
// 重复如上过程直到整棵树为空 
// 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4,5]
//  
//          1
//         / \
//        2   3
//       / \     
//      4   5    
//
//输出: [[4,5,3],[2],[1]]
// 
//
// 
//
// 解释: 
//
// 1. 删除叶子节点 [4,5,3] ，得到如下树结构： 
//
//           1
//         / 
//        2          
// 
//
// 
//
// 2. 现在删去叶子节点 [2] ，得到如下树结构： 
//
//           1          
// 
//
// 
//
// 3. 现在删去叶子节点 [1] ，得到空树： 
//
//           []         
// 
// Related Topics 树 深度优先搜索 二叉树 👍 141 👎 0

package leetcode.editor.cn

/**
 * 366
 * 寻找二叉树的叶子节点
 *
 * @author Gargantua丶
 * 2021-11-23 13:42:17
 */
class FindLeavesOfBinaryTree {
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
        fun findLeaves(root: TreeNode?): List<List<Int>> {
            val map = HashMap<Int, ArrayList<Int>>()
            dfs(root ?: return emptyList(), map)
            val size = map.keys.fold(0) { max, it -> maxOf(max, it) }
            val ans = ArrayList<List<Int>>()
            for (i in 1..size) {
                ans.add(map[i]?: emptyList())
            }
            return ans
        }

        fun dfs(node: TreeNode, map: HashMap<Int, ArrayList<Int>>): Int {
            val left = node.left?.let { dfs(it, map) } ?: 0
            val right = node.right?.let { dfs(it, map) } ?: 0

            val depth = maxOf(left, right) + 1
            if (depth !in map) map[depth] = ArrayList()
            map[depth]!!.add(node.`val`)
            return depth
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}