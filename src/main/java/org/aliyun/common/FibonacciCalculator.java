package org.aliyun.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 斐波那契数列计算器
 * 提供计算和打印斐波那契数列的功能
 */
public class FibonacciCalculator {
    
    // 用于记忆化的缓存
    private static final Map<Integer, Long> cache = new HashMap<>();
    
    /**
     * 计算第n个斐波那契数（使用记忆化优化）
     * @param n 要计算的斐波那契数的位置（从0开始）
     * @return 第n个斐波那契数
     * @throws IllegalArgumentException 如果n为负数
     */
    public static long calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("输入必须是非负整数，但得到: " + n);
        }
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // 检查缓存
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        // 使用迭代方法计算，避免递归的性能问题
        long prev1 = 0, prev2 = 1;
        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2;
            // 检查溢出
            if (current < 0) {
                throw new ArithmeticException("计算第" + n + "个斐波那契数时发生整数溢出");
            }
            prev1 = prev2;
            prev2 = current;
        }
        
        cache.put(n, prev2);
        return prev2;
    }
    
    /**
     * 打印斐波那契数列的前count个数
     * @param count 要打印的斐波那契数的个数
     * @throws IllegalArgumentException 如果count为负数
     */
    public static void printFibonacciSequence(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count必须是非负整数，但得到: " + count);
        }
        
        System.out.println("斐波那契数列前" + count + "项:");
        for (int i = 0; i < count; i++) {
            try {
                System.out.print(calculateFibonacci(i) + " ");
            } catch (ArithmeticException e) {
                System.out.println("\n在第" + i + "项时发生溢出");
                break;
            }
        }
        System.out.println(); // 换行
    }
    
    /**
     * 主方法
     * @param args 命令行参数，第一个参数应该是要打印的斐波那契数的个数
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("用法: java FibonacciCalculator <数量>");
            System.err.println("示例: java FibonacciCalculator 10");
            System.exit(1);
        }
        
        try {
            int num = Integer.parseInt(args[0]);
            if (num < 0) {
                System.err.println("错误: 请输入一个非负整数");
                System.exit(1);
            }
            
            printFibonacciSequence(num);
            
        } catch (NumberFormatException e) {
            System.err.println("错误: '" + args[0] + "' 不是一个有效的整数");
            System.exit(1);
        } catch (Exception e) {
            System.err.println("发生错误: " + e.getMessage());
            System.exit(1);
        }
    }
}