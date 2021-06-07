public class Question434 {
    public int countSegments(String s) {
        int re=0;
        s+=" ";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') continue;
            while(s.charAt(i)!=' ') {
                i++;
            }
            re++;
        }
        return re;
    }
}
