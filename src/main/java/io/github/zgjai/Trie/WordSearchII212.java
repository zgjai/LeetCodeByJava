package io.github.zgjai.Trie;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input: words = ["oath","pea","eat","rain"] and board =
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 *
 * Output: ["eat","oath"]
 */
public class WordSearchII212 {

    public List<String> findWords(char[][] board, String[] words) {

    }

    private TrieNode constructTrie(char[][] board) {
        TrieNode root = new TrieNode();

        return root;
    }

    static class TrieNode {
        Map<Character, TrieNode> node;

        TrieNode() {
            this.node = new TreeMap<>();
        }
    }
}