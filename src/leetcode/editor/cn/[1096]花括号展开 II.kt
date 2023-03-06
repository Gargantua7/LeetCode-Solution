//如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。 
//
// 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则： 
//
// 
// 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x} 
// 
//
// 
// 例如，表达式 "a" 表示字符串 "a"。 
// 而表达式 "w" 就表示字符串 "w"。 
// 
// 
// 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
// 
// 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。 
// 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。 
// 
// 
// 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, 
//b) in R(e_1) × R(e_2)}
// 
// 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。 
// 
// 
// 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
// 
// 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"。 
// 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", 
//"acdfg", "acdfh", "acefg", "acefh"。 
// 
// 
//
//
// 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。 
//
// 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "{a,b}{c,{d,e}}"
//输出：["ac","ad","ae","bc","bd","be"] 
//
// 示例 2： 
//
// 
//输入：expression = "{{a,z},a{b,c},{ab,z}}"
//输出：["a","ab","ac","z"]
//解释：输出中 不应 出现重复的组合结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 60 
// expression[i] 由 '{'，'}'，',' 或小写英文字母组成 
// 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串 
// 
//
// Related Topics 栈 广度优先搜索 字符串 回溯 👍 64 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.MutableSet


/**
 * 1096
 * 花括号展开 II
 *
 * @author Gargantua丶
 * 2023-03-07 00:02:28
 */
class BraceExpansionIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun braceExpansionII(expression: String): List<String>? {
        val op = LinkedList<Char>()
        val stk: MutableList<MutableSet<String>> = ArrayList()
        for (i in expression.indices) {
            if (expression[i] == ',') {
                // 不断地弹出栈顶运算符，直到栈为空或者栈顶不为乘号
                while (!op.isEmpty() && op.peek() == '*') {
                    ope(op, stk)
                }
                op.push('+')
            } else if (expression[i] == '{') {
                // 首先判断是否需要添加乘号，再将 { 添加到运算符栈中
                if (i > 0 && (expression[i - 1] == '}' || Character.isLetter(expression[i - 1]))) {
                    op.push('*')
                }
                op.push('{')
            } else if (expression[i] == '}') {
                // 不断地弹出栈顶运算符，直到栈顶为 {
                while (!op.isEmpty() && op.peek() != '{') {
                    ope(op, stk)
                }
                op.pop()
            } else {
                // 首先判断是否需要添加乘号，再将新构造的集合添加到集合栈中
                if (i > 0 && (expression[i - 1] == '}' || Character.isLetter(expression[i - 1]))) {
                    op.push('*')
                }
                val sb = StringBuilder()
                sb.append(expression[i])
                stk.add(TreeSet(listOf(sb.toString())))
            }
        }
        while (!op.isEmpty()) {
            ope(op, stk)
        }
        return ArrayList(stk[stk.size - 1])
    }

    // 弹出栈顶运算符，并进行计算
    fun ope(op: Deque<Char>, stk: MutableList<MutableSet<String>>) {
        val l = stk.size - 2
        val r = stk.size - 1
        if (op.peek() == '+') {
            stk[l].addAll(stk[r])
        } else {
            val tmp: MutableSet<String> = TreeSet()
            for (left in stk[l]) {
                for (right in stk[r]) {
                    tmp.add(left + right)
                }
            }
            stk[l] = tmp
        }
        op.pop()
        stk.removeAt(stk.size - 1)
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}