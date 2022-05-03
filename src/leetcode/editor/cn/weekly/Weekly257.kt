package leetcode.editor.cn.weekly

/**
 * @author Gargantua丶
 **/
class Weekly257 {

    var count = 0

    fun countQuadruplets(nums: IntArray): Int {
        val n = nums.size
        count = 0
        if (n < 4) return 0
        dfs(nums, 0, n, 0, 0)
        return count
    }

    fun dfs(nums: IntArray, depth: Int, len: Int, s: Int, begin: Int) {
        var sum = s
        if (depth == 3) {
            for (i in begin until len) {
                if (sum == nums[i]) {
                    count++
                }
            }
            return
        }
        for (i in begin until len - 1) {
            sum += nums[i]
            dfs(nums, depth + 1, len, sum, i + 1)
            sum -= nums[i]
        }
    }


    // 2
    fun numberOfWeakCharacters(properties: Array<IntArray>): Int {
        properties.sortWith(kotlin.Comparator<IntArray> { (attackA, defendA), (attackB, defendB) ->
            if (attackB - attackA != 0) attackB - attackA else defendA - defendB
        })
        var ans = 0
        var maxDefend = 0
        properties.forEach { (_, defend) ->
            if (defend < maxDefend) ans++
            maxDefend = maxDefend.coerceAtLeast(defend)
        }
        return ans
    }
}