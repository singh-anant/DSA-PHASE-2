
public class FibonaciSeries {
    static int printFibonaciSeries(int n) {
        if (n == 0)
            return 0;
        return printFibonaciSeries(n - 1) + printFibonaciSeries(n - 2);

    }

    public static void main(String[] args) {
        System.out.print(printFibonaciSeries(3));
    }
}
