import java.util.*;

public class Question316 {
    public String removeDuplicateLetters(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != 0) {
                map.put((char) (i + 'a'), cnt[i]);
            }
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c)) {
                map.put(c,map.get(c)-1);
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek())>1) {
                map.put(stack.peek(),map.get(stack.peek())-1);
                stack.pop();
            }
            stack.push(c);
        }
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);
    }
}
