class Solution {
    public int compareVersion(String version1, String version2) {
        int N = version1.length();
        int M = version2.length();

        int i = 0, j = 0;

        while(i < N || j < M) {
            while(i < N && version1.charAt(i) == '0') {
                i++;
            }

            while(j < M && version2.charAt(j) == '0') {
                j++;
            }

            int start1 = i;
            while(i < N && version1.charAt(i) != '.') {
                i++;
            }

            int start2 = j;
            while(j < M && version2.charAt(j) != '.') {
                j++;
            }

            int len1 = i - start1;
            int len2 = j - start2;

            if(len1 == len2) {
                for(int k = 0; k < len1; k++) {
                    char ch1 = version1.charAt(start1 + k);
                    char ch2 = version2.charAt(start2 + k);

                    if(ch1 > ch2) {
                        return 1;
                    }else if(ch1 < ch2) {
                        return -1;
                    }
                }
            }
            else if(len1 > len2) {
                return 1;
            }else if(len1 < len2) {
                return -1;
            }

            i++;
            j++;
        }    

        return 0;
    }
}