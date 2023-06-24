public class BarChart {
    public static void main(String[] args) {
        int max = 0;
        int arr[] = { 2, 1, 7, 9, 0 };
        // find out the max
        for (int element : arr) {
            if (element > max) {
                max = element;
            }
        }
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (max - i > arr[j]) {
                    System.out.print("\t");
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println(); // Move to the next line
        }

    }
}