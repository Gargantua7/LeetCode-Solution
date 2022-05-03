package leetcode.editor.cn.weekly

/**
 * @author Gargantua丶
 *
 * [第 261 场周赛](https://leetcode-cn.com/contest/weekly-contest-261/)
 **/
class Weekly261 {

    fun minimumMoves(s: String): Int {
        var ans = 0
        var i = 0
        while (i < s.length) {
            if (s[i++] == 'X') {
                i += 2
                ans++
            }
        }
        return ans
    }

    fun missingRolls(rolls: IntArray, mean: Int, n: Int): IntArray {
        val sum = (rolls.size + n) * mean - rolls.sum()
        if (sum !in n..n * 6) return intArrayOf()
        val ans = IntArray(n)
        var curr = sum
        for (i in ans.indices) {
            val temp = curr / (n - i)
            ans[i] = temp
            curr -= temp
        }
        return ans
    }

    fun stoneGameIX(stones: IntArray): Boolean {
        val count = IntArray(3)
        stones.forEach { n ->
            count[n % 3]++
        }
        val temp = intArrayOf(count[0], count[2], count[1])
        return play(count) || play(temp)
    }

    fun play(count: IntArray): Boolean {
        if (count[1] == 0) return false
        count[1]--
        var turn = 1 + minOf(count[1], count[2]) * 2 + count[0]
        if (count[1] > count[2]) {
            turn++
            count[1]--
        }
        return turn and 1 == 1 && count[1] != count[2]
    }
}