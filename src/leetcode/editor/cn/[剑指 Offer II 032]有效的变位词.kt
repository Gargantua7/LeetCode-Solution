//给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同且字符顺序不完全相同，则称 s 和 t 互为变位词（字母异位词）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "a"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 10⁴ 
// s and t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
//
// 
//
// 注意：本题与主站 242 题相似（字母异位词定义不同）：https://leetcode-cn.com/problems/valid-anagram/ 
// Related Topics 哈希表 字符串 排序 👍 2 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 032
 * 有效的变位词
 *
 * @author Gargantua丶
 * 2021-10-07 16:06:14
 */
class DKk3P7 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun isAnagram(s: String, t: String): Boolean {
            if (s == t) return false
            // If the string contains Unicode characters, use HashMap instead
            val sCount = IntArray(26)
            val tCount = IntArray(26)
            s.forEach { sCount[it - 'a']++ }
            t.forEach { tCount[it - 'a']++ }
            return sCount.contentEquals(tCount)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}