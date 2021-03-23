import java.util.*;

public class Question71 {
    public String simplifyPath(String path) {
        StringBuilder re=new StringBuilder();
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                int j = i+1 ;
                while (j<path.length()&&path.charAt(j) != '/') {
                    j++;
                }
                String current = path.substring(i,j);
                i=j;
                if (current.equals("..")) {
                    stack.pollFirst();
                } else if (current.equals(".")) {
                } else { stack.push(current);
                }

            }
        }
        String word;
        if(stack.isEmpty()){
            return "/";
        }
        while((word=stack.pollLast())!=null){
            re.append("/");
            re.append(word);
        }
        String result=new String(re);
        return result;
    }
}
