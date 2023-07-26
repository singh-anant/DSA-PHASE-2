class SumK {
    int sumBase(int n, int k) {
        int ans = 0;
        while (n == 0) {
            ans = ans + n % k;
            n = n / k;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}