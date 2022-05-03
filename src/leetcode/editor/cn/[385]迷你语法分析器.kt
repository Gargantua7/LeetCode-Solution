//给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "324",
//输出：324
//解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 
//输入：s = "[123,[456,[789]]]",
//输出：[123,[456,[789]]]
//解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成 
// 用例保证 s 是可解析的 NestedInteger 
// 输入中的所有值的范围是 [-10⁶, 10⁶] 
// 
// Related Topics 栈 深度优先搜索 字符串 👍 177 👎 0

package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayDeque


/**
 * 385
 * 迷你语法分析器
 * 
 * @author Gargantua丶
 * 2022-04-21 01:26:05
 */
class MiniParser {
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */
internal class Solution {
    fun deserialize(s: String): NestedInteger {
        if (s[0] != '[') {
            return NestedInteger(s.toInt())
        }
        val stack: Deque<NestedInteger> = LinkedList()
        var num = 0
        var negative = false
        for (i in s.indices) {
            val c = s[i]
            if (c == '-') {
                negative = true
            } else if (Character.isDigit(c)) {
                num = num * 10 + (c - '0')
            } else if (c == '[') {
                stack.push(NestedInteger())
            } else if (c == ',' || c == ']') {
                if (Character.isDigit(s[i - 1])) {
                    if (negative) {
                        num *= -1
                    }
                    stack.peek().add(NestedInteger(num))
                }
                num = 0
                negative = false
                if (c == ']' && stack.size > 1) {
                    val ni: NestedInteger = stack.pop()
                    stack.peek().add(ni)
                }
            }
        }
        return stack.pop()
    }
}


//leetcode submit region end(Prohibit modification and deletion)

    class NestedInteger {
        // Constructor initializes an empty nested list.
        constructor()
        // Constructor initializes a single integer.
        constructor(value: Int)
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        fun isInteger(): Boolean = true
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        fun getInteger(): Int? = 1
        // Set this NestedInteger to hold a single integer.
        fun setInteger(value: Int) = Unit
        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        fun add(ni: NestedInteger) =  Unit
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        fun getList(): List<NestedInteger>? = null
    }
}
