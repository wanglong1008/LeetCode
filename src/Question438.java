import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question438 {
    public List<Integer> findAnagrams(String s, String p) {
        //记录p的所有字母及其个数
        char[] need = new char[26];
        for (int i = 0; i < p.length(); i++) {
            need[p.charAt(i) - 'a']++;
        }
        //start和end分别控制窗口的前端和后端
        int start = 0, end = 0;
        char[] window = new char[26];
        List<Integer> ans = new ArrayList<Integer>();
        while (end < s.length()) {
            window[s.charAt(end) - 'a']++; //加入窗口数据
            while (end - start + 1 == p.length()) { //维护一个长度为p.length()的窗口，并更新答案
                if (Arrays.equals(window, need)) ans.add(start);
                window[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }
        return ans;
    }
}
