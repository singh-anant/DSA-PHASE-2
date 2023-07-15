import java.util.Stack;

public class PostfixExpressionEvaluation {
    static int result(String s) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)))
                stack.push(Character.getNumericValue(s.charAt(i)));
            else {
                int num1 = stack.pop();
                int num2 = stack.pop();

                switch (s.charAt(i)) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                    case '%':
                        stack.push(num1 % num2);
                        break;
                }

            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(result("543/+*"));
    }
}
