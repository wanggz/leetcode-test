package com.yudao.leetcode.sort;

import com.yudao.leetcode.sort.tools.QuickSort;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode954
 *
 * 问题：二倍数对数组
 * 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 示例 1：
 *
 * 输入：[3,1,3,6]
 * 输出：false
 * 示例 2：
 *
 * 输入：[2,1,2,6]
 * 输出：false
 * 示例 3：
 *
 * 输入：[4,-2,2,-4]
 * 输出：true
 * 解释：我们可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * 示例 4：
 *
 * 输入：[1,2,4,16,8,4]
 * 输出：false
 */
public class TwoTimesArray {

    public static void main(String[] args) {
        int [] a = new int[] {-3,-6,2,4,5,10};

        System.out.println(solution(a));
    }

    /**
     * 解决思路：
     *  先将数组分成正负两部分，分别排序，正序部分从小到大，负序部分从大到小，
     *  比较后一个是否是前一个2倍，如果不是返回false，全都比较完返回true。
     *
     */
    public static boolean solution(int [] A){

        List<Integer> parray = new ArrayList<>();
        List<Integer> narray = new ArrayList<>();

        for(int i = 0; i< A.length; i++){
            if(A[i] >= 0){
                parray.add(A[i]);
            } else {
                narray.add(A[i]);
            }
        }

        if(parray.size() % 2 != 0 && narray.size() % 2 != 0){
            return false;
        }

        int[] p = parray.stream().mapToInt(Integer::valueOf).toArray();
        QuickSort.sort(p,0,p.length-1,true);
        for(int i = 0; i< p.length; i=i+2){
            if(p[i+1] != 2* p[i]){
                return false;
            }
        }

        int[] n = narray.stream().mapToInt(Integer::valueOf).toArray();
        QuickSort.sort(n,0,n.length-1,false);
        for(int i = 0; i< n.length; i=i+2){
            if(n[i+1] != 2* n[i]){
                return false;
            }
        }

        return true;
    }
}
