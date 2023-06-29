
public class Bit {

    public static void main(String[] args) {
        // Update the bits
        int n = 12;
        int k = 3;
        int bit = 1;
        System.out.println((n & ~(1 << k)) | (bit << k));

        
    }
}
