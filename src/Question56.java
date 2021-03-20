import java.util.*;

public class Question56 {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int length=intervals.length;
        Set<int[]> result = new HashSet<int[]>();
        int []tmp=new int[2];
        tmp[0]=intervals[0][0];
        tmp[1]=intervals[0][1];
        for (int i = 0; i < length-1; i++) {
            if (tmp[1] >= intervals[i + 1][0]) {
                if (tmp[1] < intervals[i + 1][1])
                    tmp[1] = intervals[i + 1][1];
                else continue;

            } else {
                result.add(tmp);
                tmp=new int[2];
                tmp[0]=intervals[i+1][0];
                tmp[1]=intervals[i+1][1];
            }
        }
        result.add(tmp);
        int [][]result1=new int[result.size()][2];
        result.toArray(result1);
        return result1;
    }
}
