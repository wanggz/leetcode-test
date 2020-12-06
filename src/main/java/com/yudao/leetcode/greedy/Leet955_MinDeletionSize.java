package com.yudao.leetcode.greedy;

/**
 * LeetCode955删列造序 ||
 *
 * 问题：
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * 选取一个删除索引序列，对于 A 中的每个字符串，删除对应每个索引处的字符。
 * 比如，有 A = ["abcdef", "uvwxyz"]，删除索引序列 {0, 2, 3}，删除后 A 为["bef", "vyz"]。
 * 假设，我们选择了一组删除索引 D，那么在执行删除操作之后，最终得到的数组的元素是按 字典序（A[0] <= A[1] <= A[2] ... <= A[A.length - 1]）排列的，然后请你返回 D.length 的最小可能值。
 *
 * 示例 1：
 *
 * 输入：["ca","bb","ac"]
 * 输出：1
 * 解释：
 * 删除第一列后，A = ["a", "b", "c"]。
 * 现在 A 中元素是按字典排列的 (即，A[0] <= A[1] <= A[2])。
 * 我们至少需要进行 1 次删除，因为最初 A 不是按字典序排列的，所以答案是 1。
 * 示例 2：
 *
 * 输入：["xc","yb","za"]
 * 输出：0
 * 解释：
 * A 的列已经是按字典序排列了，所以我们不需要删除任何东西。
 * 注意 A 的行不需要按字典序排列。
 * 也就是说，A[0][0] <= A[0][1] <= ... 不一定成立。
 * 示例 3：
 *
 * 输入：["zyx","wvu","tsr"]
 * 输出：3
 * 解释：
 * 我们必须删掉每一列。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 */
public class Leet955_MinDeletionSize {

    public static void main(String[] args) {

        String [] A = new String[] {"ca","bb","ac"};

        System.out.println(solution(A));

    }

    /**
     * 思路：
     *
     *  依次取数组中字符串的指定列的字母与前一个比较。
     *  如果字母比较结果为小，比较下一列字母，删除元素加1。
     *  如果字母比较结果相同，比较列增加，继续比较。
     *  如果字母比较结果为大，比较后面字符串，直到比较完成。
     */
    public static int solution(String[] A){
        int i = 0;

        while (true){
            boolean flag = true;
            for(int s = 1; s < A.length; s++){
                boolean is_small = compare(A[s-1],A[s],i,1);
                if(!is_small){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            i++;
            if(i >= A[0].length()){
                break;
            }
        }
        return i;

    }

    public static boolean compare(String a, String b, int index, int count){
        if (a.charAt(index+count-1) > b.charAt(index+count-1)){
            return false;
        } else if (a.charAt(index+count-1) == b.charAt(index+count-1)) {
            if(index+count > a.length()){
                return true;
            }
            return compare(a,b,index,count+1);
        } else {
            return true;
        }

    }

}
