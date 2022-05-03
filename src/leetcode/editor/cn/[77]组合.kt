//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 669 👎 0


package leetcode.editor.cn


/**
 * 77
 * 组合
 *
 * @author Gargantua丶
 * 2021-08-22 01:12:36
 */
class Combinations { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    val temp = ArrayList<Int>()
    val ans = ArrayList<List<Int>>()

    fun combine(n: Int, k: Int): List<List<Int>> {
        dfs(1, n, k)
        return ans
    }

    fun dfs(cur: Int, n: Int, k: Int) {
        if (temp.size + (n - cur + 1) < k) {
            return
        }
        if (temp.size == k) {
            ans.add(ArrayList(temp))
            return
        }
        temp.add(cur)
        dfs(cur + 1, n, k)
        temp.removeAt(temp.lastIndex)
        dfs(cur + 1, n, k)
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}