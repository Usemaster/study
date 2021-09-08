package com.study.test;

/*
7.整数反转
给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
假设环境不允许存储 64 位整数（有符号或无符号）。

示例 1：
输入：x = 123
输出：321

示例 2：
输入：x = -123
输出：-321

示例 3：
输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0

提示：
-231 <= x <= 231 - 1
* */
public class Reverse {

    public static void main(String[] args) {

    }

    //数学方法
    //记 rev 为翻转后的数字，为完成翻转，我们可以重复「弹出」x 的末尾数字，将其「推入」rev 的末尾，直至 x 为 0。
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            //判断反转后的数字是否超出有符号整数的范围(2^31 - 1,-2^31)
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            //弹出x的末尾数字
            int digit = x % 10;
            x /= 10;
            //将数字digit推入rev末尾
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
