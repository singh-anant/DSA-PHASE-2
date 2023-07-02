public class Atoi {
  // 32bit Integer
  // Remove white spaces..
  // "-4"-->-4
  // Maintain + and - Sign
  // Alphanumeric values....
  // "00000039"-->39

  private static int ConvertToInteger(String s) {
    int sign = 1;// here we are assuming the integer is positive...
    int index = 0;
    int result = 0;
    // For Whitespaces....
    while (index < s.length() && s.charAt(index) == ' ')
      index++;

    // For Sign

    if (index < s.length() && s.charAt(index) == '+') {
      sign = 1;
      index++;
    }

    else {
      if (index < s.length() && s.charAt(index) == '-') {
        sign = -1;
        index++;
      }
    }
    while (index < s.length() && Character.isDigit((s.charAt(index)))) {
      int digit = s.charAt(index) - '0';
      if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      } else if (result <= Integer.MIN_VALUE / 10)
        return Integer.MIN_VALUE;
      result = 10 * result + digit;
      index++;
    }
    return result * sign;
  }

  public static void main(String[] args) {
    // so we will be working on the length....
    // We have to check whether integer going out of bound or not...
    String str = "   49";
    System.out.println(ConvertToInteger(str));

  }
}
