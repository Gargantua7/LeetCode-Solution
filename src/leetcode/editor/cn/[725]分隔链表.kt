//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。 
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。 
//
// 返回一个符合上述规则的链表的列表。 
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ] 
//
// 示例 1： 
//
// 
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.
//next.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
// 
//
// 示例 2： 
//
// 
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示: 
//
// 
// root 的长度范围： [0, 1000]. 
// 输入的每个节点的大小范围：[0, 999]. 
// k 的取值范围： [1, 50]. 
// 
//
// 
// Related Topics 链表 👍 154 👎 0


package leetcode.editor.cn
/**
 * 725
 * 分隔链表
 *
 * @author Gargantua丶
 * 2021-09-22 00:36:30
 */
class SplitLinkedListInParts { 
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
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var curr: ListNode? = head?: return Array(k) { null }
        val node = ArrayList<ListNode>()
        while (curr != null) {
            node.add(curr)
            curr = curr.next
        }
        val length = node.size / k
        val plus = node.size % k
        val ans = Array<ListNode?>(k) { null }
        var i = 0
        for (j in ans.indices) {
            if (length == 0 && j >= plus) continue
            ans[j] = node[i]
            if (i > 0) node[i - 1].next = null
            i += length
            if (j < plus) i++
        }
        return ans
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}