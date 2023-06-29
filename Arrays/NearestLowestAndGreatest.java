public class NearestLowestAndGreatest {
    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
        int low = 0;
        int high = arr.length - 1;
        int nearestLowestElement = 0;
        int nearestHighestElement = 0;
        int elementToBeSearched = 62;
        int i = 0;
        while (i < arr.length) {
            int mid = (high + low) / 2;
            if (elementToBeSearched > arr[mid]) {
                nearestLowestElement = arr[mid];
                low = mid + 1;
            } else if (elementToBeSearched < arr[mid]) {
                nearestHighestElement = arr[mid];
                high = mid - 1;
            } else
                nearestLowestElement = nearestHighestElement = arr[mid];
            i++;

        }
        System.out.println("Nearest Lowest Element-: " + nearestLowestElement);
        System.out.println("Nearest Highest Element-: " + nearestHighestElement);

    }

}
