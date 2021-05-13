public class Question313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        /**
         * ugly[] 是为了存储之前计算到的ugly number，这个在计算后续的ugly number时会用到
         */
        int[] ugly = new int[n];
        /**
         * 第一个ugly number是1
         */
        ugly[0] = 1;
        /**
         * index数组，对于每个prime，现在在之前哪一个ugly number基础上去乘的index
         */
        int[] index = new int[primes.length];
        for (int i = 1; i < n; i ++) {
            int nthUgly = Integer.MAX_VALUE;
            /**
             * 一轮循环选出来最小的ugly number
             */
            for (int j = 0; j < primes.length; j ++) {
                nthUgly = Math.min(nthUgly, ugly[index[j]] * primes[j]);
            }
            /**
             * 选出来之后，更新一下对应的index
             */
            for (int j = 0; j < primes.length; j ++) {
                /**
                 * 这里很多人写>=我也不知道为什么，==就足够了
                 */
                if (nthUgly == ugly[index[j]] * primes[j]) {
                    index[j] ++;
                }
            }
            /**
             * 记录本次计算得到的ugly number
             */
            ugly[i] = nthUgly;
        }
        return ugly[n - 1];
    }
}
