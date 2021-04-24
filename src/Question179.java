import java.util.Arrays;
import java.util.Comparator;

public class Question179 {
    public String largestNumber(int[] nums) {
        String[] a = new String[nums.length];
        int j = 0;
        int k=0;
        for (int i : nums) {
            a[j] = String.valueOf(i);
            j++;
            if(i==0) k++;
        }
        if(k==nums.length) return new String("0");
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a=o1+o2,b=o2+o1;
                int i=a.length();
                for (int j = 0; j < i; j++) {
                    if (a.charAt(j) > b.charAt(j)) {
                        return -1;
                    } else if (a.charAt(j) < b.charAt(j)) {
                        return 1;
                    } else continue;
                }
                return 0;
            }
        });
        StringBuffer re=new StringBuffer();
        for(String i:a){
            re.append(i);
        }
        return new String(re);
    }
}
