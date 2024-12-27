//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 268 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 449
 * 序列化和反序列化二叉搜索树
 *
 * @author Gargantua丶
 * 2022-05-11 00:08:54
 */
class SerializeAndDeserializeBst {
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
	// Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        return buildString {
            pre(root?: return "")
            deleteCharAt(lastIndex)
        }
    }

    private fun StringBuilder.pre(root: TreeNode) {
        append("${root.`val`},")
        root.left?.let { pre(it) }
        root.right?.let { pre(it) }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return data.ifEmpty { null }?.let { build(Int.MIN_VALUE, Int.MAX_VALUE, LinkedList(data.split(',').map(String::toInt))) }
    }

    private fun build(lower: Int, upper: Int, queue: LinkedList<Int>): TreeNode? {
        if (queue.isEmpty() || queue.peek() !in lower..upper) return null
        return TreeNode(queue.poll()).apply {
            left = build(lower, `val`, queue)
            right = build(`val`, upper, queue)
        }
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */
//leetcode submit region end(Prohibit modification and deletion)

}
