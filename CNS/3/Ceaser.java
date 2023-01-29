/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNS;

import java.util.Scanner;

public class Ceaser 
{
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";    
    public static void main(String args[])
    {
         Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the Plain text");
        String plaintext,ciphertext,decrypttext;
        plaintext = in.nextLine();
        System.out.println("Enter the Key value");
        int key;
        key = in.nextInt();
        
        ciphertext = Encryption(plaintext,key);
        System.out.println("The ENCRYPT text :"+ciphertext);
         
        decrypttext=Decryption(ciphertext,key);
        System.out.println("The DECRYPT text :"+decrypttext); 
        
    }
    private static String Encryption(String plaintext, int key) 
    {
        String ciphertext="";
        plaintext=plaintext.toLowerCase();
        for(int i=0;i<plaintext.length();i++)
        {
            if(plaintext.charAt(i)>='a'||plaintext.charAt(i)<='z')
            {
                int charPosition = ALPHABET.indexOf(plaintext.charAt(i));
                int keyval = (key+charPosition)%26;
                char replace = ALPHABET.charAt(keyval);
                ciphertext += replace; 
            }
            
        }
        return ciphertext;
    }
    private static String Decryption(String ciphertext, int key) 
    {
        String plaintext="";
        ciphertext=ciphertext.toLowerCase();
        for(int i=0;i<ciphertext.length();i++)
        {
            if(ciphertext.charAt(i)>='a'||ciphertext.charAt(i)<='z')
            {
                int charPosition = ALPHABET.indexOf(ciphertext.charAt(i));
                int keyval = (charPosition-key)%26;
                if(keyval<0)
                {
                    keyval = ALPHABET.length()+keyval;
                }
                char replace = ALPHABET.charAt(keyval);
                plaintext += replace; 
            }
           
        }
        return plaintext;
    }    
}
