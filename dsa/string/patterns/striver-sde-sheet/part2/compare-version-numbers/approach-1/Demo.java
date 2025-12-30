class Solution {
    public int compareVersion(String version1, String version2) {
        String numbers1[] = version1.split("\\.");
        /*
            \n is invalid we should use \\n
            \. is invalid we should use \\.
        */
        int len1 = numbers1.length;

        String numbers2[] = version2.split("\\.");
        int len2 = numbers2.length;

        int maxLen = Math.max(len1, len2);

        for(int i = 0; i < maxLen; i++) {
            int num1 = i < len1 ? Integer.parseInt(numbers1[i]): 0;
            int num2 = i < len2 ? Integer.parseInt(numbers2[i]): 0;

            if(num1 < num2) {
                return -1;
            }else if(num1 > num2) {
                return 1;
            }
        }

        return 0;
    }
}