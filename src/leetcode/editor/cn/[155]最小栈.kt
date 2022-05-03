//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 👍 991 👎 0


package leetcode.editor.cn

import java.util.*
import kotlin.properties.Delegates

/**
 * 155
 * 最小栈
 *
 * @author Gargantua丶
 * 2021-08-25 00:56:51
 */
class MinStack { 
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    val stack: Deque<Int> = LinkedList()
    val minStack: Deque<Int> = LinkedList()

    init {
        minStack.push(Int.MAX_VALUE)
    }

    fun push(`val`: Int) {
        stack.push(`val`)
        minStack.push(kotlin.math.min(minStack.peek(), `val`))
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top() = stack.peek()

    fun getMin() = minStack.peek()

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
//leetcode submit region end(Prohibit modification and deletion)

}