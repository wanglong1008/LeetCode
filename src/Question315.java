import java.util.*;

public class Question315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int[] index=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            index[i]=i;
            ans.add(0);
        }
        MergeSort(nums,0,nums.length-1,index,ans);
        return ans;
    }
    void MergeSort(int[] nums,int start,int end,int[] index,List<Integer> ans){
        if(start>=end)
            return ;
        int mid=(start+end)/2;
        MergeSort(nums,start,mid,index,ans);
        MergeSort(nums,mid+1,end,index,ans);
        Merge(nums,start,mid,end,index,ans);
    }
    void Merge(int[] nums,int start,int mid,int end,int[] index,List<Integer> ans){
        int[] copynums=new int[end-start+1];
        int[] copyindex=new int[end-start+1];
        int k=end-start;
        int i=mid,j=end;
        int count=0;
        while(i>=start&&j>mid){
            if(nums[i]>nums[j]){
                copyindex[k]=index[j];
                copynums[k--]=nums[j--];
            }else{
                count=ans.get(index[i])+end-j;
                ans.set(index[i],count);
                copyindex[k]=index[i];
                copynums[k--]=nums[i--];
            }
        }
        while(i>=start){
            count=ans.get(index[i])+end-j;
            ans.set(index[i],count);
            copyindex[k]=index[i];
            copynums[k--]=nums[i--];
        }
        while(j>mid){
            copyindex[k]=index[j];
            copynums[k--]=nums[j--];
        }
        for(int z=start;z<=end;z++){
            nums[z]=copynums[z-start];
            index[z]=copyindex[z-start];
        }
    }
}
