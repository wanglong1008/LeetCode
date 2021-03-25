import java.util.*;

public class Question76 {
    public String minWindow(String s, String t) {
        if(t.length()==0) return t;
        if(s.length()==0) return s;
        int len=t.length();
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for(int i=0;i<len;i++){
            if(hashMap.containsKey(t.charAt(i))){
                hashMap.put(t.charAt(i), hashMap.get(t.charAt(i)) + 1);
            }else{
                hashMap.put(t.charAt(i), 1);
            }
        }
        boolean flag=false;
        int left=0,right=0;
        int r1=0,r2=0;
        int count=0;
        int min=Integer.MAX_VALUE;
        while(left<s.length()&&right<=s.length()){
            if(count==t.length()) {
                flag=true;
                if(min>right-left){
                    min=right-left;
                    r1=left;
                    r2=right;
                }
                if (hashMap.containsKey(s.charAt(left))) {
                    int a =hashMap.get(s.charAt(left)) +1;
                    hashMap.put(s.charAt(left),a );
                    //if( hashMap.get(t.charAt(left)) -1)
                    if(a>0) count--;
                }
                left++;
            }
            else{
                if (right<s.length()&&hashMap.containsKey(s.charAt(right))) {
                    int a =hashMap.get(s.charAt(right)) -1;
                    hashMap.put(s.charAt(right),a );
                    //if( hashMap.get(t.charAt(left)) -1)
                    if(a>=0) count++;
                }
                right++;
            }
        }
        if(flag==false) return "";
        else return s.substring(r1,r2);
    }
}
