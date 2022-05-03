//整数可以被看作是其因子的乘积。 
//
// 例如： 
//
// 8 = 2 x 2 x 2;
//  = 2 x 4. 
//
// 请实现一个函数，该函数接收一个整数 n 并返回该整数所有的因子组合。 
//
// 注意： 
//
// 
// 你可以假定 n 为永远为正数。 
// 因子必须大于 1 并且小于 n。 
// 
//
// 示例 1： 
//
// 输入: 1
//输出: []
// 
//
// 示例 2： 
//
// 输入: 37
//输出: [] 
//
// 示例 3： 
//
// 输入: 12
//输出:
//[
//  [2, 6],
//  [2, 2, 3],
//  [3, 4]
//] 
//
// 示例 4: 
//
// 输入: 32
//输出:
//[
//  [2, 16],
//  [2, 2, 8],
//  [2, 2, 2, 4],
//  [2, 2, 2, 2, 2],
//  [2, 4, 4],
//  [4, 8]
//]
// 
// Related Topics 数组 回溯 👍 92 👎 0


package leetcode.editor.cn


/**
 * 254
 * 因子的组合
 *
 * @author Gargantua丶
 * 2021-09-26 13:48:13
 */
class FactorCombinations { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun getFactors(n: Int): List<List<Int>> {
        return ArrayList<List<Int>>().apply {
            dfs(this, ArrayList(), n, 2)
        }
    }

    private fun dfs(res: ArrayList<List<Int>>, item: ArrayList<Int>, n: Int, start: Int) {
        if (n == 1) {
            if (item.size > 1) {
                res.add(ArrayList(item))
            }
            return
        }
        var i = start
        while (i * i <= n) {
            if (n % i == 0) {
                item.add(i)
                item.add(n / i)
                res.add(ArrayList(item))
                item.removeAt(item.size - 1)
                dfs(res, item, n / i, i)
                item.removeAt(item.size - 1)
            }
            i++
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}