
package CNS;

import java.security.Key;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author goushik
 */
public class DES 
{
    public static String KEY = "password";
    
    
    public static SecretKeySpec createKey()
    {
        byte[] k = KEY.getBytes();
        return new SecretKeySpec(k,"DES");
    }
    public static String Encrypt(String plaintext)
    {
        try
        {
            SecretKeySpec k = createKey();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,k);
            
            byte[] plaintextByte = plaintext.getBytes();
            byte[] encryptedByte = cipher.doFinal(plaintextByte);
            
            return Base64.getEncoder().encodeToString(encryptedByte);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static String Decrypt(String ciphertext)
    {
        try
        {
            SecretKeySpec k = createKey();
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,k);
            
            
            byte[] encryptedByte = Base64.getDecoder().decode(ciphertext);
            byte[] plaintextByte = cipher.doFinal(encryptedByte);
            
            return new String(plaintextByte);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    public static void main(String ards[])throws Exception
    {
        Scanner in = new Scanner(System.in);        
        System.out.println("Enter the Plain text");
        String plaintext,ciphertext,decrypttext;
        plaintext = in.nextLine();               
        ciphertext = Encrypt(plaintext);
        System.out.println("The ENCRYPT text :"+ciphertext);         
        decrypttext=Decrypt(ciphertext);
        System.out.println("The DECRYPT text :"+decrypttext);
    }   
    
}
