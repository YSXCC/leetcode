import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        List<StringBuffer> resultStringList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            resultStringList.add(new StringBuffer());
        }
        int goDirection = 1;    //1 -> goDown; -1 -> goUp
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            resultStringList.get(flag).append(s.charAt(i));
            if(goDirection == 1){
                flag++;
                if(flag == numRows){
                    goDirection = -1;
                    flag = numRows - 2;
                }
            }else{
                flag--;
                if(flag == -1){
                    goDirection = 1;
                    flag = 1;
                }
            }
            
        }
        StringBuffer result = new StringBuffer();
        for (StringBuffer stringBuffer : resultStringList) {
            result.append(stringBuffer);
        }
        return result.toString();
    }
}
// @lc code=end

