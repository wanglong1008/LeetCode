import java.util.TreeMap;

public class Question436 {
    public int[] findRightInterval(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++){
            map.put(intervals[i][0], i);
        }
        for(int i = 0; i < intervals.length; i++){
            Integer key = map.higherKey(intervals[i][1]-1);
            if(key == null){
                res[i] = -1;
            }else{
                res[i] = map.get(key);
            }
        }
        return res;
    }
}
