//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 
// 👍 320 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 33
 * 二叉搜索树的后序遍历序列
 *
 * @author Gargantua丶
 * 2021-08-10 01:13:29
 */
class ErChaSouSuoShuDeHouXuBianLiXuLieLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun verifyPostorder(postorder: IntArray): Boolean {
        var lastSub = postorder[1] - postorder[0]
        for (i in 1..postorder.lastIndex) {
            val currSub = postorder[i] - postorder[i - 1]
            if(currSub * lastSub > 0) return false
            lastSub = currSub
        }
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}