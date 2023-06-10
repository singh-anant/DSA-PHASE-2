import java.util.ArrayList;

public class ProductList {
    static ArrayList<Integer> printProductList(ArrayList<Integer> arr, int index, ArrayList<Integer> ans) {
        if (index == arr.size() - 1) {
            return ans;
        }
        int product = arr.get(index) * arr.get(index);
        ans.add(product);
        return printProductList(arr, index + 1, ans);

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        ArrayList<Integer> ans = new ArrayList<>();
        System.out.println(arr.size());
        System.out.println(printProductList(arr, 0, ans));
    }
}
