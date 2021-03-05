public class Question11 {
    public int maxArea(int[] height) {
        int i=0,j=height.length;
        int max=0;
        while(i<j){
            int now=(j-i-1)*Math.min(height[i],height[j-1]);
            if(now>max){
                max=now;
            }
            if(height[i]>height[j-1]){ j--;}
            else i++;
        }
        return  max;
    }
}
