//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: [[1]] 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// 
//
// 注意：本题与主站 77 题相同： https://leetcode-cn.com/problems/combinations/ 
// Related Topics 数组 回溯 👍 7 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val ans = ArrayList<List<Int>>()
        for(i in 1..n + 1 - k) dfs(n, i, ArrayList(), ans, k)
        return ans
    }

    fun dfs(n: Int, index: Int, list: ArrayList<Int>, ans: ArrayList<List<Int>>, k: Int) {
        if (index !in 1..n) return
        list.add(index)
        if (list.size == k) ans += ArrayList(list)
        else for (i in index + 1..n + 1 - k + list.size) dfs(n, i, list, ans, k)
        list.removeAt(list.lastIndex)
    }
}
//leetcode submit region end(Prohibit modification and deletion)
