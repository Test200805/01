/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class AES128 
{
   public static String KEY = "passwordpassword";
   
   public static Key createkey()
   {
       byte[] k = KEY.getBytes();
       return new SecretKeySpec(k,"AES");
   }
   
   public static String Encrypt(String plaintext)
   {
       try
       {
           Key k = createkey();  
           Cipher cipher = Cipher.getInstance("AES");
           cipher.init(Cipher.ENCRYPT_MODE,k);
           byte[] plaintextByte = plaintext.getBytes();
           byte[] encryptByte = cipher.doFinal(plaintextByte);
           return Base64.getEncoder().encodeToString(encryptByte);
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
           Key k = createkey();  
           Cipher cipher = Cipher.getInstance("AES");
           cipher.init(Cipher.DECRYPT_MODE,k);
           byte[] encryptedtextByte = Base64.getDecoder().decode(ciphertext);
           byte[] decryptByte = cipher.doFinal(encryptedtextByte);
           return new String(decryptByte);
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
