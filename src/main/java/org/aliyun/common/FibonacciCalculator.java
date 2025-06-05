public class FibonacciCalculator {
    
    // 计算第n个斐波那契数的方法
    public static int calculateFibonacci(int n) {
        if (n <= 0) {
            return 0;  // Bug 1: 对于n=0应该返回0，但n为负数时处理不当
        }
        
        if (n == 1) {
            return 1;
        }
        
        //注意这段bug
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }
    
    // 打印斐波那契数列的方法
    public static void printFibonacciSequence(int count) {
        // Bug 3: 没有验证count是否为非负数
        for (int i = 0; i <= count; i++) {  // Bug 4: 应该是i < count，否则会多打印一个数
            System.out.print(calculateFibonacci(i) + " ");
        }
    }
    
    public static void main(String[] args) {
        // Bug 5: 没有处理可能的NumberFormatException
        int num = Integer.parseInt(args[0]);
        
        System.out.println("斐波那契数列前" + num + "项:");
        printFibonacciSequence(num);
    }
}