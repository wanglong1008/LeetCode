public class Question309 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==0)return 0;
        int[] hold=new int[n];
        hold[0]=-prices[0];
        int[] notHold=new int[n];
        for(int i=1;i<n;i++){
            if(i>=2)hold[i]=Math.max(hold[i-1],notHold[i-2]-prices[i]);
            else hold[i]=Math.max(hold[i-1],-prices[i]);
            notHold[i]=Math.max(notHold[i-1],hold[i-1]+prices[i]);
        }
        return notHold[n-1];
    }
}
