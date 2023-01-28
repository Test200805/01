import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.spec.DESKeySpec;

public class CryptographyDES {
    
    String KEY = "password";
        
    public SecretKeySpec createKey(String chave) {
        try {
            byte[] charac = chave.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            charac = md.digest(charac);
            charac = Arrays.copyOf(charac, 8); // DES key size is 8 bytes
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key = factory.generateSecret(new DESKeySpec(charac));
            return new SecretKeySpec(key.getEncoded(), "DES");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String encrypt(String plainText) {
        try {
            SecretKeySpec secretKeySpec = createKey(KEY);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            byte[] plainTextBytes = plainText.getBytes("UTF-8");
            byte[] encryptedBytes = cipher.doFinal(plainTextBytes);
            String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            return encryptedText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String decrypt(String encryptedText) {
        try {
            SecretKeySpec secretKeySpec = createKey(KEY);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

            byte[] encryptedTextBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedTextBytes);
            String decryptedText = new String(decryptedBytes, "UTF-8");
            return decryptedText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
       CryptographyDES des = new CryptographyDES();
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter text to encrypt: ");
       String plainText = sc.nextLine();
       String encryptedText = des.encrypt(plainText);
       System.out.println("Encrypted Text: " + encryptedText);
       System.out.println("Decrypted Text: " + des.decrypt(encryptedText));
    }
}
