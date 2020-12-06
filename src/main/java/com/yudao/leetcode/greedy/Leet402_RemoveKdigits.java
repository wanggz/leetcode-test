package com.yudao.leetcode.greedy;

import java.util.Stack;

/**
 * leetcode 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 *
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 示例 3 :
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet402_RemoveKdigits {

    public static String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i< num.length(); i++) {
            int a = Integer.parseInt(num.charAt(i)+"");
            while (!stack.empty() && stack.get(stack.size()-1) > a && k > 0) {
                stack.pop();
                k--;
            }
            if(a != 0 || stack.size() != 0) {
                stack.push(a);
            }
        }
        while (stack.size() > 0 && k > 0){
            stack.pop();
            k--;
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < stack.size(); i++){
            sb.append(stack.get(i)+"");
        }
        if(sb.length() == 0){
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        //System.out.println(RemoveKdigits.removeKdigits("12345",2));     //123
        System.out.println(Leet402_RemoveKdigits.removeKdigits("1234567890",9));    //0
        System.out.println(Leet402_RemoveKdigits.removeKdigits("100200",1));
        //System.out.println(RemoveKdigits.removeKdigits("1432219",3));   //1219

    }
}
