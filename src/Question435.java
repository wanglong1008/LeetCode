import java.util.Arrays;
import java.util.Comparator;

public class Question435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0) return 0;
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[1]!=o2[1]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        });
        int result=1;
        int right=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=right){
                result++;
                right=intervals[i][1];
            }
        }
        return intervals.length-result;
    }
}
