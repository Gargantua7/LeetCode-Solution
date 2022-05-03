package leetcode.editor.cn.weekly

import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Gargantua丶
 **/
class DoubleWeekly61 {

    fun countKDifference(nums: IntArray, k: Int): Int {
        var ans = 0
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                if (kotlin.math.abs(nums[i] - nums[j]) == k) ans++
            }
        }
        return ans

    }


    fun findOriginalArray(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) return IntArray(0)
        val odd = ArrayList<Int>()
        var even = ArrayList<Int>()
        var zero = 0
        val ans = ArrayList<Int>()
        changed.forEach {
            if (it == 0) zero++
            else if (it % 2 == 0) even.add(it)
            else odd.add(it)
        }
        if (zero % 2 != 0) return IntArray(0)
        for (i in 1..zero / 2) ans.add(0)
        var count = -1
        while (even.isNotEmpty()) {
            count++
            for (i in odd.indices) {
                val n = odd[i]
                val double = even.indexOf(n * 2)
                if (double < 0) return IntArray(0)
                ans.add(n)
                even[double] = -1
            }
            val temp = even
            odd.clear()
            even = ArrayList()
            temp.forEach { n ->
                if (n > -1) {
                    val it = n / (1 shl (count + 1))
                    if (it % 2 == 0) even.add(n)
                    else odd.add(n)
                }
            }
        }
        return ans.toIntArray()
    }

    fun findOriginalArray2(changed: IntArray): IntArray {
        if (changed.size % 2 != 0) return IntArray(0)
        val map = TreeMap<Int, Int>()
        changed.forEach { map[it] = (map[it] ?: 0) + 1 }
        val ans = IntArray(changed.size / 2)
        var i = 0
        while (map.isNotEmpty()) {
            ans[i] = map.firstKey()
            map[ans[i]] = map[ans[i]]!! - 1
            if (map[ans[i]]!! == 0) map -= ans[i]
            map[ans[i] * 2] = (map[ans[i] * 2] ?: return IntArray(0)) - 1
            if ((map[ans[i] * 2] == 0)) map -= ans[i] * 2
            i++
        }
        return ans
    }

    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        val dp = LongArray(n + 1)
        rides.sortBy { it[1] }
        var i = 0
        for (j in 1..dp.lastIndex) {
            dp[j] = dp[j - 1]
            while (i < rides.size && rides[i][1] <= j) {
                val (s, e, t) = rides[i++]
                dp[j] = dp[j].coerceAtLeast(dp[s] + e - s + t)
            }
        }
        return dp.last()
    }

    fun minOperations(nums: IntArray): Int {
        val set = TreeSet(nums.toList()).toList()
        var i = 0
        return nums.size - set.foldIndexed(0) { index, max, n ->
            while (i + 1 < set.size && set[i + 1] - n < nums.size) i++
            max.coerceAtLeast(i - index + 1)
        }
    }
}