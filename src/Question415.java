public class Question415 {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int max = Math.max(n1, n2);
        int[] a1 = new int[max + 1];
        int[] a2 = new int[max + 1];
        for (int i = n1 - 1; i >= 0; i--) {
            a1[max - (n1 - i) + 1] = num1.charAt(i) - '0';
        }
        for (int i = n2 - 1; i >= 0; i--) {
            a2[max - (n2 - i) + 1] = num2.charAt(i) - '0';
        }
        int jinwei = 0;
        for (int i = max; i >= 0; i--) {
            a1[i] += a2[i] + jinwei;
            jinwei = a1[i] / 10;
            a1[i] = a1[i] % 10;
        }
        StringBuilder result = new StringBuilder();
        if (a1[0] == 1) result = new StringBuilder("1");
        for (int i = 1; i < max + 1; i++) {
            result.append(a1[i]);
        }
        return result.toString();
    }
}
