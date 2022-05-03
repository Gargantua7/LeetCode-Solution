//请你设计一个迭代器，除了支持 hasNext 和 next 操作外，还支持 peek 操作。 
//
// 实现 PeekingIterator 类： 
//
// 
// 
// 
// PeekingIterator(int[] nums) 使用指定整数数组 nums 初始化迭代器。 
// int next() 返回数组中的下一个元素，并将指针移动到下个元素处。 
// bool hasNext() 如果数组中存在下一个元素，返回 true ；否则，返回 false 。 
// int peek() 返回数组中的下一个元素，但 不 移动指针。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["PeekingIterator", "next", "peek", "next", "next", "hasNext"]
//[[[1, 2, 3]], [], [], [], [], []]
//输出：
//[null, 1, 2, 2, 3, false]
//
//解释：
//PeekingIterator peekingIterator = new PeekingIterator([1, 2, 3]); // [1,2,3]
//peekingIterator.next();    // 返回 1 ，指针移动到下一个元素 [1,2,3]
//peekingIterator.peek();    // 返回 2 ，指针未发生移动 [1,2,3]
//peekingIterator.next();    // 返回 2 ，指针移动到下一个元素 [1,2,3]
//peekingIterator.next();    // 返回 3 ，指针移动到下一个元素 [1,2,3]
//peekingIterator.hasNext(); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 1000 
// 对 next 和 peek 的调用均有效 
// next、hasNext 和 peek 最多调用 1000 次 
// 
// 
// 
//
// 
//
// 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？ 
// Related Topics 设计 数组 迭代器 👍 95 👎 0


package leetcode.editor.cn

/**
 * 284
 * 窥探迭代器
 *
 * @author Gargantua丶
 * 2021-10-05 00:51:03
 */
class PeekingIterator {
//leetcode submit region begin(Prohibit modification and deletion)
// Kotlin Iterator reference:
// https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-iterator/

    class PeekingIterator(val iterator: Iterator<Int>) : Iterator<Int> {

        var cache: Int? = null

        fun peek(): Int {
            if (cache == null) cache = iterator.next()
            return cache!!
        }

        override fun next(): Int {
            if (cache == null) cache = iterator.next()
            val temp = cache!!
            cache = null
            return temp
        }

        override fun hasNext(): Boolean {
            return cache != null || iterator.hasNext()
        }
    }

    /**
     * Your PeekingIterator object will be instantiated and called as such:
     * var obj = PeekingIterator(arr)
     * var param_1 = obj.next()
     * var param_2 = obj.peek()
     * var param_3 = obj.hasNext()
     */
//leetcode submit region end(Prohibit modification and deletion)

}