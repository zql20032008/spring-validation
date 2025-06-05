package org.aliyun.common;

import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciCalculatorTest {
    
    @Test
    public void testBasicFibonacciNumbers() {
        assertEquals(0, FibonacciCalculator.calculateFibonacci(0));
        assertEquals(1, FibonacciCalculator.calculateFibonacci(1));
        assertEquals(1, FibonacciCalculator.calculateFibonacci(2));
        assertEquals(2, FibonacciCalculator.calculateFibonacci(3));
        assertEquals(3, FibonacciCalculator.calculateFibonacci(4));
        assertEquals(5, FibonacciCalculator.calculateFibonacci(5));
        assertEquals(8, FibonacciCalculator.calculateFibonacci(6));
        assertEquals(13, FibonacciCalculator.calculateFibonacci(7));
        assertEquals(21, FibonacciCalculator.calculateFibonacci(8));
        assertEquals(34, FibonacciCalculator.calculateFibonacci(9));
        assertEquals(55, FibonacciCalculator.calculateFibonacci(10));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInput() {
        FibonacciCalculator.calculateFibonacci(-1);
    }
    
    @Test
    public void testLargeFibonacciNumber() {
        // 测试较大的斐波那契数
        assertEquals(102334155L, FibonacciCalculator.calculateFibonacci(40));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPrintNegativeCount() {
        FibonacciCalculator.printFibonacciSequence(-1);
    }
    
    @Test
    public void testPrintZeroCount() {
        // 应该不打印任何数字
        FibonacciCalculator.printFibonacciSequence(0);
    }
    
    @Test
    public void testPerformance() {
        long startTime = System.currentTimeMillis();
        FibonacciCalculator.calculateFibonacci(40);
        long endTime = System.currentTimeMillis();
        
        // 优化后的版本应该在100毫秒内完成
        assertTrue("计算第40个斐波那契数耗时过长", (endTime - startTime) < 100);
    }
}