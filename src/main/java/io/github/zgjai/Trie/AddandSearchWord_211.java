package io.github.zgjai.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word) bool search(word) search(word) can search a literal word or a regular expression string containing
 * only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad") addWord("dad") addWord("mad") search("pad") -> false search("bad") -> true search(".ad") -> true
 * search("b..") -> true
 */
public class AddandSearchWord_211 {
    private static class WordDictionary {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode curNode = root;
            for (Character c : word.toCharArray()) {
                if (!curNode.node.containsKey(c)) {
                    TrieNode node = new TrieNode();
                    curNode.node.put(c, node);
                }
                curNode = curNode.node.get(c);
            }
            curNode.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one
         * letter.
         */
        public boolean search(String word) {
            List<TrieNode> curNodeList = new ArrayList<>();
            char firstC = word.charAt(0);
            if ('.' == firstC) {
                curNodeList = new ArrayList<>(root.node.values());
            } else if (root.node.containsKey(firstC)) {
                curNodeList.add(root.node.get(firstC));
            } else {
                return false;
            }
            word = word.substring(1);
            for (Character c : word.toCharArray()) {
                curNodeList = search(c, curNodeList);
                if (curNodeList == null || curNodeList.size() == 0) {
                    return false;
                }
            }
            for (TrieNode node : curNodeList) {
                if (node.isWord) {
                    return true;
                }
            }
            return false;
        }

        private List<TrieNode> search(Character c, List<TrieNode> nodeList) {
            if (nodeList == null || nodeList.size() == 0) {
                return null;
            }
            List<TrieNode> result = new ArrayList<>();
            nodeList.forEach(node -> {
                if ('.' == c) {
                    result.addAll(node.node.values());
                } else {
                    TrieNode tmp = node.node.get(c);
                    if (tmp != null) {
                        result.add(tmp);
                    }
                }
            });
            return result;
        }

        static class TrieNode {
            boolean isWord;
            Map<Character, TrieNode> node;

            public TrieNode() {
                this.isWord = false;
                this.node = new TreeMap<Character, TrieNode>();
            }
        }
    }
}
