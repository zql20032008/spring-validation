package org.aliyun.common;

public class FibonacciCalculator {
    
    // 计算第n个斐波那契数的方法,未判断n
    public static int calculateFibonacci(int n) {
        if (n <= 0) {
            return 0;  
        }
        
        if (n == 1) {
            return 1;
        }
        
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
    
    // 打印斐波那契数列的方法
    public static void printFibonacciSequence(int count) {
        for (int i = 0; i <= count; i++) {  
            System.out.print(calculateFibonacci(i) + " ");
        }
    }
    
    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);
        
        System.out.println("斐波那契数列前" + num + "项:");
        printFibonacciSequence(num);
    }
}