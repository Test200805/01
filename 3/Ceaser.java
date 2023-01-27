import java.util.*; 
public class Ceaser
{ 
  public static final String ALPHABET="abcdefghijklmnopqrstuvwxyz"; 
  public static String encrypt(String plaintext,int shiftkey) 
  { 
    plaintext=plaintext.toLowerCase(); 
    String ciphertext=""; 
    for(int i=0;i<plaintext.length();i++) 
    { 
       int charPosition = ALPHABET.indexOf(plaintext.charAt(i)); 
       int keyval=(shiftkey+charPosition)%26; 
       char replaceval=ALPHABET.charAt(keyval); 
       ciphertext+=replaceval; 
    } 
    return ciphertext; 
  } 
  public static String decrypt(String ciphertext,int shiftkey) 
  { 
    ciphertext=ciphertext.toLowerCase(); 
    String plaintext=""; 
    for(int i=0;i<ciphertext.length();i++) 
    { 
       int charPosition = ALPHABET.indexOf(ciphertext.charAt(i)); 
       int keyval=(charPosition-shiftkey)%26; 
       if(keyval<0) 
       { 
       keyval=ALPHABET.length()+keyval; 
       } 
       char replaceval=ALPHABET.charAt(keyval); 
       plaintext+=replaceval; 
    } 
    return plaintext; 
  }
  public static void main(String[] args) 
  { 
     Scanner s=new Scanner(System.in); 
     System.out.println("enter string for encryption"); 
     String message=s.nextLine(); 
     message=message.replace(" ", "");
     System.out.println("enter the keyvalue"); 
     int key=s.nextInt(); 
     System.out.println("encryption message="+encrypt(message,key)); 
     System.out.println("decryption message="+decrypt(encrypt(message,key),key)); 
     s.close(); 
  } 
}