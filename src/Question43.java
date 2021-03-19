public class Question43 {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return new String("0");
        int a=num1.length();
        int b=num2.length();
        int[] result1=new int[a+b];
        for(int i=0;i<a;i++){
            int tmp1=num1.charAt(i)-'0';
            for(int j=0;j<b;j++){
                int tmp2=num2.charAt(j)-'0';
                int re=tmp1*tmp2;
                result1[i+j+1]+=re%10;
                result1[i+j]+=re/10;
            }
        }
        for(int aa:result1) {
            System.out.println(aa);
        }
        StringBuilder buffer=new StringBuilder();
        for(int i=result1.length-1;i>=0;i--){
            if(result1[i]>=10){
                result1[i-1]+=result1[i]/10;

                result1[i]=result1[i]%10;
            }
            char c=(char)(result1[i]+'0');
            buffer.append(c);
        }
        System.out.println(buffer);
        buffer.reverse();
        if(buffer.charAt(0)=='0'){
            buffer=new StringBuilder(buffer.substring(1,buffer.length()));
        }
        String result=new String(buffer);
        //StringBuffer buffer=new StringBuffer();
        return result;
    }
}
