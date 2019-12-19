/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String str) {
        long value = 0;
        int flag = -1;   // 0 -> +  1 -> -
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' '){
                index++;
            }else{
                str = str.substring(index);
                break;
            }
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char nowChar = str.charAt(i);
            //'+' or '-'
            if(i == 0){
                if(nowChar == '+'){
                   flag = 0;
                   continue;
                }else if(nowChar == '-'){
                    flag = 1;
                    continue;
                }else if(nowChar >= '0' && nowChar <= '9'){
                    if(flag < 0){
                        flag = 0;
                    }
                    value = value * 10 + nowChar - '0';
                    continue;
                }
                else{
                    return 0;
                }
            }
             if(nowChar >= '0' && nowChar <= '9'){
                if(flag < 0){
                    flag = 0;
                }
                value = value * 10 + nowChar - '0';
                if(value > Integer.MAX_VALUE){
                    return flag == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }else{
                if(flag >= 0){
                    //是否到了边界
                    if(i+1 >= str.length())
                        break;
                    else{
                        if(value > Integer.MAX_VALUE){
                            return flag == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                        }
                        return flag == 0 ? (int)value : -(int)value;
                    }
                }
            }
        }
        return flag == 0 ? (int)value : -(int)value;
    }
}
// @lc code=end

