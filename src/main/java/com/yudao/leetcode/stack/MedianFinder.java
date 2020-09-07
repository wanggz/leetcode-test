package com.yudao.leetcode.stack;

import java.util.PriorityQueue;

/**
 *
 */
public class MedianFinder {

    int count = 0;
    PriorityQueue<Integer> first;   //从大到小
    PriorityQueue<Integer> end;     //从小到大

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        first = new PriorityQueue<>((x, y) -> {
            if (x > y) return -1;
            else if (x < y) return 1;
            else return x.compareTo(y);
        });
        end = new PriorityQueue<>((x, y) -> {
            if (x > y) return 1;
            else if (x < y) return -1;
            else return x.compareTo(y);
        });
    }

    public void addNum(int num) {
        this.count++;
        first.add(num);
        end.add(first.poll());
        if ((count & 1) == 1) first.add(end.poll());
    }

    public double findMedian() {
        if ((count & 1) == 1) return Double.parseDouble(String.valueOf(first.peek()));
        else {
            double ans = (first.peek() + end.peek()) / 2.0f;
            return ans;
        }
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();

        //System.out.println(finder.findMedian());
        finder.addNum(-1);
        System.out.println(finder.findMedian());
        finder.addNum(-2);
        System.out.println(finder.findMedian());
        finder.addNum(-3);
        System.out.println(finder.findMedian());
        finder.addNum(-4);
        System.out.println(finder.findMedian());
        finder.addNum(-5);
        System.out.println(finder.findMedian());
        //
        //System.out.println(finder.findMedian());
        //
        //System.out.println(finder.findMedian());

    }

}
