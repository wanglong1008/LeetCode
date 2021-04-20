public class Question151 {
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        int len = s.length();
        s = s.trim();
        StringBuffer re = new StringBuffer();
        int i = s.length();
        for (int j = s.length() - 1; j >=0; j--) {
            if (j == 0) {
                re.append(" ");
                re.append(s.substring(j, i));

            }
            if (s.charAt(j) == ' ') {
                re.append(s.substring(j, i));
                //re.append(" ");
                while(j>0&&s.charAt(j-1) == ' ') j=j-1;
                i = j;
            } else continue;


        }
        String result = new String(re);
        return result.trim();
    }
}
