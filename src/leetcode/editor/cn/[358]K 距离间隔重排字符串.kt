//给你一个非空的字符串 s 和一个整数 k，你要将这个字符串中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离至少为 k。 
//
// 所有输入的字符串都由小写字母组成，如果找不到距离至少为 k 的重排结果，请返回一个空字符串 ""。 
//
// 示例 1： 
//
// 输入: s = "aabbcc", k = 3
//输出: "abcabc" 
//解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
// 
//
// 示例 2: 
//
// 输入: s = "aaabc", k = 3
//输出: "" 
//解释: 没有办法找到可能的重排结果。
// 
//
// 示例 3: 
//
// 输入: s = "aaadbbcc", k = 2
//输出: "abacabcd"
//解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
// 
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 👍 79 👎 0

package leetcode.editor.cn

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap

/**
 * 358
 * K 距离间隔重排字符串
 *
 * @author Gargantua丶
 * 2021-12-02 14:34:32
 */
class RearrangeStringKDistanceApart {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun rearrangeString(s: String, k: Int): String {
            if (k <= 1) return s
            val map = HashMap<Char, Int>()
            val heap = PriorityQueue<Pair<Char, Int>>() { (_, a), (_, b) -> b - a }
            s.forEach { c -> map[c] = (map[c]?: 0) + 1 }
            heap += map.map { (k, v) -> k to v}
            val sb = StringBuilder()
            val queue = LinkedList<Pair<Char, Int>>()
            while (heap.isNotEmpty()) {
                val (ch, count) = heap.poll()
                sb.append(ch)
                queue.offer(ch to count - 1)
                if (queue.size == k) {
                    val e = queue.poll()
                    if (e.second > 0) heap.offer(e)
                }
            }
            return if (sb.length == s.length) sb.toString() else ""
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}