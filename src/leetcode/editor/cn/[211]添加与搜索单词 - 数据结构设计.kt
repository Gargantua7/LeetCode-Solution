//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // return False
//wordDictionary.search("bad"); // return True
//wordDictionary.search(".ad"); // return True
//wordDictionary.search("b.."); // return True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 500 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 50000 次 addWord 和 search 
// 
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 286 👎 0


package leetcode.editor.cn

/**
 * 211
 * 添加与搜索单词 - 数据结构设计
 *
 * @author Gargantua丶
 * 2021-10-19 00:08:58
 */
class DesignAddAndSearchWordsDataStructure {

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        val root = TrieNode('0')

        class TrieNode(val c: Char) {

            var end = false
            val children = Array<TrieNode?>(26) { null }
        }

        fun addWord(word: String) {
            var temp = root
            word.forEach { c ->
                if (temp.children[c - 'a'] == null) temp.children[c - 'a'] = TrieNode(c)
                temp = temp.children[c - 'a']!!
            }
            temp.end = true
        }

        fun search(word: String) = dfs(root, word, 0)

        fun dfs(root: TrieNode, word: String, index: Int): Boolean {
            if (index == word.length) return root.end
            if (word[index] == '.') {
                root.children.forEach { node ->
                    node?.let {
                        if (dfs(it, word, index + 1)) return true
                    }
                }
            } else {
                root.children[word[index] - 'a']?.let {
                    if (dfs(it, word, index + 1)) return true
                }
            }
            return false
        }

    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * var obj = WordDictionary()
     * obj.addWord(word)
     * var param_2 = obj.search(word)
     */
//leetcode submit region end(Prohibit modification and deletion)

}