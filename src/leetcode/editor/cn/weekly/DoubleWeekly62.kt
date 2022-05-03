package leetcode.editor.cn.weekly


/**
 * @author Gargantua丶
 **/
class DoubleWeekly62 {

    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) return emptyArray()
        return Array(m) { i -> IntArray(n) { j -> original[i * n + j] } }
    }

    fun numOfPairs(nums: Array<String>, target: String): Int {
        val map = HashMap<String, Int>()
        var ans = 0
        nums.forEach {
            if (it.length < target.length) {
                if (it == target.substring(target.length - it.length, target.length))
                    ans += map[target.substring(0, target.length - it.length)] ?: 0
                if (it == target.substring(0, it.length))
                    ans += map[target.subSequence(it.length, target.length)] ?: 0
            }
            map[it] = (map[it] ?: 0) + 1
        }
        return ans
    }

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var fast = 0
        var slow = 0
        var ans = 0
        var curr = 0
        while (slow <= fast && fast < answerKey.length) {
            if (answerKey[fast] == 'T') {
                fast++
            } else {
                if (curr == k) {
                    while (answerKey[slow] == 'T' && slow <= fast) slow++
                    slow++
                    curr--
                } else {
                    curr++
                    fast++
                }
            }
            ans = ans.coerceAtLeast(fast - slow)
        }
        fast = 0
        slow = 0
        curr = 0
        while (slow <= fast && fast < answerKey.length) {
            if (answerKey[fast] == 'F') {
                fast++
            } else {
                if (curr == k) {
                    while (answerKey[slow] == 'F' && slow <= fast) slow++
                    slow++
                    curr--
                } else {
                    curr++
                    fast++
                }
            }
            ans = ans.coerceAtLeast(fast - slow)
        }
        return ans
    }

//    val dp = Array(answerKey.length) { Array(k + 1) { IntArray(2) } }
//        for (j in 0..k){
//            dp[0][j][0] = 1
//            dp[0][j][1] = 1
//        }
//        dp[0][0][1] = 0
//        for (i in 1..dp.lastIndex) {
//            dp[i][0][0] = if (answerKey[i - 1] == answerKey[i]) dp[i - 1][0][0] + 1 else 1
//            dp[i][0][1] = 0
//            for (j in 1..minOf(i + 1, k)) {
//                if (answerKey[i - 1] == answerKey[i]) {
//                    dp[i][j][0] = dp[i - 1][j - 1][0] + 1
//                    dp[i][j][1] = dp[i - 1][j - 1][1] + 1
//                } else {
//                    dp[i][j][0] = dp[i - 1][j - 1][1] + 1
//                    dp[i][j][1] = dp[i - 1][j - 1][0] + 1
//                }
//            }
//        }
//        for (i in dp.indices) {
//            for (j in dp[0].indices) {
//                print(dp[i][j].contentToString())
//            }
//            println()
//        }
//        var ans = 0
//        for (j in 1 until k) {
//            ans = ans.coerceAtLeast(maxOf(dp.last()[j][1], dp.last()[j][0]))
//        }
//        return ans

    fun waysToPartition(nums: IntArray, k: Int): Int {
        val temp = IntArray(nums.size + 1)
        val pre = HashMap<Int, Int>()
        val lst = HashMap<Int, Int>()
        for (i in 1..temp.lastIndex) {
            temp[i] = nums[i - 1] + temp[i - 1]
            if (i != temp.lastIndex) lst[temp[i]] = (lst[temp[i]] ?: 0) + 1
        }
        var ans = 0
        if (temp.last() % 2 == 0) ans = lst[temp.last() / 2] ?: 0
        for (i in nums.indices) {
            val change = k - nums[i]
            val sum = temp.last() + change
            if (sum % 2 == 0) {
                ans = ans.coerceAtLeast((pre[sum / 2] ?: 0) + (lst[sum / 2 - change] ?: 0))
            }
            if (i != nums.lastIndex) {
                pre[temp[i + 1]] = (pre[temp[i + 1]] ?: 0) + 1
                lst[temp[i + 1]] = (lst[temp[i + 1]] ?: 1) - 1
                if (lst[temp[i + 1]]!! == 0) lst.remove(temp[i + 1])
            }
        }
        return ans
    }

    fun waysToPartition2(nums: IntArray, k: Int): Int {
        val temp = IntArray(nums.size + 1)
        val pre = HashMap<Int, Int>()
        val lst = HashMap<Int, Int>()
        for (i in 1..nums.size) {
            temp[i] = nums[i - 1] + temp[i - 1]
            if (i != nums.size) lst[temp[i]] = (lst[temp[i]] ?: 0) + 1
        }
        var ans = 0
        if (temp[nums.size] % 2 == 0) {
            ans = lst[temp[nums.size] / 2] ?: 0
        }
        for (i in nums.indices) {
            val change = k - nums[i]
            val sum = temp[nums.size] + change
            if (sum % 2 == 0) {
                ans = ans.coerceAtLeast((pre[sum / 2] ?: 0) + (lst[sum / 2 - change] ?: 0))
            }
            if (i != nums.lastIndex) {
                pre[nums[i + 1]] = (pre[nums[i + 1]] ?: 0) + 1
                val tmp = lst[temp[i + 1]]!!
                if (tmp == 1) {
                    lst.remove(temp[i + 1])
                } else {
                    lst[temp[i + 1]] = tmp - 1
                }
            }
        }
        return ans
    }
}