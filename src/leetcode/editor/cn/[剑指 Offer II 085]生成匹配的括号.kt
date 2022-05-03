//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 10 👎 0


package leetcode.editor.cn

/**
 * 剑指 Offer II 085
 * 生成匹配的括号
 *
 * @author Gargantua丶
 * 2021-10-26 20:59:54
 */
class IDBivT {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun generateParenthesis(n: Int): List<String> {
            val ans = ArrayList<String>()
            dfs(n, 0, 0, StringBuilder(), ans)
            return ans
        }

        fun dfs(n: Int, left: Int, right: Int, s: StringBuilder, ans: ArrayList<String>) {
            if (right == n) {
                ans.add(s.toString())
                return
            }
            if (n == left) {
                s.append(')')
                dfs(n, left, right + 1, s, ans)
            } else {
                s.append('(')
                dfs(n, left + 1, right, s, ans)
                if (right < left) {
                    s.deleteCharAt(s.lastIndex)
                    s.append(')')
                    dfs(n, left, right + 1, s, ans)
                }
            }
            s.deleteCharAt(s.lastIndex)
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}