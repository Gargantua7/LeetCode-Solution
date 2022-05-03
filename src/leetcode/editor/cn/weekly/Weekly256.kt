package leetcode.editor.cn.weekly

/**
 * @author Gargantua丶
 **/
class Weekly256 {

    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        nums.sortWith(kotlin.Comparator<String> { a: String, b: String ->
            if (a.length == b.length) b.compareTo(a)
            else b.length - a.length
        })
        return nums[k - 1]
    }
}