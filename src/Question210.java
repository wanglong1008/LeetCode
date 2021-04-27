import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Question210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[]list=new List[numCourses];
        for(int i=0;i<numCourses;i++){
            list[i]=new ArrayList<>();
        }
        int []inDegree=new int[numCourses];
        for(int[] a:prerequisites){
            list[a[1]].add(a[0]);
            inDegree[a[0]]++;
        }
        LinkedList<Integer> queue=new LinkedList<>();
        for(int j=0;j<numCourses;j++){
            if(inDegree[j]==0){
                queue.add(j);
            }
        }
        int []result=new int[numCourses];
        int nums=0;
        while(!queue.isEmpty()){
            int k=queue.poll();
            result[nums++]=k;
            for(int i:list[k]){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }
        }
        if(nums==numCourses){
            return result;
        }
        else return new int[0];
    }
}
