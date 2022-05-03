//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 
//key 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//inputs = ["MapSum", "insert", "sum", "insert", "sum"]
//inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
//
// 
//
// 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/ 
// Related Topics 设计 字典树 哈希表 字符串 👍 2 👎 0


package leetcode.editor.cn

import java.util.*

/**
 * 剑指 Offer II 066
 * 单词之和
 *
 * @author Gargantua丶
 * 2021-10-19 13:58:33
 */
class Z1R5dt { 
//leetcode submit region begin(Prohibit modification and deletion)
class MapSum() {

    /** Initialize your data structure here. */
    val root = TrieNode(' ')

    class TrieNode(val c: Char) {

        var value: Int = 0
        var children: Array<TrieNode?>? = null
    }

    fun insert(key: String, value: Int) {
        var temp = root
        key.forEach { c ->
            if (temp.children == null) temp.children = Array(26) { null }
            if (temp.children!![c - 'a'] == null) temp.children!![c - 'a'] = TrieNode(c)
            temp = temp.children!![c - 'a']!!
        }
        temp.value = value
    }

    fun sum(prefix: String): Int {
        var temp = root
        prefix.forEach { c ->
            temp = temp.children?.get(c - 'a')?: return 0
        }
        var ans = 0
        val stack: Deque<TrieNode> = LinkedList()
        stack.push(temp)
        while (stack.isNotEmpty()) {
            val node = stack.pop()
            ans += node.value
            node.children?.let { children ->
                children.forEach { child ->
                    child?.let { stack.push(it) }
                }
            }
        }
        return ans
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */
//leetcode submit region end(Prohibit modification and deletion)

}