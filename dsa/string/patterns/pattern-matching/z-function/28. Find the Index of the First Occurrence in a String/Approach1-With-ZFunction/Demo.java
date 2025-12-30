// 28. Find the Index of the First Occurrence in a String
class Solution {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();

        String combined = needle + "$" + haystack;
        int z[] = zFunction(combined);

        for(int i = M + 1; i < z.length; i++) {
            if(z[i] == M) {
                return (i - M - 1);
            }
        }

        return -1;
    }

    private int[] zFunction(String s) {
        int N = s.length();
        int z[] = new int[N];

        int L = 0, R = 0;
        for(int i = 1; i < N; i++) {
            if(i <= R) {
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