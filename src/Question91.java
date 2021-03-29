public class Question91 {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        if(s.length()==1) return 1;
        int[] result=new int[s.length()];
        result[0]=1;
        if(s.charAt(1)=='0')
        {
            if(s.charAt(0)>'2') return 0;
            result[1]=1;
        }
        else if(10*(s.charAt(0)-'0')+s.charAt(1)-'0'>26){
            result[1]=1;
        }
        else result[1]=2;
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(10*(s.charAt(i-1)-'0')+s.charAt(i)-'0'>26||s.charAt(i-1)=='0')
                    return 0;
                result[i]=result[i-2];
            }
            else if(s.charAt(i-1)=='0') result[i]=result[i-1];
            else if(10*(s.charAt(i-1)-'0')+s.charAt(i)-'0'>26){
                result[i]=result[i-1];
            }
            else result[i]=result[i-2]+result[i-1];
        }
        return result[s.length()-1];
    }
}
