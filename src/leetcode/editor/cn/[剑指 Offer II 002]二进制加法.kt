//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 3 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer II 002
 * 二进制加法
 *
 * @author Gargantua丶
 * 2021-09-28 13:30:56
 */
class JFETK5 { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun addBinary(a: String, b: String): String {
        return buildString {
            var i = a.lastIndex
            var j = b.lastIndex
            var plus = false
            while (i >= 0 || j >= 0) {
                var sum = if (plus) 1 else 0
                if (i >= 0 && a[i--] == '1') sum++
                if (j >= 0 && b[j--] == '1') sum++
                plus = when (sum) {
                    0, 1 -> {
                        append(sum)
                        false
                    }
                    else -> {
                        append(sum - 2)
                        true
                    }
                }
            }
            if (plus) append(1)
        }.reversed()
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}