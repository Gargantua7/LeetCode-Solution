//给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。 
//
// 注意: 
//
// 
// 十六进制中所有字母(a-f)都必须是小写。 
// 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
// 给定的数确保在32位有符号整数范围内。 
// 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。 
// 
//
// 示例 1： 
//
// 
//输入:
//26
//
//输出:
//"1a"
// 
//
// 示例 2： 
//
// 
//输入:
//-1
//
//输出:
//"ffffffff"
// 
// Related Topics 位运算 数学 👍 155 👎 0


package leetcode.editor.cn

/**
 * 405
 * 数字转换为十六进制数
 *
 * @author Gargantua丶
 * 2021-10-02 00:04:38
 */
class ConvertANumberToHexadecimal {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun toHex(num: Int): String {
            return if (num == 0) "0" else buildString {
                for(i in 0..(31 - Integer.numberOfLeadingZeros(num)) / 4) {
                    val n = num shr (4 * i) and 15
                    insert(0, if (n < 10) n else 'a' + n - 10)
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}