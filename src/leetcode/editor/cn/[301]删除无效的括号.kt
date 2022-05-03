//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
// Related Topics 广度优先搜索 字符串 回溯 👍 512 👎 0

package leetcode.editor.cn


/**
 * 301
 * 删除无效的括号	
 *
 * @author Gargantua丶
 * 2021-10-27 00:08:54
 */
class RemoveInvalidParentheses { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
        val ans = ArrayList<String>()
        var currSet = HashSet<String>()
        currSet.add(s)
        while (true) {
            for (str in currSet) {
                if (isValid(str)) {
                    ans.add(str)
                }
            }
            if (ans.size > 0) {
                return ans
            }
            val nextSet = HashSet<String>()
            for (str in currSet) {
                for (i in str.indices) {
                    if (i > 0 && str[i] == str[i - 1]) {
                        continue
                    }
                    if (str[i] == '(' || str[i] == ')') {
                        nextSet.add(str.substring(0, i) + str.substring(i + 1))
                    }
                }
            }
            currSet = nextSet
        }
    }

    private fun isValid(str: String): Boolean {
        val ss = str.toCharArray()
        var count = 0
        for (c in ss) {
            if (c == '(') {
                count++
            } else if (c == ')') {
                count--
                if (count < 0) {
                    return false
                }
            }
        }
        return count == 0
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}