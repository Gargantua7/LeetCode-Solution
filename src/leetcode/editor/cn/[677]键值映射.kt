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
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
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
// Related Topics 设计 字典树 哈希表 字符串 👍 143 👎 0

package leetcode.editor.cn

import java.util.*

/**
 * 677
 * 键值映射
 *
 * @author Gargantua丶
 * 2021-11-14 13:37:27
 */
class MapSumPairs {
    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        class TreeNode {
            var value: Int = 0
            var children = Array<TreeNode?>(26) { null }
        }

        val root = TreeNode()

        fun insert(key: String, value: Int) {
            var temp = root
            key.forEach { c ->
                if (temp.children[c - 'a'] == null) temp.children[c - 'a'] = TreeNode()
                temp = temp.children[c - 'a']!!
            }
            temp.value = value
        }

        fun sum(prefix: String): Int {
            var temp = root
            prefix.forEach { c ->
                temp = temp.children[c - 'a']?: return 0
            }
            var sum = 0
            val queue: Queue<TreeNode> = LinkedList()
            queue.offer(temp)
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                node.children.forEach { child ->
                    child?.let { queue.offer(it) }
                }
                sum += node.value
            }
            return sum
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