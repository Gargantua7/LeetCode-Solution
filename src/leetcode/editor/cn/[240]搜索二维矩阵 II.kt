//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 分治 矩阵 
// 👍 687 👎 0


package leetcode.editor.cn
/**
 * 240
 * 搜索二维矩阵 II
 *
 * @author Gargantua丶
 * 2021-08-15 01:32:08
 */
class SearchA2dMatrixIi { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var i = 0
        var j = matrix[0].lastIndex
        while (i < matrix.size && j >= 0) {
            val n = matrix[i][j]
            if (n == target) return true
            if (n > target) j--
            else i++
        }
        return false
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}