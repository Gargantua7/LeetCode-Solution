//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 124 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 50
 * 第一个只出现一次的字符
 *
 * @author Gargantua丶
 * 2021-08-10 01:33:19
 */
class DiYiGeZhiChuXianYiCiDeZiFuLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun firstUniqChar(s: String): Char {
            val map = HashMap<Char, Int>()
            s.forEach { c -> map[c] = (map[c] ?: 0) + 1 }
            s.forEach { c -> if (map[c] == 1) return c }
            return ' '
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}