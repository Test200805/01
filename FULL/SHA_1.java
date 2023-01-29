/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNS;

import java.security.MessageDigest;

/**
 *
 * @author goushik
 */
public class SHA_1 
{
   private static String BytesToHex(byte[] b)
   {
       char hexDigit[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
       StringBuffer bf = new StringBuffer();
       for(byte aB:b)
       {
           bf.append(hexDigit[aB>>4&0x0f]);
           bf.append(hexDigit[aB & 0x0f]);
       }
       return bf.toString();
   }
   public static void main(String args[])
   {
    try
    {
       MessageDigest md = MessageDigest.getInstance("SHA1");
       System.out.println("--------Message Digest information-------\n");
       System.out.println("Algorithm = "+md.getAlgorithm());
       System.out.println("Provider = "+md.getProvider());
       System.out.println("To string = "+md.toString());
       
       String input="";
       md.update(input.getBytes());
       byte[] output = md.digest();
       System.out.println("Sha(\""+input+"\") = "+BytesToHex(output));
       
    }   
    catch(Exception ex)
    {
        System.out.println(ex);
    }
   }
}
