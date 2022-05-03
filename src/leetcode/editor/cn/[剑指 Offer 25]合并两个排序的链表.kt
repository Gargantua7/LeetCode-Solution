//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 递归 链表 
// 👍 151 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 25
 * 合并两个排序的链表
 *
 * @author Gargantua丶
 * 2021-08-08 00:24:26
 */
class HeBingLiangGePaiXuDeLianBiaoLcof {
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

        fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
            val head = ListNode(0)
            var p = head
            var p1 = l1
            var p2 = l2
            var count: ListNode? = null
            while (p1 != null && p2 != null) {
                if (p1.`val` < p2.`val`) {
                    p.next = p1
                    p1 = p1.next
                } else {
                    p.next = p2
                    p2 = p2.next
                }
                p = p.next!!
            }
            if(p1 != null) p.next = p1
            if(p2 != null) p.next = p2
            return head.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}