/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNS;

import java.util.*;

/**
 *
 * @author goushik
 */
public class VigenereCipher 
{
    private String key;    
    public VigenereCipher (String key)
    {
        this.key=key;
    }
    private String Encrypt(String plaintext)
    {
        plaintext = plaintext.toUpperCase();
        key = key.toUpperCase();
        
        String ciphertext = "";
        
        for(int i=0,j=0;i< plaintext.length();i++)
        {
           char c = plaintext.charAt(i);
           
           if(c<'A'||c>'Z')
           {
               continue;
           }
           ciphertext+=(char)((c+key.charAt(j)-2*'A')%26+'A');
           j = ++j%key.length();
        }        
        return ciphertext;        
    }
    private String Decrypt(String ciphertext)
    {
        ciphertext = ciphertext.toUpperCase();
        key = key.toUpperCase();        
        String decrypttext = "";        
        for(int i=0,j=0;i< ciphertext.length();i++)
        {
           char c = ciphertext.charAt(i);
           
           if(c<'A'||c>'Z')
           {
               continue;
           }
           decrypttext+=(char)((c-key.charAt(j)+26)%26+'A');
           j = ++j%key.length();
        }        
        return decrypttext;
    }
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);        
        System.out.println("Enter the plaintext :");
        String plaintext = in.nextLine();
        System.out.println("Enter the keytext :");
        String key = in.nextLine();
        VigenereCipher vigenerecipher = new VigenereCipher(key);        
        String ciphertext = vigenerecipher.Encrypt(plaintext);
        System.out.println("The Encrypted text :"+ciphertext);        
        String decrypted = vigenerecipher.Decrypt(ciphertext);
        System.out.println("The Decrypted text :"+decrypted);       
    }    
}
