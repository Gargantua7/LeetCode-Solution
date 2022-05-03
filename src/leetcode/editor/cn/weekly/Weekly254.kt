package leetcode.editor.cn.weekly

/**
 * @author Gargantua丶
 **/
class Weekly254 {

    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.fold(0) { ans, n ->
            if (n in word) ans + 1 else ans
        }
    }

    fun rearrangeArray(nums: IntArray): IntArray {
        nums.sort()
        val ans = ArrayList<Int>()
        val mid = (nums.size + 1) / 2
        for (i in 0 until mid) {
            ans += nums[i]
            if (i + mid < nums.size) {
                ans += nums[i + mid]
            }
        }
        return ans.toIntArray()
    }
}