package com.javarush.task.task23.task2305;

/* 
Inner
*/

public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] res = new Solution[2];
        Solution s1 = new Solution();
        Solution s2 = new Solution();

        s1.innerClasses = new InnerClass[]{s1.new InnerClass(), s1.new InnerClass()};
        s2.innerClasses = new InnerClass[]{s2.new InnerClass(), s2.new InnerClass()};

        res[0] = s1;
        res[1] = s2;

        return res;
    }

    public static void main(String[] args) {

    }
}
