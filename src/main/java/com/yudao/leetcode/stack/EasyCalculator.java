package com.yudao.leetcode.stack;

import java.util.Stack;

/**
 * leetcode 224. 基本计算器
 *
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
 *
 * 示例 1:
 * 输入: "1 + 1"
 * 输出: 2
 *
 * 示例 2:
 * 输入: " 2-1 + 2 "
 * 输出: 3
 *
 * 示例 3:
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/basic-calculator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class EasyCalculator {

    public static int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        int res = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int curSum = s.charAt(i) - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                    curSum = curSum * 10 + s.charAt(++i) - '0';
                }
                res = res + curSum * sign;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch =='-') {
                sign = -1;
            } else if (ch == '(') {
                nums.push(res);
                res = 0;
                nums.push(sign);
                sign = 1;

            } else if (ch == ')') {
                res = nums.pop() * res + nums.pop();
            }
        }
        return res;
    }



    public static void main(String[] args) {

        System.out.println(EasyCalculator.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
