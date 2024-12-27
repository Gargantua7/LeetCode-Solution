//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 433 👎 0


package leetcode.editor.cn

/**
 * 212
 * 单词搜索 II
 *
 * @author Gargantua丶
 * 2021-09-16 00:17:48
 */
class WordSearchIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        class Trie {

            private val children = Array<Trie?>(26) { null }

            var word: String? = null

            operator fun get(index: Int) = children[index]

            operator fun set(index: Int, value: Trie) {
                children[index] = value
            }

            operator fun plusAssign(words: Array<String>) {
                words.forEach { word ->
                    var curr = this
                    word.forEach { c ->
                        val i = c - 'a'
                        if (curr[i] == null) curr[i] = Trie()
                        curr = curr[i]!!
                    }
                    curr.word = word
                }
            }
        }

        fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
            val root = Trie()
            root += words
            val res = ArrayList<String>()
            board.forEachIndexed { i, it -> it.forEachIndexed { j, _ -> dfs(board, i, j, root, res)  } }
            return res
        }

        fun dfs(board: Array<CharArray>, i: Int, j: Int, trie: Trie, res: ArrayList<String>) {
            val ch = board[i][j]

            if (ch == '.') return
            val curr = trie[ch - 'a']?: return

            curr.word?.let {
                res += it
                curr.word = null
            }

            board[i][j] = '.'

            if(i + 1 < board.size){
                dfs(board, i + 1, j, curr, res)
            }
            if(j + 1 < board[0].size){
                dfs(board, i, j + 1, curr, res)
            }
            if(i - 1 >= 0){
                dfs(board, i - 1, j, curr, res)
            }
            if(j - 1 >= 0){
                dfs(board, i, j - 1, curr, res)
            }

            board[i][j] = ch
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}