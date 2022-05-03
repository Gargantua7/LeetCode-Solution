//给定一个链表数组，每个链表都已经按升序排列。 
//
// 请将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 
//输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// 
//
// 注意：本题与主站 23 题相同： https://leetcode-cn.com/problems/merge-k-sorted-lists/ 
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 15 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 078
 * 合并排序链表
 *
 * @author Gargantua丶
 * 2021-10-23 14:19:00
 */
class VvXgSW {
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

        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            val queue = PriorityQueue<ListNode> { a, b ->
                a.`val` - b.`val`
            }
            for (i in lists.indices) {
                lists[i]?.let { queue.offer(it) }
            }
            val head = ListNode(0)
            var q = head
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                q.next = node
                q = node
                node.next?.let { queue.offer(it) }
            }
            q.next = null
            return head.next
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}