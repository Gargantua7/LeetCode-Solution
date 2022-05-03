//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 👍 1013 👎 0


package leetcode.editor.cn
/**
 * 24
 * 两两交换链表中的节点
 *
 * @author Gargantua丶
 * 2021-08-23 00:28:41
 */
class SwapNodesInPairs { 
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val new = ListNode(0)
        new.next = head
        var x: ListNode = new
        var y: ListNode = head?: return null
        var z: ListNode? = y.next ?: return head
        while (z != null) {
            x.next = z
            y.next = z.next
            z.next = y
            x = y
            y = y.next?: return new.next
            z = y.next
        }
        return new.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}