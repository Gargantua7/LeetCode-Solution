//给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// 
//
// 注意：本题与主站 148 题相同：https://leetcode-cn.com/problems/sort-list/ 
// Related Topics 链表 双指针 分治 排序 归并排序 👍 13 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 077
 * 链表排序
 *
 * @author Gargantua丶
 * 2021-10-23 14:17:19
 */
class SevenWHec2 { 
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

    fun sortList(head: ListNode?): ListNode? {
        return sortList(head, null)
    }

    fun sortList(head: ListNode?, tail: ListNode?): ListNode? {
        if (head == null) {
            return head
        }
        if (head.next == tail) {
            head.next = null
            return head
        }
        var slow = head
        var fast = head
        while (fast != tail) {
            slow = slow!!.next
            fast = fast!!.next
            if (fast != tail) {
                fast = fast!!.next
            }
        }
        val mid = slow
        val list1 = sortList(head, mid)
        val list2 = sortList(mid, tail)
        return merge(list1, list2)
    }

    fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var temp: ListNode? = dummyHead
        var temp1 = head1
        var temp2 = head2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` <= temp2.`val`) {
                temp!!.next = temp1
                temp1 = temp1.next
            } else {
                temp!!.next = temp2
                temp2 = temp2.next
            }
            temp = temp.next
        }
        if (temp1 != null) {
            temp!!.next = temp1
        } else if (temp2 != null) {
            temp!!.next = temp2
        }
        return dummyHead.next
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}