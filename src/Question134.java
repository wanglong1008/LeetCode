public class Question134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int oil=0;
        int a1=0,a2=0;
        for(int i=0;i<gas.length;i++) {
            a1+=gas[i];
            a2+=cost[i];
        }
        if(a1<a2) return -1;
        for(int i=0;i<gas.length;i++){
            if(oil+gas[i]-cost[i]>=0){
                oil=oil+gas[i]-cost[i];
            }
            else {
                start = i + 1;
                oil = 0;
            }
        }
        if(start==gas.length) return -1;
        else return start;
    }
}
