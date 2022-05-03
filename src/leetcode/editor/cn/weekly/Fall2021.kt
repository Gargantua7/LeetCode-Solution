package leetcode.editor.cn.weekly

import java.util.*


/**
 * @author Gargantua丶
 **/
class Fall2021 {

    fun minimumSwitchingTimes(source: Array<IntArray>, target: Array<IntArray>): Int {
        var ans = 0
        val list = ArrayList<Int>()
        source.forEach { it.forEach { num -> list.add(num) } }
        target.forEach {
            it.forEach { num ->
                val index = list.indexOf(num)
                if (index == -1) ans++
                else list[index] = -1
            }
        }
        return ans
    }

//    fun maxmiumScore(cards: IntArray, cnt: Int): Int {
//            cards.sortedDescending()
//            val ans = IntArray(cnt)
//            var sum = 0
//            for (i in 0 until cnt) {
//                ans[i] = cards[cnt - i - 1]
//                sum += ans[i]
//            }
//            if (sum % 2 == 1) {
//                for (i in ans.indices) {
//                    if (ans[i] % 2 == 1) {
//                        sum -= ans[i]
//                        break
//                    }
//                }
//                for (i in cnt..cards.lastIndex) {
//                    if (cards[i] % 2 == 0) {
//                        sum += cards[i]
//                        break
//                    }
//                }
//            }
//            return sum
//    }

    fun maxmiumScore(cards: IntArray, cnt: Int): Int {
        val n = cards.size
        var odd = 0
        var even = 0
        var i1 = 0
        var i2 = 0
        var res = 0
        for (i in cards) if (i % 2 == 1) odd++
        even = n - odd
        val odds = IntArray(odd + 1)
        val evens = IntArray(even + 1)
        for (i in cards) {
            if (i % 2 == 1) odds[i1++] = i else evens[i2++] = i
        }
        Arrays.sort(odds)
        Arrays.sort(evens)
        for (i in 1..odd) odds[i] += odds[i - 1]
        for (i in 1..even) evens[i] += evens[i - 1]
        var i = 0
        while (i <= Math.min(Math.min(n, odd), cnt)) {
            if (even >= cnt - i) res =
                Math.max(res, odds[odd] - odds[odd - i] + evens[even] - evens[even - (cnt - i)])
            i += 2
        }
        return res
    }

    fun maxmiumScore1(cards: IntArray, cnt: Int): Int {
        val dp = Array(cnt) { IntArray(2) }

        if (cards[0] % 2 == 0) dp[1][0] = cards[0] else dp[1][1] = cards[0]

        for (i in 1..cards.lastIndex) {
            for (j in kotlin.math.min(i, cnt) downTo 1) {
                if (cards[i] % 2 == 1) {
                    if (dp[j - 1][1] % 2 == 1)
                        dp[j][0] = kotlin.math.max(dp[j - 1][1] + cards[i], dp[j][0])
                    if ((dp[j - 1][0] != 0 || j == 1) && dp[j - 1][0] % 2 == 0)
                        dp[j][1] = kotlin.math.max(dp[j - 1][0] + cards[i], dp[j][1])
                } else {
                    if ((dp[j - 1][0] != 0 || j == 1) && dp[j - 1][0] % 2 == 0)
                        dp[j][0] = kotlin.math.max(dp[j - 1][0] + cards[i], dp[j][0])
                    if (dp[j - 1][1] % 2 == 1)
                        dp[j][1] = kotlin.math.max(dp[j - 1][1] + cards[i], dp[j][1])
                }
            }
        }
        return dp.last().first()
    }

}