//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 
// 👍 145 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer 05
 * 替换空格
 *
 * @author Gargantua丶
 * 2021-08-05 01:11:06
 */
class TiHuanKongGeLcof {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun replaceSpace(s: String) = s.replace(" ", "%20")
    }
//leetcode submit region end(Prohibit modification and deletion)

}