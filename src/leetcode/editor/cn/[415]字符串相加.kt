//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 数学 字符串 模拟 
// 👍 423 👎 0


package leetcode.editor.cn

/**
 * 415
 * 字符串相加
 *
 * @author Gargantua丶
 * 2021-08-17 00:43:49
 */
class AddStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun addStrings(num1: String, num2: String): String {
            if (num2.length > num1.length) return addStrings(num2, num1)
            return buildString {
                val sub = num1.length - num2.length
                append(num1.subSequence(0, sub))
                for (i in num2.indices) {
                    println(toString())
                    val sum = num1[i + sub] - '0' + (num2[i] - '0')
                    if (sum > 9) {
                        val temp = if (isNotEmpty()) {
                            val t = last()
                            deleteCharAt(lastIndex)
                            t
                        } else '0'
                        if (temp + 1 > '9') append("10")
                        else append(temp + 1)
                    }
                    append(sum.toString().last())
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}