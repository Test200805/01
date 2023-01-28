import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class CryptographyAES128 {
    private static final String ALGORITHM = "AES";
    private static final String KEY = "passwordpassword";

    public static Key generateKey() {
        byte[] charac = KEY.getBytes();
        return new SecretKeySpec(charac, ALGORITHM);
    }

    public static String encrypt(String value) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] charac = value.getBytes();
            byte[] encrypted = cipher.doFinal(charac);
            String encryptedValue = Base64.getEncoder().encodeToString(encrypted);
            return encryptedValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String decrypt(String value) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] charac = Base64.getDecoder().decode(value);
            byte[] decrypted = cipher.doFinal(charac);
            String decryptedValue = new String(decrypted);
            return decryptedValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plain text : ");
        String plainText = scanner.nextLine();
        
        try {
            String encryptedText = encrypt(plainText);
            String decryptedText = decrypt(encryptedText);
            System.out.println("Plain Text : " + plainText);
            System.out.println("Encrypted Text : " + encryptedText);
            System.out.println("Decrypted Text : " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
