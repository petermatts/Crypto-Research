package crypto;

// import java.math.BigInteger; 
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 

public class SHA256 {
    private static byte[] getSHA(String input) throws NoSuchAlgorithmException { 
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
    }
    
    private static String toHexString(byte[] hash) {
        // BigInteger number = new BigInteger(1, hash); 
        // StringBuilder hexString = new StringBuilder(number.toString(16)); 
        // while (hexString.length() < 32) { 
        //     hexString.insert(0, '0'); 
        // } 
  
        // return hexString.toString(); 

        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    } 

    public static String hash(String input) throws NoSuchAlgorithmException, Exception {
        String hash = toHexString(getSHA(input)).toUpperCase();

        if(hash.length() != 64) {
            throw new Exception("hash length != 64, length=" + hash.length() + "\nInput: " + input);
        }

        return hash;
    }

    public static void main(String args[]) { 
        try {
            String hw_hash = hash("Hello World");
            // System.out.println(hw_hash.replaceAll("^[A-Fa-f0-9]+$","").isEmpty()); //Expected: true
            // System.out.println("Hello World: " + hw_hash);
            // System.out.println("Hello World x2: " + hash("Hello World Hello World"));
            // System.out.println("Super duper really long input: " + hash("Super duper really long input"));

            System.out.println();
            System.out.println("Hello World");
            System.out.println("hash(\"Hello World\") = " + hw_hash);
            System.out.println("hash(\"" + hw_hash + "\") = " + hash(hw_hash));
        } catch (NoSuchAlgorithmException e) { 
            System.out.println("Exception thrown for incorrect algorithm: " + e); 
        } catch(Exception e) {
            System.out.println("Some other error:\n" + e);
        }
    } 
}
