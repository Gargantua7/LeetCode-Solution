//一个 2D 网格中的 顶峰元素 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 顶峰元素 mat[i][j] 并 返回其
//位置 [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3和4都是顶峰元素，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30和32都是顶峰元素，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
// Related Topics 数组 二分查找 分治 矩阵 👍 13 👎 0

package leetcode.editor.cn

/**
 * 1901
 * 找出顶峰元素 II
 * 
 * @author Gargantua丶
 * 2021-12-07 13:53:12
 */
class FindAPeakElementIi {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun findPeakGrid(mat: Array<IntArray>): IntArray? {
        val m = mat.size
        var l = 0
        var r = m - 1
        while (l < r) {
            val mid = l + r shr 1
            val maxCol = findMaxCol(mat, mid)
            val max1 = if (mid - 1 >= 0) mat[mid - 1][findMaxCol(mat, mid - 1)] else -1 //mid-1行的最大值
            val max2 = mat[mid][maxCol] //mid行的最大值
            val max3 = if (mid + 1 < m) mat[mid + 1][findMaxCol(mat, mid + 1)] else -1 //mid+1行的最大值
            if (max2 > max1 && max2 > max3) return intArrayOf(mid, maxCol)
            if (max1 > max3) r = mid - 1 else l = mid + 1
        }
        return intArrayOf(l, findMaxCol(mat, l))
    }

    fun findMaxCol(mat: Array<IntArray>, x: Int): Int { //返回x行中最大值的那一列
        var maxCol = 0
        val n = mat[x].size
        for (y in 0 until n) {
            if (mat[x][y] >= mat[x][maxCol]) {
                maxCol = y
            }
        }
        return maxCol
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}