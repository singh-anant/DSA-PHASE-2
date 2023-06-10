public class AddTaxInSalary {
    static int[] printAddTaxInSalary(int salary[], int index) {
        if (index == salary.length) {
            int ans[] = new int[salary.length];
            return ans;
        }

        int ans[] = printAddTaxInSalary(salary, index + 1);
        ans[index] = salary[index] + ((salary[index] * 100) + 10) / 100;
        // System.out.println(ans[index]);
        return ans;
    }

    public static void main(String[] args) {
        int salary[] = { 30000, 50000, 70000, 40000 };
        int incSalary[] = printAddTaxInSalary(salary, 0);
        for (int i : incSalary) {
            System.out.print(i + " ");
        }
    }
}
