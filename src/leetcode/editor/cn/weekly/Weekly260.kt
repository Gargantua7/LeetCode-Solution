package leetcode.editor.cn.weekly

import java.util.*
import kotlin.collections.HashSet

/**
 * @author Gargantua丶
 *
 * [第 260 场周赛](https://leetcode-cn.com/contest/weekly-contest-260/)
 **/
class Weekly260 {

    /**
     * [2016. 增量元素之间的最大值](https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/)
     */
    fun maximumDifference(nums: IntArray): Int {
        var ans = -1
        var min = Int.MAX_VALUE
        nums.forEach {
            if (min < it) {
                ans = ans.coerceAtLeast(it - min)
            }
            min = min.coerceAtMost(it)
        }
        return ans
    }

    /**
     * [2017. 网格游戏](https://leetcode-cn.com/problems/grid-game/)
     */
    fun gridGame(grid: Array<IntArray>): Long {
        val pre = Array(2) { LongArray(grid[0].size + 1) }
        for (i in 0..1) {
            for (j in 1..pre[0].lastIndex) {
                pre[i][j] += pre[i][j - 1] + grid[i][j - 1]
            }
        }
        var ans = Long.MAX_VALUE
        for (i in 1..pre[0].lastIndex) {
            ans = ans.coerceAtMost(maxOf(pre[1][i - 1], pre[0].last() - pre[0][i]))
        }
        return ans
    }

    /**
     * [2018. 判断单词是否能放入填字游戏内](https://leetcode-cn.com/problems/check-if-word-can-be-placed-in-crossword/)
     */
    fun placeWordInCrossword(board: Array<CharArray>, word: String): Boolean {
        for (i in board.indices) {
            for (j in board[0].indices) {
                if (board[i][j] == ' ' || board[i][j] == word[0]) {
                    if (check(board, i, j, 1, 0, word) ||
                        check(board, i, j, 0, 1, word) ||
                        check(board, i, j, -1, 0, word) ||
                        check(board, i, j, 0, -1, word)
                    ) return true
                }
            }
        }
        return false
    }

    fun check(board: Array<CharArray>, i: Int, j: Int, u: Int, v: Int, word: String, index: Int = 0): Boolean {
        println("board[$i][$j] = ${board[i][j]}, mode: [$u, $v], word[$index] = ${word[index]}")
        if (index == 0 && i - u in board.indices && j - v in board[0].indices && board[i - u][j - v] != '#')
            return false
        if (board[i][j] == '#' || (board[i][j] != ' ' && board[i][j] != word[index])) return false
        if (i + u in board.indices && j + v in board[0].indices) {
            if (word.lastIndex == index) return board[i + u][j + v] == '#'
            return check(board, i + u, j + v, u, v, word, index + 1)
        }
        return index == word.lastIndex
    }

    fun scoreOfStudents(s: String, answers: IntArray): Int {
        // Correct Result
        val stack: Deque<Int> = LinkedList()
        stack.push(s[0] - '0')
        for (i in 1..s.lastIndex step 2) {
            stack.push(if (s[i] == '+') s[i + 1] - '0' else stack.pop() * (s[i + 1] - '0'))
        }
        val correctRes = stack.sum()
        // All Possible Result
        val dp = Array(s.length + 2) { Array(s.length + 2) { HashSet<Int>() } }
        for (i in s.indices step 2) dp[i][i].add(s[i] - '0')
        for (step in 2 until s.length step 2) {
            for (i in 0 until s.length - step step 2) {
                for (j in 0 until step step 2) {
                    dp[i][i + j].forEach { x ->
                        dp[i + j + 2][i + step].forEach { y ->
                            val res = if (s[i + j + 1] == '+') x + y else x * y
                            if (res <= 1000) dp[i][i + step].add(res)
                        }
                    }
                }
            }
        }
        val allRes = dp[0][s.lastIndex]
        // Calculation Point
        return answers.fold(0) { point, answer ->
            point + when(answer) {
                correctRes -> 5
                in allRes -> 2
                else -> 0
            }
        }
    }

}