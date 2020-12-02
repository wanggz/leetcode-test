package com.yudao.leetcode.search;

import java.util.*;

/**
 * 127. 单词接龙
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 *
 * 说明:
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * https://blog.csdn.net/qq_41231926/article/details/81545756
 */
public class LadderLength {

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

        LadderLength l = new LadderLength();

        System.out.println(l.ladderLength1(start, end, list));

        System.out.println(l.ladderLength2(start,end,list));
    }

    // 图的广度优先遍历
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        if(wordList.indexOf(endWord) == -1) {
            return 0;
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
                return temp.level + 1;
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

        return 0;
    }

    // todo SPFA算法求最短路径
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        return 0;
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
