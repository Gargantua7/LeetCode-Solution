//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 👍 936 👎 0

package leetcode.editor.cn

import java.util.*


/**
 * 394
 * 字符串解码
 *
 * @author Gargantua丶
 * 2021-11-17 14:28:51
 */
class DecodeString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun decodeString(s: String): String {
            val stack = LinkedList<String>()
            var idx = 0
            while (idx < s.length) {
                val c = s[idx]
                if (c.isDigit()) {
                    val get = s[idx, Char::isDigit]
                    stack.push(get)
                    idx += get.length
                } else if (c == '[') {
                    stack.push("[")
                    idx++
                } else if (c.isLetter()) {
                    val get = s[idx, Char::isLetter]
                    stack.push(get)
                    idx += get.length
                } else {
                    idx++
                    val string = buildString {
                        while (stack.peek() != "[") {
                            insert(0, stack.pop())
                        }
                    }
                    if (stack.peek() == "[") stack.pop()
                    val int = stack.pop().toInt()
                    stack.push(buildString {
                        repeat(int) {
                            append(string)
                        }
                    })
                }
            }
            return buildString {
                stack.forEach { insert(0, it) }
            }
        }

        operator fun String.get(start: Int, check: Char.() -> Boolean): String {
            val that = this
            return buildString {
                for (i in start..that.lastIndex) {
                    if (!that[i].check()) break
                    append(that[i])
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}