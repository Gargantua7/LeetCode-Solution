package leetcode.editor.cn.weekly

/**
 * @author Gargantua丶
 **/
class Weekly255 {
    fun findGCD(nums: IntArray): Int {
        var max = nums.maxOrNull()!!
        var min = nums.minOrNull()!!
        while (min != 0) {
            val temp = max % min
            max = min
            min = temp
        }
        return max
    }

    fun findDifferentBinaryString(nums: Array<String>): String {
        return buildString {
            nums.forEachIndexed { i, num ->
                append(if(num[i] == '0') '1' else '0')
            }
        }
    }
}