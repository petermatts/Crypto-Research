package crypto;

/**
 * This class was made for me to work around and  test with bitwise operators for the first time :)
 */
public class Bitwise {
    /**
     * Adds all binary strings entered together module 2^32
     * @param bin varargs parmeter of binary strings
     * @return binary String of sum of input
     */
    private static String add(String... bin) {
        final long mod = (long) Math.pow(2, 32);
        long sum = 0;

        for(String b : bin) {
            Long add = Long.parseLong(b, 2);
            sum += add;
            sum %= mod;
        }

        String result = Long.toBinaryString(sum);
        while(result.length() < 32)
            result = "0" + result;

        return result;
    }

    private static String shiftLeft(String bin, int distance) {
        final int len = bin.length();
        Long num = Long.parseLong(bin, 2);
        num = num<<distance;
        String result = Long.toBinaryString(num);
        while(result.length() < len)
            result = "0" + result;

        // System.out.println(result.length()); //Should always be 32 for SHA256
        // System.out.println(num); //base 10 representation

        return result;
    }

    private static String shiftRight(String bin, int distance) {
        final int len = bin.length();
        Long num = Long.parseLong(bin, 2);
        num = num>>distance;
        String result = Long.toBinaryString(num);
        while(result.length() < len)
            result = "0" + result;

        // System.out.println(result.length()); //Should always be 32 for SHA256
        // System.out.println(num); //base 10 representation

        return result;
    }

    private static String rotateLeft(String bin, int distance) {
        distance %= bin.length();
        String left = bin.substring(0, distance);
        String right = bin.substring(distance);
        // System.out.println(Long.parseLong(right+left, 2)); //base 10 representation

        return right + left;
    }

    private static String rotateRight(String bin, int distance) {
        distance %= bin.length();
        String left = bin.substring(0, bin.length() - distance);
        String right = bin.substring(bin.length() - distance);
        // System.out.println(Long.parseLong(right+left, 2)); //base 10 representation

        return right + left;
    }

    private static String choice(String bin1, String bin2, String bin3) {
        Long long1 = Long.parseLong(bin1, 2);
        Long long2 = Long.parseLong(bin2, 2);
        Long long3 = Long.parseLong(bin3, 2);
        Long sum = (long1 & long2) ^ (~long1 & long3);

        String result = Long.toBinaryString(sum);
        while(result.length() < 32)
            result = "0" + result;

        // System.out.println(result);

        return result;
    }

    private static String majority(String bin1, String bin2, String bin3) {
        Long long1 = Long.parseLong(bin1, 2);
        Long long2 = Long.parseLong(bin2, 2);
        Long long3 = Long.parseLong(bin3, 2);
        Long sum = (long1 & long2) ^ (long1 & long3) ^ (long2 & long3);

        String result = Long.toBinaryString(sum);
        while(result.length() < 32)
            result = "0" + result;

        // System.out.println(result);

        return result;
    }

    public static void testing() {
         //testing out shift methods
         System.out.println(shiftLeft("00000000000000000000000000000101", 2)); //Expected: 00000000000000000000000000010100 (20)
         System.out.println(shiftRight("00000000000000000000000001010000", 2)); //Expected: 00000000000000000000000000010100 (20)
 
         //testing out cirlce methods 
         System.out.println(rotateLeft("10000000000000000000000000000101", 33)); //Expected: 00000000000000000000000000001011 (11)
         System.out.println(rotateRight("10000000000000000000000000000101", 33)); //Expected: 11000000000000000000000000000010 (3221225474)
 
         // for(int i = 0; i < 32; i++) {
         //     System.out.println(rotateRight("10000000000000000000000000000101", i)); 
         // }
 
         // System.out.println(Long.MAX_VALUE);
         // System.out.println(5>>2); //should be 1
    }

    public static void main(String[] args) throws Exception {
        testing();
    }
}
