import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;

public class CryptographyAES192 {

    private static final String ALGORITHM = "AES";
    private static final int KEY_SIZE = 192;
    private static final String KEY = "yourkey";

    public static SecretKeySpec createKey() {
        byte[] keyBytes = new byte[KEY_SIZE / 8];
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, ALGORITHM);
        return secretKeySpec;
    }

    public static String encrypt(String plainText) {
        try {
            SecretKeySpec secretKey = createKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] plainTextBytes = plainText.getBytes();
            byte[] cipherText = cipher.doFinal(plainTextBytes);
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static String decrypt(String cipherText) {
        try {
            SecretKeySpec secretKey = createKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] cipherTextBytes = Base64.getDecoder().decode(cipherText);
            byte[] plainText = cipher.doFinal(cipherTextBytes);
            return new String(plainText);
        } catch (Exception e) {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to encrypt: ");
        String plainText = sc.nextLine();
        String cipherText = encrypt(plainText);
        System.out.println("Encrypted Text: " + cipherText);

        String decryptedText = decrypt(cipherText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
