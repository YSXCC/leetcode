/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        //2、动态规划
        int length = s.length();
        String reverse = new StringBuffer(s).reverse().toString();
        int arr[][] = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if(s.charAt(i) == reverse.charAt(j)){
                    if(i == 0 || j == 0){
                        arr[i][j] = 1;
                    }
                    else{
                        arr[i][j] = arr[i-1][j-1] + 1;
                    }
                }
            }
        }
        return s.substring(maxEnd-length+1, maxEnd+1);
    }

    
}
// @lc code=end


    // class Solution {
    //     public String longestPalindrome(String s) {
            // 1、暴力求解超时
            // boolean isHuiwen(String s){
            //     int length = s.length();
            //     for(int i=0;i<length/2;i++){
            //         if(s.charAt(i) != s.charAt(length-1-i)){
            //             return false;
            //         }
            //     }
            //     return true;
            // }
            // if(s.length() > 1000){
            //     return "";
            // }
            // if(s.length() == 1){
            //     return s;
            // }
            // String result = "";
            // for(int i=0;i<s.length();i++){
            //     for(int j=i+1;j<=s.length();j++){
            //         if(isHuiwen(s.substring(i, j))){
            //             if(result != null && s.substring(i, j).length() > result.length()){
            //                 result = s.substring(i, j);
            //             }
            //             if(result == null){
            //                 result = s.substring(i, j);
            //             }
            //         }
            //     }
            // }
            // return result;
    //     }
    
        
    // }