class Solution {
    public int compareVersion(String version1, String version2) {
        int N = version1.length();
        int M = version2.length();

        int i = 0, j = 0;

        while(i < N || j < M) {
            int num1 = 0;
            while(i < N && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            int num2 = 0;
            while(j < M && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if(num1 < num2) {
                return -1;
            }else if(num1 > num2){
                return 1;
            }

            i++;
            j++;
        }    
        return 0;
    }
}