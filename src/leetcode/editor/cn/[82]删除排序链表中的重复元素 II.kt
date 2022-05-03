//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 👍 684 👎 0


package leetcode.editor.cn
/**
 * 82
 * 删除排序链表中的重复元素 II
 *
 * @author Gargantua丶
 * 2021-08-22 01:44:23
 */
class RemoveDuplicatesFromSortedListIi { 
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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val p = ListNode(0)
        var q = p
        p.next = head?: return null
        while (q.next != null && q.next!!.next != null) {
            if (q.next!!.`val` == q.next!!.next.`val`) {
                val x: Int = q.next!!.`val`
                while (q.next != null && q.next!!.`val` == x) {
                    q.next = q.next!!.next
                }
            } else {
                q = q.next!!
            }
        }
        return p.next
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}