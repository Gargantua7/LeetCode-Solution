//给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。 
//
// 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作： 
//
//
// 
// 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足
// row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。 
// 
//
// 返回执行完所有操作后得到的矩阵 mat 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
//输出：[[1,1,0],[1,2,1],[0,1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
//- 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。 
//- 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 2, queries = [[0,0,1,1]]
//输出：[[1,1],[1,1]]
//解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。 
//- 第一个操作：将矩阵中的每个元素加 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 500 
// 1 <= queries.length <= 10⁴ 
// 0 <= row1i <= row2i < n 
// 0 <= col1i <= col2i < n 
// 
//
// Related Topics 数组 矩阵 前缀和 👍 75 👎 0


package leetcode.editor.cn

/*** 2536
* 子矩阵元素加 1
*
* @author Gargantua7
* 2025-11-14 22:22:16
*/
class IncrementSubmatricesByOne {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val diff = Array(n + 1) { IntArray(n + 1) }
        queries.forEach { (sx, sy, ex, ey) ->
            diff[sx][sy]++
            diff[sx][ey + 1]--
            diff[ex + 1][sy]--
            diff[ex + 1][ey + 1]++
        }

        val res = Array(n) { IntArray(n) }
        for (x in 0..<n) {
            for (y in 0..<n) {
                res[x][y] = diff[x][y] +
                        (res.getOrNull(x - 1)?.getOrNull(y) ?: 0) +
                        (res.getOrNull(x)?.getOrNull(y - 1) ?: 0) -
                        (res.getOrNull(x - 1)?.getOrNull(y - 1) ?: 0)
            }
        }
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}