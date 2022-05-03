//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。 
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
// 
//
// 示例 2： 
//
// 输入：["b==a","a==b"]
//输出：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
// 
//
// 示例 3： 
//
// 输入：["a==b","b==c","a==c"]
//输出：true
// 
//
// 示例 4： 
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
// 
//
// 示例 5： 
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= equations.length <= 500 
// equations[i].length == 4 
// equations[i][0] 和 equations[i][3] 是小写字母 
// equations[i][1] 要么是 '='，要么是 '!' 
// equations[i][2] 是 '=' 
// 
// Related Topics 并查集 图 数组 字符串 👍 205 👎 0

package leetcode.editor.cn

/**
 * 990
 * 等式方程的可满足性
 *
 * @author Gargantua丶
 * 2021-11-27 13:59:14
 */
class SatisfiabilityOfEqualityEquations {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        fun equationsPossible(equations: Array<String>): Boolean {
            val map = IntArray(26) { it }
            equations.filter { (_, o) -> o == '=' }.forEach { (a, _, _, b) ->
                map.union(a - 'a', b - 'a')
            }
            equations.filter { (_, o) -> o == '!' }.forEach { (a, _, _, b) ->
                if (map.find(a - 'a') == map.find(b - 'a')) return false
            }
            return true
        }

        private fun IntArray.union(idx1: Int, idx2: Int) {
            this[find(idx1)] = find(idx2)
        }

        private fun IntArray.find(idx: Int): Int {
            var curr = idx
            while (this[curr] != curr) {
                this[curr] = this[this[curr]]
                curr = this[curr]
            }
            return curr
        }

        private operator fun String.component1() = this[0]
        private operator fun String.component2() = this[1]
        private operator fun String.component3() = this[2]
        private operator fun String.component4() = this[3]
    }
//leetcode submit region end(Prohibit modification and deletion)

}


