//给出两个一维的向量，请你实现一个迭代器，交替返回它们中间的元素。 
//
// 示例: 
//
// 输入:
//v1 = [1,2]
//v2 = [3,4,5,6] 
//
//输出: [1,3,2,4,5,6]
//
//解析: 通过连续调用 next 函数直到 hasNext 函数返回 false，
//     next 函数返回值的次序应依次为: [1,3,2,4,5,6]。 
//
// 拓展：假如给你 k 个一维向量呢？你的代码在这种情况下的扩展性又会如何呢? 
//
// 拓展声明： 
// “锯齿” 顺序对于 k > 2 的情况定义可能会有些歧义。所以，假如你觉得 “锯齿” 这个表述不妥，也可以认为这是一种 “循环”。例如： 
//
// 输入:
//[1,2,3]
//[4,5,6,7]
//[8,9]
//
//输出: [1,4,8,2,5,9,3,6,7].
// 
// Related Topics 设计 队列 数组 迭代器 👍 47 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 281
 * 锯齿迭代器	
 *
 * @author Gargantua丶
 * 2021-11-17 13:49:55
 */
class ZigzagIterator { 
//leetcode submit region begin(Prohibit modification and deletion)
class ZigzagIterator(val v1: IntArray, val v2: IntArray) {

    var idx = 0
    var list = LinkedList<IntArray?>()

    init {
        if (v1.isNotEmpty()) list.add(v1)
        if (v2.isNotEmpty()) list.add(v2)
        list.add(null)
    }

    fun next(): Int {
        val re = list[0]!![idx]
        while (list.size > 1) {
            if (list[0] == null) {
                idx++
                list.add(list.removeAt(0))
            }
            else if (list[0]!!.lastIndex < idx) list.removeAt(0)
            else list.add(list.removeAt(0))

            if ((list[0]?.lastIndex?: -1) >= idx) break
        }
        return re
    }
    
    fun hasNext(): Boolean {
        return list.size > 1
    }
}

// Your ZigzagIterator object will be instantiated and called as such:
// var i = ZigzagIterator(v1, v2)
// var ret = ArrayList<Int>()
// while(i.hasNext()){
//		ret.add(i.next())
// }
//leetcode submit region end(Prohibit modification and deletion)

}