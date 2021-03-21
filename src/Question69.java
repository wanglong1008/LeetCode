public class Question69 {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int r1=x/2;
        while(r1>x/r1)
            r1=(r1+x/r1)/2;
        return (int)r1;
    }
}
