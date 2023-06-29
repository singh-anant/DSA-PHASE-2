public class BuyAndSellStocks {
    public static void main(String[] args) {
        int arr[] = { 7, 1, 2, 5, 3, 6, 4 };
        int cost = 0;
        int min = arr[0];
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            cost = arr[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, arr[i]);
        }
        System.out.println(profit);
    }
}
