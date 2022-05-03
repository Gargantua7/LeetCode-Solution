//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1028 👎 0


package leetcode.editor.cn

/**
 * 79
 * 单词搜索
 *
 * @author Gargantua丶
 * 2021-09-16 12:11:49
 */
class WordSearch {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        fun exist(board: Array<CharArray>, word: String): Boolean {
            board.forEachIndexed { i, it -> it.forEachIndexed { j, _ ->
                if (dfs(board, i, j, word, 0)) return true
            } }
            return false
        }

        fun dfs(board: Array<CharArray>, i: Int, j: Int, word: String, index: Int): Boolean {
            val ch = board[i][j]

            if (index == word.lastIndex && ch == word[index]) return true

            if (ch == '.' || ch != word[index]) return false

            board[i][j] = '.'

            if ((i + 1 < board.size && dfs(board, i + 1, j, word, index + 1)) ||
                (j + 1 < board[0].size && dfs(board, i, j + 1, word, index + 1)) ||
                (i - 1 >= 0 && dfs(board, i - 1, j, word, index + 1)) ||
                (j - 1 >= 0 && dfs(board, i, j - 1, word, index + 1))
            ) {

                board[i][j] = ch
                return true
            }

            board[i][j] = ch

            return false
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}