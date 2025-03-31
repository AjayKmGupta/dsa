package practice.solution.recursion;

import java.util.ArrayList;

public class FactorialLessThanOrEqualtoN {

	static ArrayList<Long> longList = new ArrayList<>();
	
	public static void main(String[] args) {
		long n = 6;
		System.out.println(factorialNumbers(n));
	}
	
    static ArrayList<Long> factorialNumbers(long n) {
        // code here
        if(n <= 0) {
            return longList;
        }
        factorialNumbers(n - 1);
        long fact = 1;
        for(int i = 1; i < longList.size(); i++) {
            fact = fact * longList.get(i);
            if(fact < n) {
                longList.add(n);
            }
        }
        return longList;
    }
}
