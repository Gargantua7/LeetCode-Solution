//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/ 
// Related Topics 数组 回溯 矩阵 
// 👍 377 👎 0


package leetcode.editor.cn
/**
 * 剑指 Offer 12
 * 矩阵中的路径
 *
 * @author Gargantua丶
 * 2021-08-05 23:55:51
 */
class JuZhenZhongDeLuJingLcof { 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val words = word.toCharArray()
        for (i in board.indices) {
            for (j in 0 until board[0].size) {
                if (dfs(board, words, i, j, 0)) return true
            }
        }
        return false
    }

    private fun dfs(board: Array<CharArray>, word: CharArray, i: Int, j: Int, k: Int): Boolean {
        if (i >= board.size || i < 0 || j >= board[0].size || j < 0 || board[i][j] != word[k]) return false
        if (k == word.size - 1) return true
        board[i][j] = '\u0000'
        val res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1)
        board[i][j] = word[k]
        return res
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}