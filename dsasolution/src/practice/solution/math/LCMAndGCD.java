package practice.solution.math;

public class LCMAndGCD {

	public static void main(String[] args) {
		int[] result = lcmAndGcd(60, 61);
		System.out.println(result[0] + " " + result[1]);
	}
	
	public static int[] lcmAndGcd(int a, int b) {
        // code here
        int lcm = 1;
        int[] result = new int[2];
        
        int maxNum = Math.max(a, b);
        int minNum = a < b ? a : b;
        int divisor = 2;
        
        
        while(a > 1 || b > 1) {
            if(a % divisor == 0 && b % divisor == 0) {
                lcm = lcm * divisor;
                a = a / divisor;
                b = b / divisor;
            } else if(a % divisor == 0 && b % divisor != 0) {
                lcm = lcm * divisor;
                a = a / divisor;
            } else if(a % divisor != 0 && b % divisor == 0) {
                lcm = lcm * divisor;
                b = b / divisor;
            } else {
                divisor++;
            }
            
            if(a == 1 && b == 1) {
                break;
            }
            
            
        }
        result[0] = lcm;
        int remainder = 1;
        int gcd = minNum;
        while(remainder >= 1) {
            remainder = maxNum % gcd;
            if(remainder == 0) {
                break;
            }
            maxNum = gcd;
            gcd = remainder;
        }
        result[1] = gcd;
        
        return result;
    }

}
