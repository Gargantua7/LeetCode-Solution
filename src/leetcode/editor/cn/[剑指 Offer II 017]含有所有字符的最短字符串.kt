//给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。 
//
// 如果 s 中存在多个符合条件的子字符串，返回任意一个。 
//
// 
//
// 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC" 
//解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C' 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3： 
//
// 
//输入：s = "a", t = "aa"
//输出：""
//解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//
// 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ 
//
// 
//
// 注意：本题与主站 76 题相似（本题答案不唯一）：https://leetcode-cn.com/problems/minimum-window-
//substring/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 6 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 017
 * 含有所有字符的最短字符串
 *
 * @author Gargantua丶
 * 2021-10-03 18:01:52
 */
class M1oyTv {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun minWindow(s: String, t: String): String {
            var fast = 0
            var slow = 0
            val map = HashMap<Char, Int>()
            val more = HashMap<Char, Int>()
            var index = 0
            var length = Int.MAX_VALUE
            t.forEach { c -> map[c] = (map[c] ?: 0) + 1 }
            val temp = HashSet(map.keys)
            while (slow <= fast && fast < s.length) {
                if (map.isNotEmpty()) {
                    if (s[fast] in temp) {
                        if (s[fast] !in map) {
                            more[s[fast]] = (more[s[fast]] ?: 0) + 1
                        } else {
                            map[s[fast]] = map[s[fast]]!! - 1
                            if (map[s[fast]] == 0) map.remove(s[fast])
                        }
                    }
                    fast++
                } else {
                    if (length > fast - slow) {
                        index = slow
                        length = fast - slow
                    }
//                    println("[$slow, $fast] -> ${s.substring(slow until fast)} -> $more")
                    if (s[slow] in temp) {
                        if (s[slow] in more) {
                            more[s[slow]] = more[s[slow]]!! - 1
                            if (more[s[slow]] == 0) more.remove(s[slow])
                        } else map[s[slow]] = (map[s[slow]] ?: 0) + 1
                    }
                    slow++
                }
            }
            while (map.isEmpty()) {
                if (length > fast - slow) {
                    index = slow
                    length = fast - slow
                }
//                println("[$slow, $fast] -> ${s.substring(slow until fast)} -> $more")
                if (s[slow] in temp) {
                    if (s[slow] in more) {
                        more[s[slow]] = more[s[slow]]!! - 1
                        if (more[s[slow]] == 0) more.remove(s[slow])
                    } else map[s[slow]] = (map[s[slow]] ?: 0) + 1
                }
                slow++
            }
            return if (index + length > s.length) "" else s.substring(index until index + length)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}