import java.util.Scanner;

class Solution {
	public void patternMatching(String text, String pattern) {
		String combinedText = pattern + "$" + text;
		System.out.println(combinedText);
		int z[] = zFunction(combinedText);
		
		int patternLen = pattern.length();
		int textLen = text.length();
	
		for(int i = 0; i < textLen; i++) {
				if(z[i] == patternLen) {
					System.out.println(i - patternLen - 1);
				}
		}
	}
	
	private int[] zFunction(String s) {
		int N = s.length();
		int z[] = new int[N];
		
		int L = 0, R = 0;
		z[0] = 0;
		
		for(int i = 1; i < N; i++) {
			if(i < R) {
				z[i] = Math.min(R - i + 1, z[i - L]);
			}
			
			while(i + z[i] < N && s.charAt(z[i]) == s.charAt(i + z[i])) {
				z[i]++;
			} 
			
			if(i + z[i] - 1 > R) {
				L = i;
				R = i + z[i] - 1;
			}
		}
		
		return z;
	}
}

public class Demo {
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[]) {
		String s = sc.nextLine();
		String p = sc.nextLine();
		
		Solution solution = new Solution();
		solution.patternMatching(s, p); 
	}
}