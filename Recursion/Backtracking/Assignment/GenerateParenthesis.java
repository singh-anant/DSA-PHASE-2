import java.util.ArrayList;

public class GenerateParenthesis {
    static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        genBrackets(result, n, 0, 0, sb);
        return result;
    }

    private static void genBrackets(ArrayList<String> result, int n, int totalOpeningBrackets, int totalClosingBrackets,
            StringBuilder output) {
        // Termination Case
        if (output.length() == n * 2) {
            result.add(output.toString());
            return;
        }
        // Can i Place Opening
        if (totalOpeningBrackets < n) {
            output.append("("); // Place Opening
            genBrackets(result, n, totalOpeningBrackets + 1, totalClosingBrackets, output);
            // Stack Fall
            output.deleteCharAt(output.length() - 1); // Undo
        }
        // Can i Place Closing
        if (totalClosingBrackets < totalOpeningBrackets) {
            output.append(")"); // Place Closing
            genBrackets(result, n, totalOpeningBrackets, totalClosingBrackets + 1, output);
            // Stack Fall
            output.deleteCharAt(output.length() - 1);

        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }
}