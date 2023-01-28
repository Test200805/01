import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Scanner;

public class DESEncryption {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter plaintext: ");
            String plaintext = sc.nextLine();
            
            // Generate a secret key for the DES algorithm
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            SecretKey secretKey = keyGenerator.generateKey();
            
            // Create a Cipher object to encrypt the plaintext
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] ciphertext = cipher.doFinal(plaintext.getBytes());
            
            System.out.println("Encrypted Text : " + new String(ciphertext));
            
            // Create a Cipher object to decrypt the ciphertext
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedText = cipher.doFinal(ciphertext);
            
            System.out.println("Decrypted Text : " + new String(decryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
