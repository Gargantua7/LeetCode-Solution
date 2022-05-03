//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 
// 👍 274 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 24
 * 反转链表
 *
 * @author Gargantua丶
 * 2021-08-08 00:20:59
 */
class FanZhuanLianBiaoLcof { 
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
    fun reverseList(head: ListNode?): ListNode? {
        var p = head
        var q: ListNode? = null
        while (p != null) {
            val count = p.next
            p.next = q
            q = p
            p = count
        }
        return q
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}