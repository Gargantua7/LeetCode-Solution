//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 123 👎 0

package leetcode.editor.cn

/**
 * 504
 * 七进制数
 * 
 * @author Gargantua丶
 * 2022-03-07 00:47:50
 */
class Base7 {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun convertToBase7(num: Int): String {
        if (num == 0) return "0"
        var n = kotlin.math.abs(num)
        return buildString {
            while (n > 0) {
                append(n % 7)
                n /= 7
            }
            if (num < 0) append('-')
            reverse()
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
