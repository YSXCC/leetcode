/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        //2、动态规划
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;      //为空串准备
        
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length(); j >= 0; j--) {
                //空串处理
                if(i == s.length() && j == p.length())  continue;

                boolean firstMatch = (i < s.length() && j < p.length() 
                                      && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));
                if(j + 1 < p.length() && p.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || firstMatch && dp[i+1][j]; 
                }else{
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
// @lc code=end

//1、凡人理解迭代，神理解递归
// if(p.isEmpty()) return s.isEmpty();

// boolean firstMatch = (!s.isEmpty() && ((p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')));

// if(p.length() >= 2 && p.charAt(1) == '*'){
//     出现0次和匹配一次
//     return (isMatch(s, p.substring(2)) ||
//             firstMatch && isMatch(s.substring(1), p));
// }else{
//     return firstMatch && isMatch(s.substring(1), p.substring(1));
// }