package io.github.zgjai.Trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 */
public class ImplementTrie_208 {

    private static class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                TrieNode next = curNode.node.get(c);
                if (next == null) {
                    next = new TrieNode();
                    curNode.node.put(c, next);
                }
                curNode = next;
            }
            curNode.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.node.containsKey(c)) {
                    curNode = curNode.node.get(c);
                    continue;
                }
                return false;
            }
            return curNode.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            for (char c : prefix.toCharArray()) {
                if (curNode.node.containsKey(c)) {
                    curNode = curNode.node.get(c);
                    continue;
                }
                return false;
            }
            return true;
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