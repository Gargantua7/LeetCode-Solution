//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
//
// Related Topics 位运算 数学 字符串 👍 45 👎 0


package leetcode.editor.cn

/**
 * 面试题 05.02
 * 二进制数转字符串
 *
 * @author Gargantua丶
 * 2023-03-02 00:04:00
 */
class BianryNumberToStringLcci {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun printBin(num: Double): String {
        return buildString(9) {
            append("0.")
            var temp = num
            while (temp != 0.0 && length < 9) {
                temp *= 2
                if (temp >= 1.0) {
                    temp--
                    append(1)
                } else append(0)
            }
            if (temp != 0.0) return "ERROR"
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}