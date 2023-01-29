/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CNS;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Scanner;

/**
 *
 * @author goushik
 */
public class DSS 
{
     public static void main(String args[]) throws Exception
     {
         Scanner in = new Scanner(System.in); 
         System.out.println("Enter the Text : ");
         String msg = in.nextLine();
         byte[] bytes = msg.getBytes();
         
         KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
         
         keyPairGen.initialize(2048);
         KeyPair pair = keyPairGen.generateKeyPair();
         
         PrivateKey privKey = pair.getPrivate();
         PublicKey pubKey = pair.getPublic();
         
         Signature sign = Signature.getInstance("SHA256withDSA");
         sign.initSign(privKey);         
         
         sign.update(bytes);
         
         byte[] signature = sign.sign();
         System.out.println("Digital Signature for the given text : "+new String(signature,"UTF8"));
         
         Signature verifier = Signature.getInstance("SHA256withDSA");
         verifier.initVerify(pubKey);
         verifier.update(bytes);
         boolean verified = verifier.verify(signature);
         System.out.println("Signature verfication : "+verified);
         
     }
}
