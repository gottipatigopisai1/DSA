class Solution {
    public int compareVersion(String version1, String version2) {
        int N = version1.length();
        int M = version2.length();

        int i = 0, j = 0;

        while(i < N || j < M) {
            int start1 = i;
            while(i < N && version1.charAt(i) != '.') {
                i++;
            }

            int start2 = j;
            while(j < M && version2.charAt(j) != '.') {
                j++;
            }

            while(start1 < i && version1.charAt(start1) == '0') {
                start1++;
            }

            while(start2 < j && version2.charAt(start2) == '0') {
                start2++;
            }

            String num1 = "";
            String num2 = "";

            if(start1 < N) {
                num1 = version1.substring(start1, i);
            }

            if(start2 < M) {
                num2 = version2.substring(start2, j);
            }

            if(num1.length() != num2.length()) {
                if(num1.length() > num2.length()) {
                    return 1;
                }else{
                    return -1;
                }
            }else{
                if(!num1.equals(num2)) {
                    if(num1.compareTo(num2) > 0) { //  "A".compareTo("D") is -3
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }

            i++;
            j++;
        }    

        return 0;
    }
}