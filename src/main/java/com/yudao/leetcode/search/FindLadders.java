package com.yudao.leetcode.search;

import java.util.*;

/**
 * 126. 单词接龙 II
 */
public class FindLadders {

    class LevelWord {
        String word;
        int level;
        public LevelWord(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }

    public static void main(String[] args) {

        String start = "hit";
        String end = "cog";
        List<String> list = new ArrayList<String>() {
            {add("hot");add("dot");add("dog");add("lot");add("log");add("cog");}
        };

        FindLadders f = new FindLadders();

        System.out.println(f.findLadders(start, end, list));
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if(wordList.indexOf(endWord) == -1) {
            return result;
        }
        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }
        //list中两两word是否可以转化
        boolean[][] nextWords = new boolean[wordList.size()][wordList.size()];
        //是否访问过，先全部初始化为false；
        Map<String, Boolean> visited = new HashMap<>();
        for(int i = 0; i < wordList.size(); i++) {
            for(int j = 0; j < i; j++){
                if(is_transform(wordList.get(i), wordList.get(j))) {
                    nextWords[i][j] = nextWords[j][i] =	true;
                }
            }
            visited.put(wordList.get(i), false);
        }
        Queue<LevelWord> queue = new LinkedList<>();
        queue.add(new LevelWord(beginWord, 0));
        visited.put(beginWord, true);
        while(!queue.isEmpty()) {
            LevelWord temp = queue.poll();
            if(temp.word.equals(endWord)) {
                //return temp.level + 1;
            }
            List<String> nextWord = new ArrayList<>();
            int n = wordList.indexOf(temp.word);
            for (int i = 0; i < nextWords[n].length; i++) {
                if(nextWords[n][i]) {
                    nextWord.add(wordList.get(i));
                }
            }
            for (int i = 0; i < nextWord.size(); i++) {
                String nextTemp = nextWord.get(i);
                if(!visited.get(nextTemp)) {
                    queue.add(new LevelWord(nextTemp, temp.level + 1));
                    visited.put(nextTemp, true);
                }
            }
        }

        return null;
    }

    private boolean is_transform(String s1, String s2){
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        int dif = 0;
        for(int i = 0; i < c1.length; i++){
            if(c1[i] != c2[i]) {
                dif++;
            }
        }
        if(dif == 1) {
            return true;
        } else {
            return false;
        }
    }

}
